package com.company.Classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Register a person on the txt file
 */
public class RegisterSeller {
    Gson gson = new Gson();
    Vendedor[] registerdUsers = null;
    private String fileNamePath  = "./registeredPersons/registeredPersons.json";

    public boolean appendPersonToFile(Vendedor p) throws IOException {
        Vendedor vendedor = p;
        Vendedor[] vendedors = getRegisteredUsers();
        boolean alreadyRegisterd = false;
        Vendedor[] tmp = new Vendedor[vendedors.length + 1];

        for (int i = 0; i < vendedors.length; i++) {
            tmp[i] = vendedors[i];
            if (vendedors[i].getNome().equals(vendedor.getNome())) {
                System.out.println("Pessoa já registrada");
                alreadyRegisterd = true;
            }
        }
        if (!alreadyRegisterd) {

            tmp[tmp.length - 1] = vendedor;
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();

            FileWriter writer = new FileWriter(this.fileNamePath);

            gson.toJson(tmp, writer);

            writer.flush();
            writer.close();
        }
        return true;
    }

    public Vendedor[] getRegisteredUsers() throws IOException {
        Gson gson = new Gson();

        Reader reader = Files.newBufferedReader(Paths.get(this.fileNamePath));

        Vendedor[] vendedors = gson.fromJson(reader, Vendedor[].class);

        reader.close();
        this.registerdUsers = vendedors;
        return vendedors;
    }

    public void printAll() throws IOException {
        Vendedor[] regVendedors = this.getRegisteredUsers();

        for (int i = 0; i< regVendedors.length; i++){
            Vendedor p = regVendedors[i];
            System.out.println("Name: "+ p.getNome());
        }
    }
}
