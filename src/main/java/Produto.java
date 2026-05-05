package main.java;

import java.util.Observable;

public class Produto extends Observable {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void atualizarPreco(double novoPreco) {
        this.preco = novoPreco;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
