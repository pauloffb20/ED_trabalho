package com.company.Classes;

public class Local {

    private String local_name, type;


    public Local(String name, String type){
        this.local_name = name;
        this.type = type;
    }

    public String getLocal_name() {
        return local_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocal_name(String local_name) {
        this.local_name = local_name;
    }

    @Override
    public String toString() {
        return "locais{" + "\n" +
                "nome=" + local_name + "\n" +
                "tipo=" + type +
                '}';
    }

}
