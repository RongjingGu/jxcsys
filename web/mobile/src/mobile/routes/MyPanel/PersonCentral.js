import React from 'react';
import { connect } from 'dva';
import { List, Button, WhiteSpace } from 'antd-mobile';
import PageAuth from '../../components/PageAuth';
// import styles from './IndexPage.less';


const Item = List.Item;
function exit() {
  // @todo
  console.log('logout');
}

function Account({ history }) {
  return (
    <div>
      <List>
        <PageAuth auth={'account'}>
          <Item
            thumb="https://zos.alipayobjects.com/rmsportal/dNuvNrtqUztHCwM.png"
            arrow="horizontal"
            onClick={() => {
              history.push('/MyPanel/PersonCentral/Account');
            }}
          >账号信息</Item>
        </PageAuth>
        <PageAuth auth={'empower'}>
          <Item
            thumb="https://zos.alipayobjects.com/rmsportal/dNuvNrtqUztHCwM.png"
            arrow="horizontal"
            onClick={() => {
              history.push('/MyPanel/PersonCentral/Empower');
            }}
          >授权服务</Item>
        </PageAuth>
        <PageAuth auth={'pwd'}>
          <Item
            thumb="https://zos.alipayobjects.com/rmsportal/UmbJMbWOejVOpxe.png"
            onClick={() => {
              history.push('/MyPanel/PersonCentral/Pwd');
            }}
            arrow="horizontal"
          >
        密码设置
      </Item>
        </PageAuth>
        <PageAuth auth={'authInfo'}>
          <Item
            thumb="https://zos.alipayobjects.com/rmsportal/dNuvNrtqUztHCwM.png"
            arrow="horizontal"
            onClick={() => {}}
          >服务者信息</Item>
        </PageAuth>
      </List>
      <PageAuth auth={'notice'}>
        <WhiteSpace />
        <WhiteSpace />
        <List>
          <Item
            thumb="https://zos.alipayobjects.com/rmsportal/UmbJMbWOejVOpxe.png"
            arrow="horizontal"
            extra={(<div style={{ color: 'red' }}>1</div>)}
            onClick={() => {
              history.push('/MyPanel/PersonCentral/Notice');
            }}
          >
          通知
          </Item>
        </List>
      </PageAuth>
      <WhiteSpace />
      <WhiteSpace />
      <Button type="warning" onClick={exit}>退出</Button>
    </div>

  );
}

Account.propTypes = {
};

export default connect()(Account);
