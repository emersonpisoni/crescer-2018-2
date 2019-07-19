import React, { Component, Fragment } from 'react'
import { Redirect } from 'react-router-dom'
import { Table } from 'reactstrap'
import '../Cadastro.css'
import MotoristaService from '../../Services/MotoristaService';

export default class ListaMotorista extends Component {

    constructor() {
        super()
        this.state = {
            motoristas: [],
            deveRedirecionarParaHome: false
        }
        this.motoristasService = new MotoristaService()
    }

    componentDidMount() {
        this.motoristasService.motoristas().then((response) => {
            this.setState({ motoristas: response.data.content })
        })
    }

    voltar = () => {
        this.setState({ deveRedirecionarParaHome: true })
    }

    renderLista() {
        return this.state.motoristas.map((item) => {
            return (
                    <tr>
                        <th>{item.id}</th>
                        <td>{item.nome}</td>
                        <td>{item.email}</td>
                        <td>{item.dataNascimento}</td>
                        <td>{item.carteiraHabilitacao.numeroDoDocumento}</td>
                        <td>{item.carteiraHabilitacao.categoria}</td>
                        <td>{item.carteiraHabilitacao.dataVencimento}</td>
                        <td>{item.saldo}</td>
                    </tr>
            )
        })

    }

    render() {
        return (
            this.state.deveRedirecionarParaHome ? <Redirect to="/motoristas" /> :
                <div className="lista-motoristas">
                    <Table striped>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nome</th>
                                <th>Email</th>
                                <th>Data de nascimento</th>
                                <th>Numero do documento</th>
                                <th>Categoria</th>
                                <th>Data de vencimento</th>
                                <th>Saldo</th>
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
