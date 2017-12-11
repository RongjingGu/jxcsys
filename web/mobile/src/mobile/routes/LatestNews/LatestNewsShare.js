import React from 'react';
import { ListView, PullToRefresh } from 'antd-mobile';
import { connect } from 'dva';
import ReactDOM from 'react-dom';
import { withRouter } from 'react-router';
import moment from 'moment';
import styles from './LatestNews.less';
// import { PAGE_SIZE } from '../../constants';

function genData(rData = [], pIndex = 0) {
  const dataArr = [];
  for (let i = 0; i < rData.length; i++) {
    dataArr.push(`row - ${(pIndex * rData.length) + i}`);
  }
  return dataArr;
}

const dataSource = new ListView.DataSource({
  rowHasChanged: (row1, row2) => row1 !== row2,
});

class LatestNewsShare extends React.Component {
  state={
    dataSource,
    height: document.documentElement.clientHeight,
    isLoadingMore: false,
  }

  componentDidMount() {
    const getRect = ReactDOM.findDOMNode(this.lv).getBoundingClientRect();
    const hei = getRect.height - getRect.top;
    const rData = this.props.list ? this.props.list : [];
    this.setState({
      dataSource: this.state.dataSource.cloneWithRows(rData),
      height: hei,
      refreshing: false,
      isLoading: false,
    });
  }

  componentWillReceiveProps() {
    const rData = this.props.list ? this.props.list : [];
    this.setState({
      dataSource: this.state.dataSource.cloneWithRows(genData(rData)),
      refreshing: false,
      isLoading: false,
    });
    if (!this.props.scrollY) {
      document.body.style.overflow = 'auto';
    } else {
      document.body.style.overflow = 'hidden';
    }
  }

  componentDidUpdate() {
    if (!this.props.scrollY) {
     // document.body.style.overflow = 'auto';
    } else {
      document.body.style.overflow = 'hidden';
    }
  }

  onRefresh = () => {
    this.setState({ refreshing: true, isLoading: true });
    setTimeout(() => {
      this.props.dispatch({ type: 'LatestNews/query', payload: {} });
    }, 150);
  };

  onEndReached = () => {
    // load new data
    // hasMore: from backend data, indicates whether it is the last page, here is false
    console.log(`onEndReached${this.props.loading.effects['LatestNews/nextPage']}`);

    if (this.props.loading.effects['LatestNews/nextPage'] && this.state.isLoadingMore) { // @todo hasMore
      return;
    }
    if (this.props.noMore) {
      // Toast.info('沒有更多数据了', 1);
      return;
    }

    let { page } = this.props;
    // if(PAGE_SIZE * page > total){//@todo lastpage define
    //     Toast.info("没有更多了")
    // }
    if (!page) {
      page = 2;
    } else {
      page += 1;
    }
    this.setState({
      isLoadingMore: true,
    }, function () {
      setTimeout(() => {
        this.props.dispatch({ type: 'LatestNews/nextPage', payload: { page } });
      }, 300);
    });
    this.setState({
      isLoadingMore: false,
    });
  };

  render() {
    const { list } = this.props;
    const row = (rowData, sectionID, rowID) => {
      console.log(list, rowID);
      const obj = list[rowID];
      if (!obj) {
        return null;
      }
      return (
        <div
          key={rowID}
          style={{
            padding: '0 15px',
            backgroundColor: 'white',
          }}
          onClick={() => {
            this.props.history.push('/LatestNews/LatestNewsInfo/test');
          }}
        >
          <div className="row_style">
            <img className="row_img" src={obj.img} alt="" />
            <div className="row_content">
              <div className="row_detail">
                <div className="row_title">{obj.lastTendencyTitle}</div>
                <div className="row_footer"><span className="row_time">{moment(obj.publishDayString).format('YYYY-MM-DD')}</span></div>
              </div>

            </div>
          </div>
        </div>
      );
    };
    const needRender = {};
    if (!this.props.scrollY) {
      needRender.renderScrollComponent = props => <div className="scrollRender">{props.children}</div>;
    } else {
      console.log(this.state.isLoadingMore);
      needRender.renderFooter = () => (this.props.scrollY && <div style={{ padding: 5, textAlign: 'center' }}>
        {(this.state.isLoadingMore || this.props.loading.effects['LatestNews/nextPage']) ? 'Loading...' : this.props.noMore ? '没有更多了' : ''}
      </div>);
    }
    // console.log(this.props.loading.effects['LatestNews/nextPage']);
    return (
      <div className={styles.LatestNewsIndex}>
        {/* {this.props.list && this.props.list.map((value, index) => {
          return (
            <Item
              arrow="horizontal"
              thumb="https://zos.alipayobjects.com/rmsportal/dNuvNrtqUztHCwM.png"
              multipleLine
              onClick={() => {
                this.props.history.push(`/LatestNews/LatestNewsInfo/${value.name}`);
              }}
              key={index}
            >
              {value.name} <Brief>{value.phone}    {value.address && value.address.street}</Brief>
            </Item>
          );
        })
        } */}
        <ListView
          ref={el => this.lv = el}
          dataSource={this.state.dataSource}
          renderRow={row}
          onEndReachedThreshold={500}
          style={!this.props.scrollY ? {} : {
            height: this.state.height,
            margin: '5px 0',
          }}
          {...needRender}
          pullToRefresh={this.props.pullRefresh ? <PullToRefresh
            refreshing={this.props.loading.effects['LatestNews/query']}
            onRefresh={this.onRefresh}
          />
            :
            false
          }
          onEndReached={this.props.nextPage ? this.onEndReached : () => {}}
          // pageSize={5}
        />
      </div>
    );
  }
}

function mapStateToProps(state) {
  if (state.LatestNews) {
    const { list, total, page, noMore } = state.LatestNews;
    return {
      loading: state.loading,
      list,
      total,
      page,
      noMore,
    };
  }
}


export default connect(mapStateToProps)(withRouter(LatestNewsShare));
