import React, { Component, Fragment } from 'react'
import './Container_card.css'
import Card from './Card/Card'
import Formulario from '../Formulario/Formulario'
import Title from '../Title/Title'

export default class Container_card extends Component {

    constructor(props) {
        super(props)

        this.state = {
            pokemons: [],
            pokemon: '',
            url: '',
            quantPokemons: 4,
            exibirListagem: true,
            obrigatorioName: false,
            obrigatorioImg: false
        }
    }

    componentDidMount() {
        this.setState({
            pokemons: [
                {
                    name: "Mewtwo",
                    imageUrl: "https://vignette.wikia.nocookie.net/pokepediabr/images/d/d3/Mewtwo.png/revision/latest?cb=20130519030910&path-prefix=pt-br"
                },
                {
                    name: "Squirtle",
                    imageUrl: "http://www.stickpng.com/assets/images/580b57fcd9996e24bc43c32a.png"
                },
                {
                    name: "Pidgeotto",
                    imageUrl: "https://vignette.wikia.nocookie.net/nintendo/images/5/57/Pidgeotto.png/revision/latest?cb=20141002082803&path-prefix=en"
                },
                {
                    name: "Charizard",
                    imageUrl: "https://vignette.wikia.nocookie.net/nintendo/images/9/95/Charizard.png/revision/latest?cb=20141002083306&path-prefix=en"
                },
            ]
        })
    }

    renderPokemons() {
        return this.state.pokemons.map((pokemons) => {
            return <Card
                nomepokemon={pokemons.name}
                imageURL={pokemons.imageUrl} />
        })
    }

    onVoltarPraLista = () =>
        this.setState({ exibirListagem: true })

    onIrFormulario = () =>
        this.setState({ exibirListagem: false })

    onSalvarNaLista = () => {
        const newPokemon = { name: this.state.pokemon, imageUrl: this.state.url }
        const novosPokemons = [...this.state.pokemons, newPokemon]

        this.setState({ pokemons: novosPokemons, exibirListagem: true, quantPokemons: this.state.quantPokemons + 1 }, () => {
            console.log(this.state.quantPokemons)
            console.log(this.state.pokemons)
            this.limparInputPokemon()
        })
    }

    limparInputPokemon() {
        this.setState({ pokemon: '', url: '' })
    }

    verificaStateVazio = () => {
        return (
            this.state.pokemon === "" || this.state.url === ""
        )
    }

    onHandleChange = (event) => {
        const target = event.target
        this.setState({ [target.name]: target.value })
    }

    renderAdicionar() {
        return <button className="card" onClick={this.onIrFormulario}>
            <div className="mais">+</div>
            <div>Adicionar Pokemon</div>
        </button>
    }

    rendePokemons() {
        return (
            <div>
                {this.renderTitle()}
                <div className="container_card">
                    {this.renderPokemons()}
                    {this.renderAdicionar()}
                </div>
            </div>
        )
    }

    renderTitle() {
        return <Title text={this.state.quantPokemons} />
    }

    renderFormulario() {
        return (
            <Formulario
                onSalvarNaLista={this.onSalvarNaLista}
                onVoltarPraLista={this.onVoltarPraLista}
                url={this.state.url}
                nome={this.state.pokemon}
                mostraImagem={this.state.url}
                onChange={this.onHandleChange}
                verificaStateVazio={this.verificaStateVazio}
                verificaNameVazio={this.verificaNameVazio}
                verificaImgVazio={this.verificaImgVazio}
                obrigatorioNome={this.campoObrigatorioName}
                obrigatorioImg={this.campoObrigatorioImg}
            />
        )
    }

    campoObrigatorioName = () => {
        if (this.state.obrigatorioName) {
            return  <div className="campo_obrigatorio">campo obrigatorio</div>
        } else {
            return null
        }
    }

    campoObrigatorioImg = () => {
        if (this.state.obrigatorioImg) {
            return  <div className="campo_obrigatorio">campo obrigatorio</div>
        } else {
            return null
        }
    }

    verificaNameVazio = () => {
        if (this.state.pokemon === "") {
            this.setState({ obrigatorioName: true })
        } else {
            this.setState({ obrigatorioName: false })
        }
    }

    verificaImgVazio = () => {
        if (this.state.url === "") {
            this.setState({ obrigatorioImg: true })
        } else {
            this.setState({ obrigatorioImg: false })
        }
    }

    render() {
        return this.state.exibirListagem ? this.rendePokemons() : this.renderFormulario()
    }
}