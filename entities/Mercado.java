package com.mycompany.entities;

import java.util.ArrayList;

public class Mercado {

    public ArrayList<Produto> produtosEmStock;
    public ArrayList<Pedido> listaPedidosEmAberto;

    public Mercado() {
        this.produtosEmStock = new ArrayList<>();
        this.listaPedidosEmAberto = new ArrayList<>();
    }

    public void InserirEstoque(Produto produto) {
        this.produtosEmStock.add(produto);
    }

    public void EditarEstoque(Produto produto, String novoNome, double novoPreco, int novaQuantidade) {
        for (Produto p : produtosEmStock) {
            if (p.equals(produto)) {
                p.setNome(novoNome);
                p.setValor(novoPreco);
                p.setQuantidade(novaQuantidade);
                break;
            }
        }
    }

    public void ExcluirDoEstoque(int id) {
        for (int i = 0; i < produtosEmStock.size(); i++) {
            if (produtosEmStock.get(i).getId() == id) {
                produtosEmStock.remove(i);
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    public Produto getProdutoPorId(int id) {
        for (Produto produto : produtosEmStock) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public void cadastrarPedido(Pedido pedido) {
        this.listaPedidosEmAberto.add(pedido);
    }

    public void adicionarProdutoNoPedido(Produto produto, int quantProdutos, int idPedido) {
        var existe = false;
        var nome = produto.getNome();
        var valor = produto.getValor();
        var quantidade = produto.getQuantidade();
        var valorTotal = listaPedidosEmAberto.get(idPedido).getValorTotal();
        if (quantProdutos <= quantidade) {
            for (ProdutoPedido p : listaPedidosEmAberto.get(idPedido).getProdutoPedido()) {
                if (p.getNome().equals(nome)) {
                    p.setQuantidade(p.getQuantidade() + quantProdutos);
                    produto.setQuantidade(quantidade - quantProdutos);
                    existe = true;
                }
            }
            if (existe == false) {
                ProdutoPedido produtoPedido = new ProdutoPedido(nome, valor, quantProdutos);
                listaPedidosEmAberto.get(idPedido).getProdutoPedido().add(produtoPedido);
                listaPedidosEmAberto.get(idPedido).setValorTotal(valorTotal + (produto.getValor() * quantProdutos));
                produto.setQuantidade(quantidade - quantProdutos);
            }
        }
    }

    public void removerProduto(Produto produto, int quantProdutos, int idPedido) {
        var quantidade = produto.getQuantidade();
        var nome = produto.getNome();
        var valor = produto.getValor();
        Pedido pedido = listaPedidosEmAberto.get(idPedido);
        var valorTotal = pedido.getValorTotal();
        ArrayList<ProdutoPedido> produtoDoPedido = pedido.getProdutoPedido();

        for (ProdutoPedido p : produtoDoPedido) {
            if (p.getNome().equals(nome)) {
                if (p.getQuantidade() == quantProdutos) {
                    produtoDoPedido.remove(p);
                }
                listaPedidosEmAberto.get(idPedido).setValorTotal(valorTotal - (produto.getValor() * quantProdutos));
                produto.setQuantidade(quantidade + quantProdutos);
                break;
            }
        }
    }

    public String concluirVenda(int idPedido, FormaPagamento formaPagamento, Integer numeroParcelas) {
        Pedido pedido = listaPedidosEmAberto.get(idPedido);
        String retorno = "";
        if (!pedido.getProdutoPedido().isEmpty() && pedido.getEstado() == "Aberto") {
            switch (formaPagamento) {
                case DINHEIRO:
                    retorno = "O total da compra foi de R$" + pedido.getValorTotal() + ", a forma de pagamento escolhida foi dinheiro";
                    pedido.setEstado("Fechado");
                    listaPedidosEmAberto.remove(pedido);
                    break;
                case CARTAO_CREDITO:
                    var valorParcela = pedido.getValorTotal() / numeroParcelas;
                    if (valorParcela > 20) {
                        retorno = "O total da compra foi de R$" + pedido.getValorTotal() + ", a forma de pagamento escolhida foi no cartão de crédito, e o valor da parcela ficou: R$" + valorParcela;
                        pedido.setEstado("Fechado");
                        listaPedidosEmAberto.remove(pedido);
                    } else {
                        retorno = "Valor de parcelas inferior a 20 reais.";
                    }

                    break;
                case CARTAO_DEBITO:
                    retorno = "O total da compra foi de R$" + pedido.getValorTotal() + ", a forma de pagamento escolhida foi no cartão de débito";
                    pedido.setEstado("Fechado");
                    listaPedidosEmAberto.remove(pedido);
                    break;
            }
            return retorno;

        } else {
            return "Não há itens em seu pedido!";
        }
    }
}
