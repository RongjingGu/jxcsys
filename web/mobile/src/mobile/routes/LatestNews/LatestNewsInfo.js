import React from 'react';
// import { SearchBar, WhiteSpace, List } from 'antd-mobile';
import { connect } from 'dva';

class LatestNewsInfo extends React.Component {


  render() {
    console.log(this.props.match.params.id);
    return (
      <div className="art_main">
        {this.props.match.params.id}
        <a href="tel:15052201860">电话</a>
        <div className="art_title" >
          这是文章标题
        </div>
        <p className="art_time">
          2017-06-07
        </p>
        <div className="art_content">
          详细内容
        </div>
      </div>
    );
  }
}

export default connect()(LatestNewsInfo);
