import React from 'react';
import { Carousel } from 'antd-mobile';
import styles from './IndexPage.less';

class RollGraph extends React.Component {
  state = {
    data: ['', '', ''],
    initialHeight: 176,
  }
  componentDidMount() {
    // simulate img loading
    setTimeout(() => {
      this.setState({
        data: ['AiyWuByWklrrUDlFignR', 'TekJlZRVCjLFexlOCuWn', 'IJOtIlfsYdTyaDTRVrLI'],
      });
    }, 100);
  }
  render() {
    const hProp = this.state.initialHeight ? { height: this.state.initialHeight } : {};
    return (
      <Carousel
        className={styles.carousel}
        autoplay={false}
        infinite
        selectedIndex={1}
        swipeSpeed={35}
        beforeChange={(from, to) => console.log(`slide from ${from} to ${to}`)}
        afterChange={index => console.log('slide to', index)}
      >
        {this.state.data.map(ii => (
          <a href="http://www.baidu.com" key={ii} style={hProp}>
            <img
              src={`https://zos.alipayobjects.com/rmsportal/${ii}.png`}
              alt=""
              onLoad={() => {
                // fire window resize event to change height
                window.dispatchEvent(new Event('resize'));
                this.setState({
                  initialHeight: null,
                });
              }}
            />
          </a>
        ))}
      </Carousel>
    );
  }
}

export default RollGraph;
