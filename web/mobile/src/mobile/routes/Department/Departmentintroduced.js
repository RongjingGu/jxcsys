import React from 'react';
import { connect } from 'dva';
import Helmet from 'react-helmet';
import MainLayout from '../../components/MainLayout/MainLayout';
import LogoTopBar from '../../components/MainLayout/LogoTopBar';
import styles from './Department.less';

const pageTitle = '科室介绍';
class Departmentintroduced extends React.Component {

  render() {
    return (
      <MainLayout location={location}>
        <Helmet>
          <title>{pageTitle}</title>
          <meta name="description" content={pageTitle} />
        </Helmet>
        <div>
          <div className={styles.LogoTop}>
            <LogoTopBar />
          </div>
          <div>

            <p className={styles.introduced}> xxxx</p>
          </div>
        </div>

      </MainLayout>
    );
  }
    }

export default connect()(Departmentintroduced);
