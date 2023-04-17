# TrabalhoDeEngenhariaDeSoftware-TestesUnitáriosEmJava

## Tema

Sistema De Vendas

## Funcionalidades

O Sistema de Vendas tem as seguintes funcionalidades:

1. Fornecer um conjunto de produtos com nome e valor, permitindo ao usuário inserir, alterar e remover os produtos.

2. Oferecer um mecanismo de venda por meio de um Pedido, que inclui uma lista de produtos, o valor total e a forma de pagamento. O sistema não permite o registro da forma de pagamento caso não existam produtos inseridos.

3. Quando a forma de pagamento for escolhida como crédito, permitir o registro da quantidade de parcelas, sendo que cada parcela deve ser maior que R$ 20,00

## **OBservações importantes:**
- Todos os métodos de ação, excluindo os getters e setters, foram testados tanto para fluxos corretos quanto para fluxos alternativos, garantindo a integridade do sistema.

- O teste do método selecionarProdutoPorId como visto em aula, o teste funciona, porém ao utilizar o jococo o teste simplismete para de funcionar. Logo acreditamos que a nossa cobertura de testes esteja entorno de 90%, já que tivemos que deixar o teste desse método comentado.

- O sistema foi construído com base nos testes TDD, adaptando a arquitetura de acordo com os casos de teste previamente definidos. No entanto, para centralizar os testes em uma classe, a classe Mercado foi criada para atuar como um repositório de controle de estoque, pedidos e vendas. Embora não seja o ideal, isso impediu a compilação do sistema ao criar outras classes de teste.

## Divisão do trabalho

- Pesquisa e implementação do JOCOCO: Pedro.
- Implementação dos testes: Tales e Pedro.
- Desenvolvimento do software: Tales e Pedro.
- Decisão sobre a arquitetura: Tales e Pedro.
- Documentação do projeto: Tales.

## Contabilização de tempo para a construção do projeto

- Foram gastos 5 dias ou melhor 5 noites para fazer o trabalho.
- 1 dia para fazer o planejamento e tomar as decisões do trabalho.
- 1 dia para pensar e desenvolver os testes que iriam reger nosso trabalho.
- 2 dias para desenvolver o sistema, demorou um pouco mais que o previsto por conta de problemas que tivemos com o netbeans.
- E 1 dia para fazer a documentação, pesquisar sobre o jococo e inserir no projeto, e resolver alguns conflitos que tivemos.

## Calculo de Complexidade Ciclomática 

- Método de InserirEstoque: CC = 1;
- Método de EditarEstoque: CC = 3
- Método de ExcluirDoEstoque: CC = 3;
- Método de getProdutoPorId: CC = 3;
- Método de adicionarProdutoNoPedido: CC = 5;
- Método de removerProduto: CC = 4;
- Método de concluirVenda: CC = 7;
