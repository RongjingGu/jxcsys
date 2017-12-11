import React from 'react';
import { List, ActivityIndicator } from 'antd-mobile';
import { connect } from 'dva';
import { Link } from 'dva/router';
import styles from './LatestNews.less';
import LatestNewsShare from './LatestNewsShare';

class LatestNewsIndex extends React.Component {
  render() {
    return (
      <div className={styles.LatestNewsIndex}>
        <List renderHeader={() => { return (<div className="list_header_title"> 最新动态 <Link to="/LatestNews/LatestNewsList" className="bar_more">更多&gt;</Link> </div>); }} className="my-list">
          {this.props.loading ? <ActivityIndicator className="loading_center" animating /> : <LatestNewsShare />}
        </List>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return {
    loading: state.loading.models.LatestNews,
  };
}

export default connect(mapStateToProps)(LatestNewsIndex);
