import axios from 'axios';
import { Toast } from 'antd-mobile';
/**
 * Requests a URL, returning a promise.
 *
 * @param  {string} url       The URL we want to request
 * @param  {object} [options] The options we want to pass to "fetch"
 * @return {object}           An object containing either "data" or "err"
 */
export default function request(url, options) {
  // return { list: [], data: [] };
  console.log(options);
  return axios.get(url, { params: { ...options } })
  .then((response) => {
    let ret = {};
    if (!response.data.datas) {
      ret.data = response.data;
      ret.headers = {};
    } else {
      ret = response.data;
      ret.headers = {};
    }
    return ret;
  })
  .catch((error) => {
    Toast.info(error.message, 1.5);
    console.error(error);
  });
}
