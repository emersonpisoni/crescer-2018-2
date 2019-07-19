import React, { Component } from 'react';
import './Herois.css'

class Hero extends Component {
  render() {
    return (
      <div className="heroi">
        <img src={this.props.imagemHeroi} />
      </div>
    );
  }
}

export default Hero;