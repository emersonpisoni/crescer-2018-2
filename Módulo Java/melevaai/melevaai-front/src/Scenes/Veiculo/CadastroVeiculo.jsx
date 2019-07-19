import React, { Component } from 'react'
import '../Cadastro.css'
import swal from 'sweetalert2'
import { Redirect } from 'react-router-dom'

import VeiculoService from '../../Services/VeiculoService';

export default class Cadastro extends Component {

    constructor() {
        super()
        this.state = {
            ano: '',
            categoria: 'A',
            cor: 'BRANCO',
            foto: '',
            id: '',
            marca: 'AUDI',
            modelo: '',
            quantidadeLugares: '',
            deveRedirecionarParaVeiculos: false,
        }
        this.veiculoService = new VeiculoService()

    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    voltar = () => {
        this.setState({ deveRedirecionarParaVeiculos: true })
    }

    cadastrar = (e) => {
        e.preventDefault()
        this.veiculoService.criarVeiculo(this.state.ano, this.state.categoria, this.state.cor
            , this.state.foto, this.state.id, this.state.marca, this.state.modelo, this.state.quantidadeLugares).then(() => {

                swal({
                    title: 'Sucesso',
                    text: 'Veiculo cadastrado',
                    type: 'success',
                    confirmButtonText: 'Ok'
                })
            }).catch((err) => {
                if (this.state.ano  == "" || this.state.categoria  == "" || this.state.cor  == "" || this.state.foto  == "" || this.state.id  == ""
                    || this.state.marca  == "" || this.state.modelo == "") {
                    swal({
                        title: 'Algum campo está vazio',
                        text: 'Verifique os campos e tente novamente!',
                        type: 'warning',
                        confirmButtonText: 'Ok'
                    })
                } else {
                    swal({
                        title: err.response.data.message,
                        text: 'Verique os cmapo e tente novamente',
                        type: 'warning',
                        confirmButtonText: 'Ok'
                    })
                }
            })
    }

    render() {
        return (
            this.state.deveRedirecionarParaVeiculos ? <Redirect to="/veiculos" /> :
                <form onSubmit={this.onSubmit} className="cadastro-motoristas">
                <div className="title">Cadastrar motorista</div>
                    <label>Ano</label>
                    <input type="text" placeholder="digite o ano do veiculo"
                        name="ano" onChange={this.onChange} value={this.state.ano} />
                    <label>Categoria</label>
                    <select name="categoria" value={this.state.categoria} onChange={this.onChange}>
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                        <option value="D">D</option>
                        <option value="E">E</option>
                        <option value="ACC">ACC</option>
                    </select>
                    <label>Cor</label>
                    <select name="cor" value={this.state.cor} onChange={this.onChange}>
                    <   option value="bRANCO">Branco</option>
                        <option value="PRETO">Preto</option>
                        <option value="PRATA">Prata</option>
                    </select>
                    <label>Foto do Veículo</label>
                    <input type="text" placeholder="http//:*****"
                        name="foto" onChange={this.onChange} value={this.state.foto} />
                    <label>Id do motorista</label>
                    <input type="text" placeholder="digite o id do Motorista"
                        name="id" onChange={this.onChange} value={this.state.id} />
                    <label>Marca</label>
                    <select name="marca" value={this.state.marca} onChange={this.onChange}>
                        <option value="AUDI">AUDI</option>
                        <option value="BMW">BMW</option>
                        <option value="CHERY">CHERY</option>
                        <option value="CHEVROLET">CHEVROLET</option>
                        <option value="CHRYSLER">CHRYSLER</option>
                        <option value="CITROEN">CITROEN</option>
                        <option value="DODGE">DODGE</option>
                        <option value="EFFA">EFFA</option>
                        <option value="FIAT">FIAT</option>
                        <option value="FORD">FORD</option>
                        <option value="GEELY">GEELY</option>
                        <option value="HONDA">HONDA</option>
                        <option value="HYUNDAI">HYUNDAI</option>
                        <option value="JAC">JAC</option>
                        <option value="JEEP">JEEP</option>
                        <option value="KIA">KIA</option>
                        <option value="LAND_ROVER">LAND_ROVER</option>
                        <option value="LEXUS">LEXUS</option>
                        <option value="LIFAN">LIFAN</option>
                        <option value="MERCEDES_BENZ">MERCEDES_BENZ</option>
                        <option value="MITSUBISHI">MITSUBISHI</option>
                        <option value="NISSAN">NISSAN</option>
                        <option value="PEUGEOT">PEUGEOT</option>
                        <option value="RENAULT">RENAULT</option>
                        <option value="SEAT">SEAT</option>
                        <option value="SMART">SMART</option>
                        <option value="SSANGYONG">SSANGYONG</option>
                        <option value="SUBARU">SUBARU</option>
                        <option value="SUZUKI">SUZUKI</option>
                        <option value="TOYOTA">TOYOTATOYOTA</option>
                        <option value="VOLKSWAGEN">VOLKSWAGEN</option>
                        <option value="VOLVO">VOLVO</option>
                    </select>
                    <label>Modelo</label>
                    <input type="text" placeholder="digite o modelo do veículo"
                        name="modelo" onChange={this.onChange} value={this.state.modelo} />
                    <label>Quantidade de lugares</label>
                    <input type="text" placeholder="digite quantidade de lugares do veículo"
                        name="quantidadeLugares" onChange={this.onChange} value={this.state.quantidadeLugares} />
                    <button onClick={this.cadastrar}>Cadastrar Veículo</button>
                    <button onClick={this.voltar}>Voltar</button>
                </form>
        )
    }
}
