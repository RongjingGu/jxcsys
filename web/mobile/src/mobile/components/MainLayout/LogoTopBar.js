import React from 'react';
import { connect } from 'dva';
// import styles from './IndexPage.less';


function LogoTopBar() {
  return (
    <div className="logo_top_bar">
      <span alt="" src="" className="top_bar_logo" />
      复旦大学附属肿瘤医院大肠外科
    </div>
  );
}

LogoTopBar.propTypes = {
};

export default connect()(LogoTopBar);
