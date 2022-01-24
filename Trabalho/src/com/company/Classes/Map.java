package com.company.Classes;

import com.company.Estruturas.ArrayUnorderedList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.IOException;

public class Map {
    private ArrayUnorderedList<Vendedor> os_vendedores;
    private ArrayUnorderedList<Local> locais;

    public Map() {
        this.os_vendedores = new ArrayUnorderedList<>();
        this.locais = new ArrayUnorderedList<>();
    }

    public ArrayUnorderedList<Vendedor> getVendedores() {
        return os_vendedores;
    }

    public void addLocal(Local local){
        this.locais.addToRear(local);
    }

    public void addVendedor(Vendedor vendedor){
        this.os_vendedores.addToRear(vendedor);
    }

    public void buildGraphFromJSON(JsonArray vendedores) throws IOException {
        for (JsonElement rJson: vendedores) {
            String vendedor = rJson.getAsString();
           // Vendedor vendedor1 = new Vendedor(vendedor);
            //this.addVendedor(vendedor1);
        }
    }

    public String toString() {
        String s = "";
        s += "Sellers:";
        for (Vendedor vendedor : os_vendedores) {
            s += vendedor.toString() + "\n";
        }
       return s;
    }
}
