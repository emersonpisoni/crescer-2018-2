import React, { Component } from 'react'
import './Cadastro.css'
import HeaderDeslogado from '../../Components/Container/Header/HeaderDeslogado'
import { Redirect } from 'react-router-dom'
import RegisterService from '../../Services/RegisterService'

export default class Cadastro extends Component {

    constructor() {
        super()
        this.state = {
            email: '',
            login: '',
            password: '',
            imageUrl: '',
            firstName: '',
            lastName: '',
            mensagemErro: '',
            deveRedirecionarParaLogin: false
        }
        this.registerService = new RegisterService()
    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    onSubmit = (e) => {
        e.preventDefault()
        this.registerService.register(this.state.email, this.state.login, this.state.password,
            this.state.imageUrl, this.state.firstName, this.state.lastName).then(() => {
                alert("Usuário Criado")
                this.setState({
                    deveRedirecionarParaLogin: true
                })
            }).catch(() => {
                this.setState({ mensagemErro: "Não foi possivel criar o usuário, verifique os campos e tente novamente!" })
            })
    }

    irParaLogin = () => {
        this.setState({ deveRedirecionarParaLogin: true })
    }

    renderError() {
        if (this.state.mensagemErro) {
            return alert(this.state.mensagemErro)
        }
    }

    render() {
        return (
            this.state.deveRedirecionarParaLogin ? <Redirect to="/" /> :
                <form onSubmit={this.onSubmit} className="cadastro">
                    <HeaderDeslogado />
                    <label>Email</label>
                    <input type="text" placeholder="digite seu email"
                        name="email" onChange={this.onChange} value={this.state.email} />
                    <label>Login</label>
                    <input type="text" placeholder="digite seu login"
                        name="login" onChange={this.onChange} value={this.state.login} />
                    <label>Senha</label>
                    <input type="password" placeholder="digite sua senha"
                        name="password" onChange={this.onChange} value={this.state.password} />
                    <label>Imagem</label>
                    <input type="text" placeholder="informe sua foto de perfil"
                        name="imageUrl" onChange={this.onChange} value={this.state.imageUrl} />
                    <label>Primeiro nome</label>
                    <input type="text" placeholder="primeiro nome"
                        name="firstName" onChange={this.onChange} value={this.state.firstName} />
                    <label>Ultimo nome</label>
                    <input type="text" placeholder="ultimo nome"
                        name="lastName" onChange={this.onChange} value={this.state.lastName} />
                    <button>Cadastrar</button>
                    <button onClick={this.irParaLogin}>Ir para Login</button>
                    {this.renderError()}
                </form>
        )
    }
}
