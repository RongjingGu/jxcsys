import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { HashRouter, Route } from 'react-router-dom';
import store from './store';
import routes from './routes';
import Login from './Login'

ReactDOM.render(
    <Provider store={store}>
        <HashRouter>
            <div className="router-index">
            <Route path="/login" component={Login} isLogin={true} />   , 
            /* <App>
                
                {
                    routes.map((route, index) => (
                        <PrivateRoute
                            key={index}
                            path={route.path}
                            exact={route.exact}
                            component={route.render}
                        />))
                }
            </App> */
            </div>
         </HashRouter>
     </Provider>,
    document.getElementById('contentApp'),
);
