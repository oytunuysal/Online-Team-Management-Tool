import React from 'react';
import { useHistory } from "react-router";
import { Row, Col, Button } from "antd";
import { errorMessage } from "../../service/UserService";

import { Select } from 'antd';

const { Option } = Select;

const members = [<Option key='ali'>{'Ali'}</Option>, <Option key='ayşe'>{'Ayşe'}</Option>];

const StartMeeting = () => {    const history = useHistory();

    function handleChange(value) {
        errorMessage('Not Implemented Yet')
        //<Redirect to="/login" from="/" />
      }
  

      return (
        <Row type="flex" justify="center" style={{ minHeight: "100vh"}}>
          <Col>
          <Select mode="tags" style={{ width: '100%' , width : 300  }} placeholder="Select a Member" onChange={handleChange}>
    {members}
  </Select>
          </Col>
          <Button type="primary" htmlType="submit" style={{ width: 150 }} onClick={handleChange}>
                Start the Meeting
                          </Button>
        </Row>
      );
  };
export default StartMeeting;