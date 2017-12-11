// import React from 'react';
// import { Menu, Icon } from 'antd';
// import { Link } from 'dva/router';
import React from 'react';
import { TabBar } from 'antd-mobile';
import PropTypes from 'prop-types';
import { withRouter } from 'react-router';
import styles from './MainLayout.less';

let tabTitle = '咨询记录';
class ChatFooter extends React.Component {

  static propTypes = {
    location: PropTypes.object.isRequired,
    history: PropTypes.object.isRequired,
  }
  render() {
    const { location, history } = this.props;
    const { curRole } = sessionStorage;
    if (curRole == 'crc') {
      tabTitle = '我的服务';
    } else if (curRole == 'patient') {
      tabTitle = '我的咨询';
    }
    return (

      <div id={styles.footTab}>
        <TabBar
          unselectedTintColor="#949494"
          tintColor="#33A3F4"
          barTintColor="white"
          style={{ height: '100px' }}
        >
          <TabBar.Item
            title="医生团队"
            key="DoctorList"
            selected={location.pathname === '/Chat/DoctorList'}
            onPress={() => {
              history.push('/Chat/DoctorList');
            }}
            icon={<i />}
            selectedIcon={<i />}
            style={{
              borderRight: '1px solid #ccc',
            }}
          >
            {/* {this.renderContent('Life')} */}
          </TabBar.Item>
          <TabBar.Item
            title="热门咨询"
            key="HotChats"
            selected={location.pathname === '/Chat/HotChats'}
            onPress={() => {
              history.push('/Chat/HotChats');
            }}
            icon={<i />}
            selectedIcon={<i />}
          >
            {/* {this.renderContent('Koubei')} */}
          </TabBar.Item>
          <TabBar.Item
            title={tabTitle}
            key="MyChat"
            dot={true}
            onPress={() => {
              history.push('/Chat/MyChat');
            }}
            selected={location.pathname === '/Chat/MyChat'}
            icon={<i />}
            selectedIcon={<i />}
          >
            {/* {this.renderContent('Friend')} */}
          </TabBar.Item>
        </TabBar>
      </div>

    );
  }

  // return (
  //   <Menu
  //     selectedKeys={[location.pathname]}
  //     mode="horizontal"
  //     theme="dark"
  //   >
  //     <Menu.Item key="/users">
  //       <Link to="/users"><Icon type="bars" />Users</Link>
  //     </Menu.Item>
  //     <Menu.Item key="/">
  //       <Link to="/"><Icon type="home" />Home</Link>
  //     </Menu.Item>
  //     <Menu.Item key="/404">
  //       <Link to="/page-you-dont-know"><Icon type="frown-circle" />404</Link>
  //     </Menu.Item>
  //     <Menu.Item key="/antd">
  //       <a href="https://github.com/dvajs/dva" target="_blank">dva</a>
  //     </Menu.Item>
  //   </Menu>
  // );
}

export default withRouter(ChatFooter);
