
package com.mycompany.entities;

import java.util.ArrayList;


public class Pedido {
    private ArrayList<ProdutoPedido> produtoPedido;
    
    private double valorTotal;
    private FormaPagamento formaPagamento;
    private int parcelas;
    private String estado;

    public Pedido() {
        this.produtoPedido = new ArrayList<>();
        this.valorTotal = 0.0;
        this.formaPagamento = null;
        this.parcelas = 0;
        this.estado = "Aberto";
    }


    public ArrayList<ProdutoPedido> getProdutoPedido() {
        return produtoPedido;
    }

    public void setProdutoPedido(ArrayList<ProdutoPedido> produtoPedido) {
        this.produtoPedido = produtoPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
