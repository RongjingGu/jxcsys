import React from 'react';
import { List, Tabs } from 'antd-mobile';
import { connect } from 'dva';
import { Link } from 'dva/router';
import WorkShopShare from '../WorkShop/WorkShopShare';

class DepartmentInfoIndex extends React.Component {
  state = {
    data: ['', '', ''],
    initialHeight: 176,
  }

  render() {
    const tabs = [
      { title: '全部' },
      { title: '资讯' },
      { title: '知识' },
      { title: '病例' },
      { title: '病例1' },
      { title: '病例2' },
    ];
    return (
      <div>
        <List renderHeader={() => { return (<div className="list_header_title"> 科普宣教 <Link to="/WorkShop/WorkShopList" className="bar_more">更多&gt;</Link> </div>); }} className="my-list">

          <Tabs
            tabs={tabs}
            initialPage={1}
            onChange={(tab, index) => { console.log('onChange', index, tab); }}
            onTabClick={(tab, index) => { console.log('onTabClick', index, tab); }}
          >
            <div style={{ width: '100%', marginLeft: '0px', marginRight: '0px' }}>
              <WorkShopShare />
            </div>
            <div style={{ width: '100%', marginLeft: '0px', marginRight: '0px' }}>
              <WorkShopShare />
            </div>
            <div style={{ width: '100%', marginLeft: '0px', marginRight: '0px' }}>
              <WorkShopShare />
            </div>
            <div style={{ width: '100%', marginLeft: '0px', marginRight: '0px' }}>
              <WorkShopShare />
            </div>
            <div style={{ width: '100%', marginLeft: '0px', marginRight: '0px' }}>
              <WorkShopShare />
            </div>
            <div style={{ width: '100%', marginLeft: '0px', marginRight: '0px' }}>
              ·1232
            </div>

          </Tabs>
        </List>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return {
    loading: state.loading.models.DepartmentInfo,
  };
}

export default connect(mapStateToProps)(DepartmentInfoIndex);
