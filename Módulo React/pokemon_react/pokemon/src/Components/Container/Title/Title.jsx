import React, { Component } from 'react'
import './Title.css'


export default class Title extends Component {

  render() {
    return (
      <div className="title">
        <h1>Você possui {this.props.text} pokemons</h1>
      </div>
    )
  }
}