import React from 'react';
import { ListView, PullToRefresh } from 'antd-mobile';
import { connect } from 'dva';
import ReactDOM from 'react-dom';
import { withRouter } from 'react-router';
import styles from './WorkShop.less';
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

class WorkShopShare extends React.Component {
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
    this.props.dispatch({ type: 'WorkShop/query', payload: {} });
  };

  onEndReached = () => {
    // load new data
    // hasMore: from backend data, indicates whether it is the last page, here is false
    console.log(`onEndReached${this.props.loading.effects['WorkShop/nextPage']}`);

    if (this.props.loading.effects['WorkShop/nextPage']) { // @todo hasMore
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
    this.props.dispatch({ type: 'WorkShop/nextPage', payload: { page } });
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
        >
          <div style={{ display: 'flex', padding: '15px' }}>
            <img style={{ height: '63px', width: '63px', marginRight: '15px' }} src={obj.img} alt="" />
            <div style={{ display: 'inline-block' }}>
              <div style={{ marginBottom: '8px', color: '#000', fontSize: '16px', overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap', maxWidth: '250px' }}>{obj.name}</div>
              <div style={{ fontSize: '16px' }}><span style={{ fontSize: '30px', color: '#FF6E27' }}>{rowID}</span> 元/任务</div>
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
        {this.props.loading.effects['WorkShop/nextPage'] ? 'Loading...' : ''}
      </div>);
    }
    console.log(this.props.loading.effects['WorkShop/nextPage']);
    return (
      <div className={styles.WorkShopIndex}>
        {/* {this.props.list && this.props.list.map((value, index) => {
          return (
            <Item
              arrow="horizontal"
              thumb="https://zos.alipayobjects.com/rmsportal/dNuvNrtqUztHCwM.png"
              multipleLine
              onClick={() => {
                this.props.history.push(`/WorkShop/WorkShopInfo/${value.name}`);
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
            refreshing={this.props.loading.effects['WorkShop/query']}
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
  if (state.WorkShop) {
    const { list, total, page, hasMore } = state.WorkShop;
    return {
      loading: state.loading,
      list,
      total,
      page,
      hasMore,
    };
  }
}


export default connect(mapStateToProps)(withRouter(WorkShopShare));
