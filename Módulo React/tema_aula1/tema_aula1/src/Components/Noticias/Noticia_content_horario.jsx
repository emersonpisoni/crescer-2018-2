import './Noticia_content_horario.css';
import React, { Component } from 'react';

class Noticia_content_horario extends Component {
    render() {
        return (
            <div className="noticia--content__horario">
                {this.props.text}
            </div>
            );
        }
    }
    
export default Noticia_content_horario;