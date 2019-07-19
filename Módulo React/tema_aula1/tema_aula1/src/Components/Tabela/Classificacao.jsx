import './Classificacao.css';
import React, { Component } from 'react';
import Classificacao_header from'./Classificacao_header'
import Classificacao_body from './Classificacao_body'

class Classificacao extends Component {
    render() {
        return (
            <div className="classificacao">
                <Classificacao_header/>
                <Classificacao_body/>
            </div>
            );
        }
    }
    
export default Classificacao;