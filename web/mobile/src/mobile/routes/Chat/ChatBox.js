import React from 'react';
import { connect } from 'dva';
import styles from './Chat.less';
import ChatComponent from './Chat';

function Chat() {
  return (
    <div className={styles.normal}>
      <ChatComponent />
    </div>
  );
}

export default connect()(Chat);
