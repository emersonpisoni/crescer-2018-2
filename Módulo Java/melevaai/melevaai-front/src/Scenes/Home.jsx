import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import './Cadastro.css'
import VeiculoService from '../Services/VeiculoService';

export default class Cadastro extends Component {

    constructor() {
        super()
        this.state = {
            ano: '',
            categoria: '',
            cor: '',
            foto: '',
            id: '',
            marca: '',
            modelo: '',
            quantidadeLugares: '',
            deveRedirecionarParaMotoristas: false,
            deveRedirecionarParaPassageiros: false,
            deveRedirecionarParaVeiculos: false,
            deveRedirecionarParaCorridas: false,
        }
        this.veiculoService = new VeiculoService()

    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    irParaMotoristas = () => {
        this.setState({deveRedirecionarParaMotoristas: true})
    }

    irParaPassageiros = () => {
        this.setState({deveRedirecionarParaPassageiros: true})
    }

    irParaVeiculos = () => {
        this.setState({deveRedirecionarParaVeiculos: true})
    }

    irParaCorridas = () => {
        this.setState({deveRedirecionarParaCorridas: true})
    }
    

    onSubmit = (e) => {
        e.preventDefault()
        this.veiculoService.criarVeiculo(this.state.ano, this.state.categoria, this.state.cor
        ,this.state.foto, this.state.id, this.state.marca, this.state.modelo, this.state.quantidadeLugares).then(() => {
                alert("Veículo Criado")
            }).catch(() => {
                this.setState({ mensagemErro: "Não foi possivel cadastrar o veículo, verifique os campos e tente novamente!" })
            })
    }

    render() {
        return (
            this.state.deveRedirecionarParaMotoristas ? <Redirect to="/motoristas"/> :
            this.state.deveRedirecionarParaPassageiros ? <Redirect to="/passageiros"/> :
            this.state.deveRedirecionarParaVeiculos ? <Redirect to="/veiculos"/> :
            this.state.deveRedirecionarParaCorridas ? <Redirect to="/corridas"/> :
            
            <form className="cadastro">
            <div className="title-title">ME LEVA AÍ!</div>
                <button onClick={this.irParaMotoristas}>Motoristas</button>
                <button onClick={this.irParaPassageiros}>Passageiros</button>
                <button onClick={this.irParaVeiculos}>Veiculos</button>
                <button onClick={this.irParaCorridas}>Corridas</button>
            </form>
        )
    }
}
