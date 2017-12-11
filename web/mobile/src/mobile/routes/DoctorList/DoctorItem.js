import React from 'react';
import { List } from 'antd-mobile';
import { withRouter } from 'react-router';
import styles from './DoctorList.less';
import ElementAuth from '../../components/ElementAuth';

const Item = List.Item;
const Brief = Item.Brief;

class DoctorItem extends React.Component {

  render() {
    const value = this.props.value;
    let authDOM = (<div />);
    if (value.AuthAble === 'ready') {
      authDOM = (<span className={styles.btn_green}>
        已授权
      </span>);
    } else if (value.AuthAble === 'pedding') {
      authDOM = (<span className={styles.btn_orange}>
        授权申请中
      </span>);
    } else if (value.AuthAble === 'other') {
      authDOM = (<span className={styles.btn_grey}>
        已授权他人
      </span>);
    }
    console.log(value);
    return (
      <div className={styles.doctor_list}>
        <ElementAuth auth="DoctorItem">
          {/* 病人角色 */}
          <Item
            thumb="https://zos.alipayobjects.com/rmsportal/dNuvNrtqUztHCwM.png"
            multipleLine
            onClick={() => {
              this.props.history.push(`/Chat/DoctorList/${value.name}`);
            }}
            auth="chat"
            extra={(value.chatAble && <span className={styles.btn_green}>
                可咨询
              </span>)}
          >
            {value.name} <span className={styles.position}>主任医师</span>
            <Brief>
                擅长：{value.address && value.address.street}<br />
              <p className={styles.chat_number}><i className="icon iconfont icon-zixun" />咨询量: {value.phone}</p>
            </Brief>
          </Item>
          {/* 医助角色 */}
          <Item
            thumb="https://zos.alipayobjects.com/rmsportal/dNuvNrtqUztHCwM.png"
            multipleLine
            onClick={() => {
              this.props.history.push(`/Chat/DoctorList/${value.name}`);
            }}
            auth="auth"
            extra={authDOM}
          >
            {value.name} <span className={styles.position}>主任医师</span>
            <Brief>
                擅长：{value.address && value.address.street}<br />
              <p className={styles.chat_number}><i className="icon iconfont icon-zixun" />咨询量: {value.phone}</p>
            </Brief>
          </Item>
          {/* 医生角色 */}
          <Item
            thumb="https://zos.alipayobjects.com/rmsportal/dNuvNrtqUztHCwM.png"
            multipleLine
            onClick={() => {
              this.props.history.push(`/Chat/DoctorList/${value.name}`);
            }}
            auth="nothing"
          >
            {value.name} <span className={styles.position}>主任医师</span>
            <Brief>
                擅长：{value.address && value.address.street}<br />
              <p className={styles.chat_number}><i className="icon iconfont icon-zixun" />咨询量: {value.phone}</p>
            </Brief>
          </Item>
        </ElementAuth>
      </div>
    );
  }
}

export default withRouter(DoctorItem);

