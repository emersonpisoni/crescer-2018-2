import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import swal from 'sweetalert2'
import '../Cadastro.css'
import MotoristaService from '../../Services/MotoristaService';

export default class SacarMotorista extends Component {

    constructor() {
        super()
        this.state = {
            id: '',
            valorSacado: '',
            deveRedirecionarParaMotoristas: false
        }
        this.sacarMotoristaService = new MotoristaService()

    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    sacar = (e) => {
        e.preventDefault()
        this.sacarMotoristaService.sacar(this.state.id, this.state.valorSacado).then(() => {
            swal({
                title: 'Valor sacado!',
                text: 'Valor sacado com sucesso',
                type: 'success',
                confirmButtonText: 'Ok'
            })
        }).catch((err) => {

            if (this.state.idCorrida == "" || this.state.nota == "") {
                swal({
                    title: 'Campo vazio!',
                    text: 'Algum campo está vazio',
                    type: 'warning',
                    confirmButtonText: 'Ok'
                })
            } else {
                swal({
                    title: err.response.data.message,
                    text: 'Verifique os dados e tente novamente.',
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
                    <div className="title">Sacar dinheiro</div>
                    <label>id do Motorista</label>
                    <input type="text" placeholder="digite o id do motorista"
                        name="id" onChange={this.onChange} value={this.state.id} />
                    <label>Valor para sacar</label>
                    <input type="text" placeholder="digite o valor desejado"
                        name="valorSacado" onChange={this.onChange} value={this.state.valorSacado} />
                    <button onClick={this.sacar}>Sacar dinheiro</button>
                    <button className="button_voltar" onClick={this.voltar}>Voltar</button>
                </form>
        )
    }
}
