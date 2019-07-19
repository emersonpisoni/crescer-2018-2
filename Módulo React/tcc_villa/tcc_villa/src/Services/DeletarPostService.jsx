import BaseService from './BaseService'
import axios from 'axios'
import UserService from './UserService'

export default class DeletarPostService extends BaseService {

    constructor() {
        super()
        this.UserService = new UserService()
    }

    deletarPost(id) {
        const token = this.UserService.getToken()
        return axios.delete(`${this.baseUrl}posts/${id}`,
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            })
    }

}
