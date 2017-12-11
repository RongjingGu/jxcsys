import React from 'react';
import { connect } from 'dva';
import { List, WhiteSpace } from 'antd-mobile';
import Helmet from 'react-helmet';
import ElementAuth from '../../components/ElementAuth';
// import styles from './IndexPage.less';

const pageTitle = '帐号信息';
const Item = List.Item;

function Account({ detail }) {
  const { name,
  patientNo,
  mobile,
  email,
  enterprise,
  department } = detail;
  return (
    <div>
      <Helmet>
        <title>{pageTitle}</title>
        <meta name="description" content={pageTitle} />
      </Helmet>
      <List className="my-list">
        <ElementAuth auth="account">
          <Item extra={name} auth="name">姓名</Item>
          <Item extra={patientNo} auth="patientNo">住院号</Item>
          <Item extra={patientNo}>没有auth</Item>
          <Item extra={mobile} auth="mobile">手机号</Item>
          <Item extra={email} auth="email">邮箱</Item>
          <Item extra={enterprise} auth="enterprise">单位</Item>
          <Item extra={department} auth="department">部门科室</Item>
        </ElementAuth>
      </List>
      <WhiteSpace />
      <WhiteSpace />
    </div>

  );
}

Account.propTypes = {
};

function mapStateToProps(state) {
  const { detail } = state.MyPanel;
  console.log(detail);
  return {
    loading: state.loading.models.Account,
    detail,
  };
}

export default connect(mapStateToProps)(Account);
