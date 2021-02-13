import React from 'react';
import { useHistory } from "react-router";
import { Row, Button } from "antd";
import {  errorMessage } from "../../service/UserService";
import foto from '../../1.png'
import { useState } from 'react';
import { Modal } from 'antd';

import { Select } from 'antd';

import { Upload, message } from 'antd';
import { InboxOutlined } from '@ant-design/icons';

const { Dragger } = Upload;

const props = {
    name: 'file',
    multiple: true,
    action: '',
    onChange(info) {
        const { status } = info.file;
        if (status !== 'uploading') {
            console.log(info.file, info.fileList);
        }
        if (status === 'done') {
            message.success(`${info.file.name} file uploaded successfully.`);
        } else if (status === 'error') {
            message.error(`${info.file.name} file upload failed.`);
        }
    },
};

const { Option } = Select;

const members = [<Option key='ali'>{'Ali'}</Option>, <Option key='ayşe'>{'Ayşe'}</Option>];

const Meeting = () => {
    const history = useHistory();
    const [isModalVisible, setIsModalVisible] = useState(false);

    const showModal = () => {
        setIsModalVisible(true);
    };

    const handleOk = () => {
        setIsModalVisible(false);
    };

    const handleCancel = () => {
        setIsModalVisible(false);
    };


    function handleChange(value) {
        errorMessage('Not Implemented Yet')
    }


    return (
        <div>
            <Row type="flex" justify="center" style={{ minHeight: "10vh" }}>

                <div>

                    <img src={foto} />
                </div>
                <>
                    <Button type="primary" onClick={showModal}>
                        Share Document
                    </Button>
                    <Modal title="Upload File" visible={isModalVisible} onOk={handleOk} onCancel={handleCancel}>
                        <Dragger {...props}>
                            <p className="ant-upload-drag-icon">
                                <InboxOutlined />
                            </p>
                            <p className="ant-upload-text">Click or drag file to this area to upload</p>
                            <p className="ant-upload-hint">
                            </p>
                        </Dragger>
                    </Modal>
                </>

            </Row>
            <Row type="flex" justify="center" style={{ minHeight: "10vh" }}>
                <Button type="primary" htmlType="submit" style={{ width: 60 }} onClick={handleChange}>
                    Leave
                          </Button>
            </Row>
        </div>



    );


}

export default Meeting;

