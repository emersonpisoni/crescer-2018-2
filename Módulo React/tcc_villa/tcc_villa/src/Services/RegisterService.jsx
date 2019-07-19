import BaseService from './BaseService'
import UserService from './UserService'
import axios from 'axios';

export default class RegisterService extends BaseService {

    constructor() {
        super()
        this.userService = new UserService()
    }

    register(email, usuario, senha, imageUrl, firstName, lastName) {
        const dados = {
            email: email,
            login: usuario,
            password: senha,
            imageUrl: imageUrl,
            firstName: firstName,
            lastName: lastName
        }
        return axios.post(`${this.baseUrl}register`, dados)
    }

    alterarUsuario(email, usuario, imageUrl, firstName, lastName){
        const dados = {
            email: email,
            login: usuario,
            imageUrl: imageUrl,
            firstName: firstName,
            lastName: lastName
        }
        
        const token = this.userService.getToken()
        return axios.post(`${this.baseUrl}account`, dados,{
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
    }
}