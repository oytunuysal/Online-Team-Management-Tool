import React from 'react';
import { useHistory } from "react-router";
import { Row, Col, Button } from "antd";
import { errorMessage } from "../../service/UserService";

import { Select } from 'antd';

const { Option } = Select;

const members = [<Option key='ali'>{'Ali'}</Option>, <Option key='ayşe'>{'Ayşe'}</Option>];

const AssignMember = ()=> {
    const history = useHistory();

    function handleChange(value) {
        errorMessage('Not Implemented Yet')
      }
  

      return (
        <Row type="flex" justify="center" style={{ minHeight: "100vh"}}>
          <Col>
          <Select mode="tags" style={{ width: '100%' , width : 300  }} placeholder="Select a Member" onChange={handleChange}>
    {members}
  </Select>
  <Select
    showSearch
    style={{ width: 200 }}
    placeholder="Select a Project"
    optionFilterProp="children"
    filterOption={(input, option) =>
      option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
    }
    filterSort={(optionA, optionB) =>
      optionA.children.toLowerCase().localeCompare(optionB.children.toLowerCase())
    }
  >
    <Option value="1">Project1</Option>
    <Option value="2">Project2</Option>
  </Select>
          </Col>
          <Button type="primary" htmlType="submit" style={{ width: 150 }} onClick={handleChange}>
                Assign to Project
                          </Button>
        </Row>
    
        
      );
  
  
  };

export default AssignMember;

