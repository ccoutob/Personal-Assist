<h1 align="center">Personal Assist 🤖 </h1>

<div align="center">


| Integrantes      |            Responsabilidades          | Turma      |   RM     |
| --------------   | ------------------------------------- | ---------- | -------- |
| Leonardo Matheus | Documentação do sistema               |  2TDSPN    |  99824   |
| Cauã Couto       | Desenvolvimento do projeto em Java    |  2TDSS     |  97755   |
| Kaique Agostinho | Mapeamento das tabelas e relações     |  2TDSS     |  550815  |
| Thiago Gil       | Documentação do sistema               |  2TDSPV    |  551211  |
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
![Relacional](https://github.com/ccoutob/Personal-Assist/assets/126828978/7e63b000-e409-4865-b734-ac499fff2448)
## 📋 Modelo Lógico das Entidades
![Logico](https://github.com/ccoutob/Personal-Assist/assets/126828978/5c4f7c5d-f988-4a87-a13c-2b035bf6d3ae)

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

## ❗❗ COMO NOSSO SISTEMA FUNCINA ❗❗
<li> Inicie a aplicação spring após clonar o repositório ou baixar o arquivo do projeto</li>
<li> Baixe o arquivo de requisições do postman que está logo abaixo das tabelas de endpoints</li>
<li> Importe o arquivo para o seu postman</li>
<li> realize as requisições de GET, POST, PUT e DELETE</li>
<li> Utilize na URL "http://localhost:8080/{Endpoint}" Confira abaixo em Endpoints</li>


<h2 name="endpoints">🌐 Endpoints</h2>

### 💻 Cliente

| Método | Endpoint                  | Descrição                |
| ------ | ------------------------- | -------------------------|
| GET    | /clientes                 | Listar todos os clientes |
| GET    | /clientes/&lt;id&gt;      | Buscar cliente pelo id   |
| POST   | /clientes                 | Cadastrar um cliente     |
| PUT    | /clientes/&lt;id&gt;      | Atualizar um cliente     |
| DELETE | /clientes/&lt;id&gt;      | Deletar um cliente       |

### 💻 Empresa

| Método | Endpoint                  | Descrição                |
| ------ | --------------------------| -------------------------|
| GET    | /empresas                 | Listar todos as empresas |
| GET    | /empresas/&lt;id&gt;      | Buscar empresa pelo id   |
| POST   | /empresas                 | Cadastrar uma empresa    |
| PUT    | /empresas/&lt;id&gt;      | Atualizar uma empresa    |
| DELETE | /empresas/&lt;id&gt;      | Deletar uma empresa      |

### 💻 Estatistica

| Método | Endpoint                  | Descrição                    |
| ------ | ------------------------- | -----------------------------|
| GET    | /estatisticas             | Listar todos as estatisticas |
| GET    | /estatisticas/&lt;id&gt;  | Buscar estatistica pelo id   |
| POST   | /estatisticas             | Cadastrar uma estatistica    |
| PUT    | /estatisticas/&lt;id&gt;  | Atualizar uma estatistica    |
| DELETE | /estatisticas/&lt;id&gt;  | Deletar uma estatistica      |

### 💻 Servico

| Método | Endpoint                 | Descrição                |
| ------ | -------------------------| -------------------------|
| GET    | /servico                 | Listar todos os servicos |
| GET    | /servico/&lt;id&gt;      | Buscar servico pelo id   |
| POST   | /servico                 | Cadastrar um servico     |
| PUT    | /servico/&lt;id&gt;      | Atualizar um servico     |
| DELETE | /servico/&lt;id&gt;      | Deletar um servico       |

### 💻 Suporte

| Método | Endpoint                 | Descrição              |
| ------ | -------------------------| -----------------------|
| GET    | /suporte                 | Listar todos um ticket |
| GET    | /suporte/&lt;id&gt;      | Buscar ticket pelo id  |
| POST   | /suporte                 | Cadastrar um ticket    |
| PUT    | /suporte/&lt;id&gt;      | Atualizar um ticket    |
| DELETE | /suporte/&lt;id&gt;      | Deletar um ticket      |

❗❗ Acesse o arquivo de requisições do postman <a href="https://github.com/ccoutob/Personal-Assist/blob/main/Personal_Assist_Postman_Collection">AQUI</a> ❗❗

<h1 name="objetivo">🎯 Funcionalidades do projeto adicionadas na Sprint 2</h1>
<li>Tabelas relacionadas por chave estrangeira, agora se comunicam entre si. Relacionamentos 1:1, 1:N e N:M</li>
<li>Nova tabela NFE adicionada, se relacionando com a tabela CLIENTE em um relacionamento 1:1</li>
<li>Requisições estrangeiras no Postman estão nomeadas, garantindo organização</li>

### 💻 Feedback
> O POST desta tabela já é automaticamente adicionada na inserção de dados da Empresa e do Cliente - Cadastrando um dos dois já é inserido o feedback 

| Método | Endpoint                  | Descrição                 |
| ------ | --------------------------| --------------------------|
| GET    | /feedback                 | Listar todos os feedbacks |
| GET    | /feedback/&lt;id&gt;      | Buscar feedback por id    |
| PUT    | /feedback/&lt;id&gt;      | Atualizar um feedback     |
| DELETE | /feedback/&lt;id&gt;      | Deletar um feedback       |

### 🌐Endpoints das chaves estrangeiras

### 💻 Cliente
| Método | Endpoint                                              | Descrição                         | 
| ------ | ----------------------------------------------------- | ----------------------------------|
| PUT    | /clientes/&lt;idCliente&gt;/servico/&lt;idServico&gt; | Adicionar um servico a um cliente |
| DELETE | /clientes/&lt;idCliente&gt;/servico/&lt;idServico&gt; | Deletar o servico de um cliente   |

### 💻 Empresa
| Método | Endpoint                                             | Descrição                          | 
| ------ | ---------------------------------------------------- | -----------------------------------|
| PUT    | /empresa/&lt;idEmpresa&gt;/servico/&lt;idServico&gt; | Adicionar um servico a uma empresa |
| DELETE | /empresa/&lt;idEmpresa&gt;/servico/&lt;idServico&gt; | Deletar o servico de uma empresa   |

### 💻 Estatistica
> Agora a Tabela ESTATISTICA deve realizar o metodo post já associando a tabela Empresa ou Cliente

| Método | Endpoint                                           | Descrição                            |
| ------ | -------------------------------------------------- | -------------------------------------|
| POST   | /estatisticas/&lt;idEmpresa&gt;/estatisticaEmpresa | Cadastrar uma estatistica da empresa |
| POST   | /estatisticas/&lt;idCliente&gt;/estatisticaCliente | Cadastrar uma estatistica do cliente |

### 💻 Servico

| Método | Endpoint                            | Descrição                        |
| ------ | ------------------------------------| ---------------------------------|
| DELETE | /empresas/&lt;idEmpresa&gt;/servico | Deletar o servico de uma empresa |
| DELETE | /clientes/&lt;idCliente&gt;/servico | Deletar o servico de um cliente  |

### 💻 Suporte

| Método | Endpoint                                  | Descrição                             |
| ------ | ------------------------------------------| --------------------------------------|
| POST   | /suporte/&lt;idSuporte&gt;/suporteCliente | Cadastrar o suporte para um cliente   |
| POST   | /suporte/&lt;idSuporte&gt;/suporteEmpresa | Cadastrar o suporte para uma empresa  |

<br>

<h1 name="objetivo">🎯 Funcionalidades do projeto adicionadas na Sprint 3</h1>
<li>Segurança com JWT</li>
<li>Controle de acesso em nossa aplicação, usuário precisa estar logado para realizar requisições</li>
<li>Documentação da API com seus Endpoints no Swagger</li>

<h1>Sem anonimato 🕵️</h1> 
<li>Com o sistema de login, nenhum usuário de fora do nosso sistema poderá realizar qualquer ação de CRUD de nossa aplicação</li>
</br>

## 📝 Acesso ao Swagger
Verifique nossa documentação do Swagger <a href=http://localhost:8080/swagger-ui/index.html> AQUI </a>
> Antes de abrir o link acima é necessário a aplicação já ter sido iniciada

<br>
❗❗ Para mais informações, veja o vídeo explicativo de nosso sistema <a href=https://youtu.be/LeKTfMQguW4> AQUI </a> ❗❗

### 🧑🏻‍💻 Autor 
> Cauã Couto Basques - Turma 2TDSS


