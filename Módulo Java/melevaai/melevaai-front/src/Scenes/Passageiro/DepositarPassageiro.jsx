import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import swal from 'sweetalert2'
import '../Cadastro.css'
import PassageiroService from '../../Services/PassageiroService';

export default class DepositarPassageiro extends Component {

    constructor() {
        super()
        this.state = {
            id: '',
            valorDepositado: '',
            deveRedirecionarParaPassageiros: false
        }
        this.depositarPassageiroService = new PassageiroService()

    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    depositar = (e) => {
        e.preventDefault()
        this.depositarPassageiroService.depositar(this.state.id, this.state.valorDepositado).then((response) => {
            swal({
                title: 'Sucesso',
                text: 'Valor depositado de R$' + this.state.valorDepositado,
                type: 'success',
                confirmButtonText: 'Ok'
            })
        }).catch((err) => {
            if (this.state.id == "" || this.state.valorDepositado == "") {
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
        this.setState({ deveRedirecionarParaPassageiros: true })
    }

    render() {
        return (
            this.state.deveRedirecionarParaHome ? <Redirect to="/" /> :
                this.state.deveRedirecionarParaPassageiros ? <Redirect to="/passageiros" /> :
                    <form onSubmit={this.onSubmit} className="cadastro-motoristas">
                    <div className="title">Depositar dinheiro</div>
                        <label>id do Motorista</label>
                        <input type="text" placeholder="digite o id do motorista"
                            name="id" onChange={this.onChange} value={this.state.id} />
                        <label>Valor para depositar</label>
                        <input type="text" placeholder="digite o valor desejado"
                            name="valorDepositado" onChange={this.onChange} value={this.state.valorDepositado} />
                        <button onClick={this.depositar}>Depositar dinheiro</button>
                        <button className="button_voltar" className="button_voltar" onClick={this.voltar}>Voltar</button>
                    </form>
        )
    }
}
