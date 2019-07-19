import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import '../Cadastro.css'


export default class Passageiro extends Component {

    constructor() {
        super()
        this.state = {
            deveRedirecionarParaChamarCorrida: false,
            deveRedirecionarParaCorrida: false,
            deveRedirecionarParaIniciarCorrida: false,
            deveRedirecionarParaListarCorridas: false,
            deveRedirecionarParaListarCorridasPassageiro: false,
            deveRedirecionarParaFinalizarCorrida: false,
            deveRedirecionarParaAvaliacao: false,
            deveRedirecionarParaGastos: false,

        }

    }

    chamarCorrida = () => {
        this.setState({deveRedirecionarParaChamarCorrida: true})
    }

    iniciarCorrida = () => {
        this.setState({deveRedirecionarParaIniciarCorrida: true})
    }

    listarCorrida = () => {
        this.setState({deveRedirecionarParaListarCorridas: true})
    }

    listarCorridasPassageiro = () => {
        this.setState({deveRedirecionarParaListarCorridasPassageiro: true})
    }

    listarGastosCorridas = () => {
        this.setState({deveRedirecionarParaGastos: true})
    }

    finalizarCorrida = () => {
        this.setState({deveRedirecionarParaFinalizarCorrida: true})
    }

    avaliacao = () => {
        this.setState({deveRedirecionarParaAvaliacao: true})
    }

    voltar = ()  => {
        this.setState({deveRedirecionarParaCorrida: true})
    }

  render() {
    return (
        this.state.deveRedirecionarParaCorrida ? <Redirect to="/"/> :
        this.state.deveRedirecionarParaChamarCorrida ? <Redirect to="/corridas/chamar"/> :
        this.state.deveRedirecionarParaIniciarCorrida ? <Redirect to="/corridas/iniciar"/> :
        this.state.deveRedirecionarParaListarCorridas ? <Redirect to="/corridas/listar"/> :
        this.state.deveRedirecionarParaListarCorridasPassageiro ? <Redirect to="/corridas/listarPeloPassageiro"/> :
        this.state.deveRedirecionarParaFinalizarCorrida ? <Redirect to="/corridas/finalizar"/> :
        this.state.deveRedirecionarParaAvaliacao ? <Redirect to="/corridas/avaliacao"/> :
        this.state.deveRedirecionarParaAvaliacao ? <Redirect to="/corridas/avaliacao"/> :
        this.state.deveRedirecionarParaGastos ? <Redirect to="/corridas/gastos"/> :
        <form className="cadastro">
            <button onClick={this.chamarCorrida}>Chamar Corrida</button>
            <button onClick={this.iniciarCorrida}>Iniciar Corrida</button>
            <button onClick={this.finalizarCorrida}>Finalizar Corrida</button>
            <button onClick={this.listarCorrida}>Listar corridas</button>
            <button onClick={this.listarCorridasPassageiro}>Listar corridas de um passageiro</button>
            <button onClick={this.listarGastosCorridas}>Listar gastos das corridas</button>
            <button onClick={this.avaliacao}>Avaliação</button>
            <button className="button_voltar" onClick={this.voltar}>Voltar</button>
        </form>
    )
  }
}
