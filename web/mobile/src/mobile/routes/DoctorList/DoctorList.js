import React from 'react';
import { connect } from 'dva';
import PropTypes from 'prop-types';
import { withRouter } from 'dva/router';
import Helmet from 'react-helmet';
import styles from './DoctorList.less';
import DoctorItem from './DoctorItem';
import ChatFooter from '../../components/MainLayout/ChatFooter';

const pageTitle = '医生团队';
class DoctorList extends React.Component {

  render() {
    return (
      <div className={styles.WorkShopIndex}>
        <Helmet>
          <title>{pageTitle}</title>
          <meta name="description" content={pageTitle} />
        </Helmet>
        {/* {withRouter(renderList({ list: this.props.list }))} */}
        {this.props.list.map((value) => {
          return <DoctorItem value={value} key={value.name} />;
        })
        }
        <ChatFooter />
      </div>
    );
  }
}

DoctorList.PropTypes = {
  list: PropTypes.array,
};

function mapStateToProps(state) {
  const { list, total, page } = state.DoctorList;
  return {
    loading: state.loading.models.DoctorList,
    list,
    total,
    page,
  };
}


export default connect(mapStateToProps)(withRouter(DoctorList));
