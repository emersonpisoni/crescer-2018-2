import React, { Component } from 'react';
import './App.css';

import capitaoAmerica from './assets/capitain.png'
import hulk from './assets/hulk.png'
import iron from './assets/iron.png'
import spider from './assets/spider.png'


class App extends Component {
  render() {
    return <div className="app">
      <div className="herois-container">
        <div className="heroi">
          <img src={capitaoAmerica} />
        </div>
        <div className="heroi">
          <img src={hulk} />
        </div>
        
        <div className="heroi">
          <img src={iron} />
        </div>
        <div className="heroi">
          <img src={spider} />
        </div>
      </div>
    </div>
  }
}
export default App;
