import React, { Component, Fragment } from 'react'

export default class InputButton extends Component {
  render() {
    return (
      <Fragment>
        <button className={this.props.className} value={this.props.value} type={this.props.type}
          id={this.props.id} onClick={this.props.onClick}>{this.props.text}</button>
      </Fragment>
    )
  }
}