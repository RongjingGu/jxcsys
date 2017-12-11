import React from 'react';
import { SearchBar, WhiteSpace, List } from 'antd-mobile';
import { connect } from 'dva';
import WorkShopShare from './WorkShopShare';

function search(e, dispatch) {
  console.log(e);
  dispatch({ type: 'WorkShop/query', payload: { page: e } });
}


class WorkShopList extends React.Component {

  render() {
    return (
      <div>
        <WhiteSpace />
        <SearchBar placeholder="关键词搜索" maxLength={50} onSubmit={e => search(e, this.props.dispatch)} />
        <WhiteSpace />
        <List >
          <WorkShopShare nextPage={true} pullRefresh={true} scrollY={true} />
        </List>
      </div>
    );
  }
}

export default connect()(WorkShopList);
