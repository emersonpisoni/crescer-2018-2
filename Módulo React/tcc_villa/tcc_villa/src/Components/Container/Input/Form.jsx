import React, { Component, Fragment } from 'react'

export default class Form extends Component {
    render() {
        return (
            <Fragment>
                <label className={this.props.classLabel}>{this.props.title}</label>
                <input type={this.props.type} placeholder={this.props.placeholder}
                    autoComplete="off" className={this.props.className} name={this.props.name} onChange={this.props.onChange} value={this.props.value} />

            </Fragment>
        )
    }
}