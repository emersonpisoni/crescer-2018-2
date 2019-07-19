import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import swal from 'sweetalert2'
import '../Cadastro.css'
import CorridaService from '../../Services/CorridaService'

export default class Avaliacao extends Component {

    constructor() {
        super()
        this.state = {
            idCorrida: '',
            nota: '1',
            deveRedirecionarParaCorrida: false,
            deveRenderizarNotaMotorista: false,
            deveRenderizarNotaMotorista: false
        }
        this.corridaService = new CorridaService()
    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
        console.log(this.state.nota)
    }

    onAvaliarMotorista = (e) => {
        e.preventDefault()
        this.corridaService.avaliarMotorista(this.state.idCorrida, this.state.nota).then((response) => {
            swal({
                title: "Sucesso",
                text: 'Motorista avaliado com uma nota ' + response.data.notaMotorista + ' Obrigado(a)',
                type: 'success',
                confirmButtonText: 'Obrigado(a)'
            })
            }).catch((err) => {
                if(this.state.idCorrida == "" || this.state.nota == ""){
                    swal({
                        title: 'Campo vazio!',
                        text: 'Algum campo está vazio',
                        type: 'warning',
                        confirmButtonText: 'Ok'
                    })
                }else{
                    swal({
                        title: err.response.data.message,
                        text: 'Verifique os campos e tente novamente',
                        type: 'warning',
                        confirmButtonText: 'Entendi'
                    })
                }
            })
    }

    onAvaliarPassageiro = (e) => {
        e.preventDefault()
        this.corridaService.avaliarPassageiro(this.state.idCorrida, this.state.nota).then((response) => {
            swal({
                title: "Sucesso",
                text: 'Passageiro avaliado com uma nota ' + response.data.notaPassageiro + ' Obrigado(a)',
                type: 'success',
                confirmButtonText: 'Obrigado(a)'
            })
            }).catch((err) => {
                if((this.state.idCorrida && this.state.nota) == ""){
                    swal({
                        title: 'Campo vazio!',
                        text: 'Algum campo está vazio',
                        type: 'warning',
                        confirmButtonText: 'Ok'
                    })
                }else{
                    swal({
                        title: err.response.data.message,
                        text: 'Verifique os campos e tente novamente',
                        type: 'warning',
                        confirmButtonText: 'Entendi'
                    })
                }
            })
    }

    voltar = () => {
        this.setState({deveRenderizarNotaMotorista: false, deveRenderizarNotaPassageiro: false})
    }

    voltaParaCorrida = () => {
        this.setState({deveRedirecionarParaCorrida: true})
    }

    avaliarMotorista = () => {
        this.setState({deveRenderizarNotaMotorista: true})
    }

    avaliarPassageiro = () => {
        this.setState({deveRenderizarNotaPassageiro: true})
    }

    renderError() {
        if (this.state.mensagemErro) {
            return alert(this.state.mensagemErro)
        }
    }
    
    renderNotaPassageiro() {
        return (
                <form onSubmit={this.onSubmit} className="cadastro-motoristas">
                <div className="title">Avaliacao do passageiro</div>
                    <label>Id da corrida</label>
                    <input type="text" placeholder="digite o id da corrida"
                        name="idCorrida" onChange={this.onChange} value={this.state.idCorrida} />
                        <label>Nota do passageiro</label>
                        <select name="nota" value={this.state.nota} onChange={this.onChange}>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>                     
                    <button onClick={this.onAvaliarPassageiro}>Avaliar</button>
                    <button className="button_voltar" onClick={this.voltar}>Voltar</button>
                    {this.renderError()}
                </form>
        )
    }

    renderNotaMotorista() {
        return (
                <form onSubmit={this.onSubmit} className="cadastro-motoristas">
                <div className="title">Avaliacao do motorista</div>
                    <label>Id da corrida</label>
                    <input type="text" placeholder="digite o id da corrida"
                        name="idCorrida" onChange={this.onChange} value={this.state.idCorrida} />
                        <label>Nota do motorista</label>
                        <select name="nota" value={this.state.nota} onChange={this.onChange}>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>                   
                    <button onClick={this.onAvaliarMotorista}>Avaliar</button>
                    <button className="button_voltar" onClick={this.voltar}>Voltar</button>
                    {this.renderError()}
                </form>
        )
    }

    render() {
        return (
            this.state.deveRenderizarNotaPassageiro ? this.renderNotaPassageiro() :
            this.state.deveRenderizarNotaMotorista ? this.renderNotaMotorista() :
            this.state.deveRedirecionarParaCorrida ? <Redirect to="/corridas"/> :
                <form className="cadastro">                     
                    <button onClick={this.avaliarMotorista}>Avaliar motorista</button>
                    <button onClick={this.avaliarPassageiro}>Avaliar passageiro</button>
                    <button className="button_voltar" onClick={this.voltaParaCorrida}>Voltar</button>
                    {this.renderError()}
                </form>
        )
    }
}
