import React, { Component } from 'react'
import './Login.css'
import HeaderDeslogado from '../../Components/Container/Header/HeaderDeslogado'
import { Redirect } from 'react-router-dom'
import UserService from '../../Services/UserService'

export default class Login extends Component {

    constructor() {
        super()
        this.state = {
            username: '',
            password: '',
            mensagemErro: '',
            deveRedirecionarParaDashboard: false,
            deveRedirecionarParaCadastro: false
        }
        this.userService = new UserService()
    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    onSubmit = (e) => {
        e.preventDefault()
        this.userService.login(this.state.username, this.state.password).then((response) => {
            this.userService.salvarToken(response.data.id_token)
            this.setState({
                deveRedirecionarParaDashboard: true
            })
        }).catch((err) => {
            this.setState({ mensagemErro: err.response.data.detail })
        })
    }

    irParaCadastro = () => {
        this.setState({ deveRedirecionarParaCadastro: true })
    }

    renderError() {
        if (this.state.mensagemErro) {
            return alert(this.state.mensagemErro)
        }
    }

    render() {
        return (
            this.state.deveRedirecionarParaDashboard ? <Redirect to="/home" /> :
                this.state.deveRedirecionarParaCadastro ? <Redirect to="/cadastro" /> :
                    <form onSubmit={this.onSubmit} className="login">
                        <HeaderDeslogado />
                        <label>Login</label>
                        <input type="text" placeholder="digite seu email" name="username" onChange={this.onChange} value={this.state.username} />
                        <label>Senha</label>
                        <input type="password" placeholder="digite sua senha" name="password" onChange={this.onChange} value={this.state.password} />
                        <button>Entrar</button>
                        <button onClick={this.irParaCadastro}>Ir para cadastro</button>
                        {this.renderError()}
                    </form>
        )
    }
}