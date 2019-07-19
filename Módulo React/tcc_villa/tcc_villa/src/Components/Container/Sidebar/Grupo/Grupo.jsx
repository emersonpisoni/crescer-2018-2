import React, { Component, Fragment } from 'react'
import './Grupo.css'
import EventoService from '../../../../Services/EventosService'
import Pontinhos from '../../../../Assets/pontos.png'

export default class Grupo extends Component {

    constructor() {
        super()
        this.state = {
            grupo: []
        }
    }

    componentDidMount() {
        this.eventoService = new EventoService()
        this.eventoService.getGrupos().then((response) => {
            this.setState({ grupo: response.data })
        })
    }

    renderGrupos() {
        return this.state.grupo.map((item) => {
            return (
                <div class="grupos-grupo">
                    <div class="grupos-image">
                        <img src={item.urlImagem} />
                    </div>
                    <div class="grupos-text">{item.nome}</div>
                </div>
            )
        }
        )
    }

    render() {
        return (
            <Fragment>
                <div class="grupos">
                    <div class="grupos-header">
                        <div class="grupos-meus">Meus grupos</div>
                        <div class="grupos-opcoes">
                            <img src={Pontinhos} />
                        </div>
                    </div>
                    {this.renderGrupos()}
                </div>
            </Fragment>
        )
    }
}