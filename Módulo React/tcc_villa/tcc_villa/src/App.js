import React, { Component } from 'react'
import Home from './Scenes/Home/Home/Home'
import { Route } from 'react-router-dom'
import Login from './Scenes/Login/Login'
import Cadastro from './Scenes/Cadastro/Cadastro'
import CriarPost from './Scenes/Home/CriarPost/CriarPost';



export default class App extends Component {
  render() {
    return (
      <div className="App">
        <Route component={Login} path="/" exact/>
        <Route component={Home} path="/home" />
        <Route component={CriarPost} path="/home/criarpost" />
        <Route component={Cadastro} path="/cadastro" />
      </div>
    )
  }
}