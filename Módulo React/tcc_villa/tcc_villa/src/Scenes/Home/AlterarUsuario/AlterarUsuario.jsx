import React, { Component } from 'react'
import RegisterService from '../../../Services/RegisterService'
import InputForm from '../../../Components/Container/Input/Form'


export default class AlterarUsuario extends Component {

    constructor() {
        super()
        this.state = {
            email: '',
            login: '',
            imageUrl: '',
            firstName: '',
            lastName: '',
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
        this.registerService.alterarUsuario(this.state.email, this.state.login,
            this.state.imageUrl, this.state.firstName, this.state.lastName).then(() => {
                alert("Usuário Alterado")
            }).catch(() => {
                alert("não alterado")
            })
    }

    render() {
        return (
            <form onSubmit={this.onSubmit} className="cadastro">
                <InputForm title="Email" type="text" name="email"
                    value={this.state.email} onChange={this.onChange} placeholder="digite seu email" />
                <InputForm title="Login" type="text" name="login"
                    value={this.state.login} onChange={this.onChange} placeholder="digite seu login" />
                <InputForm title="Imagem" type="text" name="imageUrl"
                    value={this.state.imageUrl} onChange={this.onChange} placeholder="informe sua foto de perfil" />
                <InputForm title="Primeiro nome" type="text" name="firstName"
                    value={this.state.firstName} onChange={this.onChange} placeholder="primeiro nome" />
                <InputForm title="Ultimo nome" type="text" name="lastName"
                    value={this.state.lastName} onChange={this.onChange} placeholder="ultimo nome" />

                <button>Alterar Usuario</button>
            </form>
        )
    }
}