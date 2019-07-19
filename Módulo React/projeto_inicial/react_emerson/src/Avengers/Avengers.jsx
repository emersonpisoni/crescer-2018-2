import React from 'react'
import Hero from './Hero/Hero'
import capitaoAmerica from './Hero/capitain.png'
import hulk from './Hero/hulk.png'
import iron from './Hero/iron.png'
import spider from './Hero/spider.png'
import './Avengers.css'

export default class Avengers extends React.Component {

    render() {
        return <div className="herois-container">
            <Hero imagemHeroi={capitaoAmerica} />
            <Hero imagemHeroi={hulk} />
            <Hero imagemHeroi={iron} />
            <Hero imagemHeroi={spider} />
        </div>
    }
}