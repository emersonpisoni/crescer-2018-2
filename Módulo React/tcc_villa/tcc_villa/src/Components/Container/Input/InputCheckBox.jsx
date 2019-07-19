import React, { Component, Fragment } from 'react'
import './Input.css'
export default class InputCheckBox extends Component {
  render() {
    return (
      <Fragment>
        <input type="checkbox" id="menu-mostrar" class="checkbox-menu" />
      </Fragment>
    )
  }
}