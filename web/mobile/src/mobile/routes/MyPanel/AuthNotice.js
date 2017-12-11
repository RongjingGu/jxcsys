import React from 'react';
import { connect } from 'dva';
import { withRouter } from 'dva/router';
import { List, SwipeAction } from 'antd-mobile';
import Helmet from 'react-helmet';
import ElementAuth from '../../components/ElementAuth';
// import styles from './MyPanel.less';

const Item = List.Item;
const Brief = Item.Brief;
const pageTitle = '消息';
// const alert = Modal.alert;

// function deleteNotice() {
//   console.log('清空列表');
// }

class AuthNotice extends React.Component {

  render() {
    const value = this.props.value;
    console.log(value);
    return (
      <div>
        <Helmet>
          <title>{pageTitle}</title>
          <meta name="description" content={pageTitle} />
        </Helmet>
        {/* <div
          className={styles.sub_delete}
          onClick={() => alert('提示', '确定清空消息列表?', [
            { text: '取消', onPress: () => console.log('cancel') },
            { text: '确定', onPress: () => deleteNotice() },
          ])}
        /> */}
        <List className="my-list">
          <ElementAuth auth="notice">
            <SwipeAction
              style={{ backgroundColor: 'gray' }}
              autoClose
              right={[
                {
                  text: '删除',
                  onPress: () => console.log('delete'),
                  style: { backgroundColor: '#F4333C', color: 'white' },
                },
              ]}
              onOpen={() => console.log('global open')}
              onClose={() => console.log('global close')}
            >
              <Item
                onClick={() => {
                  this.props.history.push(`/MyPanel/EmpowerApply/${value.id}`);
                }}
                extra={value.phone}
                align="top"
                thumb="https://zos.alipayobjects.com/rmsportal/dNuvNrtqUztHCwM.png" multipleLine
              >
                {value.email} <Brief>您提交的服务正在审核中{value.username}</Brief>
              </Item>
            </SwipeAction>
          </ElementAuth>
        </List>
      </div>

    );
  }
}

function mapStateToProps(state) {
  const { detail } = state.MyPanel;
  console.log(detail);
  return {
    loading: state.loading.models.MyPanel,
    detail,
  };
}

export default connect(mapStateToProps)(withRouter(AuthNotice));
