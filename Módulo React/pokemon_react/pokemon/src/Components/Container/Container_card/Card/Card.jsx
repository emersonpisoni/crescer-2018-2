import React, { Component } from 'react'
import './Card.css'

export default class Card extends Component {

  render() {
    return (
      <div className="card">
        <img src={this.props.imageURL} />
        <div className="nome-pokemon">
          <span>{this.props.nomepokemon}</span>
        </div>
      </div>
    )
  }
}