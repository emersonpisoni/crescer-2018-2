import React, { Component, Fragment } from 'react'
import { Redirect } from 'react-router-dom'
import { Table } from 'reactstrap'
import '../Cadastro.css'
import PassageiroService from '../../Services/PassageiroService';

export default class ListaPassageiro extends Component {

    constructor() {
        super()
        this.state = {
            passageiros: [],
            deveRedirecionarParaHome: false
        }
        this.passageirosService = new PassageiroService()
    }

    componentDidMount() {
        this.passageirosService.passageiros().then((response) => {
            this.setState({passageiros: response.data.content})
        })
    }

    voltar = ()  => {
        this.setState({deveRedirecionarParaHome: true})
    }

    renderLista() {
        return this.state.passageiros.map((item) => {
            return (
                    <tr>
                        <th>{item.id}</th>
                        <td>{item.nome}</td>
                        <td>{item.email}</td>
                        <td>{item.dataNascimento}</td>
                        <td>{item.saldo}</td>
                    </tr>
            )
        })

    }

    render(){
        return (
            this.state.deveRedirecionarParaHome ? <Redirect to="/passageiros" /> :
                <div className="lista-motoristas">
                    <Table striped>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nome</th>
                                <th>Email</th>
                                <th>Data de nascimento</th>
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
