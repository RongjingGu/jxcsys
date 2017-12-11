import React from 'react';
import { SearchBar } from 'antd-mobile';
import { connect } from 'dva';
import Helmet from 'react-helmet';
import MyChatTypes from './MyChatTypes';
import ChatFooter from '../../components/MainLayout/ChatFooter';

function search(e, dispatch) {
  dispatch({ type: 'LatestNews/query', payload: { page: e } });
}


let pageTitle = '咨询记录';

class LatestNewsList extends React.Component {

  render() {
    const { curRole } = sessionStorage;
    if (curRole == 'crc') {
      pageTitle = '我的服务';
    } else if (curRole == 'patient') {
      pageTitle = '我的咨询';
    }
    return (
      <div>
        <Helmet>
          <title>{pageTitle}</title>
          <meta name="description" content={pageTitle} />
          <style type="text/css">{`
                body,#root,.am-search{
                    background-color: #ddeaf0;
                }
          `}</style>
        </Helmet>
        <SearchBar placeholder="请输入问题\医生\患者搜索" maxLength={50} onSubmit={e => search(e, this.props.dispatch)} />
        <MyChatTypes nextPage={true} pullRefresh={true} scrollY={true} />
        <ChatFooter />
      </div>
    );
  }
}

export default connect()(LatestNewsList);
