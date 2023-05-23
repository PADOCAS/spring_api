<h1 align="center">Spring API</h1>
<h3 align="center">Api construída para estudo e prática das habilidades em Spring Boot</h3>

<h3 align="left">Ferramentas utilizadas:</h3>
- Apache Netbeans IDE 17 
<br/>
- Servidor TomCat embutido
<br/>
- PostgreSQL 
<br/>
- Java 18
<br/>
- Spring Boot Starter 2.7.8

<h3 align="left">Resumo da API:</h3>
API com spring boot, funções disponíveis:
<br/>
- Listar Pessoas cadastradas
<br/>
- Alterar Pessoas cadastradas
<br/>
- Incluir novas pessoas
<br/>
- Deletar pessoas
<br/>
Utiliza 3 camadas e se conecta a um banco de dados postgreSQL.
<br/>
<picture>
  <source srcset="https://github.com/PADOCAS/spring_api/assets/99546913/7c535931-1594-4a6e-8692-35295335ff78">
  <img alt="Resumo da API" src="https://github.com/PADOCAS/spring_api/assets/99546913/0b98a61a-8750-474b-98da-cbb0332d843f">
</picture>
<br/>
Camada API/Controller -> recebe as solicitações e envia para camada de serviços
<br/>
Camada de serviço -> faz a lógica de negócio
<br/>
Camada de banco de dados -> é responsável por se conectar com o banco de dados
<br/>

<h3 align="left">Configuração para testes:</h3>
Arquivo de configuração (src/main/resources/application.yml), nele você configurara:
<br/>
- A base de dados que vai utilizar.
<br/>
- Usuário/Senha do banco
<br/>
- Porta TomCat
<br/>
- Configura a estrutura do hibernate (ddl-auto -> create-drop, update, create ou validate)
<br/>
<br/>
Para testes, indico o postman, onde é possível simular todas as opções bem facilmente, segue alguns exemplos de requisições:
<br/>
GET -> localhost:8080/api/pessoa/jdbc (Consulta com JDBC exemplo - lista todas as pessoas cadastradas)
<br/>
GET -> localhost:8080/api/pessoa (Lista todas as pessoas cadastradas)
<br/>
GET -> localhost:8080/api/pessoa/1 (Retorna a Pessoa com o código 1 (se existir))
<br/>
POST -> localhost:8080/api/pessoa (Passando um objeto JSON com nome,email, data nascimento)
<br/>
DELETE -> localhost:8080/api/pessoa/29 (Delete a Pessoa com código 29 (se existir))
<br/>
PUT -> localhost:8080/api/pessoa/1?email=alves_peres_marques@gmail.com.br&nome=Regis Polentão (Altera a pessoa de código 1 (se existir))

