import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import swal from 'sweetalert2'
import '../Cadastro.css'
import CorridaService from '../../Services/CorridaService'

export default class ChamarCorrida extends Component {

    constructor() {
        super()
        this.state = {
            id: '',
            pontoInicial: '',
            pontoFinal: '',
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

    onChamar = (e) => {
        e.preventDefault()
        this.corridaService.chamarCorrida(this.state.id, this.state.pontoInicial, this.state.pontoFinal).then(() => {    
            swal({
                    title: 'Sucesso',
                    text: 'Corrida chamada, aguarde',
                    type: 'success',
                    confirmButtonText: 'Ok'
                })
            }).catch((err) => {
                if (this.state.id == "" || this.state.pontoInicial == "" || this.state.pontoFinal == "") {
                    swal({
                        title: 'Campo vazio!',
                        text: 'Algum campo está vazio',
                        type: 'warning',
                        confirmButtonText: 'Ok'
                    })
                }else {
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
        this.setState({deveRedirecionarParaCorrida: true})
    }

    renderError() {
        if (this.state.mensagemErro) {
            return alert(this.state.mensagemErro)
        }
    }

    render() {
        return (
            this.state.deveRedirecionarParaHome ? <Redirect to="/" /> :
            this.state.deveRedirecionarParaCorrida ? <Redirect to="/corridas"/> :
                <form onSubmit={this.onSubmit} className="cadastro-motoristas">
                    <div className="title"> Chamar uma corrida</div>
                    <label>id do passageiro</label>
                    <input type="number" placeholder="digite o id do passageiro"
                        name="id" onChange={this.onChange} value={this.state.id} />
                    <label>Ponto de partida</label>
                    <input type="text" placeholder="informe o ponto de partida"
                        name="pontoInicial" onChange={this.onChange} value={this.state.pontoInicial} />
                    <label>Ponto de chegada</label>
                    <input type="text" placeholder="informe o ponto de chegada"
                        name="pontoFinal" onChange={this.onChange} value={this.state.pontoFinal} />                        
                    <button onClick={this.onChamar}>Chamar corrida</button>
                    <button className="button_voltar"onClick={this.voltar}>Voltar</button>
                    {this.renderError()}
                </form>
        )
    }
}
