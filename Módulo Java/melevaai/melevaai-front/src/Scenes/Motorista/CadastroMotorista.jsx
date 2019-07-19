import React, { Component } from 'react'
import swal from 'sweetalert2'
import { Redirect } from 'react-router-dom'
import '../Cadastro.css'
import MotoristaService from '../../Services/MotoristaService';

export default class CadastroMotorista extends Component {

    constructor() {
        super()
        this.state = {
            dataNascimento: '',
            email: '',
            nome: '',
            categoria: 'A',
            dataVencimento: '',
            numeroDoDocumento: '',
            deveRedirecionarParaMotoristas: false
        }
        this.criarMotoristaService = new MotoristaService()
    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    onCadastrar = (e) => {
        e.preventDefault()
        this.criarMotoristaService.criarMotorista(this.state.nome, this.state.email, this.state.dataNascimento
            , this.state.categoria, this.state.dataVencimento, this.state.numeroDoDocumento).then(() => {
                swal({
                    title: 'Sucesso',
                    text: 'Motorista cadastrado',
                    type: 'success',
                    confirmButtonText: 'Ok'
                })
            }).catch((err) => {
                if (this.state.dataNascimento == "" || this.state.dataVencimento == "" || this.state.nome == "" || this.state.email == ""
                    || this.state.numeroDoDocumento == "") {
                    swal({
                        title: 'Algum campo está vazio',
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

    irParaHome = () => {
        this.setState({ deveRedirecionarParaHome: true })
    }

    voltar = () => {
        this.setState({ deveRedirecionarParaMotoristas: true })
    }

    render() {
        return (
                this.state.deveRedirecionarParaMotoristas ? <Redirect to="/motoristas" /> :
                    <form onSubmit={this.onSubmit} className="cadastro-motoristas">
                    <div className="title">Cadastrar motorista</div>
                        <label>Nome</label>
                        <input type="text" placeholder="digite seu nome"
                            name="nome" onChange={this.onChange} value={this.state.nome} />
                        <label>email</label>
                        <input type="text" placeholder="digite seu email"
                            name="email" onChange={this.onChange} value={this.state.email} />
                        <label>dataNascimento</label>
                        <input type="date" placeholder="dd/mm/aaaa"
                            name="dataNascimento" onChange={this.onChange} value={this.state.dataNascimento} />
                        <label>Categoria</label>
                        <select name="categoria" value={this.state.categoria} onChange={this.onChange}>
                            <option value="A">A</option>
                            <option value="B">B</option>
                            <option value="C">C</option>
                            <option value="D">D</option>
                            <option value="E">E</option>
                            <option value="ACC">ACC</option>
                        </select>
                        <label>data de vencimento</label>
                        <input type="date" placeholder="digite a data de vencimento da CNH"
                            name="dataVencimento" onChange={this.onChange} value={this.state.dataVencimento} />
                        <label>Numero do documento</label>
                        <input type="text" placeholder="digite o numero da CNH"
                            name="numeroDoDocumento" onChange={this.onChange} value={this.state.numeroDoDocumento} />
                        <button onClick={this.onCadastrar}>Cadastrar Motorista</button>
                        <button className="button_voltar" onClick={this.voltar}>Voltar</button>
                    </form>
        )
    }
}
