import React, { Component } from 'react'
import './Evento.css'
import EventoService from '../../../../Services/EventosService'
import moment from 'moment'

export default class Evento extends Component {

    constructor() {
        super()
        this.state = {
            evento: []
        }
    }

    componentDidMount() {

        this.eventoService = new EventoService()
        this.eventoService.getEventos().then((response) => {
            this.setState({ evento: response.data })
        })
    }

    render() {
        return this.state.evento.map((item) => {
            return (
                <div class="user">
                    <div class="image">
                        <img src={item.urlImagem} />
                    </div>
                    <div class="text">
                        <div class="robotocond">
                            <strong>{item.nome}</strong> </div>
                        <div class="segoe">
                            <small>{moment(item.data).fromNow()}</small>
                        </div>
                    </div>
                </div>
            )
        }
        )
    }
}