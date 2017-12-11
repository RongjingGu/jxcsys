import React from 'react';
import { SearchBar, WhiteSpace } from 'antd-mobile';
import { connect } from 'dva';
import LatestNewsShare from './LatestNewsShare';

function search(e, dispatch) {
  dispatch({ type: 'LatestNews/query', payload: { lastTendencyTitle: e } });
}


class LatestNewsList extends React.Component {

  render() {
    return (
      <div>
        <WhiteSpace />
        <SearchBar placeholder="关键词搜索" maxLength={50} onSubmit={e => search(e, this.props.dispatch)} />
        <WhiteSpace />
        <LatestNewsShare nextPage={true} pullRefresh={true} scrollY={true} />
      </div>
    );
  }
}

export default connect()(LatestNewsList);
