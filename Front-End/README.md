
# instalar dependências
npm install

# carregar servidor na porta localhost:8080
npm run dev

----
Um erro de acesso foi detectado no código do backend forcecido, então adicionei o seguinte trecho
 no arquivo server.js:

app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  res.header('Access-Control-Allow-Methods', 'POST, GET, PUT, DELETE, OPTIONS');
  next();
});