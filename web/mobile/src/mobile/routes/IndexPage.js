import React from 'react';
import { connect } from 'dva';
import { SearchBar } from 'antd-mobile';
import Helmet from 'react-helmet';
import MainLayout from '../components/MainLayout/MainLayout';
import RollGraph from '../components/IndexPage/RollGraph';
import WorkShopIndex from '../routes/WorkShop/WorkShopIndex';
import LatestNewsIndex from '../routes/LatestNews/LatestNewsIndex';
import LogoTopBar from '../components/MainLayout/LogoTopBar';
import HottopicList from '../routes/Hottopic/HottopicList';


const pageTitle = '首页';

function IndexPage({ location }) {
  return (
    <MainLayout location={location}>
      <Helmet>
        <title>{pageTitle}</title>
        <meta name="description" content={pageTitle} />
      </Helmet>
      <LogoTopBar />
      <RollGraph />
      <div className="line_gradient" />
      <WorkShopIndex />
      {/* <HotSubjectIndex />
      <LatestNewsIndex /> */}
      <HottopicList />
      <LatestNewsIndex />
      <SearchBar
        placeholder="搜索1"
      />
      <SearchBar
        placeholder="搜索2"
      />
      <SearchBar
        placeholder="搜索3"
      />
    </MainLayout>
  );
}

IndexPage.propTypes = {
};

export default connect()(IndexPage);
