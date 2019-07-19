import React, { Component } from 'react'
import Button from '../Input/InputButton'
import Post from '../../../Scenes/Home/CriarPost/Post/Post'
import './Feed.css'

export default class Feed extends Component {
    render() {
        return (
            <div class="feed">
                {this.props.children}
                <Post onEditar={this.props.onEditar} id={this.props.id} />
                <Button className="mais" text="Carrega mais" />
            </div>
        )
    }
}
