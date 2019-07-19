import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import swal from 'sweetalert2'
import '../Cadastro.css'
import CorridaService from '../../Services/CorridaService'

export default class IniciarCorrida extends Component {

    constructor() {
        super()
        this.state = {
            idCorrida: '',
            deveRedirecionarParaPassageiro: false
        }
        this.corridaService = new CorridaService()

    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    onIniciar = (e) => {
        e.preventDefault()
        this.corridaService.iniciarCorrida(this.state.idCorrida).then(() => {
            swal({
                title: 'Corrida iniciada',
                text: 'Obrigado(a)',
                type: 'success',
                confirmButtonText: 'Ok'
            })
        }).catch((err) => {
            if (this.state.idCorrida == "") {
                swal({
                    title: 'Campo vazio!',
                    text: 'Informe um id de corrida',
                    type: 'warning',
                    confirmButtonText: 'Entendi'
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
                        <div className="title">Iniciar uma corrida</div>
                        <label>id da corrida</label>
                        <input type="text" placeholder="digite o id da corrida"
                            name="idCorrida" onChange={this.onChange} value={this.state.idCorrida}/>
                        <button onClick={this.onIniciar}>Iniciar corrida</button>
                        <button className="button_voltar" onClick={this.voltar}>Voltar</button>
                        
                        {this.renderError()}
                    </form>
        )
    }
}
