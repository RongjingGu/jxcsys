import React from 'react';
import { List, WingBlank, Carousel, Flex } from 'antd-mobile';
import { connect } from 'dva';
import { Link } from 'dva/router';
import styles from './Hottopic.less';


class HottopicList extends React.Component {
  state = {
    data: ['', '', ''],
    initialHeight: 176,
  }


  render() {
    return (
      <div>
        <List renderHeader={() => { return (<div className="list_header_title"> 热门话题 <Link to="/WorkShop/WorkShopList" className="bar_more">更多&gt;</Link> </div>); }} className="my-list">

          <WingBlank size="md" className="clearPrefix">
            <Carousel
              className={styles.carousel}
              autoplay={false}
              infinite
              selectedIndex={1}
              swipeSpeed={35}
              beforeChange={(from, to) => console.log(`slide from ${from} to ${to}`)}
              afterChange={index => console.log('slide to', index)}
            >
              {this.state.data.map(() => (
                <a style={{ height: '160px', display: 'block' }}>
                  <Flex>
                    <Flex.Item>
                      <div className={styles.doc_flex}>
                        <div className={styles.img_box}>
                          <a href="/WorkShop/WorkShopList"><img
                            src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3859995904,214476591&fm=173&s=A0D23DCC46540477CCAC4DB20300C092&w=218&h=146&img.JPG"
                            alt="" className={styles.doctor_img}
                          /></a>

                        </div>
                        <p>遗传性癌</p>
                      </div>
                    </Flex.Item>
                    <Flex.Item>
                      <div className={styles.doc_flex}>
                        <div className={styles.img_box}>
                          <a href="/WorkShop/WorkShopList"><img
                            src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3859995904,214476591&fm=173&s=A0D23DCC46540477CCAC4DB20300C092&w=218&h=146&img.JPG"
                            alt="" className={styles.doctor_img}
                          /></a>
                        </div>
                        <p>原发性癌</p>
                      </div>
                    </Flex.Item>
                  </Flex>
                </a>


        ))}
            </Carousel>
          </WingBlank>
        </List>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return {
    loading: state.loading.models.HottopicModel,
  };
}


export default connect(mapStateToProps)(HottopicList);
