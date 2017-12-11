import React from 'react';
import ReactDOM from 'react-dom';
import io from 'socket.io-client';
import { PullToRefresh } from 'antd-mobile';
import styles from './Chat.less';

const socket = io('http://192.168.10.14:3000');

class App extends React.Component {
  state = {
    data: [1, 2, 3],
    typeMsg: '',
    img: '',
    refreshing: false,
    down: true,
    height: document.documentElement.clientHeight,
    initMsg: [
    ],
  }

  componentDidMount() {
    console.log(this.state.height);
    const hei = this.state.height - ReactDOM.findDOMNode(this.ptr).offsetTop - 80;
    console.log(hei);
    setTimeout(() => this.setState({
      height: hei,
      initMsg: [{
        type: 'me',
        msg: 'fffrerrrrrrrrrrrrrrrrrrrrrrrrrrrrr ggggggggggggggggggg',
      },
      {
        type: 'me',
        msg: '第二条我的',
      },
      {
        type: 'you',
        msg: '第一条你的',
      },
      {
        type: 'you',
        msg: '第一条你的',
      },
      {
        type: 'you',
        msg: '第一条你的',
      },
      {
        type: 'you',
        msg: '第一条你的',
      },
      {
        type: 'you',
        msg: '第一条你的',
      },
      {
        type: 'you',
        msg: '第一条你的',
      },
      {
        type: 'you',
        msg: '第一条你的',
      },
      {
        type: 'you',
        msg: '第一条你的',
      },
      {
        type: 'you',
        msg: '第一条你的',
      },
      {
        type: 'you',
        msg: '第一条你的',
      },
      {
        type: 'you',
        msg: '最后一條',
      },
      ],
      getMsg: [],
      hisMsg: [{
        type: 'you',
        msg: '历史第一条你的',
      },
      {
        type: 'me',
        msg: '历史第一条我的',
      },
      {
        type: 'you',
        msg: '历史第二条你的',
      },
      ],
    }), 0);
    socket.on('chat message', (newMsg) => {
      // if (this.refs.myRef) {
      const { data } = this.state;
      data.push(newMsg);
      console.log(data);
      this.setState({
        data,
      });
     // }
    });
    window.wx.config({
      debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
      appId: 'wxc29c57adf3f17e04', // 必填，公众号的唯一标识
      timestamp: 151080214, // 必填，生成签名的时间戳
      nonceStr: 'saz6f2aoSC4Ouf7m', // 必填，生成签名的随机串
      signature: 'ea419aa7cd3778fc97d3e1435e037c44a0a577be', // 必填，签名，见附录1
      jsApiList: [
        'checkJsApi',
        'onMenuShareTimeline',
        'onMenuShareAppMessage',
        'onMenuShareQQ',
        'onMenuShareWeibo',
        'onMenuShareQZone',
        'hideMenuItems',
        'showMenuItems',
        'hideAllNonBaseMenuItem',
        'showAllNonBaseMenuItem',
        'translateVoice',
        'startRecord',
        'stopRecord',
        'onVoiceRecordEnd',
        'playVoice',
        'onVoicePlayEnd',
        'pauseVoice',
        'stopVoice',
        'uploadVoice',
        'downloadVoice',
        'chooseImage',
        'previewImage',
        'uploadImage',
        'downloadImage',
        'getNetworkType',
        'openLocation',
        'getLocation',
        'hideOptionMenu',
        'showOptionMenu',
        'closeWindow',
        'scanQRCode',
        'chooseWXPay',
        'openProductSpecificView',
        'addCard',
        'chooseCard',
        'openCard',
      ], // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    window.wx.ready(() => {
      // alert(location.href.split('#')[0]);

      // alert('weixinready');
          // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，
          // config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则
          // 须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
    });
  }

  // componentDidMount() {
  //   socket.on(`server:event`, data => {
  //     this.setState({ data })
  //   })
  // }

  // sendMessage = () => {
  //   const {typeMsg} = this.state;
  //   socket.emit(`client:sendMessage`, typeMsg);
  //   this.setState({
  //     typeMsg:""
  //   })
  // }
  sendMessage = () => {
    const { typeMsg } = this.state;
    socket.emit('chat message', typeMsg);
    this.setState({
      typeMsg: '',
    });
  }

  typeMsg = (value) => {
    this.setState({
      typeMsg: value,
    });
  }

  sendPic = () => {
    // window.wx.chooseImage({
    //   count: 1, // 默认9
    //   sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
    //   sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
    //   success(res) {
    //     const localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
    //     window.wx.uploadImage({
    //       localId: localIds.toString(), // 需要上传的图片的本地ID，由choos eImage接口获得
    //       isShowProgressTips: 1, // 默认为1，显示进度提示
    //       success(res1) {
    //         const serverId = res1.serverId; // 返回图片的服务器端ID
    //         console.log(serverId);
    //         window.wx.downloadImage({
    //           serverId, // 需要下载的图片的服务器端ID，由uploadImage接口获得
    //           isShowProgressTips: 1, // 默认为1，显示进度提示
    //           success(res2) {
    //             const localId = res2.localId; // 返回图片下载后的本地ID
    //             window.wx.getLocalImgData({
    //               localId, // 图片的localID
    //               // success(res3) {
    //               //   const localData = res3.localData; // localData是图片的base64数据，可以用img标签显示
    //               //   console.log(res3);
    //               // },
    //             });
    //           },
    //         });
    //       },
    //     });
    //   },
    // });
    window.wx.previewImage({
      current: 'http://images0.cnblogs.com/blog2015/835/201508/061652238306577.png', // 当前显示图片的http链接
      urls: ['http://images0.cnblogs.com/blog2015/835/201508/061652238306577.png', 'http://blog.backand.com/wp-content/uploads/2014/08/LAMP-vs-MEAN.jpg', 'http://mmbiz.qpic.cn/mmbiz/DQhUDoDvrLnX8ibKvXNqWRCZXibZRTYNudKo7uzZhU80sndPiax2z5DdaXKibrtv2nUZSEDbz9bRK5yoxZJS19TYzw/0?wx_fmt=png'], // 需要预览的图片http链接列表
    });
  }

  render() {
    const { data, typeMsg, img, initMsg, hisMsg } = this.state;
    console.log(data, typeMsg);
    return (
      <div className={styles.chatBox}>
        <div className={styles.docBox} style={{ height: '80px' }}>
          医生信息
        </div>


        {/* <div className={`${styles.clear} ${styles.chat_msg}`}>
          <div className={`${styles.me} ${styles.message}`}>
            <img className={styles.avatar} alt="" src="https://q.qlogo.cn/g?b=qq&nk=522784020&s=100&t=1510717450388" title="徐春晓" />
            <div className={styles.content}>
              <div className={`${styles.bubble} ${styles.bubble_primary} ${styles.right}`}>
                <div className={styles.bubble_cont}>
                  <div className={styles.plain}>
                    <div className={styles.js_msg_plain}>
                    测试文字显示
                  </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div> */}

        {/* <div className={`${styles.clear} ${styles.chat_msg}`}>
          <div className={`${styles.you} ${styles.message}`}>
            <img className={styles.avatar} alt="" src="https://q.qlogo.cn/g?b=qq&nk=522784020&s=100&t=1510717450388" title="徐春晓" />
            <div className={styles.content}>
              <div className={`${styles.bubble} ${styles.bubble_default} ${styles.left}`}>
                <div className={styles.bubble_cont}>
                  <div className={styles.plain}>
                    <div className={styles.js_msg_plain}>
                    测试文字显示测试文字显示  测试文字显示测试文字显  示测试文字显示测试文字显示
                  </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div> */}
        <PullToRefresh
          ref={el => this.ptr = el}
          style={{
            height: this.state.height,
            overflow: 'auto',
          }}
          indicator={this.state.down ? {} : { deactivate: '上拉可以刷新' }}
          direction={this.state.down ? 'down' : 'up'}
          refreshing={this.state.refreshing}
          onRefresh={() => {
            this.setState({ refreshing: true });
            initMsg.unshift(...hisMsg);
            setTimeout(() => {
              this.setState({
                refreshing: false,
                initMsg,
              });
            }, 1000);
          }}
        >
          <div className={styles.msg_system}>
            <div className={`${styles.content}`}>
            11:46
          </div>
          </div>
          {
          initMsg.map((val) => {
            if (val.type === 'me') {
              return (
                <div className={`${styles.clear} ${styles.chat_msg}`}>
                  <div className={`${styles.me} ${styles.message}`}>
                    <img className={styles.avatar} alt="" src="https://q.qlogo.cn/g?b=qq&nk=522784020&s=100&t=1510717450388" title="徐春晓" />
                    <div className={styles.content}>
                      <div className={`${styles.bubble} ${styles.bubble_primary} ${styles.right}`}>
                        <div className={styles.bubble_cont}>
                          <div className={styles.plain}>
                            <div className={styles.js_msg_plain}>
                              {val.msg}
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              );
            } else if (val.type === 'you') {
              return (
                <div className={`${styles.clear} ${styles.chat_msg}`}>
                  <div className={`${styles.you} ${styles.message}`}>
                    <img className={styles.avatar} alt="" src="https://q.qlogo.cn/g?b=qq&nk=522784020&s=100&t=1510717450388" title="徐春晓" />
                    <div className={styles.content}>
                      {/* <h4 className={styles.nickname}>褚树明</h4> */}
                      <div className={`${styles.bubble} ${styles.bubble_default} ${styles.left}`}>
                        <div className={styles.bubble_cont}>
                          <div className={styles.plain}>
                            <div className={styles.js_msg_plain}>
                              {val.msg}
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              );
            }
          })
        }
        </PullToRefresh>
        {/* <div className={styles.messagebox}>
          {
            data.map((val) => {
              return (
                <p>{val}</p>
              );
            })
          }
        </div> */}

        {/* <div className={styles.inputBox}
        style={{ position: 'fixed', bottom: '0px', height: '80px' }}>
          <List>
            <InputItem
              // {...getFieldProps('autofocus')}
              clear
              placeholder="auto focus"
              ref={el => this.autoFocusInst = el}
              extra={(<div><span onClick={this.sendPic}>加号</span></div>)}
              returnKeyType
              onChange={this.typeMsg}
              value={typeMsg}
            />
          </List>
          <button onClick={this.sendMessage}>提交</button>
        </div> */}

        <div className={styles.chats_bar}>
          <div className={styles.upload_btn}>
            <img onClick={this.sendPic} src="https://h2img.guahao.com/h5/img/quankezixun/icon_img_up.png?20170112&_=fdd606c" alt="" />
          </div>
          <textarea className={styles.text_input} id="J_Msg" placeholder="请描述病情..." />
          <button className={styles.send_btn}>发送</button>
        </div>


      </div>
    );
  }
}

export default App;
