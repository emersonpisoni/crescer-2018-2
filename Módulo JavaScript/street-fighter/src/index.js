import './index.css'
import BaseService from './BaseService.js'

class Street {

  constructor() {
    this.baseService = new BaseService()
    this.ultimoChar = 0
    this.contadorCodigo = 0
    this.preencherPersonagens()
    this.konamiCode()
  }

  konamiCode(contadorCodigo) {
    contadorCodigo = 0
    document.addEventListener('keydown', (event) => {
      let codeKonami = [38, 38, 40, 40, 37, 39, 37, 39, 66, 65]
      if (event.keyCode == codeKonami[contadorCodigo]) {
        contadorCodigo++
      } else {
        contadorCodigo = 0
      }
      if (contadorCodigo == 10) {
        alert('Silvão Liberado')
        this.liberarSecret()
        contadorCodigo = 0
      }
      console.log(contadorCodigo)
    })
  }

  liberarSecret() {
    this.baseService.getPersonagens().then(result => {
      this.personagens = result.data
      let secret = document.querySelector('.button-secret')
      console.log(this.personagens)
      for (let i = 0; i < 10; i++) {
        if (this.personagens[i].secret) {
          secret.classList.remove("button-secret")
          secret.classList.add("button-personagens")
          secret.disabled = false
        }
      }
    }).catch(err => {
      throw new Error(err)
    })
    console.log()
  }

  preencherPersonagens() {
    this.baseService.getPersonagens().then(result => {
      this.personagens = result.data
      let div = document.querySelector('.selecao-personagens')
      let pers_img = document.querySelector('.image-personagem')
      let heigth = document.querySelector('.height-texto')
      let style = document.querySelector('.style-texto')
      let skill = document.querySelector('.skill-texto')
      let body = document.querySelector('body')
      let logo = document.querySelector('.logo')
      let name = document.querySelector('.name')
      let tag_name = document.querySelector('.tag-name')
      let btn_pers = document.querySelector('.button-personagens')
      setTimeout(() => { logo.classList.add("piscar-logo") }, 2000)

      for (let i = 0; i < 10; i++) {
        const button = document.createElement('button')
        button.setAttribute("id", "button-pers" + i)
        button.setAttribute("name", "selecao")
        if (this.personagens[i].secret) {
          button.classList.add("button-secret")
          button.disabled = true;
        } else {
          button.classList.add("button-personagens")
        }
        const tag_name = document.createElement('div')
        tag_name.classList.add("tag-name")
        tag_name.innerHTML = `${this.personagens[i].name}`
        button.innerHTML = `<img src = "${this.personagens[i].smallImg}">`
        button.addEventListener('click', () => {
          let retira = document.querySelector('#button-pers' + this.ultimoChar)
          retira.classList.remove("piscar")
          name.innerHTML = `${this.personagens[i].name}`
          name.classList.add("dropshadow")
          tag_name.add
          heigth.innerHTML = `${this.personagens[i].height}`
          style.innerHTML = `${this.personagens[i].fighting}`
          skill.innerHTML = `${this.personagens[i].skills}`
          pers_img.innerHTML = `<img class="dropshadow transition" src = "${this.personagens[i].largeImg}">`
          body.style.backgroundImage = `linear-gradient(#4a4a4ad6, #440000) ,url(http://street-crescer.surge.sh/images/flags/${this.personagens[i].birth}.png)`;
          button.classList.add("piscar")

          this.ultimoChar = i
        })
        div.appendChild(button)
        button.appendChild(tag_name)
      }
    }).catch(err => {
      throw new Error(err)
    })
  }
}
let street = new Street()