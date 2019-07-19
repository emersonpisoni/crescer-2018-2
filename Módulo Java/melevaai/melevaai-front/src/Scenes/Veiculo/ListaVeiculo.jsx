import React, { Component, Fragment } from 'react'
import { Redirect } from 'react-router-dom'
import { Table } from 'reactstrap'
import '../Cadastro.css'
import VeiculoService from '../../Services/VeiculoService';

export default class ListaVeiculo extends Component {

    constructor() {
        super()
        this.state = {
            veiculos: [],
            deveRedirecionarParaHome: false
        }
        this.veiculoService = new VeiculoService()
    }

    componentDidMount() {
        this.veiculoService.veiculos().then((response) => {
            this.setState({veiculos: response.data.content})
        })
    }

    voltar = ()  => {
        this.setState({deveRedirecionarParaHome: true})
    }

    renderLista() {
        return this.state.veiculos.map((item) => {
            return (
                    <tr>
                        <th>{item.id}</th>
                        <td>{item.marca}</td>
                        <td>{item.modelo}</td>
                        <td>{item.ano}</td>
                        <td>{item.cor}</td>
                        <td><img src={item.foto}/></td>
                        <td>{item.quantidadeLugares}</td>
                        <td>{item.categoria}</td>
                        <td>{item.motorista.id}</td>
                        <td>{item.motorista.nome}</td>
                    </tr>
            )
        })
    }

    render(){
        return (
            this.state.deveRedirecionarParaHome ? <Redirect to="/veiculos" /> :
                <div className="lista-motoristas">
                    <Table striped>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Ano</th>
                                <th>Cor</th>
                                <th>foto</th>
                                <th>Quantidade de lugares</th>
                                <th>Categoria</th>
                                <th>Id motorista</th>
                                <th>Nome do motorista</th>
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
