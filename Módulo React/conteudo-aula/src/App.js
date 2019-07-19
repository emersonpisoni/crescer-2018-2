import React, { Component } from 'react';
import logo from './logo.svg';
import BemVindo from './components/BemVindo/BemVindo'
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <BemVindo titulo="Hello gentiii" mensagem="Bem venidos ao mundo de React :)" />
      </div>
    );
  }
}

export default App;
