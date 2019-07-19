import React, { Component } from 'react';
import './App.css';
import Header from './Components/Header/Header'
import Noticias from './Components/Noticias/Noticia'
import Classificacao from './Components/Tabela/Classificacao'

class App extends Component {
  render() {
    return (
      <div className="App">
        <div>
          <Header />
          <Noticias />
          <Classificacao />
        </div>
      </div>
    );
  }
}

export default App;