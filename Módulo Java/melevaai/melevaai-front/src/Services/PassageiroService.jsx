import BaseService from './BaseService'
import axios from 'axios'

export default class PassageiroService extends BaseService {

    constructor() {
        super()
    }

    criarPassageiro(nome, email, dataNascimento) {
        const dados = {
            nome: nome,
            email: email,
            dataNascimento: dataNascimento
        }
        return axios.post(`${this.baseUrl}passageiros`, dados)
    }

    depositar(id, valorDepositado){
        return axios.put(`${this.baseUrl}passageiros/${id}/conta-virtual?valorDepositado=${valorDepositado}`)
    }

    passageiros(){
        return axios.get(`${this.baseUrl}passageiros`)
    }

}