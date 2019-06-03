import React from 'react';
import './App.css';
import {BrowserRouter,Route,Link,Switch} from 'react-router-dom'
import Dishes from './sms/Dishes'

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        {/* 顶部 */}
        <div className="top-nav">
          <span className="top-nav-one">甜品屋</span>
          <span className="top-nav-two">点餐系统</span>
        </div>
        {/* 左侧导航栏 */}
        <div className="left-nav">
          <div className="er">
            <img src={require('./image/sjpj.jpg')} width="70" height="70"></img>
            <div className="yuan"></div>
            <p>用户名</p>
            <div className="zhuxiao"><a href="denglu">注销</a></div>
          </div>
          <ul>
            <li><Link to="/dishes">甜品信息</Link></li>
            <li><Link to="/course">订单管理</Link></li>
            <li><Link to="/teacher">消费清单</Link></li>
            <li><Link to="/sc">系统设置</Link></li>
          </ul>
          <div className="wei">
            <div className="wei-one"></div>
            <div className="wei-two"><span>条款</span>
            <span>隐私</span>
            <span>帮助</span>
            <span>关于</span>
            </div>
          </div>
        </div>
        
        <div className="right-nav">
          <Switch>
            <Route path="/dishes" component={Dishes}/>
            
          </Switch>
        </div>
    </BrowserRouter>
    
    </div>
  );
  
}

export default App;
