import BaseService from './BaseService'
import UserService from './UserService'
import axios from 'axios';

export default class EventosService extends BaseService {

    constructor() {
        super()
        this.userService = new UserService()
    }

    getEventos() {
        const token = this.userService.getToken()
        return axios.get(`${this.baseUrl}eventos`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
    }

    getGrupos() {
        const token = this.userService.getToken()
        return axios.get(`${this.baseUrl}grupos`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
    }
}
