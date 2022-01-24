package com.company.Classes;
import org.json.simple.JSONArray;
import java.io.IOException;


public class Vendedor {

    private String nome;
    private JSONArray mercados;
    private long id, capacidade;

    public Vendedor(long id, String name, long capacidade, JSONArray mercados) throws IOException {
        this.nome = name;
        this.id = id;
        this.capacidade = capacidade;
        this.mercados = mercados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public JSONArray getMercados() {
        return mercados;
    }

    public void setMercados(JSONArray mercados) {
        this.mercados = mercados;
    }

    public long getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(long capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {

        String s = "ID:" + id + "\n" + "Nome:" + nome
                + "\n" + "Capacidade:"
                + capacidade + "\n" + "Mercados" + mercados;

            return s;
        }
}
