import { Toast } from 'antd-mobile';
import * as WorkShopService from '../../services/WorkShop/WorkShopService';

export default {
  namespace: 'WorkShop',
  state: {
    list: [],
    total: null,
    page: null,
  },
  reducers: {
    save(state, { payload: { data: list, total, page } }) {
      console.log(list);
      return {
        ...state, list, total, page,
      };
    },
    saveInfo(state, { payload: { data } }) {
      return {
        ...state, data,
      };
    },
    addList(state, { payload: { data: list, total, page } }) {
      const addList = [...state.list, ...list];
      return {
        ...state, list: addList, total, page,
      };
    },
  },
  effects: {
    *query({ payload }, { call, put }) {
      console.log(payload);
      const response = yield call(WorkShopService.query, payload);
      if (!response) {
        return;
      }
      const { data = [] } = response;
      console.log(data);
      console.log(payload);
      yield put({
        type: 'save',
        payload: {
          data,
          // total: parseInt(headers['x-total-count'], 10),
          page: payload.page,
        },
      });
    },
    *nextPage({ payload }, { call, put }) {
      const response = yield call(WorkShopService.query, payload);
      if (!response) {
        return;
      }
      const { data = [] } = response;
      if (!data.length) {
        Toast.info('沒有更多数据了');// @todo use hasMore
        return;
      }
      yield put({
        type: 'addList',
        payload: {
          data,
          // total: parseInt(headers['x-total-count'], 10),
          page: payload.page,
          noMore: !data.length,
        },
      });
    },
    *getInfo({ payload }, { put }) {
      // const { data, headers } = yield call(WorkShopService.query, payload);
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
        if (pathname === '/WorkShop/WorkShopList') {
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
