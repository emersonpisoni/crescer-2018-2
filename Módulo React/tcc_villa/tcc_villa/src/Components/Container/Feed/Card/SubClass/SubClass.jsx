import React, { Component, Fragment } from 'react'
import Button from '../../../Input/InputButton'

export default class SubClass extends Component {
    render() {
        return (
            <Fragment>
                <label>
                    <li>
                        <Button className={this.props.className} onClick={this.props.onClick} name={this.props.name} id={this.props.id} text={this.props.text} />
                    </li>
                </label>
            </Fragment>
        )
    }
}