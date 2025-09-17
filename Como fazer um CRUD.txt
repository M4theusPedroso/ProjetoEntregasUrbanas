como fazer um CRUD:

1 - criar a model: 
  - gerar um pacote
  - criar model como uma nova classe
  - importar as bibliotecas que sao necessarias para o seu projeto (jakarta, getter e setter)
  - criar suas variaveis ou importar do banco de dados 

2 - repository: 
  - criar um pacote como repository
  - criar uma interface referenciando a sua tabela (ClienteRepository)
  - fazer a anotacao, @Repository, indicando que e um repository
  - extender a interface ao JpaRepository

3 - service:
  - gerar o pacote service 
  - criar uma nova classe como "ClienteService"
  - fazer anotacao indicando que e um Service (@Service)
  - criar uma variavel final para conectar ClienteService com ClienteRepository
  - gerar um metodo ClienteService que recebe funcoes de ClienteRepository
  - fazer metodos para listar, cadastrar, buscar, deletar, atualizar

4 - controller
  - criar pacote para controller
  - criar classe (ClienteController)
  - importar bibliotecas para criar o codigo
  - criar anotacoes @RestController para interagir com os dados. 
  - @ResquestMapping para mapear sua URL
  - dentro da classe, gerar variavel final, conectando ClienteService
  - criar metodo para clienteController receber clienteService
  - gerar anotacoes @GetMapping, @PostMapping, @DeleteMapping, @PutMapping