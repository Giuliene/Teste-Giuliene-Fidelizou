const customExpress = require('./config/customExpress')
const conexao = require('./infraestrutura/conexao')
const Tabelas = require('./infraestrutura/tabelas')
const Config = require('./config/config')

conexao.connect(erro => {
    if(erro) {
        console.log(erro)
    } else {
        Tabelas.init(conexao)
        const app = customExpress()

        app.listen(Config.porta, () => console.log('Servidor rodando'))
    }
})

 