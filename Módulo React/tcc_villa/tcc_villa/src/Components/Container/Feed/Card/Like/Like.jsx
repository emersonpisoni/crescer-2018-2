import React, { Component } from 'react'
import './Like.css'

export default class Like extends Component {
    render() {
        return (
            <div class="like">
                <div class="like-image">
                    <img src={this.props.img} />
                </div>
                <div class="like-text">Curtir</div>
            </div>
        )
    }
}