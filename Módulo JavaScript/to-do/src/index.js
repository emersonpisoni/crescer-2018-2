import './index.css'

let i
const listaHTML = document.querySelector('.list')
let texto

const input = document.getElementById('todo');
input.addEventListener('keypress', function (e) {
  if (e.keyCode == 13) {
    if (input.value != "") {
      texto = input.value
      funcaoElement(texto)
      input.value = ""
    }
  }
});

const ListItemTemplate = (item) => {
  return `
      <input type="checkbox" id="item-${item.id}">
      <label for="item-${item.id}">${item.label}</label>
    `
}

const itemExemplo = {
  id: i,
  label: texto
}

const funcaoElement = (texto) => {
  const item = {
    id: i,
    label: texto
  }

const element = document.createElement('li')
  element.className = 'item'
  element.innerHTML = ListItemTemplate(item)
  listaHTML.appendChild(element)
  i++
}