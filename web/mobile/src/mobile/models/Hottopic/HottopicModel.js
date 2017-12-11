import * as Service from '../../services/DoctorList';

export default {
  namespace: 'Hottopic',
  state: {
    list: [],
    total: null,
    page: null,
  },
  reducers: {
    save(state, { payload: { data: list, total, page } }) {
      return {
        ...state, list, total, page,
      };
    },
    saveInfo(state, { payload: { data } }) {
      return {
        ...state, data,
      };
    },
  },
  effects: {
    *query({ payload }, { call, put }) {
      console.log(payload);
      const { data } = yield call(Service.query, payload);
      yield put({
        type: 'save',
        payload: {
          data: data.list,
          // total: parseInt(headers['x-total-count'], 10),
          // page: parseInt(page, 10),
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
      return history.listen(({ pathname, query = { limit: 6 } }) => {
        if (pathname === '/Hottopic/HottopicList') {
          dispatch({ type: 'query', payload: query });
        }
      });
    },
  },
};
