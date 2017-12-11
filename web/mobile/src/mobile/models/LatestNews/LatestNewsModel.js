import * as LatestNewsService from '../../services/LatestNewsService';
import { PAGE_SIZE } from '../../constants';

export default {
  namespace: 'LatestNews',
  state: {
    list: [],
    total: null,
    page: null,
  },
  reducers: {
    save(state, { payload: { data: list, total, page, noMore } }) {
      console.log(list);
      return {
        ...state, list, total, page, noMore,
      };
    },
    saveInfo(state, { payload: { data } }) {
      return {
        ...state, data,
      };
    },
    addList(state, { payload: { data: list, total, page, noMore } }) {
      const addList = [...state.list, ...list];
      return {
        ...state, list: addList, total, page, noMore,
      };
    },
  },
  effects: {
    *query({ payload }, { call, put }) {
      console.log(payload);
      const response = yield call(LatestNewsService.query, payload);
      if (!response) {
        return;
      }
      console.log(response);
      const { datas = [], totalCount } = response;
      console.log(datas);
      console.log(payload);
      const noMore = payload.page * PAGE_SIZE > totalCount;
      yield put({
        type: 'save',
        payload: {
          data: datas,
          // total: parseInt(headers['x-total-count'], 10),
          page: payload.page,
          noMore,
        },
      });
    },
    *nextPage({ payload }, { call, put }) {
      const response = yield call(LatestNewsService.query, payload);
      if (!response) {
        return;
      }
      const { datas = [], totalCount } = response;
      console.log(`${response.datas}test123`);
      // if (!data.length) {
      //   Toast.info('沒有更多数据了');// @todo use hasMore
      //   return;
      // }
      const noMore = payload.page * PAGE_SIZE > totalCount;
      yield put({
        type: 'addList',
        payload: {
          data: datas,
          // total: parseInt(headers['x-total-count'], 10),
          page: payload.page,
          noMore,
        },
      });
    },
    *getInfo({ payload }, { put }) {
      // const { data, headers } = yield call(LatestNewsService.query, payload);
      yield put({
        type: 'saveInfo',
        payload: {
          data: 'data',
        },
      });
    },
  },
  subscriptions: {
    setup({ dispatch, history }) {
      return history.listen(({ pathname, query = { } }) => {
        if (pathname === '/LatestNews/LatestNewsList') {
          dispatch({ type: 'query', payload: query });
        }
      });
    },
    setupIndex({ dispatch, history }) {
      return history.listen(({ pathname, query = { limit: 3 } }) => {
        if (pathname === '/') {
          dispatch({ type: 'query', payload: query });
        }
      });
    },
    setupDepartment({ dispatch, history }) {
      return history.listen(({ pathname, query = { limit: 6 } }) => {
        if (pathname === '/Department') {
          dispatch({ type: 'query', payload: query });
        }
      });
    },
  },
};
