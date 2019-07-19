import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import '../Cadastro.css'


export default class Motorista extends Component {

    constructor() {
        super()
        this.state = {
            deveRedirecionarParaCadastro: false,
            deveRedirecionarParaHome: false,
            deveRedirecionarParaLista: false,
            deveRedirecionarParaDeletar: false,
            deveRedirecionarParaSacar: false
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

    irParaSacar = () => {
        this.setState({deveRedirecionarParaSacar: true})
    }


  render() {
    return (
        this.state.deveRedirecionarParaHome ? <Redirect to = "/"/> :
        this.state.deveRedirecionarParaCadastro ? <Redirect to="/motoristas/cadastrar"/> :
        this.state.deveRedirecionarParaSacar ? <Redirect to="/motoristas/sacar"/> :
        this.state.deveRedirecionarParaLista ? <Redirect to="/motoristas/listar"/> :
        this.state.deveRedirecionarParaDeletar ? <Redirect to="/motoristas/deletar"/> :
        <form className="cadastro">
            <button onClick={this.irParaCadastro}>Cadastro de Motorista</button>
            <button onClick={this.irParaLista}>Lista de Motorista</button>
            <button onClick={this.irParaDeletar}>Excluir Motorista</button>
            <button onClick={this.irParaSacar}>Sacar dinheiro</button>
            <button className="button_voltar" onClick={this.voltar}>Voltar</button>
        </form>
    )
  }
}
