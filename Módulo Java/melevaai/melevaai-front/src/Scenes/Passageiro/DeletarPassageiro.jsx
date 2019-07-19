import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'
import MotoristaService from '../../Services/MotoristaService';

export default class DeletaMotorista extends Component {

  constructor() {
    super()
    this.state = {
        id: '',
        deveRedirecionarParaHome: false,
        deveRedirecionarParaMotoristas: false
    }
    this.deletarMotoristaService = new MotoristaService

  }

  onChange = (e) => {
    const target = e.target
    this.setState({
        [target.name]: target.value
    })
    console.log(this.state.id)
}

  irParaHome = () => {
    this.setState({deveRedirecionarParaHome: true})
  }

  voltar = () => {
    this.setState({deveRedirecionarParaMotoristas: true})
  }

  excluir = () =>{
    this.deletarMotoristaService.deletarMotorista(this.state.id).then(() =>{
      alert("Motorista excluído")
    })
  }

  render() {
    return (
      this.state.deveRedirecionarParaHome ? <Redirect to="/" /> :
      this.state.deveRedirecionarParaMotoristas ? <Redirect to="/motoristas"/> :
          <form onSubmit={this.onSubmit} className="cadastro">
              <label>Id do motorista</label>
              <input type="text" placeholder="digite o id do motorista que será excluído"
                  name="id" onChange={this.onChange} value={this.state.id} />
              <button onClick={this.excluir}>Excluir</button>
              <button onClick={this.voltar}>Voltar</button>
              <button onClick={this.irParaHome}>Home</button>
          </form>
    )
  }
}
