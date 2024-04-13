<h1 align="center">
<br>Personal Assist 🤖
</h1>

<div align="center">


| Integrantes     |            Responsabilidades          | Turma      |   RM     |
| -------------   | ------------------------------------- | ---------- | -------- |
| Cauã Couto      | Desenvolvimento do projeto em Java    |  2TDSS     |  97755   |
| Kaique Agostinho| Mapeamento das tabelas e relações     |  2TDSS     |  550815  |
| Thiago Gil      | Documentação do projeto               |  2TDSPV    |  551211  |
</div>

## 📝 Descrição do Projeto 

> O projeto Personal Assist foi criado com a proposta de atender desde empresas até pessoas físicas.

Nosso sistema fornece serviços de recomendação de negócios juntamente com um feedback de acompanhamento. Por exemplo, se temos um cliente que quer investir no ramo da tecnologia, iremos avaliar as melhores atitudes a serem tomadas com base nos seus objetivos e capital.

<h2 name="objetivo">🎯 Objetivos do Projeto</h2>
<li> Prever o comportamento futuro dos clientes com base em dados históricos de interação.  </li>
<li>Sugerir produtos ou serviços relevantes com base nos padrões de comportamento dos clientes. </li>
<li>Analisar sentimentos e feedbacks dos clientes para extrair insights uteis. </li>
<li>Otimizar campanhas de marketing para maximizar o ROI. </li>
<li>• Fornece suporte e assistência personalizada aos clientes por meio de um assistente virtual inteligente.</li>

## 📋  Modelo Relacional das Entidades 
![Modelo Logico Personal Assist](https://github.com/ccoutob/Personal-Assist/assets/126828978/c6873979-f0cc-4951-bcca-dda746509cb9)

## 📋 Modelo Lógico das Entidades
![Modelo Relacional Personal Assist](https://github.com/ccoutob/Personal-Assist/assets/126828978/2e8318ec-1cb4-45ac-9b78-1a0a0d33f6fe)

<div>
<h1 align="center"> 📦 Pacotes do Projeto </h1>

<h2> 📦 Model </h2>
<li> Pacote contém as classes responsáveis por serem as base de modelagem da aplicação</li>
<li> Classes responsáveis por mapearem a tabela do Banco de Dados e suas colunas de acordo com as regras de negócio </li>

<h2> 📦 Dto </h2>
<li> As classes contidas nesse pacote são responsáveis pelo mapeamento das transferências que serão feitas no pacote controller</li>
<li> A princípio definem como as informações de nosso sistema serão navegadas e utilizadas</li>

<h2> 📦 Repository </h2>
<li> As classes contidas nesse pacote são responsáveis pela persistência JPA das tabelas</li>
<li> Essas classes serão utilizadas na controller para acessarmos o banco de dados</li>

<h2> 📦 Controller </h2>
<li> As classes contidas nesse pacote são responsáveis por controlarem as requisições que faremos no Postman</li>
<li> Contém o CRUD do projeto com os métodos GET, POST, PUT e DELETE</li>

<h2> 📦 Handler </h2>
<li> A classe nesse pacote é responsável por lançar a exceção de "error 404 not found"</li>
<li> A exceção será lançada caso tentemos realizar a requisição de algum dado que não existe, por exemplo, um id</li>
</div>

<h2 name="endpoints">🌐 Endpoints</h2>

### 💻 Cliente

| Método | Endpoint                      | Descrição                |
| ------ | ----------------------------- | -------------------------|
| GET    | /api/clientes                 | Listar todos os clientes |
| GET    | /api/clientes/&lt;id&gt;      | Buscar cliente pelo id   |
| POST   | /api/clientes                 | Cadastrar um cliente     |
| PUT    | /api/clientes/&lt;id&gt;      | Atualizar um cliente     |
| DELETE | /api/clientes/&lt;id&gt;      | Deletar um cliente       |

### 💻 Empresa

| Método | Endpoint                      | Descrição                |
| ------ | ----------------------------- | -------------------------|
| GET    | /api/empresas                 | Listar todos as empresas |
| GET    | /api/empresas/&lt;id&gt;      | Buscar empresa pelo id   |
| POST   | /api/empresas                 | Cadastrar uma empresa    |
| PUT    | /api/empresas/&lt;id&gt;      | Atualizar uma empresa    |
| DELETE | /api/empresas/&lt;id&gt;      | Deletar uma empresa      |

### 💻 Estatistica

| Método | Endpoint                      | Descrição                    |
| ------ | ----------------------------- | -----------------------------|
| GET    | /api/estatisticas             | Listar todos as estatisticas |
| GET    | /api/estatisticas/&lt;id&gt;  | Buscar estatistica pelo id   |
| POST   | /api/estatisticas             | Cadastrar uma estatistica    |
| PUT    | /api/estatisticas/&lt;id&gt;  | Atualizar uma estatistica    |
| DELETE | /api/estatisticas/&lt;id&gt;  | Deletar uma estatistica      |

### 💻 Servico

| Método | Endpoint                     | Descrição                |
| ------ | ---------------------------- | -------------------------|
| GET    | /api/servico                 | Listar todos os servicos |
| GET    | /api/servico/&lt;id&gt;      | Buscar servico pelo id   |
| POST   | /api/servico                 | Cadastrar um servico     |
| PUT    | /api/servico/&lt;id&gt;      | Atualizar um servico     |
| DELETE | /api/servico/&lt;id&gt;      | Deletar um servico       |

### 💻 Suporte

| Método | Endpoint                     | Descrição              |
| ------ | -----------------------------| -----------------------|
| GET    | /api/suporte                 | Listar todos um ticket |
| GET    | /api/suporte/&lt;id&gt;      | Buscar ticket pelo id  |
| POST   | /api/suporte                 | Cadastrar um ticket    |
| PUT    | /api/suporte/&lt;id&gt;      | Atualizar um ticket    |
| DELETE | /api/suporte/&lt;id&gt;      | Deletar um ticket      |

### 🧑🏻‍💻 Autor 
> Cauã Couto Basques - Turma 2TDSS


