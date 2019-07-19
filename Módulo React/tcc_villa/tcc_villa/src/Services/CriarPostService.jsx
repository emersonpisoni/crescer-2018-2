import BaseService from './BaseService'
import axios from 'axios'
import UserService from './UserService'

export default class CriarPostService extends BaseService {

    constructor() {
        super()
        this.UserService = new UserService()
    }

    criarPost(titulo, descricao, urlImagem) {
        const post = {
            titulo: titulo,
            descricao: descricao,
            urlImagem: urlImagem
        }
        const token = this.UserService.getToken()
        return axios.post(`${this.baseUrl}posts`, post,
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            })
    }

    editarPost(id, titulo, descricao, urlImagem) {
        const post = {
            id: id,
            titulo: titulo,
            descricao: descricao,
            urlImagem: urlImagem
        }
        const token = this.UserService.getToken()
        return axios.put(`${this.baseUrl}posts`, post,
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            })
    }
}