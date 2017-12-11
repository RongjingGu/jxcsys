import React from 'react';
import PropTypes from 'prop-types';
import { AUTH, curRole } from '../constants';

const curAuth = AUTH[curRole];
function PageAuth({ children, auth }) {
  return (
    curAuth[auth].access ?
      <div>
        {children}
      </div>
    :
    null
  );
}

PageAuth.propTypes = {
  auth: PropTypes.string,
};


export default PageAuth;
