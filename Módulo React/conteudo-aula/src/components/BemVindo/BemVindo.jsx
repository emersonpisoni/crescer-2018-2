import React from 'react'
import MensagemBoasVindas from './MensagemBoasVindas/MensagemBoasVindas'

import './BemVindo.css'
export default class BemVindo extends React.Component {

    render() {
        return <div>
            <h1 className="BemVindo--titulo">{this.props.titulo}</h1>
            <MensagemBoasVindas mensagem={this.props.mensagem} />
        </div>
    }
}