import './Noticia_content_descricao.css';
import React, { Component } from 'react';

class Noticia_content_descricao extends Component {
    render() {
        return (
            <div className="noticia--content__descricao">
                {this.props.text}
            </div>
            );
        }
    }
    
export default Noticia_content_descricao;