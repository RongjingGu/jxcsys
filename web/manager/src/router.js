import React, {Component} from "react";
import {Route, Redirect} from "react-router-dom";
import Login from "./components/home/Login";
import Carousel from "./components/Index/Carousel"
import News from "./components/Index/News"
import Meeting from "./components/Index/Meeting"
import Subject from "./components/Index/Subject"
import Department from "./components/Team/Department"
import Doctor from "./components/Team/Doctor"
import EducationClass from "./components/Education/EducationClass"
import Detail from "./components/Education/Detail"
import Question from "./components/Question"

const routes = [{
    path: '/',
    exact: true,
    render: () => 1 ? <Redirect to="/index/news"/> : <Redirect to="/login"/>,
}, {
    path: '/index',
    exact: true,
    render: () => <News />,
}, {
    path: '/index/news',
    exact: true,
    render: () => <News />,
}, {
    path: '/index/meet',
    exact: true,
    render: () => <Meeting />,
}, {
    path: '/index/subject',
    exact: true,
    render: () => <Subject />,
}, {
    path: '/index/carousel',
    exact: true,
    render: () => <Carousel />,
}, {
    path: '/team/department',
    exact: true,
    render: () => <Department />,
}, {
    path: '/team/doctor',
    exact: true,
    render: () => <Doctor />,
}, {
    path: '/education/class',
    exact: true,
    render: () => <EducationClass />,
}, {
    path: '/education/detail',
    exact: true,
    render: () => <Detail />,
}, {
    path: '/question',
    exact: true,
    render: () => <Question />,
}

];

export default routes;
