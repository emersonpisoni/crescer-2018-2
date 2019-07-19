import axios from 'axios'
import BaseService from './base.service'
import UserService from './user.service'
export default class PostService extends BaseService {

    constructor() {
        super()
        this.userService = new UserService()
    }

    criarPost(titulo, descricao) {
        const token = this.userService.getToken()
        const dados = {
            name: titulo,
            handle: descricao
        }
        return axios.post(`${this.baseUrl}blogs`, dados,
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            })
    }

    getPost() {
        const token = this.userService.getToken()
        return axios.get(`${this.baseUrl}blogs`,
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            })
    }
}