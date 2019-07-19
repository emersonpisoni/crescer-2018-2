import React, { Component } from 'react';

class MensagemBoasVindas extends Component {
    render() {
        return (
            <div>
                <p>{this.props.mensagem}</p>
            </div>
        )
    }
}

export default MensagemBoasVindas;