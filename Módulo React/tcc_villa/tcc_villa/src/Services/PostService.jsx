import axios from 'axios';
import UserService from './UserService'
import BaseService from './BaseService'
export default class PostService extends BaseService {

    constructor() {
        super()
        this.userService = new UserService()
    }

    posts() {
        const token = this.userService.getToken()
        return axios.get(`${this.baseUrl}posts`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
    }
}