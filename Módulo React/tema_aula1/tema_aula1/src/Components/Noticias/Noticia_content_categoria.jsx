import './Noticia_content_categoria.css';
import React, { Component } from 'react';

class Noticia_content_categoria extends Component {
    render() {
        return (
            <div className="noticia--content__categoria">
                {this.props.text}
            </div>
            );
        }
    }
    
export default Noticia_content_categoria;