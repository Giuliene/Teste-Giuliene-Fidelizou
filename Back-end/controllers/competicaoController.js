const Competicao = require('../models/competicao')
const Usuarios = require('../models/usuarios')
const Config = require('../config/config')

module.exports = app => {
    /**
     * Caminho enviado ao usuário para o compartilhamento do link de convite
     */
    app.get('/compartilha-link/:mascara', (req, res) => {
        const mascara = req.params.mascara
        Competicao.compartilhaLink(mascara, res)
    })

    /**
     * Usuário se cadastra sem convite
     */
    app.post('/cadastro', (req, res) => {
        const cadastro = req.body
        Usuarios.adicionaUsuario(null, cadastro, res) 
    })

    /**
     * Usuário se cadastra pelo link do convite
     */
    app.post('/convite/:mascara', (req, res) => {
        const cadastro = req.body
        const mascara = req.params.mascara
        Usuarios.adicionaUsuario(mascara, cadastro, res)  
        })

    /**
     * Página de resultados dacompetição, mostrando os vencedores 
     * apenas no dia do seu término
     */
    app.get('/resultado', (req, res) => {
        dataFinal = Config.dataFinalCompeticao
        Competicao.exibeResultado(dataFinal, res)
    })

   
}