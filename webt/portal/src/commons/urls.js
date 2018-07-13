import ENV from './env.js';


let API_URL = {};

API_URL = {
    user: {
        login: `${ENV.ADMIN_URL}/user/login.do`
    },
};

export default API_URL;