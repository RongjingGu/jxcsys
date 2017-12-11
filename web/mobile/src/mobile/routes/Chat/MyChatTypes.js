import React from 'react';
import { Tabs } from 'antd-mobile';
import { connect } from 'dva';
import styles from './Chat.less';
import MyChatList from './MyChatList';
// import WorkShopShare from '../WorkShop/WorkShopShare';s

class MyChatTypes extends React.Component {
  state = {
    data: ['', '', ''],
    initialHeight: 176,
  }

  render() {
    const tabs = [
      { title: '待回复' },
      { title: '已回复' },
      { title: '已完成' },
      { title: '全部' },
    ];
    return (
      <div className={styles.chat_types}>

        <Tabs
          tabs={tabs}
          initialPage={0}
          onChange={(tab, index) => { console.log('onChange', index, tab); }}
          onTabClick={(tab, index) => { console.log('onTabClick', index, tab); }}
          swipeable={false}
        >
          <div style={{ width: '100%', marginLeft: '0px', marginRight: '0px' }}>
            <MyChatList type={tabs[0].title} nextPage={true} pullRefresh={true} scrollY={true} />
          </div>
          <div style={{ width: '100%', marginLeft: '0px', marginRight: '0px' }}>
            <MyChatList type={tabs[0].title} nextPage={true} pullRefresh={true} scrollY={true} />
          </div>
          <div style={{ width: '100%', marginLeft: '0px', marginRight: '0px' }}>
            <MyChatList type={tabs[0].title} nextPage={true} pullRefresh={true} scrollY={true} />
          </div>
          <div style={{ width: '100%', marginLeft: '0px', marginRight: '0px' }}>
            <MyChatList type={tabs[0].title} nextPage={true} pullRefresh={true} scrollY={true} />
          </div>
        </Tabs>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return {
    loading: state.loading.models.DepartmentInfo,
  };
}

export default connect(mapStateToProps)(MyChatTypes);
