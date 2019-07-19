import React, { Component, Fragment } from 'react'
import Card from '../../../../Components/Container/Feed/Card/Card'

export default class Post extends Component {

    constructor() {
        super()
        this.state = {
            posts: [],
            usuario: ''
        }
    }

    renderPosts() {
        return <Card onEditar={this.props.onEditar} id={this.props.id} />
    }

    render() {
        return (
            <Fragment>
                {this.renderPosts()}
            </Fragment>
        )
    }
}