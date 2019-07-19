import './Noticia_content_titulo.css';
import React, { Component } from 'react';

class Noticia_content_titulo extends Component {
    render() {
        return (
            <div className="noticia--content__titulo">
                 {this.props.text}
            </div>
            );
        }
    }
    
export default Noticia_content_titulo;