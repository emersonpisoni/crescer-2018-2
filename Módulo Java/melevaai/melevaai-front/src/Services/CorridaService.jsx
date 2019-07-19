import BaseService from './BaseService'
import axios from 'axios'

export default class CorridaService extends BaseService {

    constructor() {
        super()
    }

    chamarCorrida(id, pontoInicial, pontoFinal) {
        const dados = {
            pontoInicial: pontoInicial,
            pontoFinal: pontoFinal
        }
        return axios.post(`${this.baseUrl}corridas/passageiros/${id}`, dados)
    }

    iniciarCorrida(idCorrida) {
        return axios.post(`${this.baseUrl}corridas/${idCorrida}`)
    }

    corridas(){
        return axios.get(`${this.baseUrl}corridas`)
    }

    gastosCorridas(){
        return axios.get(`${this.baseUrl}corridas/gastos`)
    }

    corridasDoPassageiro(idPassageiro){
        return axios.get(`${this.baseUrl}corridas/passageiros/${idPassageiro}`)
    }
    
    finalizarCorrida(idCorrida) {
        return axios.put(`${this.baseUrl}corridas/${idCorrida}`)
    }

    avaliarPassageiro(idCorrida, nota) {
        return axios.put(`${this.baseUrl}corridas/${idCorrida}/passageiros/avaliacao?nota=${nota}`)
    }

    avaliarMotorista(idCorrida, nota) {
        return axios.put(`${this.baseUrl}corridas/${idCorrida}/motoristas/avaliacao?nota=${nota}`)
    }

}