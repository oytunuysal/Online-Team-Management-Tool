import React from 'react';
import { useHistory } from "react-router";
import { Row, Col, Input, Button, Form, Select } from "antd";
import { UserOutlined, BookOutlined } from "@ant-design/icons";
import { successMessage, url, errorMessage, getUsers } from "../../service/UserService";
import Axios from 'axios';
import { DatePicker, Space } from 'antd';
import { MinusCircleOutlined, PlusOutlined } from '@ant-design/icons';
const { Option } = Select;


class AddNewProjectPlan extends React.Component{
  state = {
    members: [],
    isLoading: true,
    error: null
  };



  //history = useHistory();

  onChange(date, dateString) {
    console.log(date, dateString);
  }


  addProjectPlan(values){
    // Axios.post("http://localhost:8080/login");
    Axios.post(`${url}/api/projectplan`, values, { withCredentials: true })
      .then(() => {
        successMessage('Project Plan Created!')
      }).catch((errorType) => {
        if ('Error: Network Error' == errorType) {
          errorMessage('Server is down!')
        } else { errorMessage('Project already exists!') }

      })
  }

  componentDidMount() {
    this.getMembers();
  }

  getMembers(){
    getUsers().then((users) => {
      let data = [];

      users.map((user, index) => {
        data.push(
          <Option key={user.name}>{user.name}</Option>
        );
        return data;
      });
      
      this.setState({
        members: data,
        isLoading: false
      });
    }).catch((error) => this.setState({error, isLoading:false}));
  }

  render() {
    const {isLoading, members, error} = this.state;
    return (
      <React.Fragment>
        {!isLoading ? (
                    error ? (
                        `An error occured: ${error}`
                    ) : (
      <Row type="flex" justify="center" style={{ minHeight: "100vh" }}>
        <Col>
          <Form name="login-form" style={{ maxWidth: 300 }} onFinish={this.addProjectPlan}>
            <Form.Item name="projectName" rules={[{ required: true, message: "Is required" }]}>
              <Input prefix={<BookOutlined className="site-form-item-icon" />} placeholder="Project Name" />
            </Form.Item>
            <Form.Item name="teamName" rules={[{ required: true, message: "Is required" }]}>
              <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Team Name" />
            </Form.Item>
            <Form.Item name="projectManager" rules={[{ required: true, message: "Is required" }]}>
              <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Project Manager" />
            </Form.Item>


            <Form.Item name="startDate" direction="vertical">
              <DatePicker onChange={this.onChange} placeholder="Start Date" />

            </Form.Item>
            <Form.Item name="dueDate" direction="vertical">
              <DatePicker onChange={this.onChange} placeholder="Due Date" />

            </Form.Item>

            <Form.List name="tasks">
              {(fields, { add, remove }) => (
                <>
                  {fields.map(field => (
                    <Space key={field.key} style={{ display: 'flex', marginBottom: 8, width: 600 }} align="baseline">
                      <Form.Item
                        {...field}
                        name={[field.name, 'taskName']}
                        fieldKey={[field.fieldKey, 'taskName']}
                        rules={[{ required: true, message: 'Missing task name' }]}
                      >
                        <Input placeholder="Task Name" />
                      </Form.Item>
                      <Form.Item
                        {...field}
                        name={[field.name, 'assignedTo']}
                        fieldKey={[field.fieldKey, 'assignedTo']}
                        rules={[{ required: true, message: 'Missing assigned to' }]}
                        
                      >
                        
                        <Select showSearch allowClear style={{ width: '100%' , width : 150  }} placeholder="Assign To">
                          {members}
                        </Select>
                      </Form.Item>
                      <Form.Item {...field}
                        name={[field.name, 'startDate']}
                        fieldKey={[field.fieldKey, 'startDate']}
                        rules={[{ required: true, message: 'Missing start date' }]}>
                        <DatePicker onChange={this.onChange} placeholder="Start Date" />
                      </Form.Item>
                      <Form.Item {...field}
                        name={[field.name, 'dueDate']}
                        fieldKey={[field.fieldKey, 'dueDate']}
                        rules={[{ required: true, message: 'Missing due date' }]}>
                        <DatePicker onChange={this.onChange} placeholder="Due Date" />
                      </Form.Item>

                      <MinusCircleOutlined onClick={() => remove(field.name)} />
                    </Space>
                  ))}
                  <Form.Item>
                    <Button type="dashed" onClick={() => add()} block icon={<PlusOutlined />}>
                      Add Task
                </Button>
                  </Form.Item>
                </>
              )}
            </Form.List>

            <Form.Item>
              <Button type="primary" htmlType="submit" style={{ width: 150 }}>
                Create Project Plan
                          </Button>
            </Form.Item>
          </Form>
        </Col>
      </Row>
      ) 
      ) : (
        <p>Loading...</p>
      )}
      </React.Fragment>

    );
  
  }

};

export default AddNewProjectPlan;