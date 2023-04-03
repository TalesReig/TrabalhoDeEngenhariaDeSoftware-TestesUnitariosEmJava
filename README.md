# TrabalhoDeEngenhariaDeSoftware-TestesUnitáriosEmJava

## Tema

Sistema De Vendas

## Funcionalidades

O Sistema de Vendas tem as seguintes funcionalidades:

1. Fornecer um conjunto de produtos com nome e valor, permitindo ao usuário inserir, alterar e remover os produtos.

2. Oferecer um mecanismo de venda por meio de um Pedido, que inclui uma lista de produtos, o valor total e a forma de pagamento. O sistema não permite o registro da forma de pagamento caso não existam produtos inseridos.

3. Quando a forma de pagamento for escolhida como crédito, permitir o registro da quantidade de parcelas, sendo que cada parcela deve ser maior que R$ 20,00

**OBservações importantes:**
- Todos os métodos de ação, excluindo os getters e setters, foram testados tanto para fluxos corretos quanto para fluxos alternativos, garantindo a integridade do sistema.

- O sistema foi construído com base nos testes TDD, adaptando a arquitetura de acordo com os casos de teste previamente definidos. No entanto, para centralizar os testes em uma classe, a classe Mercado foi criada para atuar como um repositório de controle de estoque, pedidos e vendas. Embora não seja o ideal, isso impediu a compilação do sistema ao criar outras classes de teste.

## Calculo de Complexidade Ciclomática 

- Método de InserirEstoque: CC = 1;
- Método de EditarEstoque: CC = 2;
- Método de ExcluirDoEstoque: CC = 2;
- Método de getProdutoPorId: CC = 1;
- Método de adicionarProdutoNoPedido: CC = 7;
- Método de removerProduto: CC = 2;
- Método de concluirVenda: CC = 4;
