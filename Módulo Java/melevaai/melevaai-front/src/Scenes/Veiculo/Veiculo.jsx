import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import '../Cadastro.css'

export default class Passageiro extends Component {

    constructor() {
        super()
        this.state = {
            deveRedirecionarParaCadastro: false,
            deveRedirecionarParaHome: false,
            deveRedirecionarParaLista: false
        }

    }

    irParaCadastro = () => {
        this.setState({deveRedirecionarParaCadastro: true})
    }

    voltar = ()  => {
        this.setState({deveRedirecionarParaHome: true})
    }

    irParaLista = () => {
        this.setState({deveRedirecionarParaLista: true})
    }

    irParaDeletar = () => {
        this.setState({deveRedirecionarParaDeletar: true})
    }

    irParaDepositar = () => {
        this.setState({deveRedirecionarParaDepositar: true})
    }

  render() {
    return (
        this.state.deveRedirecionarParaHome ? <Redirect to = "/"/> :
        this.state.deveRedirecionarParaLista ? <Redirect to = "/veiculos/listar"/> :
        this.state.deveRedirecionarParaCadastro ? <Redirect to="/veiculos/cadastrar"/> :
        <form className="cadastro">
            <button onClick={this.irParaCadastro}>Cadastro de Veiculos</button>
            <button onClick={this.irParaLista}>Listar veículos</button>
            <button className="button_voltar" onClick={this.voltar}>Voltar</button>
        </form>
    )
  }
}
