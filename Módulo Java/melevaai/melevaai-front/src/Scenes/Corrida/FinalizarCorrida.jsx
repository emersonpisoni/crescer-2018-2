import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import swal from 'sweetalert2'
import '../Cadastro.css'
import CorridaService from '../../Services/CorridaService'

export default class Finalizar extends Component {

    constructor() {
        super()
        this.state = {
            idCorrida: '',
            deveRedirecionarParaCorrida: false
        }
        this.corridaService = new CorridaService()
    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    onFinalizar = (e) => {
        e.preventDefault()
        this.corridaService.finalizarCorrida(this.state.idCorrida).then(() => {
            swal({
                title: 'Sucesso',
                text: 'Corrida finalizada, Obrigado(a)',
                type: 'success',
                confirmButtonText: 'Ok'
            })
        }).catch((err) => {
            if ((this.state.idCorrida) == "") {
                swal({
                    title: 'Campo vazio!',
                    text: 'Algum campo está vazio',
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
        this.setState({ deveRedirecionarParaCorrida: true })
    }

    renderError() {
        if (this.state.mensagemErro) {
            return alert(this.state.mensagemErro)
        }
    }

    render() {
        return (
                this.state.deveRedirecionarParaCorrida ? <Redirect to="/corridas" /> :
                    <form onSubmit={this.onSubmit} className="cadastro-motoristas">
                        <label>Id da corrida</label>
                        <input type="text" placeholder="digite o id do passageiro"
                            name="idCorrida" onChange={this.onChange} value={this.state.idCorrida} />
                        <button onClick={this.onFinalizar}>Finalizar corrida</button>
                        <button className="button_voltar" onClick={this.voltar}>Voltar</button>
                        {this.renderError()}
                    </form>
        )
    }
}
