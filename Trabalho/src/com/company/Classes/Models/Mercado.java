package com.company.Classes.Models;

import com.company.Estruturas.ArrayUnorderedList;

public class Mercado extends LocalX {

     private ArrayUnorderedList<Integer> clientes;

    public Mercado(String name, String tipo, ArrayUnorderedList<Integer> clientes){
        super();
        this.clientes = clientes;
    }

    public ArrayUnorderedList<Integer> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayUnorderedList<Integer> clientes) {
        this.clientes = clientes;
    }


    @Override
    public String toString() {
        return "Mercado{" +
                "clientes=" + clientes +
                '}';
    }
}
