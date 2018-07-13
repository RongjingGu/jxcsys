import { combineReducers } from 'redux';
import staffReducer from './staffReducer';

const reducers = combineReducers({
    staffInfo: staffReducer
});

export default reducers;