import React, { Component, Fragment } from 'react'
import './Header.css'
import Logo from '../../../Assets/group.png'

export default class HeaderDeslogado extends Component {
    render() {
        return (
            <Fragment>

                <div className="header">
                    <div className="header-logo">
                        <a href="jaime.html">
                            <img src={Logo} />
                        </a>
                    </div>
                </div>

            </Fragment>
        )
    }
}