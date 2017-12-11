import React from 'react';
import { ListView, PullToRefresh } from 'antd-mobile';
import { connect } from 'dva';
import ReactDOM from 'react-dom';
import { withRouter } from 'react-router';
import styles from './InvSubject.less';
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

class InvSubjectList extends React.Component {
  state={
    dataSource,
    height: document.documentElement.clientHeight,
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
    this.props.dispatch({ type: 'InvSubject/query', payload: {} });
  };

  onEndReached = () => {
    // load new data
    // hasMore: from backend data, indicates whether it is the last page, here is false
    console.log(`onEndReached${this.props.loading.effects['InvSubject/nextPage']}`);

    if (this.props.loading.effects['InvSubject/nextPage']) { // @todo hasMore
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
    this.props.dispatch({ type: 'InvSubject/nextPage', payload: { page } });
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
            this.props.history.push('/InvSubject/InvSubjectInfo/test');
          }}
        >
          <div className="row_style">
            <img className="row_img" style={{ width: '70px', height: '50px', marginRight: '15px' }} src={obj.img} alt="" />
            <div className="row_content">
              <div className="row_detail" style={{ position: 'relative' }}>
                <div className="row_title" style={{}}>{obj.name}</div>
                <div className="row_footer" style={{ fontSize: '12px', color: '#6a7881', lineHeight: '18px' }}>
                  <div>研究开始时间:2017-08-23</div>
                  <div style={{ position: 'relative' }}>研究结束时间:2017-08-23 <span className={styles.preparing} style={{ position: 'absolute', right: '-8px', fontSize: '14px' }}>准备中</span></div>
                </div>
              </div>
              <span style={{ position: 'absolute', right: '0px' }} className="right_arrow" />
            </div>
          </div>
        </div>
      );
    };
    const needRender = {};
    if (!this.props.scrollY) {
      needRender.renderScrollComponent = props => <div className="scrollRender">{props.children}</div>;
    } else {
      needRender.renderFooter = () => (this.props.scrollY && <div style={{ padding: 5, textAlign: 'center' }}>
        {this.props.loading.effects['InvSubject/nextPage'] ? 'Loading...' : ''}
      </div>);
    }
    console.log(this.props.loading.effects['InvSubject/nextPage']);
    return (
      <div className={styles.InvSubjectIndex}>
        {/* {this.props.list && this.props.list.map((value, index) => {
          return (
            <Item
              arrow="horizontal"
              thumb="https://zos.alipayobjects.com/rmsportal/dNuvNrtqUztHCwM.png"
              multipleLine
              onClick={() => {
                this.props.history.push(`/InvSubject/InvSubjectInfo/${value.name}`);
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
          style={!this.props.scrollY ? {} : {
            height: this.state.height,
            margin: '5px 0',
          }}
          {...needRender}
          pullToRefresh={this.props.pullRefresh ? <PullToRefresh
            refreshing={this.props.loading.effects['InvSubject/query']}
            onRefresh={this.onRefresh}
          />
            :
            false
          }
          onEndReached={this.props.nextPage ? this.onEndReached : () => {}}
          pageSize={5}
        />
      </div>
    );
  }
}

function mapStateToProps(state) {
  if (state.InvSubject) {
    const { list, total, page, hasMore } = state.InvSubject;
    return {
      loading: state.loading,
      list,
      total,
      page,
      hasMore,
    };
  }
}


export default connect(mapStateToProps)(withRouter(InvSubjectList));
