import React, { Component } from 'react'
import './Home.css'
import Header from '../../../Components/Container/Header/Header'
import Sidebar from '../../../Components/Container/Sidebar/Sidebar'
import Feed from '../../../Components/Container/Feed/Feed'
import UserService from '../../../Services/UserService'
import CriarPost from '../CriarPost/CriarPost'
import EditarPost from '../CriarPost/EditarPost/EditarPost'
import AlterarUsuario from '../AlterarUsuario/AlterarUsuario'
import { Redirect } from 'react-router-dom'
import PostService from '../../../Services/PostService';

export default class Home extends Component {

  constructor() {
    super()
    this.state = {
      id: '',
      deveRedirecionarParaLogin: false,
      deveMostrarCriarPost: false,
      deveMostrarEditarPost: false,
      deveVoltarPraHome: false,
      deveRedirecionarParaAlterarUsuario: false
    }
    this.postService = new PostService()
  }

  componentDidMount() {
    this.UserService = new UserService()
    if (!this.UserService.getToken()) {
      this.setState({
        deveRedirecionarParaLogin: true
      })
    }
  }

  onCriarPost = () => {
    this.setState({ deveMostrarCriarPost: true })
  }

  onFecharCriarPost = () => {
    this.setState({ deveMostrarCriarPost: false })
  }

  onFecharEditarPost = () => {
    this.setState({ deveMostrarEditarPost: false })
  }

  onVoltarPraHome = () => {
    this.setState({ deveMostrarCriarPost: false, deveMostrarEditarPost: false, deveMostrarCriarPost: false, deveRedirecionarParaAlterarUsuario: false })
  }

  onAlterarUsuario = () => {
    this.setState({ deveRedirecionarParaAlterarUsuario: true, deveMostrarCriarPost: false })
  }

  onEditarPost = (e) => {
    this.setState({ deveMostrarEditarPost: true, deveMostrarCriarPost: false, deveRedirecionarParaAlterarUsuario: false })
    const target = e.target
    this.setState({ id: target.id })
  }

  atualizaPosts = () => {
    this.postService.posts().then((response) => {
      this.setState({ posts: response.data })
    })
  }

  atualizaPosts = () => {
    this.postService.posts().then((response) => {
      this.setState({ posts: response.data })
    })
  }

  renderCriarPost() {
    return (
      <div className="container">
        <Header text="Home" onClick={this.onVoltarPraHome} />
        <Sidebar onAlterarUsuario={this.onAlterarUsuario} />
        <Feed onEditar={this.onCriarPost}>
          <CriarPost atualizaPosts={this.atualizaPosts} onFecharCriarPost={this.onFecharCriarPost} />
        </Feed>
      </div>
    )
  }

  renderEditarPost() {
    return (
      <div className="container">
        <Header text="Home" onClick={this.onVoltarPraHome} />
        <Sidebar onAlterarUsuario={this.onAlterarUsuario} />
        <EditarPost atualizaPosts={this.atualizaPosts} onFecharEditarPost={this.onFecharEditarPost} id={this.state.id} />
      </div>
    )
  }

  renderAlterarUsuario() {
    return (
      <div className="container">
        <Header text="Home" onClick={this.onVoltarPraHome} />
        <Sidebar onAlterarUsuario={this.onAlterarUsuario} />
        <AlterarUsuario />
      </div>
    )
  }

  render() {
    return (
      this.state.deveRedirecionarParaLogin ? <Redirect to="/" /> :
        this.state.deveMostrarCriarPost ? this.renderCriarPost() :
          this.state.deveMostrarEditarPost ? this.renderEditarPost() :
            this.state.deveRedirecionarParaAlterarUsuario ? this.renderAlterarUsuario() :
              <div className="container">
                <Header text="Criar Post" onClick={this.onCriarPost} />
                <Sidebar onAlterarUsuario={this.onAlterarUsuario} />
                <Feed onEditar={this.onEditarPost} />
              </div>
    )
  }
}