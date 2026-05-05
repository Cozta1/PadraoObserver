package main.java;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void monitorar(Produto produto) {
        produto.addObserver(this);
    }

    @Override
    public void update(Observable produto, Object arg) {
        this.ultimaNotificacao = this.nome + ", preço atualizado: " + produto.toString();
    }
}
