import React, { Component, Fragment } from 'react'
import PostService from '../../../../Services/PostService'
import imgLike from '../../../../Assets/like.png'
import Share from '../../../../Assets/share.png'
import UserService from '../../../../Services/UserService';
import Pontinhos from '../../../../Assets/pontos.png'
import SubClass from '../Card/SubClass/SubClass'
import DeletarPostService from '../../../../Services/DeletarPostService';
import Like from './Like/Like'
import moment from 'moment'
import 'moment/locale/pt-br'
import './Card.css'

export default class Post extends Component {

    constructor() {
        super()
        this.state = {
            posts: [],
            usuario: '',
            imagem: '',
            id: '',
        }
        this.deletarService = new DeletarPostService()
        this.postService = new PostService()
        this.userService = new UserService()
    }

    atualizaPosts = () => {
        this.postService.posts().then((response) => {
            this.setState({ posts: response.data })
        })
    }

    componentDidMount() {
        this.postService.posts().then((response) => {
            this.setState({ posts: response.data })
        })

        this.userService.getUsuario().then((response) => {
            this.setState({
                usuario: response.data.firstName,
                imagem: response.data.imageUrl
            })
        })
    }

    onExcluir = (e) => {
        const target = e.target
        this.deletarService.deletarPost(target.id).then(() => {
            alert("Post Excluido")
            this.atualizaPosts()
        }).catch((err) => {
            alert(err.response.data.detail)
        })
    }

    renderPosts() {
        return this.state.posts.map((item) => {
            return (
                <div class="card">
                    <div class="card-text">
                        <div class="user">
                            <div class="image">
                                <img src={this.state.imagem} />
                            </div>
                            <div class="text">
                                <div class="robotocond">
                                    <strong>{this.state.usuario}</strong> escreveu um post</div>
                                <div class="segoe">
                                    <small>{moment(item.dataCriacao).fromNow()}</small>
                                </div>
                            </div>
                            <div class="grupos-opcoes">
                                <div class="pontos-criar">
                                    <img class="pontinhos" src={Pontinhos} />
                                    <ul class="submenu">
                                        <SubClass onClick={this.props.onEditar} id={item.id} name="editar" text="Editar" />
                                        <SubClass onClick={this.onExcluir} id={item.id} text="Excluir" />
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="text-title">
                            {item.titulo}
                        </div>
                        <div class="card-text-post">
                            {item.descricao}
                        </div>
                    </div>
                    <div class="image-post">
                        <img src={item.urlImagem} />
                    </div>
                    <div class="button">
                        <Like img={imgLike} />
                        <Like img={Share} />
                    </div>
                </div>
            )
        })
    }

    render() {
        return (
            <Fragment>
                {this.renderPosts()}
            </Fragment>
        )
    }
}
