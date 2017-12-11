import React from 'react';
// import { SearchBar, WhiteSpace, List } from 'antd-mobile';
import { connect } from 'dva';

class WorkShopInfo extends React.Component {


  render() {
    return (
      <div>
        {this.props.match.params.id}
        <a href="tel:15052201860">电话</a>
      </div>
    );
  }
}

export default connect()(WorkShopInfo);
