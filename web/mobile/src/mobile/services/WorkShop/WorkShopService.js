import request from '../../utils/request';
import { PAGE_SIZE } from '../../constants';

export function query(params) {
  const newParams = {
    // method: 'post',
    ...params,
  };
  const page = params && params.page ? params.page : 1;
  const limit = params && params.limit ? params.limit : PAGE_SIZE;
  return request(`/api/users?_page=${page}&_limit=${limit}`, newParams);
}
