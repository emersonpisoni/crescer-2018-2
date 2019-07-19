import React, { Component, Fragment } from 'react'
import CriarPostService from '../../../../Services/CriarPostService';
import Form from '../../../../Components/Container/Input/Form'
import Button from '../../../../Components/Container/Input/InputButton'
import './EditarPost.css'

export default class EditarPost extends Component {

    constructor() {
        super()
        this.state = {
            titulo: '',
            descricao: '',
            urlImagem: ''
        }
        this.criarPostService = new CriarPostService()
        console.log(this.state.id)
    }

    onChange = (e) => {
        const target = e.target
        this.setState({
            [target.name]: target.value
        })
    }

    onSubmit = (e) => {
        e.preventDefault()
        this.criarPostService.editarPost(this.props.id, this.state.titulo, this.state.descricao, this.state.urlImagem).then(() => {
            alert("Post Atualizado")
            this.props.onFecharEditarPost()
            this.props.atualizaPosts()
        }).catch((err) => {
            alert(err.response.data.detail)
        })
    }

    renderPreCriarPost() {
        return (
            <form onSubmit={this.onSubmit} className="card-editar">
                <div className="edit-post">
                    Você está editando o Post {this.props.id}
                </div>
                <Form classLabel="" className="titulo" type="text" title="Título" placeholder="digite o titulo do post" name="titulo"
                    onChange={this.onChange} value={this.state.titulo} />
                <Form className="descricao" type="text" title="Descrição" placeholder="digite a descrição do post" name="descricao"
                    onChange={this.onChange} value={this.state.descricao} />
                <Form className="url" type="text" title="urlImagem" placeholder="que tal uma imagem?" name="urlImagem"
                    onChange={this.onChange} value={this.state.urlImagem} />
                <Button className="btn_editar" text="Atualizar Post" />
            </form>
        )
    }

    render() {
        return (
            <Fragment>
                {this.renderPreCriarPost()}
            </Fragment>
        )
    }
}