
package com.mycompany.entities;


public class ProdutoPedido {
    private static int count = 1;
    
    private int id;
    private String nome;
    private double valor;
    private int quantidade;

    public ProdutoPedido(String nome, double valor, int quantidadeStoque) {
        this.id = count;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidadeStoque;
        
        ProdutoPedido.count += 1;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidadeStock) {
        this.quantidade = quantidadeStock;
    }

    public String toString() {
        return "Id: " + this.getId() + "Nome: " + this.getNome() + "valor: " + this.getValor() + "Quantidade em Stock: " + this.getQuantidade();
    }
    
}
