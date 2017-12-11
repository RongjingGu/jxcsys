import * as MyPanelService from '../../services/MyPanelService';

export default {
  namespace: 'MyPanel',
  state: {
    detail: {},
  },
  reducers: {
    save(state, { payload: { data: detail } }) {
      return {
        ...state, ...detail,
      };
    },
    getEmpower(state, { payload: { data: detail } }) {
      return {
        ...state, ...detail,
      };
    },
    noticeList(state, { payload: { data: list, total, page } }) {
      return {
        ...state, list, total, page,
      };
    },
    updatePwd(state, { payload: { data: detail } }) {
      return {
        ...state, ...detail,
      };
    },
    // saveInfo(state, { payload: { data } }) {
    //   return {
    //     ...state, data,
    //   };
    // },
  },
  effects: {
    *query({ payload }, { call, put }) {
      const { data } = yield call(MyPanelService.query, payload);
      yield put({
        type: 'save',
        payload: {
          data,
        },
      });
    },
    *empower({ payload }, { call, put }) {
      const { data } = yield call(MyPanelService.empower, payload);
      yield put({
        type: 'getEmpower',
        payload: {
          data,
        },
      });
    },
    *notice({ payload }, { call, put }) {
      const { data } = yield call(MyPanelService.notice, payload);
      yield put({
        type: 'noticeList',
        payload: {
          data: data.list,
        },
      });
    },
    *pwd({ payload }, { call, put }) {
      const { data } = yield call(MyPanelService.pwd, payload);
      yield put({
        type: 'updatePwd',
        payload: {
          data,
        },
      });
    },

    // *getInfo({ payload }, { put }) {
    //   // const { data, headers } = yield call(MyPanelService.query, payload);
    //   yield put({
    //     type: 'saveInfo',
    //     payload: {
    //       data: 'data',

    //     },
    //   });
    // },
  },
  subscriptions: {
    setup({ dispatch, history }) {
      return history.listen(({ pathname, query = {} }) => {
        if (pathname === '/MyPanel/PersonCentral/Account') {
          dispatch({ type: 'query', payload: query });
        }
      });
    },
    queryEmpower({ dispatch, history }) {
      return history.listen(({ pathname, query = {} }) => {
        if (pathname === '/MyPanel/PersonCentral/Empower') {
          dispatch({ type: 'empower', payload: query });
        }
      });
    },
    queryNotice({ dispatch, history }) {
      return history.listen(({ pathname, query = {} }) => {
        if (pathname === '/MyPanel/PersonCentral/Notice') {
          dispatch({ type: 'notice', payload: query });
        }
      });
    },
    queryPwd({ dispatch, history }) {
      return history.listen(({ pathname, query = {} }) => {
        if (pathname === '/MyPanel/PersonCentral/Pwd') {
          dispatch({ type: 'pwd', payload: query });
        }
      });
    },
  },
};
