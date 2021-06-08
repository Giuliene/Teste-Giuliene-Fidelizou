class Tabelas{
    /**
     * Inicia a conexão com o banco de dados
     * @param conexao 
     */
    init(conexao) {
        this.conexao = conexao

        this.criarUsuario()
        this.criaTelefones()
    }

    /**
     * Criando a tabela Usuário
     */
    criarUsuario() {
        const sql = 'CREATE TABLE if NOT EXISTS Usuario (id int NOT NULL AUTO_INCREMENT, nome varchar(50) NOT NULL, email varchar(30), pontuacao int DEFAULT 1, PRIMARY KEY(id))'
        this.conexao.query(sql, (erro) => {
            if (erro) {
                console.log(erro)
            } 
        }) 
    }

    /**
     * Criando a tabela Telefones
     */
    criaTelefones() {
        const sql = 'CREATE TABLE IF NOT EXISTS Telefones (id int NOT NULL AUTO_INCREMENT, numeroTelefone varchar(20), tipoTelefone varchar(20), cliente INT NOT NULL, PRIMARY KEY(id), FOREIGN KEY (cliente) REFERENCES Usuario(id))'
        this.conexao.query(sql, (erro) => {
            if(erro) {
                console.log(erro)
            }
        })
    }
}

module.exports = new Tabelas