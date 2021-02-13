import React from 'react';
import { Menu } from "antd";
import { useHistory } from "react-router";
import {
    LoginOutlined
    , UserAddOutlined, TeamOutlined, DiffOutlined
    , ToolOutlined
    , FileAddOutlined
} from "@ant-design/icons";
const { SubMenu } = Menu;



const SideNavigation = () => {
    const history = useHistory();

    const handleLoginClick = () => {
        history.push("/login");
    };

    const handleAssignMember = () => {
        history.push("/assignmember");
    };
    const handleStartMeeting = () => {
        history.push("/startmeeting");
    };
    const handleAddProjectPlan = () => {
        history.push("/addprojectplan");
    };
    const handleJoinMeeting = () => {
        history.push("/joinmeeting");
    };



    return (
        <div>
            <div
                style={{
                    height: "32px",
                    background: "rgba(255,255,255, 0.2)",
                    margin: "16px",
                }}>
            </div>
            <Menu theme="dark" mode="inline">

                <Menu.Item key="1" onClick={handleLoginClick}>
                    <LoginOutlined />
                    <span> Login </span>
                </Menu.Item>

                <SubMenu key="sub1" icon={<ToolOutlined />} title="Admin">
                    <Menu.Item key="2" onClick={handleAssignMember}>
                        <TeamOutlined />
                        <span> Assign a Member to the Project </span>
                    </Menu.Item>
                    <Menu.Item key="3" onClick={handleAddProjectPlan}><FileAddOutlined />
                        <span> Add New Project Plan </span></Menu.Item>
                </SubMenu>


                <SubMenu key="sub2" icon={<ToolOutlined />} title="Project1">
                    <Menu.Item key="4" onClick={handleStartMeeting}><UserAddOutlined />
                        <span> Start a Meeting </span></Menu.Item>

                    <Menu.Item key="5" onClick={handleJoinMeeting}><DiffOutlined />
                        <span> Join a Meeting </span></Menu.Item>
                    
                </SubMenu>
                <SubMenu key="sub3" icon={<ToolOutlined />} title="Project2">
                    <Menu.Item key="6" onClick={handleStartMeeting}><UserAddOutlined />
                        <span> Start a Meeting </span></Menu.Item>

                    <Menu.Item key="7" onClick={handleJoinMeeting}><DiffOutlined />
                        <span> Join a Meeting </span></Menu.Item>
                    
                </SubMenu>


            </Menu>
        </div>
    );
};

export default SideNavigation;