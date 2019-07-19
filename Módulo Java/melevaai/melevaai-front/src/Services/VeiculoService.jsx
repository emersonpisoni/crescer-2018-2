import BaseService from './BaseService'
import axios from 'axios'

export default class VeiculoService extends BaseService {

    constructor() {
        super()
    }

    criarVeiculo(ano, categoria, cor, foto, id, marca, modelo, quantidadeLugares) {
        const dados = {
            ano: ano,
            categoria: categoria,
            cor: cor,
            foto: foto,
            id: id,
            marca: marca,
            modelo: modelo,
            quantidadeLugares: quantidadeLugares
        }
        return axios.post(`${this.baseUrl}veiculos`, dados)
    }

    veiculos(){
        return axios.get(`${this.baseUrl}veiculos`)
    }
}