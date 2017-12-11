import React from 'react';
import { connect } from 'dva';
import { List, WhiteSpace } from 'antd-mobile';
import Helmet from 'react-helmet';
import ElementAuth from '../../components/ElementAuth';
import styles from './MyPanel.less';

const Item = List.Item;
const pageTitle = '授权申请';


function EmpowerApply() {
  return (
    <div>
      <Helmet>
        <title>{pageTitle}</title>
        <meta name="description" content={pageTitle} />
      </Helmet>
      <div className={styles.sub_title}>申请者信息</div>
      <List className="my-list">
        <ElementAuth auth="empowerApply">
          <Item auth="name">姓名</Item>
        </ElementAuth>
      </List>
      <WhiteSpace />
    </div>

  );
}

function mapStateToProps(state) {
  const { detail } = state.MyPanel;
  console.log(detail);
  return {
    loading: state.loading.models.MyPanel,
    detail,
  };
}

export default connect(mapStateToProps)(EmpowerApply);
