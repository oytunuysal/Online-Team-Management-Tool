import React from 'react';
import { useHistory } from "react-router";
import { Row, Col, Button } from "antd";


import { Select } from 'antd';

const { Option } = Select;

const members = [<Option key='ali'>{'Ali'}</Option>, <Option key='ayşe'>{'Ayşe'}</Option>];

const JoinMeeting = ()=> {
    const history = useHistory();

    function handleChange(value) {
        
        //errorMessage('Not Implemented Yet')
        history.push("/meeting");
      }
  

      return (
          <div>
        <Row type="flex" justify="center" style={{ minHeight: "10vh"}}>
          <Col>
          Meeting 1
          </Col>
          <Button type="primary" htmlType="submit" style={{ width: 60}} onClick={handleChange}>
                Join
                          </Button>
                          
        </Row>
                <Row type="flex" justify="center" style={{ minHeight: "10vh"}}>
                <Col>
                Meeting 2
                </Col>
                <Button type="primary" htmlType="submit" style={{ width: 60}} onClick={handleChange}>
                      Join
                                </Button>
                                
              </Row>
          </div>

    
        
      );
  
  
}

export default JoinMeeting;

