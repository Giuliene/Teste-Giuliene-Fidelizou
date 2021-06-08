const conexao = require('../infraestrutura/conexao')
const Config = require('../config/config')

class Competicao{

    /**
     * Envia ao novo usuário seu link de convite
     * @param mascara 
     * @param res 
     */
    compartilhaLink(mascara, res) {
        res.send(`Cadastro realizado com sucesso! Seu link de convite é: ${Config.servidor}/convite/${mascara}`)
                  
    }

    /**
     * Lista os vencedores da competição
     * @param  data do fim da competição
     * @param res 
     */
    exibeResultado(dataFinal, res) {
        const dataTerminoCompeticao = new Date(dataFinal)
        const dataAtual = new Date()

        if(dataAtual < dataTerminoCompeticao) {
            res.send('Os resultado contendo a lista de ganhadores será exibido ao término da competição!')
        } else {
            const sql = 'SELECT * FROM Usuario ORDER BY pontuacao DESC LIMIT 10'
            conexao.query(sql, (erro, resultados) => {
                if(erro) {
                    res.status(400).json(erro)
                } else {
                    res.status(200).json(resultados)
                }
            })
        }
    }
}
module.exports = new Competicao