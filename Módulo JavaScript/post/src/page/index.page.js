import RegisterPage from './register.page'
export default class IndexPage {

    configure() {
        document.getElementById('leiaMaisButton').addEventListener('click', () => {
            console.log('passo 1')
            const retorno = this.nomeIfThanos('Thanos').then((result) => {
                console.log('passo 2')
                console.log(result)
            }).catch(erro => {
                console.log(erro)
                console.log(erro.erro)
            })
            console.log('passo 3')
        })
    }

    nomeIfThanos(nome) {
        return new Promise((resolve, reject) => {
            if (nome == 'Ahron') {
                setTimeout(() => {
                    resolve('tudo ok')
                }, 3000)

            } else {
                reject({ erro: 'nao eh thanos' })
            }
        })
    }

}
const indexPage = new IndexPage()
indexPage.configure()

