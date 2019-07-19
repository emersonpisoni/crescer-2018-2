import './Noticia_content.css';
import React, { Component } from 'react';
import Noticia_content_categoria from'./Noticia_content_categoria'
import Noticia_content_titulo from'./Noticia_content_titulo'
import Noticia_content_descricao from'./Noticia_content_descricao'
import Noticia_content_horario from'./Noticia_content_horario'


class Noticia_content extends Component {
    render() {
        return (
            <div className="noticia--content">
                <Noticia_content_categoria text="nas redes"/>
                <Noticia_content_titulo text="Corinthians diminui distância para o Flamengo no novo ranking digital dos clubes brasileiros"/>
                <Noticia_content_descricao text="Rubro-negro lidera, e quarteto paulista fecha o top 5, e Cruzeiro tem a maior variação de crescimento em relação ao mês anterior"/>
                <Noticia_content_horario text="HÁ 1 HORA - VASCO"/>
            </div>
            );
        }
    }
    
export default Noticia_content;