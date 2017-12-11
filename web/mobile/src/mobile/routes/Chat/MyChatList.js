import React from 'react';
import { ListView, PullToRefresh, Card, SwipeAction } from 'antd-mobile';
import { connect } from 'dva';
import ReactDOM from 'react-dom';
import { withRouter } from 'react-router';

import styles from './Chat.less';
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

class MyChatList extends React.Component {
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
    this.props.dispatch({ type: 'MyChatList/query', payload: {} });
  };

  onEndReached = () => {
    // load new data
    // hasMore: from backend data, indicates whether it is the last page, here is false
    console.log(`onEndReached${this.props.loading.effects['MyChatList/nextPage']}`);

    if (this.props.loading.effects['MyChatList/nextPage']) { // @todo hasMore
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
    this.props.dispatch({ type: 'MyChatList/nextPage', payload: { page } });
  };

  render() {
    const { list } = this.props;
    const row = (rowData, sectionID, rowID) => {
      console.log(list, rowID);
      const obj = list[rowID];
      if (!obj) {
        return null;
      }
      console.log(obj);
      return (
        <div style={{ marginTop: '10px' }} className="chat_card">
          <SwipeAction
            style={{ backgroundColor: 'gray' }}
            autoClose
            right={[
              {
                text: 'Cancel',
                onPress: () => console.log('cancel'),
                style: { backgroundColor: '#ddd', color: 'white' },
              },
              {
                text: 'Delete',
                onPress: () => console.log('delete'),
                style: { backgroundColor: '#F4333C', color: 'white' },
              },
            ]}
            onOpen={() => console.log('global open')}
            onClose={() => console.log('global close')}
          >
            <Card full>
              <Card.Header
                title={<span className="chat_header"><i className="icon iconfont icon-ren" /><span className="chat_name">张一山</span></span>}
                extra={<span className="chat_status">待回复</span>}
              />
              <Card.Body>
                <div className="card_body">This is content of `Card`</div>
              </Card.Body>
              <Card.Footer style={{ marginTop: '20px' }} content="2017-06-07 13:37" extra={<div>咨询对象:蔡三军(主任医师)</div>} />
            </Card>
          </SwipeAction>
        </div>
      );
    };
    const needRender = {};
    if (!this.props.scrollY) {
      needRender.renderScrollComponent = props => <div className="scrollRender">{props.children}</div>;
    } else {
      needRender.renderFooter = () => (this.props.scrollY && <div style={{ padding: 5, textAlign: 'center' }}>
        {this.props.loading.effects['MyChatList/nextPage'] ? 'Loading...' : ''}
      </div>);
    }
    console.log(this.props.loading.effects['MyChatList/nextPage']);
    return (
      <div className={styles.MyChatList}>
        {/* {this.props.list && this.props.list.map((value, index) => {
          return (
            <Item
              arrow="horizontal"
              thumb="https://zos.alipayobjects.com/rmsportal/dNuvNrtqUztHCwM.png"
              multipleLine
              onClick={() => {
                this.props.history.push(`/MyChatList/MyChatListInfo/${value.name}`);
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
            height: this.state.height - 25,
            margin: '0px 0',
          }}
          {...needRender}
          pullToRefresh={this.props.pullRefresh ? <PullToRefresh
            refreshing={this.props.loading.effects['MyChatList/query']}
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
  if (state.MyChatList) {
    const { list, total, page, hasMore } = state.MyChatList;
    return {
      loading: state.loading,
      list,
      total,
      page,
      hasMore,
    };
  }
}


export default connect(mapStateToProps)(withRouter(MyChatList));