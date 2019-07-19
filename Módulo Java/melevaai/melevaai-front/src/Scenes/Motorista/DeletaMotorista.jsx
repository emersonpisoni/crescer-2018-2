import React, { Component } from 'react'
import swal from 'sweetalert2'
import { Redirect } from 'react-router-dom'
import MotoristaService from '../../Services/MotoristaService';

export default class DeletaMotorista extends Component {

  constructor() {
    super()
    this.state = {
      id: '',
      deveRedirecionarParaMotoristas: false
    }
    this.deletarMotoristaService = new MotoristaService()

  }

  onChange = (e) => {
    const target = e.target
    this.setState({
      [target.name]: target.value
    })
    console.log(this.state.id)
  }

  irParaHome = () => {
    this.setState({ deveRedirecionarParaHome: true })
  }

  voltar = () => {
    this.setState({ deveRedirecionarParaMotoristas: true })
  }

  onCadastrar = (e) => {
    e.preventDefault()
    this.criarMotoristaService.criarMotorista(this.state.nome, this.state.email, this.state.dataNascimento
      , this.state.categoria, this.state.dataVencimento, this.state.numeroDoDocumento).then(() => {
        swal({
          title: 'Sucesso',
          text: 'Motorista cadastrado',
          type: 'success',
          confirmButtonText: 'Ok'
        })
      }).catch((err) => {
        swal({
          title: err.response.data.message,
          text: 'Verifique os campos e tente novamente',
          type: 'warning',
          confirmButtonText: 'Ok'
        })
      })
  }

  excluir = (e) => {
    e.preventDefault()
    this.deletarMotoristaService.deletarMotorista(this.state.id).then(() => {
      swal({
        title: 'Sucesso',
        text: 'Motorista deixou o serviço',
        type: 'success',
        confirmButtonText: 'Ok'
      })
    }).catch((err) => {
      swal({
        title: err.response.data.message,
        text: 'Verifique os campos e tente novamente',
        type: 'warning',
        confirmButtonText: 'Ok'
      })
    })
  }

  render() {
    return (
        this.state.deveRedirecionarParaMotoristas ? <Redirect to="/motoristas" /> :
          <form onSubmit={this.onSubmit} className="cadastro-motoristas">
          <div className="title">Desvincular um motorista</div>
            <label>Id do motorista</label>
            <input type="text" placeholder="digite o id do motorista que será excluído"
              name="id" onChange={this.onChange} value={this.state.id} />
            <button onClick={this.excluir}>Excluir</button>
            <button className="button_voltar" onClick={this.voltar}>Voltar</button>
          </form>
    )
  }
}
