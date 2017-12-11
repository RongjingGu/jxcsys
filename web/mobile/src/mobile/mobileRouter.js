import React from 'react';
import { Router, Switch, Route } from 'dva/router';
import dynamic from 'dva/dynamic';
import AuthRoute from './components/AuthRoute';
import './index.less';

function RouterConfig({ history, app }) {
  const IndexPage = dynamic({
    app,
    models: () => [
      import('./models/WorkShop/WorkShopModel'),
      import('./models/LatestNews/LatestNewsModel'),
    ],
    component: () => import('./routes/IndexPage'),
  });

  const Users = dynamic({
    app,
    models: () => [
      import('./models/users'),
    ],
    component: () => import('./routes/Users'),
  });

  // const Chat = dynamic({
  //   app,
  //   // models: () => [
  //   //   import('./models/users'),
  //   // ],
  //   component: () => import('./routes/Chat'),
  // });

  const WorkShopList = dynamic({
    app,
    models: () => [
      import('./models/WorkShop/WorkShopModel'),
    ],
    component: () => import('./routes/WorkShop/WorkShopList'),
  });

  const MyArchive = dynamic({
    app,
    // models: () => [
     // import('./models/MyArchive/MyArchiveModel'),
   // ],
    component: () => import('./routes/MyArchive/MyArchive'),
  });

  const HottopicList = dynamic({
    app,
    models: () => [
      import('./models/Hottopic/HottopicModel'),
    ],
    component: () => import('./routes/Hottopic/HottopicList'),
  });
  const WorkShopInfo = dynamic({
    app,
    models: () => [
      import('./models/WorkShop/WorkShopModel'),
    ],
    component: () => import('./routes/WorkShop/WorkShopInfo'),
  });
  const LatestNewsList = dynamic({
    app,
    models: () => [
      import('./models/LatestNews/LatestNewsModel'),
    ],
    component: () => import('./routes/LatestNews/LatestNewsList'),
  });
  const InvSubject = dynamic({
    app,
    models: () => [
      import('./models/InvSubject/InvSubjectModel'),
    ],
    component: () => import('./routes/InvSubject/InvSubject'),
  });

  const LatestNewsInfo = dynamic({
    app,
    models: () => [
      import('./models/LatestNews/LatestNewsModel'),
    ],
    component: () => import('./routes/LatestNews/LatestNewsInfo'),
  });

  const MyPanel = dynamic({
    app,
    // models: () => [
    //   import('./models/MyPanel/MyPanel'),
    // ],
    component: () => import('./routes/MyPanel/MyPanel'),
  });


  const PersonCentral = dynamic({
    app,
    // models: () => [
    //   import('./models/Chat/Chat'),
    // ],
    component: () => import('./routes/MyPanel/PersonCentral'),
  });

  const Account = dynamic({
    app,
    models: () => [
      import('./models/MyPanel/MyPanelModel'),
    ],
    component: () => import('./routes/MyPanel/Account'),
  });

  const DopaSpace = dynamic({
    app,
    component: () => import('./routes/DopaSpace/DopaSpace'),
  });

  const DoctorList = dynamic({
    app,
    models: () => [
      import('./models/DoctorList/DoctorList'),
    ],
    component: () => import('./routes/DoctorList/DoctorList'),
  });

  const DoctorInfo = dynamic({
    app,
    models: () => [
      import('./models/DoctorList/DoctorList'),
    ],
    component: () => import('./routes/DoctorList/DoctorInfo'),
  });


  const Departmentintroduced = dynamic({
    app,
    component: () => import('./routes/Department/Departmentintroduced'),
  });


  const ChatBox = dynamic({
    app,
    // models: () => [
    //   import('./models/Chat/ChatEntery'),
    // ],
    component: () => import('./routes/Chat/ChatBox'),
  });
  const MyChat = dynamic({
    app,
    models: () => [
      import('./models/Chat/MyChatList'),
    ],
    component: () => import('./routes/Chat/MyChat'),
  });
  const HotChats = dynamic({
    app,
    models: () => [
      import('./models/Chat/HotChatsList'),
    ],
    component: () => import('./routes/Chat/HotChats'),
  });

  const TestCrf = dynamic({
    app,
    // models: () => [
    //   import('./models/Chat/ChatEntery'),
    // ],
    component: () => import('./routes/Crf/TestCrf'),
  });
  const Department = dynamic({
    app,
    models: () => [
      // import('./models/Department/Department'),
      import('./models/WorkShop/WorkShopModel'),
    ],
    component: () => import('./routes/Department/Department'),
  });


  const Empower = dynamic({
    app,
    models: () => [
      import('./models/MyPanel/MyPanelModel'),
    ],
    component: () => import('./routes/MyPanel/Empower'),
  });

  const Notice = dynamic({
    app,
    models: () => [
      import('./models/MyPanel/MyPanelModel'),
    ],
    component: () => import('./routes/MyPanel/Notice'),
  });

  const Pwd = dynamic({
    app,
    models: () => [
      import('./models/MyPanel/MyPanelModel'),
    ],
    component: () => import('./routes/MyPanel/Pwd'),
  });

  // const ScienceNewsList = dynamic({
  //   app,
  //   models: () => [
  //     import('./models/Department/ScienceNews'),
  //   ],
  //   component: () => import('./routes/Department/ScienceNewsList'),
  // });

  return (
    <Router history={history}>
      <Switch>
        <AuthRoute history={history}>
          <Route path="/" exact component={IndexPage} />

          <Route path="/users" exact component={Users} />
          {/* <Route path="/chat" component={Chat} /> */}
          {/* 学术会议 */}
          <Route path="/WorkShop/WorkshopList" exact component={WorkShopList} />
          {/* 热门话题 */}
          <Route path="/Hottopic/HottopicList" exact component={HottopicList} />
          {/* 我的档案 */}
          <Route path="/MyArchive/MyArchive" exact component={MyArchive} />
          {/* //科室介绍 */}
          <Route path="/Department/Departmentintroduced" exact component={Departmentintroduced} />
          <Route path="/WorkShop/WorkShopInfo/:id" exact component={WorkShopInfo} />
          {/* 最新动态 */}
          <Route path="/LatestNews/LatestNewsList" exact component={LatestNewsList} />
          <Route path="/LatestNews/LatestNewsInfo/:id" exact component={LatestNewsInfo} />
          {/* //我的 */}
          <Route path="/MyPanel" auth="myPanel" exact component={MyPanel} />

          <Route path="/MyPanel/PersonCentral" exact component={PersonCentral} />

          <Route path="/MyPanel/PersonCentral/Account" auth="account" exact component={Account} />
          <Route path="/MyPanel/PersonCentral/Pwd" auth="pwd" exact component={Pwd} />
          {/* //授权服务 */}
          <Route path="/MyPanel/PersonCentral/Empower" auth="empower" exact component={Empower} />
          {/* //通知 */}
          <Route path="/MyPanel/PersonCentral/Notice" auth="notice" exact component={Notice} />


          {/* //医患空间 */}

          <Route path="/DopaSpace" exact component={DopaSpace} />
          <Route path="/Chat/DoctorList" auth="doctorList" exact component={DoctorList} />
          <Route path="/Chat/DoctorList/:id" exact component={DoctorInfo} />
          <Route path="/Chat/ChatBox" exact component={ChatBox} />
          <Route path="/Chat/MyChat" exact component={MyChat} />
          <Route path="/Chat/HotChats" exact component={HotChats} />

          {/* 研究课题 */}
          <Route path="/InvSubject" exact component={InvSubject} />

          <Route path="/Crf/TestCrf" exact component={TestCrf} />
          {/* //科室风采 */}
          <Route path="/Department" exact component={Department} />
          {/* <Route path="/Department/ScienceNewsList" exact component={ScienceNewsList} /> */}
          {/* <Route path="/DepartmentDetail" exact component={DepartmentDetail} />
          <Route path="/DepartmentDetail" exact component={DepartmentDetail} /> */}
        </AuthRoute>
        {/* {
            routes.map(({ path, ...dynamics }, key) => (
              <Route key={key}
                exact
                path={path}
                component={dynamic({
                  app,
                  ...dynamics,
                })}
              />
            ))
          } */}
      </Switch>
    </Router>
  );
}

// function check() {
//   console.log(1);
//   return false;
// }

export default RouterConfig;
