import React, { Component, Fragment } from 'react'
import './CriarPost.css'
import Form from '../../../Components/Container/Input/Form'
import Button from '../../../Components/Container/Input/InputButton'
import CriarPostService from '../../../Services/CriarPostService';

export default class CriarPost extends Component {

  constructor() {
    super()
    this.state = {
      titulo: '',
      descricao: '',
      urlImagem: ''
    }
    this.criarPostService = new CriarPostService()
  }

  onChange = (e) => {
    const target = e.target
    this.setState({
      [target.name]: target.value
    })
  }

  renderPreCard() {
    return (
      <div className="card-pre">
        <div className="titulo">
          {this.state.titulo}
        </div>
        <div className="descricao" >
          {this.state.descricao}
        </div>
        <div className="url" >
          <img src={this.state.urlImagem} />
        </div>
      </div>
    )
  }

  onSubmit = (e) => {
    e.preventDefault()
    this.criarPostService.criarPost(this.state.titulo, this.state.descricao, this.state.urlImagem).then(() => {
      alert("Post Criado")
      this.props.onFecharCriarPost()
      this.props.atualizaPosts()
    }).catch((err) => {
      alert(err.response.data.detail)
    })
  }

  renderPreCriarPost() {
    return (
      <form onSubmit={this.onSubmit} className="card-criar">
        <Form className="titulo" type="text" title="Título" placeholder="digite o titulo do post" name="titulo"
          onChange={this.onChange} value={this.state.titulo} />
        <Form className="descricao" type="text" title="Descrição" placeholder="digite a descrição do post" name="descricao"
          onChange={this.onChange} value={this.state.descricao} />
        <Form className="url" type="text" title="urlImagem" placeholder="que tal uma imagem?" name="urlImagem"
          onChange={this.onChange} value={this.state.urlImagem} />
        <Button className="btn_criar" text="Criar Post" />
      </form>
    )
  }

  render() {
    return (
      <Fragment>
        {this.renderPreCriarPost()}
        {this.renderPreCard()}
      </Fragment>
    )
  }
}