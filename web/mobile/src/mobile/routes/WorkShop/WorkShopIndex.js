import React from 'react';
import { List } from 'antd-mobile';
import { connect } from 'dva';
import { Link } from 'dva/router';
import styles from './WorkShop.less';
import WorkShopShare from './WorkShopShare';

class WorkShopIndex extends React.Component {
  render() {
    return (
      <div className={styles.WorkShopIndex}>
        <List renderHeader={() => { return (<div className="list_header_title"> 学术会议 <Link to="/WorkShop/WorkShopList" className="bar_more">更多&gt;</Link> </div>); }} className="my-list">
          {this.props.loading ? 'loading' : <WorkShopShare />}
        </List>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return {
    loading: state.loading.models.WorkShop,
  };
}

export default connect(mapStateToProps)(WorkShopIndex);
