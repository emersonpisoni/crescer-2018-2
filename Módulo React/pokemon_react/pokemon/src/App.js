import React, { Component } from 'react';
import './App.css'
import Title from './Components/Container/Title/Title'
import Container from './Components/Container/Container_card/Container_card'


class App extends Component {
  render() {
    return (
      <div className="App">
        <Container/>
      </div>
    );
  }
}

export default App;
