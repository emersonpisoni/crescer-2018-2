import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import '../Cadastro.css'


export default class Passageiro extends Component {

    constructor() {
        super()
        this.state = {
            deveRedirecionarParaCadastro: false,
            deveRedirecionarParaHome: false,
            deveRedirecionarParaDepositar: false
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
        this.state.deveRedirecionarParaCadastro ? <Redirect to="/passageiros/cadastrar"/> :
        this.state.deveRedirecionarParaLista ? <Redirect to="/passageiros/listar"/> :
        this.state.deveRedirecionarParaDepositar ? <Redirect to="/passageiros/depositar"/> :
        <form className="cadastro">
            <button onClick={this.irParaCadastro}>Cadastro de Passageiros</button>
            <button onClick={this.irParaLista}>Listar passageiros</button>
            <button onClick={this.irParaDepositar}>Despositar dinheiro</button>
            <button className="button_voltar" onClick={this.voltar}>Voltar</button>
        </form>
    )
  }
}
