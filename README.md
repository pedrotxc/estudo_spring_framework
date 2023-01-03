# spring-boot-estudo

1- Criar projeto no spring initializr (dependencia inicias: lombok, devtools, spring web)

2- Importar projeto como maven

3- Criar primeira classe Hello World
   Usar anotações @RestController, @RequestMapping e @GetMapping, para mapear essa primeira classe.

4- Requisições POST

   4.1- Instalar postman
   
   4.2- Criar primeira chamada post para a endpoint /medicos
   
   4.3- Mapear a controller e dar sysout nas informações enviadas pelo postman. Receber essas informações através de uma String a principio, para aprendizagem. Lembrar de usar a anotação @RequestBody para indicar que é o corpo da requisição
   
   4.4- Criar record (presente nas versões do java 14 e java16) para receber as informações JSON (padrão DTO = Data transfer object), que antes recebemos como string.

5- Spring Data JPA

   5.1- Adicionar as novas dependências para fazer conexão com banco e validação (validation, flyway migration, mysql driver, spring data jpa)
   
   5.2- Criar novo datasource no banco e configurar o application properties com as conexões do banco.
   
   5.3- Criar a entidade JPA médico e mapear comas anotações JPA. Lembrar de usar lombok.
   
   5.4- Criar a interface repository e fazer essa interface extender a repository da JPA. Criar um atributo repository na controller e fazer a injeção de dependência (usar anotação @Autowired para que a jpa instancie a repository).
   
   5.5- Usar a interface repository para salvar os dados. Passar os dados que serão salvos via contrutor.
   
   5.6- Criar migrations com flyway para armazenar a evolução do banco de dados, para usar o flyway é necessário ter a dependência no pom. As migrations deverão ser criadas dentro do diretório resource/db/migration e o padrão de nomenclatura é V1__"nome_migration".sql. A primeira tabela que é criada no projeto é a tabela de médicos.
    
   5.7- Usar a dependecia bean validation para dizer quais são os campos obrigatórios. As anotações usadas em primeiro momento no projeto são: @NotNull, @NotBlank (apenas String), @Email, @Pattern e @Valid. Segue link com outras anotações dessa dependência https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints
   
   5.8- Adicionar novo campo telefone, esse campo deve ser adicionado no banco através das migrations. Lembrar de fazer o mapeamento e adicionar as validations.
   
6- Requisições GET

   6.1- Criar um DTO para listagem dos dados usando o método findAll do repository. Para converter os dados de médico para o DTO, é necessário criar um stream().map e passar as informações através de um construtor.
   
   6.2- Criar a chamda do método de listar os dados no postman.
   
   6.3- Alterar o método de listar na controller, para fazer a paginação. Necessário receber como parametro um Pageable e alterar o tipo de retorno do metódo para Page. Além disso retirar o .strem, pois o método pageable ja possui o map, e também retirar o toList. A paginação é feita através da url, no postman, passando o parametro "?size=1" para falar quantos registros terão na página e para selecionar a pagina o "page=1".
   
   6.4- Fazer a listagem em ordem alfabetica, usando o parâmetro sort na url, ex: "?sort=nome", também é possível definir se será em ordem crescente ou decrescente essa ordenação, ex:"?sort=nome,desc".
   
   6.5- Adicionar configuração padrão de paginação através da anotação @PageableDefault, passamos a configuração padrão dentro dos paranteses, ex: @PageableDefault(size = 1, sort = {"cidade"}). E no apliation.properties adicionar a configuração para retornar a query no log e para que essa query seja formatada. Lembrete: É possível alterar a nomenclatura padrão que está em inglês através de configurações no application.properties, size, page, sort.
   
7- Requisições PUT e DELETE

   7.1- Criar uma requisição PUT no postman para atualizar os dados e começar a criar o método de atualização na controller.
   
   7.2- Criar DTO para fazer a atualização dos dados. 
   
   7.3- Buscar o id e as informações que serão atualizadas e criar método que irá fazer essas atualizações.
   
   7.4- Criar requisição DELETE no postman para ser feito o delete dos dados. Para fazer o delete, também é preciso informar o id do registro que será deletado, entretanto, diferente da forma que foi feito no método de atualização, no delete passaremos o id pela url.
   
   7.5- No método de excluir, receber o id pelo parametro, lembrar da anotação @PathVariable
   
   7.6- Como a exclusão é logica, não iremos deleter o registro do banco, apenas alterar o status para desativo. Para isso primeiro precisamos adicionar o campo status, pois ainda não temos. Então primeiramente criar a migration no flyway
   
   7.7- Após criar a migration, criar esse novo atributo na entidade e no construtor, para ele ser sempre true quando for instanciado. No método de excluir da controller, buscar o registro que vai ser excluido pela ID, como foi feito no método de update e após isso, criar um método de excluir, que irá alterar o valor desse registro para false.
