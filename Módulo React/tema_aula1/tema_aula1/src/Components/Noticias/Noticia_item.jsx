import './Noticia_item.css';
import React, { Component } from 'react';
import Noticia_imagem from'./Noticia_imagem'
import Noticia_content from'./Noticia_content'

class Noticia_item extends Component {
    render() {
        return (
            <div className="noticia--item">
                <Noticia_imagem/>
                <Noticia_content/>
            </div>
        );
    }
}

export default Noticia_item;