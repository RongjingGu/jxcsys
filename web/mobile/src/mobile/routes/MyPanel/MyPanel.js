import React from 'react';
import { connect } from 'dva';
import { Grid } from 'antd-mobile';
import Helmet from 'react-helmet';
import MainLayout from '../../components/MainLayout/MainLayout';
// import styles from './IndexPage.less';
import styles from './MyPanel.less';

const List = [
    { title: '个人中心', href: '/MyPanel/PersonCentral', iconClass: ' iconfont icon-iconfontgerenzhongxin ', auth: ['doc', 'pat', 'crc'] },
    { title: '我的咨询', href: '/Chat/MyChat', iconClass: 'iconfont icon-duanxin', auth: ['pat'] },
    { title: '我的档案', href: '/MyArchive/MyArchive', iconClass: 'iconfont icon-hua', auth: ['pat'] },
    { title: '咨询记录', href: '/Chat/MyChat', iconClass: 'iconfont icon-duanxin', auth: ['doc'] },
    { title: '我的服务', href: '/MySubject', iconClass: 'iconfont icon-aixin1', auth: ['crc'] },
    { title: '我的病例', href: '/MyCase', iconClass: 'iconfont icon-dangan-copy', auth: ['doc', 'crc'] },
    { title: '我的课题', href: '/MySubject', iconClass: 'iconfont icon-lingdang', auth: ['doc'] },


];


const pageTitle = '我的';


function getAuth() {
  const authList = [];
  List.map((_val) => {
   // console.log(_val.auth.includes('pat') )
    if (_val.auth && _val.auth.includes('doc')) {
      authList.push(_val);
    }
    // if (_val.auth && _val.auth.includes('doc')) {
    //   authList.push(_val);
    // }
    // if (_val.auth && _val.auth.includes('crc')) {
    //   authList.push(_val);
    // }
  });
  return authList;
}

const data = Array.from(getAuth()).map(_val => ({
  text: (<p><i className={_val.iconClass} style={{ fontSize: 24, left: 28, position: 'relative', top: -25 }} />
    <span style={{ left: -9, top: 4, position: 'relative', color: 'rgb(102,122,131)', fontSize: 12 }} >{_val.title}</span></p>),
  href: _val.href,
}));

function redirect(el, index, { history }) {
  console.log(el);
  console.log(history);
  history.push(el.href);
}

function MyPanel({ location, history }) {
  console.log(history);
  return (

    <MainLayout location={location}>
      <Helmet>
        <title>{pageTitle}</title>
        <meta name="description" content={pageTitle} />
      </Helmet>
      <div >
        {/* <div className="sub-title">Always square grid item 111</div> */}
        <div className={styles.heading}>
          <div className={styles.circle1} />
          <div className={styles.circle2} />
          <div className={styles.circle3}>
            <img src="/images/pic.png" alt="" />
          </div>
          <p style={{ color: 'white', textAlign: 'center', marginTop: 20, fontSize: 15 }}>
            蔡三军<span style={{ marginLeft: 5 }}>, 欢迎你</span>
          </p>
        </div>
        <div className={styles.gridconnet}>
          <Grid
            data={data} activeStyle={false}
            columnNum={3}
            className={styles.mine}
            onClick={(el, index) => redirect(el, index, { history })}
          />
        </div>
        <div className={styles.zzz} />
      </div>
    </MainLayout>
  );
}

MyPanel.propTypes = {
};

export default connect()(MyPanel);
