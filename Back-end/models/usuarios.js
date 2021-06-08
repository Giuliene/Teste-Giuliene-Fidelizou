const conexao = require('../infraestrutura/conexao')
const { criaTelefones } = require('../infraestrutura/tabelas')

class Usuarios {
    /**
     * Adiciona um usuário no banco a partir da requisição recebida.
     * @param  mascara 
     * @param  usuario 
     * @param  res 
     */
    adicionaUsuario(mascara, usuario, res) {
        const erros = this.validaDadosUsuario( usuario, res)
        if(erros.length){
            res.status(400).json(erros)
        } else {      
            
            const usuarioFormatado = this.formatarDadosUsuario(usuario)

            const sqlNovoUsuario = 'INSERT INTO Usuario SET ?'
            conexao.query(sqlNovoUsuario, usuarioFormatado, (erro, resultados) => {
                if(erro){
                    res.status(400).json(erro)
                } else {   
                    //inserindo telefones
                    this.adicionaTelefones('Residencial', resultados.insertId, usuario.telefoneResidencial, res)
                    this.adicionaTelefones('Comercial', resultados.insertId, usuario.telefoneComercial, res)
                    this.adicionaTelefones('Celular', resultados.insertId, usuario.telefoneCelular, res)
  
                    this.pontuaConvidante(mascara)
                    const mascaraNovoUsuario = usuario.nome.substring(0,3)+resultados.insertId
                    res.redirect(`/compartilha-link/${mascaraNovoUsuario}`) 
                }
                return resultados.insertId
            })
        }   
    }

    /**
     * Pode adicionar 3 tipos de telefone: residencial, comercial ou celular
     * @param  tipo 
     * @param  id 
     * @param  valor 
     * @param  res 
     */
    adicionaTelefones(tipo, id, valor, res) {
        const sql = `INSERT INTO Telefones (numeroTelefone, tipoTelefone, cliente) VALUES (${valor}, '${tipo}',  ${id})`
        conexao.query(sql, (erro, resultados) => {
            if(erro){
                res.status(400).json(erro)
            } 
        })        
    }

    /**
     * Valida os dados fornecidos pelo usuário
     * @param usuario 
     * @param  res 
     * @returns erros caso existam
     */
    validaDadosUsuario( usuario, res) {
        const usuarioEhValido  = usuario.nome.length >= 3
        var re = /\S+@\S+\.\S+/
        const emailEhValido = re.test(usuario.email)

        const validacoes = [
            {
                nome: 'nome',
                valido: usuarioEhValido,
                messagem: 'nome deve conter no mminimo 3 caracteres'
            },
            {
                nome: 'email',
                valido: emailEhValido,
                menssagem: 'email inválido'
            }

        ]
        const erros = validacoes.filter(campo => !campo.valido)
        return erros
    }

    /**
     * Pontua Usuário condidante através da máscara fornecida.
     * A máscara é opcional, podendo ser nula caso o usuário se cadastre sem
     * ter recebido um link de convite.
     * @param mascara 
     */
    pontuaConvidante(mascara) {
        if(mascara != null) {
            const tam = mascara.length
            const sqlPontuacao = `UPDATE Usuario SET pontuacao = pontuacao+1 WHERE id = ${mascara.substring(3,tam)}`
            
            conexao.query(sqlPontuacao, (erroPontuacao, resultadosPontuacao) => {
                if(erroPontuacao) {
                    res.status(400).json(resultadosPontuacao)
                }
            })
        }
    }

    /**
     * Prepara os dados para inserção na tabela de usuários
     * @param usuario 
     * @returns usuario formatado
     */
    formatarDadosUsuario(usuario){
        const usuarioFormatado = {
            nome : usuario.nome,
            email: usuario.email
        }
        return usuarioFormatado
    }
    
}
module.exports = new Usuarios