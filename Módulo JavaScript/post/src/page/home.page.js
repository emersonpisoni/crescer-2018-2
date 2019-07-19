import PostService from '../service/post.service'
import UserService from '../service/user.service'

const criarCard = (card) => {
    const template = `<div class="post">
                        <h5 class="card-title" id="title-post">${card.name}</h5>
                        <p class="card-text" id="handle-post">${card.handle}</p>
                        <a type="button" href="#" id="delete" class="delete">Excluir Post</a>
                    </div>`;

    const elementCard = document.createElement('div');
    elementCard.className = "card"
    elementCard.setAttribute("id", card.id)
    elementCard.innerHTML = template;
    return elementCard;
}

export default class HomePage {

    constructor() {
        this.postService = new PostService()
        const userService = new UserService()
        if (!userService.getToken()) {
            window.location.href = 'http://localhost:3000/login.html'
        }
        this.pegarPosts()
    }

    configure() {
        document.getElementById('btnSalvarPost').addEventListener('click', () => {
            const titulo = document.getElementById('title').value
            const descricao = document.getElementById('handle').value
            this.postService.criarPost(titulo, descricao).then(result => {
                const card = result.data;
                const cardContainer = document.getElementById('card-container')
                cardContainer.appendChild(criarCard(card))
            }).catch(err => {
                throw new Error(err)
                alert('deu erro')
            })
        })

        document.getElementById('delete').addEventListener('click', () => {
            const cardContainer = document.getElementById('card-container')
            cardContainer.removeChild()
        })
    }

    pegarPosts() {
        this.postService.getPost().then(result => {
            for (let i = 0; i < result.data.length; i++) {
                const card = result.data[i];
                const cardContainer = document.getElementById('card-container')
                cardContainer.appendChild(criarCard(card))
            }
        } )
    }
}

const homePage = new HomePage()
homePage.configure()