import React from 'react';
import { connect } from 'dva';
import { List, InputItem, WingBlank, Button, WhiteSpace, Modal } from 'antd-mobile';
import { createForm } from 'rc-form';
import Helmet from 'react-helmet';
import ElementAuth from '../../components/ElementAuth';
import styles from './MyPanel.less';

const alert = Modal.alert;
const pageTitle = '修改密码';

function updatePwd() {
  console.log('修改密码');
}

function Pwd() {
  return (
    <div>
      <Helmet>
        <title>{pageTitle}</title>
        <meta name="description" content={pageTitle} />
      </Helmet>
      <ElementAuth auth="pwd">
        <div className={styles.sub_title}>修改密码后,请使用新密码登陆</div>
        <List>
          <InputItem
            type="password"
            placeholder="旧密码"
          />
          <InputItem
            type="password"
            placeholder="新密码"
          />
          <InputItem
            type="password"
            placeholder="确认密码"
          />
        </List>
        <WhiteSpace />
        <WingBlank>
          <Button
            className="empower-button"
            type="primary"
            icon="check-circle-o"
            onClick={() => alert('提示', '确定修改密码?', [
          { text: '取消', onPress: () => console.log('cancel') },
          { text: '确定', onPress: () => updatePwd() },
            ])}
          >确认</Button>
        </WingBlank>
      </ElementAuth>
    </div>

  );
}

Pwd.propTypes = {
};

function mapStateToProps(state) {
  const { detail } = state.MyPanel;
  console.log(detail);
  return {
    loading: state.loading.models.MyPanel,
    detail,
  };
}
const PwdWrapper = createForm()(Pwd);
export default connect(mapStateToProps)(PwdWrapper);
