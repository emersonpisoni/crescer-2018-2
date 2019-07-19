import React, { Component } from 'react';
import { Route } from 'react-router-dom'

import Passageiro from './Scenes/Passageiro/Passageiro'
import CadastroPassageiro from './Scenes/Passageiro/CadastroPassageiro'
import DepositarPassageiro from './Scenes/Passageiro/DepositarPassageiro'
import ListaPassageiro from './Scenes/Passageiro/ListaPassageiro'

import Motorista from './Scenes/Motorista/Motorista'
import CadastroMotorista from './Scenes/Motorista/CadastroMotorista'
import ListaMotorista from './Scenes/Motorista/ListaMotorista'
import DeletaMotorista from './Scenes/Motorista/DeletaMotorista'
import SacarMotorista from './Scenes/Motorista/SacarMotorista'

import Veiculo from './Scenes/Veiculo/Veiculo'
import CadastroVeiculo from './Scenes/Veiculo/CadastroVeiculo'
import ListaVeiculo from './Scenes/Veiculo/ListaVeiculo';

import Corrida from './Scenes/Corrida/Corrida'
import ChamarCorrida from './Scenes/Corrida/ChamarCorrida'
import IniciarCorrida from './Scenes/Corrida/iniciarCorrida';
import FinalizarCorrida from './Scenes/Corrida/FinalizarCorrida';
import ListaCorrida from './Scenes/Corrida/ListaCorrida';
import ListaCorridaPassageiro from './Scenes/Corrida/ListaCorridaPassageiro';
import Avaliacao from './Scenes/Corrida/Avaliacao';
import listaGastosCorridas from './Scenes/Corrida/listaGastosCorridas';
import Home from "./Scenes/Home";
import './App.css';


export default class App extends Component {
  render() {
    return (
      <div className="App">
        <Route component={Home} path="/" exact/>

        <Route component={Motorista} path="/motoristas" exact/>
        <Route component={CadastroMotorista} path="/motoristas/cadastrar" />
        <Route component={ListaMotorista} path="/motoristas/listar" />
        <Route component={DeletaMotorista} path="/motoristas/deletar" />
        <Route component={SacarMotorista} path="/motoristas/sacar" />

        <Route component={Passageiro} path="/passageiros" exact/>
        <Route component={CadastroPassageiro} path="/passageiros/cadastrar" />
        <Route component={DepositarPassageiro} path="/passageiros/depositar" />
        <Route component={ListaPassageiro} path="/passageiros/listar" />

        <Route component={Veiculo} path="/veiculos" exact />
        <Route component={CadastroVeiculo} path="/veiculos/cadastrar" />
        <Route component={ListaVeiculo} path="/veiculos/listar" />

        <Route component={Corrida} path="/corridas" exact/>
        <Route component={ChamarCorrida} path="/corridas/chamar" exact/>
        <Route component={IniciarCorrida} path="/corridas/iniciar" exact/>
        <Route component={ListaCorrida} path="/corridas/listar" exact/>
        <Route component={ListaCorridaPassageiro} path="/corridas/listarPeloPassageiro" exact/>
        <Route component={FinalizarCorrida} path="/corridas/finalizar" exact/>
        <Route component={Avaliacao} path="/corridas/avaliacao" exact/>
        <Route component={listaGastosCorridas} path="/corridas/gastos" exact/>
      </div>
    );
  }
}
