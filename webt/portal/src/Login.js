import React from 'react'; 
import {Input, Button, Modal}from 'antd'; 
import $ from './commons/XDomainJquery'; 
import API_URL from './commons/urls'; 


class Login extends React.Component {

    state =  {
        username:'', 
        password:''
    }

    /**
     * 登录系统
     */
    login = () =>  {
         console.log(this.state.username)
         $.ajax( {
             method:'post', 
             url:`$ {API_URL.user.login}`, 
             data: {
                ...this.state
             }, 
             type:'json'
         }).done(
             result =>  {
                Modal.info( {content:result.success}); 
             }

         ).fail(
            function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR + textStatus + errorThrown); 
            }); 
    }

    setname = (e) =>  {
         this.setState( {
             username:e.target.value, 
         }); 
    }

    setpass = (e) =>  {
        this.setState( {
            password:e.target.value, 
        }); 
    }

    render() {
        return ( < div className = 'index-login' > 
         < div className = 'login form-signin'style =  { {display:'inline-block', float:'right'}} > 
          < div className = "header" >  
          < div className = "logo" ></div > 
           </div > 
            < div className = "wrap-login" >
            <div className="con-bg"></div>
                <div className='login form-signin' style={{display:'inline-block', float:'right'}} >   
              < div className = "form-signin-heading" > SMO临床试验管理系统 </div > 
               < Input className = "form-control"id = "username" onBlur =  {this.setname}placeholder = "员工号"/> 
                < Input className = "form-control"id = "password" onBlur =  {this.setpass}placeholder = "密码"/> 
                 < Button className = "btn btn-lg btn-primary btn-block"id = "loginBtn"type = "primary"onClick =  {this.login} > 
                 登录 </Button >  
                 </div>
                 </div >
                   </div > 
                    </div > )
    }
}

export default Login; 