import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import { Table } from 'reactstrap'
import '../Cadastro.css'
import CorridaService from '../../Services/CorridaService';

export default class listaGastosCorridas extends Component {

    constructor() {
        super()
        this.state = {
            corridas: [],
            deveRedirecionarParaCorridas: false
        }
        this.corridaService = new CorridaService()
    }

    componentDidMount() {
        this.corridaService.gastosCorridas().then((response) => {
            this.setState({ corridas: response.data })
        })

    }

    voltar = () => {
        this.setState({ deveRedirecionarParaCorridas: true })
    }

    renderLista() {
        return this.state.corridas.map((item) => {
            return (
                <tr>
                    <td>{item.dataCorrida}</td>
                    <td>{item.nomeMotorista}</td>
                    <td>{item.placa}</td>
                    <td>{item.nomeDoPassageiro}</td>
                    <td>{item.valorCorrida}</td>
                </tr>
            )
        })
    }

    render() {
        return (
            this.state.deveRedirecionarParaCorridas ? <Redirect to="/corridas" /> :
                <div className="lista-motoristas">
                    <Table striped>
                        <thead>
                            <tr>
                                <th>Data corrida</th>
                                <th>Nome do motorista</th>
                                <th>Placa do veículo</th>
                                <th>Nome do passageiro</th>
                                <th>Valor da corrida</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderLista()}
                        </tbody>
                    </Table>
                    <button className="button_voltar" onClick={this.voltar}>Voltar</button>
                </div>
        )
    }
}