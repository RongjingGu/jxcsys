import React from 'react';
import { List, WingBlank, WhiteSpace } from 'antd-mobile';
import { connect } from 'dva';
import { Link } from 'dva/router';
// import styles from './WorkShop.less';

class DepartmentInfoIndex extends React.Component {
  render() {
    return (
      <div>
        <List renderHeader={() => { return (<div className="list_header_title"> 科室介绍 <Link to="/Department/Departmentintroduced" className="bar_more">更多&gt;</Link> </div>); }} className="my-list">
          <WhiteSpace />
          <WingBlank size="md" className="clearPrefix">
            <div style={{ width: '35%' }}><img alt="" src="/images/keshijieshao.jpg" style={{ height: '80px', float: 'left', width: '100%' }} /></div>
            <div className="text-ellipsis list_info_text" style={{ textIndent: '2em' }}>
              text-ellipsistext-e llipsistext- ellipsi stext-e llips istext-ell
              ipsistext- ellipsistext-e llip sistex t-ellipsist ext-elli psiste
              xt-ellips  istext-ellipsi stext-
              ellipsistext-ellipsistext-ellipsistext-ellipsistext-ellipsis
            </div>
          </WingBlank>
          <WhiteSpace />
        </List>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return {
    loading: state.loading.models.DepartmentInfo,
  };
}

export default connect(mapStateToProps)(DepartmentInfoIndex);
