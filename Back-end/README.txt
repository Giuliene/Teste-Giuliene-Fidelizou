API REST criada utilizando Node.js
Banco de dados: MySQL
Criação do servidor: Express
Testes: Postman
IDE: Visual Studio Code
----
- Para alterar os dados de configuração do banco de dados, acesse o arquivo /infraestrutura/conexao.js
- Para alterar os dados do servidor, acesse o arquivo /config/config.js
- Para alterar a data em que a competição é encerrada, acesse o arquivo /config/config.js
----
Rotas:
"/cadastro" -> Cadastra um novo usuário que não recebeu o link de convite(necessário para o primeiro usuário do banco).
"/convite/mascara" -> Link de convite que cadastra um novo usuário e atribui um ponto ao convidante. A máscara é a união dos 3 primeiros dígitos do nome do usuário convidante e seu id.
"/resultado" -> Exibe o resultado da competição, apresentando os 10 vencedores que obtiveram mais pontos. Caso a data do término da competição ainda não tenha chegado, o sistema omite o resultado, fazendo com que o usuário aguarde seu término.
---
Servidor:
Para a reinicialização automática do servidor, foi utilizado um utilitário de interface chamado nodemon
Para iniciar o servidor, na linha de comando do Visual Studio, digite: npm start
---
Observações:
Os números de telefone foram considerados como (telefoneResidencial, telefoneComercial e telefoneCelular). Considere-os ao cadastrar um novo usuário (além do nome e email).
