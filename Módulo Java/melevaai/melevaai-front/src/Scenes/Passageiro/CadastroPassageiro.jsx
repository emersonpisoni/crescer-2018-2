import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import '../Cadastro.css'
import swal from 'sweetalert2'
import PassageiroService from '../../Services/PassageiroService';

export default class CadastroMotorista extends Component {

    constructor() {
        super()
        this.state = {
            dataNascimento: '',
            email: '',
            nome: '',
            deveRedirecionarParaPassageiro: false
        }
        this.criarPassageiro = new PassageiroService()
    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    onCadastrar = (e) => {
        e.preventDefault()
        this.criarPassageiro.criarPassageiro(this.state.nome, this.state.email, this.state.dataNascimento).then(() => {
            swal({
                title: 'Sucesso',
                text: 'Passageiro cadastrado',
                type: 'success',
                confirmButtonText: 'Ok'
            })
        }).catch((err) => {
            if (this.state.dataNascimento == "" || this.state.email == "" || this.state.nome == "") {
                swal({
                    title: "Verifique os campos vazios",
                    text: 'Verifique os campos e tente novamente',
                    type: 'warning',
                    confirmButtonText: 'Ok'
                })
            } else {
                swal({
                    title: err.response.data.message,
                    text: 'Verifique os campos e tente novamente',
                    type: 'warning',
                    confirmButtonText: 'Ok'
                })
            }

        })

    }

    voltar = () => {
        this.setState({ deveRedirecionarParaPassageiro: true })
    }

    render() {
        return (
                this.state.deveRedirecionarParaPassageiro ? <Redirect to="/passageiros" /> :
                    <form onSubmit={this.onSubmit} className="cadastro-motoristas">
                    <div className="title">Cadastrar passageiro</div>
                        <label>Nome</label>
                        <input type="text" placeholder="digite seu nome"
                            name="nome" onChange={this.onChange} value={this.state.nome} />
                        <label>email</label>
                        <input type="text" placeholder="digite seu email"
                            name="email" onChange={this.onChange} value={this.state.email} />
                        <label>dataNascimento</label>
                        <input type="date" placeholder="digite sua data de nascimento"
                            name="dataNascimento" onChange={this.onChange} value={this.state.dataNascimento} />
                        <button onClick={this.onCadastrar}>Cadastrar Passageiro</button>
                        <button className="button_voltar" onClick={this.voltar}>Voltar</button>
                    </form>
        )
    }
}
