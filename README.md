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
   
-Criar migrations com flyway para armazenar a evolução do banco de dados.
    -Adicionar a dependencia no pom.xml
    -Criar pasta db/migration na resource
    -Criar aquivo no padrão flyway "V1_nome.sql"
-Usar bean validation para dizer quais são os campos obrigatórios.
    -Adicionar notações @notnull / @notblank (Somente para campos string) / @email / @pattern / @Valid
    -https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints 
-Adicionar novo campo telefone e adicionar nova migration.

-Fazer metodo de listagem, usando o método findAll do repository. Lembrando que assim como para enviar os dados no post, foi necessário criar o record
para receber os atributos, na listagem também será necessário a criação do record para receber o valor dos atributos.

-Fazer paginação, usando a classe Page e Pageable, usar map para fazer a conversão para DadosListagemMédico (também tem a alternativa de ser feito essa
alteração mexendo na configuração default do spring através da anotação @PageableDefault(size = 10, sort = {"nome"}))
http://localhost:8080/medicos?sort=crm,desc&size=2&page=0
-Fazer a listagem em ordem alfabetica

pela configuração podemos alterar o nome dos parametros (ingles para portugues por exemplo)
spring.data.web.pageable.page-parameter=pagina
spring.data.web.pageable.size-parameter=tamanho
spring.data.web.sort.sort-parameter=ordem
