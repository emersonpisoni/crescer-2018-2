import React, { Component, Fragment } from 'react'
import { Redirect } from 'react-router-dom'
import { Table } from 'reactstrap'
import '../Cadastro.css'
import CorridaService from '../../Services/CorridaService';

export default class ListaCorrida extends Component {

    constructor() {
        super()
        this.state = {
            corridas: [],
            deveRedirecionarParaCorridas: false
        }
        this.corridaService = new CorridaService()
    }

    componentDidMount() {
        this.corridaService.corridas().then((response) => {
            this.setState({ corridas: response.data })
        })
        console.log(this.state.corridas)
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
                    <td>{item.dataHoraInicio}</td>
                    <td>{item.dataHoraFinal}</td>
                    <td>{item.situacao}</td>
                    <td>{item.notaMotorista}</td>
                    <td>{item.notaPassageiro}</td>
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
                    <button className="button_voltar"  onClick={this.voltar}>Voltar</button>
                </div>
        )
    }
}
