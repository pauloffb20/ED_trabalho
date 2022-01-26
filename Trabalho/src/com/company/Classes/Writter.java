package com.company.Classes;

import com.company.Classes.Models.Local;
import com.company.Classes.Models.Vendedor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Register a person on the txt file
 */
public class Writter {
    Gson gson = new Gson();
    Vendedor[] registerdUsers = null;
    Local[] registerLocals = null;
    private String fileNamePath  = "src/Documents/vendedores.json";
    private String storagePath = "src/Documents/Storage.json", enterprise = "src/Documents/enterprise.json";


    public void appendEnterprise(GestaoEmpresa p) throws IOException {
        GestaoEmpresa gestaoEmpresa = p;
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter(this.enterprise);
        gson.toJson(gestaoEmpresa, writer);
        writer.flush();
        writer.close();
    }

    public void appendPersonToFile(Vendedor p) throws IOException {
            Vendedor vendedor = p;
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            FileWriter writer = new FileWriter(this.fileNamePath);
            gson.toJson(vendedor, writer);
            writer.flush();
            writer.close();
    }

    public void appendStorage(Local local) throws IOException {
        Local local1 = local;
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter(this.storagePath);
        gson.toJson(local, writer);
        writer.flush();
        writer.close();
    }


}
