import './Classificacao_body.css';
import React, { Component, Fragment } from 'react';

class Classificacao_body extends Component {

    render() {
        return (
            <table class="classificacao-table">
                <thead>
                    <th class="classificacao-table--th">Classificacao</th>
                    <th class="classificacao-table--th">Pontos</th>
                </thead>
                <tbody>
                    <tr class="classificacao--table__tr">
                        <td class="classificacao--table__time">
                            <b>1</b> - FLA
                            </td>
                        <td class="classificacao--table__pontos">
                            10
                            </td>
                    </tr>
                    <tr class="classificacao--table__tr">
                        <td class="classificacao--table__time">
                            <b>1</b> - FLA
                            </td>
                        <td class="classificacao--table__pontos">
                            10
                            </td>
                    </tr>
                    <tr class="classificacao--table__tr">
                        <td class="classificacao--table__time">
                            <b>1</b> - FLA
                            </td>
                        <td class="classificacao--table__pontos">
                            10
                            </td>
                    </tr>
                    <tr class="classificacao--table__tr">
                        <td class="classificacao--table__time">
                            <b>1</b> - FLA
                            </td>
                        <td class="classificacao--table__pontos">
                            10
                            </td>
                    </tr>
                </tbody>
            </table>
        );
    }
}

export default Classificacao_body;