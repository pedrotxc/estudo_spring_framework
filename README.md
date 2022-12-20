# spring-boot-estudo
Criar projeto no spring initializr
Importar projeto como maven
Criar primeira classe Hello World
-usar anotações @RestController, @RequestMapping e @GetMapping, para mapear essa primeira classe.

Requisições POST
-Instalar postman
-criar primeira chamada post para a endpoint /medicos
-mapear a controller
-criar record (java 14 e java16) para receber as informações JSON (padrão DTO = Data transfer object)

Spring Data JPA
-Adicionar as dependências necessárias.
-Configurar o application properties com as conexões de banco. (saber o formato application.yaml)
-Configurar a JPA, criando calss emedico para receber as anotações dos seus atributos
-Criar a interface repository e salvar os dados, sendo que esses dados serão recebidos através do construtor pelas entidades.
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
