import React, { useState } from 'react';
import SideNavigation from "../layout/SideNavigation";
import { Layout } from "antd";
import {
    BrowserRouter as Router,
    Route,
    Switch,
    Redirect,
} from "react-router-dom";
import Login from "../pages/login/login";
import AssignMember from "../pages/user/AssignMember";
import StartMeeting from "../pages/user/StartMeeting";
import AddProjectPlan from "../pages/project/AddProjectPlan";
import JoinMeeting from "../pages/project/JoinMeeting";
import Meeting from "../pages/project/Meeting";
import { MenuUnfoldOutlined, MenuFoldOutlined } from "@ant-design/icons";

const { Header, Sider, Content } = Layout;

const ApplicationRoutes = () => {
    const [collapse, setCollapse] = useState(false);

    const handleToggle = (event) => {
        event.preventDefault();
        collapse ? setCollapse(false) : setCollapse(true);
    };

    return (
        <Router>
            <Layout>
                <Sider trigger={null} collapsible collapsed={collapse}>
                    <SideNavigation />
                </Sider>
                <Layout>
                    <Header className="siteLayoutBackground" style={{ padding: 0, background: "#001529" }}>
                        {React.createElement(
                            collapse ? MenuUnfoldOutlined : MenuFoldOutlined,
                            {
                                className: "trigger",
                                onClick: handleToggle,
                                style: { color: "#fff" },
                            }
                        )}
                    </Header>
                    <Content
                        style={{
                            margin: "24px 16px",
                            padding: 24,
                            minHeight: "calc(100vh - 114px)",
                            background: "#fff",

                        }}
                    >
                        <Switch>
                            <Route path="/login" component={Login} />
                            <Route path="/assignmember" component={AssignMember} />
                            <Route path="/startmeeting" component={StartMeeting} />
                            <Route path="/addprojectplan" component={AddProjectPlan} />
                            <Route path="/joinmeeting" component={JoinMeeting} />
                            <Route path="/meeting" component={Meeting} />
                            <Redirect to="/login" from="/" />
                        </Switch>
                    </Content>
                </Layout>
            </Layout>
        </Router>
    );

};

export default ApplicationRoutes;
