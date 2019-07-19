import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import swal from 'sweetalert2'
import { Table } from 'reactstrap'
import '../Cadastro.css'
import CorridaService from '../../Services/CorridaService';

export default class ListaCorridaPassageiro extends Component {

    constructor() {
        super()
        this.state = {
            corridas: [],
            idPassageiro: '',
            deveRedirecionarParaCorridas: false,
            deveRenderizarLista: false
        }
        this.corridaService = new CorridaService()
    }

    onListar = (e) => {
        e.preventDefault()
        this.corridaService.corridasDoPassageiro(this.state.idPassageiro).then((response) => {
            this.setState({ corridas: response.data })
            this.setState({ deveRenderizarLista: true })
        }).catch((err) => {
            if (this.state.idPassageiro == "") {
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

    procurarOutroPassageiro = () => {
        this.setState({ deveRenderizarLista: false })
    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    voltar = () => {
        this.setState({ deveRedirecionarParaCorridas: true })
    }

    renderLista() {
        return this.state.corridas.map((item) => {
            return (
                <tr>
                    <th>{item.id}</th>
                    <td>{item.veiculo.marca}</td>
                    <td>{item.veiculo.modelo}</td>
                    <td>{item.veiculo.cor}</td>
                    <td>{item.veiculo.motorista.nome}</td>
                    <td>{item.passageiro.nome}</td>
                    <td>{item.pontoInicial}</td>
                    <td>{item.pontoFinal}</td>
                    <td>{item.valorCorrida}</td>
                    <td>{item.tempoPrevisto}</td>
                    <td>{item.horaInicio}</td>
                    <td>{item.horaFinal}</td>
                    <td>{item.situacao}</td>
                    <td>{item.notaMotorista}</td>
                    <td>{item.notaPassageiro}</td>
                </tr>)
        })
    }

    render() {
        return (
            this.state.deveRedirecionarParaCorridas ? <Redirect to="/corridas" /> :
                this.state.deveRenderizarLista ?
                    <div className="lista-motoristas">
                        <Table striped>
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Marca</th>
                                    <th>Modelo</th>
                                    <th>Cor</th>
                                    <th>Nome do motorista</th>
                                    <th>Nome do passageiro</th>
                                    <th>Ponto de partida</th>
                                    <th>Ponto de chegada</th>
                                    <th>Valor da corrida</th>
                                    <th>Tempo previso</th>
                                    <th>horaInicio</th>
                                    <th>horaFinal</th>
                                    <th>situacao</th>
                                    <th>Nota do motorista</th>
                                    <th>Nota do passageiro</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.renderLista()}
                            </tbody>

                        </Table>
                        <button className="btn-lista" onClick={this.procurarOutroPassageiro}>Pesquisar outro passageiro</button>
                        <button className="btn-lista" onClick={this.voltar}>Voltar</button>
                    </div> :
                    <form onSubmit={this.onSubmit} className="cadastro-motoristas">
                        <label>id do passageiro</label>
                        <input type="text" placeholder="digite o id do passageiro"
                            name="idPassageiro" onChange={this.onChange} value={this.state.idPassageiro} />
                        <button onClick={this.onListar}>listar corridas</button>
                        <button className="button_voltar" onClick={this.voltar}>Voltar</button>
                    </form>
        )
    }
}
