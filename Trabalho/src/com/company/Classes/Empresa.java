package com.company.Classes;
import com.company.Estruturas.ArrayUnorderedList;
import com.company.Estruturas.NoComparableException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Empresa {

    private ArrayUnorderedList<Local> locais;
    private ArrayUnorderedList<Vendedor> vendedors;
    private ArrayUnorderedList<String> a_visitar;

    public Empresa() {
        this.vendedors = new ArrayUnorderedList<>();
        this.locais = new ArrayUnorderedList<>();
        this.a_visitar = new ArrayUnorderedList<>();
    }

    public void addVendedor(Vendedor m) throws NoComparableException {
        this.vendedors.addToRear(m);
    }

    public void addLocal(Local m) throws NoComparableException {
        this.locais.addToRear(m);
    }

    public ArrayUnorderedList<Local> getLocais() {
        return locais;
    }

    public ArrayUnorderedList<Vendedor> getVendedors() {
        return vendedors;
    }

    public void readJson(String path) throws IOException, ParseException, NoComparableException {

        try (FileReader reader = new FileReader(ClassLoader.getSystemResource(path).getFile())) {

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            JSONArray lang = (JSONArray) jsonObject.get("vendedores");
            JSONArray locals = (JSONArray) jsonObject.get("locais");

            Iterator i = lang.iterator();
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                long ID = (long)  innerObj.get("id");
                String nome = (String) innerObj.get("nome");
                long capacity = (long) innerObj.get("capacidade");
                JSONArray jsonArray = (JSONArray) innerObj.get("mercados_a_visitar");

                Vendedor vendedor = new Vendedor(ID,nome, capacity, jsonArray);
                //System.out.println(vendedor.toString());
                this.addVendedor(vendedor);
            }

            Iterator j = locals.iterator();
            while (j.hasNext()){

                JSONObject newObj = (JSONObject) j.next();

                String name = (String) newObj.get("nome");
                String tipo = (String) newObj.get("tipo");
                Local local = new Local(name, tipo);
                this.addLocal(local);
                //System.out.println(local.toString());
            }
        }

    }

    @Override
    public String toString() {
        String s = "Vendedores:\n";
        s += "*-------------------------------*\n";
        for (Vendedor vendedor: vendedors) {
            s += "\n" + vendedor.toString() + "\n";
        }

        s += "Locais: \n";
        s += "\n" + "*-------------------------------*\n";

        for (Local local : locais){
            s += "\n" + local.toString() + "\n";
        }

        s += "\n" + "*-------------------------------*\n";

        return s;
    }

}
