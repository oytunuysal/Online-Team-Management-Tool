
import { message} from 'antd';
import axios from 'axios';

export const url = "http://localhost:8080";

export const successMessage = (aMessage) => {
   return message.success(aMessage);
};

export const errorMessage = (aMessage) => {
    return message.error(aMessage);
 };

 export const getUsers = () => {
   return axios.get(`${url}/api/users`, { withCredentials: true }).then((response) => {
       return response.data.content.map((user) => ({
           name: `${user.name}`
       }));
   });
};
