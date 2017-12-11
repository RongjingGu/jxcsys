import React from 'react';
import { connect } from 'dva';
import { Modal, Button } from 'antd-mobile';
import styles from './DoctorInfo.less';
import ElementAuth from '../../components/ElementAuth';


class DoctorInfo extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      modal1: false,
    };
  }

  onClose = key => () => {
    this.setState({
      [key]: false,
    });
  }
  toChat = () => {
    location.href = '/Chat/ChatBox';
  }

  showModal = key => (e) => {
    e.preventDefault(); // 修复 Android 上点击穿透
   // const applicationStatus =''
    this.setState({
      [key]: true,
    });
  }

  render() {
    const applicationStatus = '';
    // const applicationStatus = 'underApplicating';
    // const applicationStatus = 'applicated';
    // const applicationStatus = 'applicatedOthers';

    return (

      <div className={styles.connent}>
        <div className={styles.heading}>
          <div className={styles.circle1} />
          <div className={styles.circle2} />
          <div className={styles.circle3}>
            <img src="/images/pic.png" alt="" />
          </div>
          {/* {curRole == 'crc'?
         (applicationStatus =='underApplicating'?
         <a className={styles.Applicationstatus1}>授权申请中</a>
         :applicationStatus =='applicated'?
         <a className={styles.Applicationstatus2}>已授权</a>
         :applicationStatus =='applicatedOthers'?
          <a className={styles.Applicationstatus3}>已授权他人</a>
         :applicationStatus ==''?
          <a className={styles.Applicationstatus4}></a>
         :'')
         :''} */}

          {/* <a className={styles.doctorInfo}>蔡三军</a>
            <a className={styles.doctorposition}>主任医师</a> */}
          {/* <p style={{ color: 'white', textAlign: 'center', marginTop: 5 }}>
            蔡三军<span style={{ marginLeft: 5 }}>主任医师</span> */}

          {applicationStatus == 'underApplicating' &&
          <ElementAuth auth="doctorInfo">
            <p className={styles.Applicationstatus1} auth="authStatus">授权申请中</p>
          </ElementAuth>
         }
          {applicationStatus == 'applicated' &&
          <ElementAuth auth="doctorInfo">
            <p className={styles.Applicationstatus2} auth="authStatus">已授权</p>
          </ElementAuth>
         }
          {applicationStatus == 'applicatedOthers' &&
          <ElementAuth auth="doctorInfo">
            <p className={styles.Applicationstatus3} auth="authStatus">已授权他人</p>
          </ElementAuth>
         }
          {applicationStatus == '' &&
          <ElementAuth auth="doctorInfo">
            <p className={styles.Applicationstatus4} auth="authStatus" />
          </ElementAuth>
         }
          <p style={{ color: 'white', textAlign: 'center', marginTop: 20 }}>
            蔡三军<span style={{ marginLeft: 5 }}>主任医师</span>
          </p>
        </div>
        {/* <div style={{height: 15,backgroundColor:"#ececff"}}></div> */}
        <div className={styles.bdconnnet}>
          <a >11</a>
          <br />
          <a style={{ textAlign: 'center' }}>22</a>
          <br />
          <a style={{ textAlign: 'center' }}>33</a>
          <br />
          <a style={{ textAlign: 'center' }}>44</a>
          <br />
          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>
          <br />
          <a style={{ textAlign: 'center' }}>11</a>
          <br />
          <a style={{ textAlign: 'center' }}>22</a>
          <br />
          <a style={{ textAlign: 'center' }}>33</a>
          <br />
          <a style={{ textAlign: 'center' }}>44</a>
          <br />
          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>
          <br />
          <a style={{ textAlign: 'center' }}>11</a>
          <br />
          <a style={{ textAlign: 'center' }}>22</a>
          <br />
          <a style={{ textAlign: 'center' }}>33</a>
          <br />
          <a style={{ textAlign: 'center' }}>44</a>
          <br />
          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>
          <br />
          <a style={{ textAlign: 'center' }}>11</a>
          <br />
          <a style={{ textAlign: 'center' }}>22</a>
          <br />
          <a style={{ textAlign: 'center' }}>33</a>
          <br />
          <a style={{ textAlign: 'center' }}>44</a>
          <br />
          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>
          <br />
          <a style={{ textAlign: 'center' }}>11</a>
          <br />
          <a style={{ textAlign: 'center' }}>22</a>
          <br />
          <a style={{ textAlign: 'center' }}>33</a>
          <br />
          <a style={{ textAlign: 'center' }}>44</a>
          <br />
          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>
          <br />
          <a style={{ textAlign: 'center' }}>11</a>
          <br />
          <a style={{ textAlign: 'center' }}>22</a>
          <br />
          <a style={{ textAlign: 'center' }}>33</a>
          <br />
          <a style={{ textAlign: 'center' }}>44</a>
          <br />
          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>
          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>
          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>

          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>
          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>
          <a style={{ textAlign: 'center' }}>55</a>
          <br />
          <a style={{ textAlign: 'center' }}>66</a>
        </div>
        <div style={{ height: 45, bottom: 0, position: 'fixed', width: '100%' }}>

          {applicationStatus == '' &&
          <ElementAuth auth="doctorInfo">
            <Button onClick={this.showModal('modal1')} style={{ backgroundColor: 'rgb(98, 207, 150)', width: '100%' }} auth="Request">
              <p style={{ color: 'white', margin: '0 auto', fontSize: 15 }} >
                <i className="icon iconfont icon-author" style={{ color: 'white', left: -15, top: 3, position: 'relative', fontSize: 24 }} />
                向TA发起服务申请</p></Button>
          </ElementAuth>
         }
          <ElementAuth auth="doctorInfo">
            <Button onClick={this.toChat} style={{ backgroundColor: 'rgb(98, 207, 150)', width: '100%' }} auth="Consultation">
              <p style={{ color: 'white', margin: '0 auto', fontSize: 15 }} >
                <i className="icon iconfont icon-zixun" style={{ color: 'white', left: -15, top: 3, position: 'relative', fontSize: 24 }} />
                向 TA 咨 询</p></Button>
          </ElementAuth>
          <Modal
            visible={this.state.modal1}
            transparent
            maskClosable={false}
            onClose={this.onClose('modal1')}
            title=""
            style={{ width: 220 }}
            footer={[{ text: '知道了', onPress: () => { console.log('ok'); this.onClose('modal1')(); } }]}
            wrapProps={{ onTouchStart: this.onWrapTouchStart }}
          >
            <div style={{ height: 30 }}>
            申请发送成功,请等待其授权
          </div>
          </Modal>
        </div>
      </div>

    );
  }
}

export default connect()(DoctorInfo);
