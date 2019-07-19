import React, { Component, Fragment } from 'react'
import './Header.css'
import Logo from '../../../Assets/group.png'
import Sino from '../../../Assets/sino.png'
import Lupa from '../../../Assets/lupa.png'
import CheckBox from '../Input/InputCheckBox'
import Button from '../Input/InputButton'
import { Redirect } from 'react-router-dom'

export default class Header extends Component {

    constructor() {
        super()
        this.state = {
            deveRedirecionarParaLogin: false
        }
    }

    onDeslogar = () => {
        localStorage.removeItem("TOKEN")
        this.setState({ deveRedirecionarParaLogin: true })
    }

    onSino = () => {
        alert("Triririririmmmm")
    }

    render() {
        return (
            this.state.deveRedirecionarParaLogin ? <Redirect to="/" /> :
                <Fragment>
                    <CheckBox />
                    <div className="header">
                        <label for="menu-mostrar" className="menu-burguer">&#9776;</label>
                        <div className="header-logo">
                            <img src={Logo} />
                        </div>
                        <div className="header-search">
                            <div className="header-lupa">
                                <img src={Lupa} />
                            </div>
                            <input type="text" className="text" placeholder="Pesquisar" />
                        </div>
                        <div className="buttons">
                            <Button className="btn_criar_post" text={this.props.text} onClick={this.props.onClick} />
                            <Button className="btn_logout" text="Log out" onClick={this.onDeslogar} />
                        </div>
                        <div onClick={this.onSino} className="header-end">
                            <img src={Sino} />
                        </div>
                    </div>
                    <CheckBox />
                </Fragment>
        )
    }
}