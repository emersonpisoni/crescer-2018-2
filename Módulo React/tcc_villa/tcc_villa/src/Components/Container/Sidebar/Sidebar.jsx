import React, { Component } from 'react'
import './Sidebar.css'
import '../../../Services/UserService'
import UserService from '../../../Services/UserService';
import Evento from '../../Container/Sidebar/Evento/Evento'
import Grupo from '../../Container/Sidebar/Grupo/Grupo'
import Pontinhos from '../../../Assets/pontos.png'
import Button from '../../Container/Input/InputButton'

export default class Sidebar extends Component {
    constructor() {
        super()
        this.state = {
            usuario: '',
            imagem: ''
        }
    }

    componentDidMount() {
        this.userService = new UserService()
        this.userService.getUsuario().then((response) => {
            this.setState({
                usuario: response.data.firstName,
                imagem: response.data.imageUrl
            })
        })
    }

    render() {
        return (
            <div class="sidebar">
                <div class="sidebar-perfil">
                    <div class="sidebar-image">
                        <img src={this.state.imagem} />
                    </div>
                    <div class="sidebar-name">
                        {this.state.usuario}
                    </div>
                    <div class="sidebar-button">
                        Meu Perfil
                </div>
                </div>
                <Grupo />
                <div class="evento">
                    <div class="grupos-header">
                        <div class="grupos-meus">Eventos</div>
                        <div class="grupos-opcoes">
                            <div class="pontos-criar">
                                <img class="pontinhos" src={Pontinhos} />
                            </div>
                        </div>
                    </div>
                    <Evento />
                    <Button className="btn_alterar_usuario" text="Alterar Usuário" onClick={this.props.onAlterarUsuario} />
                </div>
            </div>
        )
    }
}