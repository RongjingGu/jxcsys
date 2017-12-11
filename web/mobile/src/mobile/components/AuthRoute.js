import React from 'react';
import { connect } from 'dva';
import { Route } from 'dva/router';
import { AUTH, curRole } from '../constants';

const curAuth = AUTH[curRole];


function AuthRoute({ children, history }) {
  return (
    <div>
      {React.Children.map(children, (child) => {
        const routeAuth = child.props.auth;
        if (routeAuth) {
          if (curAuth[routeAuth]) {
            if (curAuth[routeAuth].access) {
              return child;
            } else {
              return (<Route
                path={child.props.path}
                render={
                          () =>
                          history.push('/')
                      }
              />);
            }
          } else {
            return child;
          }
        } else {
          return child;
        }
      })}
    </div>
  );
}

export default connect()(AuthRoute);
