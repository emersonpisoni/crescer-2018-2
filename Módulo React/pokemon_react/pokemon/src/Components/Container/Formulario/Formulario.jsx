import React, { Component } from 'react'
import './Formulario.css'

export default class Formulario extends Component {

    render() {
        return (
            <div className="formulario">
                <div className="title">
                    <h1>Vamos adicionar um novo pokemon</h1>
                </div>
                <form onSubmit={this.props.onSalvarNaLista} className="nomeAdicionar">
                    <h2>Nome do pokemon</h2>
                    <input autoComplete="off" onBlur={this.props.verificaNameVazio}
                        type="text" placeholder="Digite o nome do pokemon" className="nomeAdicionarTexto"
                        name="pokemon" onChange={this.props.onChange} value={this.props.nome} />
                    {this.props.obrigatorioNome()}

                    <h2>URL da imagem</h2>
                    <input autoComplete="off" onBlur={this.props.verificaImgVazio} type="text" placeholder="Digite a url da imagem do Pokemon" className="nomeAdicionarTexto" name="url" onChange={this.props.onChange} value={this.props.url} />
                    {this.props.obrigatorioImg()}

                    <div className="container_img">
                        <div className="card"><img src={this.props.mostraImagem} /></div>
                    </div>
                    <button className="disabled" onClick={this.props.onVoltarPraLista} >Voltar</button>
                    <button className="disabled" disabled={this.props.verificaStateVazio()} type="submit">Salvar</button>
                </form>
            </div>
        )
    }
}