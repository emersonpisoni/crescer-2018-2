import BaseService from './BaseService'
import axios from 'axios'

export default class MotoristaService extends BaseService {

    constructor() {
        super()
    }

    criarMotorista(nome, email, dataNascimento, categoria, dataVencimento, numeroDoDocumento) {
        const dados = {
            nome: nome,
            email: email,
            dataNascimento: dataNascimento,
            carteiraHabilitacao:{
                categoria: categoria,
                dataVencimento: dataVencimento,
                numeroDoDocumento: numeroDoDocumento
            }
        }
        return axios.post(`${this.baseUrl}motoristas`, dados)
    }

    deletarMotorista(id) {
        return axios.delete(`${this.baseUrl}motoristas/${id}`)
    }

    motoristas(){
        return axios.get(`${this.baseUrl}motoristas`)
    }

    sacar(id, valorSacado){
        return axios.put(`${this.baseUrl}motoristas/${id}/conta-virtual?valorSacado=${valorSacado}`)
    }

}