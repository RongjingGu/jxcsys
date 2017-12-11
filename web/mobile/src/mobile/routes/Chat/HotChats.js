import React from 'react';
import { SearchBar } from 'antd-mobile';
import { connect } from 'dva';
import Helmet from 'react-helmet';
import HotChatsList from './HotChatsList';
import ChatFooter from '../../components/MainLayout/ChatFooter';

function search(e, dispatch) {
  dispatch({ type: 'LatestNews/query', payload: { page: e } });
}


const pageTitle = '热门咨询';

class HotChats extends React.Component {

  render() {
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
        <SearchBar placeholder="请输入关键字搜索" maxLength={50} onSubmit={e => search(e, this.props.dispatch)} />
        <HotChatsList nextPage={true} pullRefresh={true} scrollY={true} />

        <ChatFooter />
      </div>
    );
  }
}

export default connect()(HotChats);
