package com.company.Classes;

import com.company.Classes.Models.Local;
import com.company.Estruturas.ArrayUnorderedList;
import com.company.Estruturas.Network;

import java.util.Scanner;

public class GestaoMercados {

    private Network<Local> network;

    public GestaoMercados(Network<Local> localNetwork){
        this.network = localNetwork;
    }

    public void printMarkets() {
        Object[] locais = network.getVertices();

        for (int i = 0; i < network.size(); i++) {
            Local atual = (Local) locais[i];
            if (atual.getType().equals("Mercado")) {
                System.out.println(i + " para escolher o :" + locais[i].toString());
            }
        }
    }

    public void printMarketsToShow() {
        Object[] locais = network.getVertices();

        for (int i = 0; i < network.size(); i++) {
            Local atual = (Local) locais[i];
            if (atual.getType().equals("Mercado")) {
                System.out.println(locais[i].toString());
            }
        }
    }

    public void setMarket(){
        Object[] locais = network.getVertices();
        int choice, choice2, choice3, choice4;
        String nome;

        printMarkets();
        System.out.println("Escolha o mercado a alterar:");
        Scanner input = new Scanner(System.in);
        input.hasNext();
        choice = Integer.parseInt(input.next());

        Local mercado = (Local) locais[choice];

        System.out.println("Qual item quer alterar?");
        System.out.println("1- Nome");
        System.out.println("2- Capacidade");
        System.out.println("3- Stock");
        System.out.println("4- Exit");
        Scanner input5 = new Scanner(System.in);
        choice4 = Integer.parseInt(input5.next());

        while (choice4 != 4) {
            switch (choice4) {
                case 1:
                    System.out.println("Nome?");
                    Scanner input6 = new Scanner(System.in);
                    input6.hasNext();
                    nome = String.valueOf(input6.next());
                    mercado.setLocal_name(nome);
                    choice4 = 4;
                    break;
                case 2:
                    System.out.println("Capacidade?");
                    Scanner input2 = new Scanner(System.in);
                    input2.hasNext();
                    choice2 = Integer.parseInt(input2.next());
                    mercado.setCapacidade(choice2);
                    choice4 = 4;
                    break;
                case 3:
                    System.out.println("Quanto Stock?");
                    Scanner input3 = new Scanner(System.in);
                    input3.hasNext();
                    choice3 = Integer.parseInt(input3.next());
                    mercado.setStock(choice3);
                    choice4 = 4;
                    break;
                default:
                    return;
            }
        }
    }

    public void addMarket(){

        int choice, choice2;
        String name, tipo = "Mercado";

        System.out.println("Nome:");
        Scanner input4 = new Scanner(System.in);
        input4.hasNext();
        name = String.valueOf(input4.next());

        System.out.println("capacidade:");
        Scanner input6 = new Scanner(System.in);
        input6.hasNext();
        choice2 = Integer.parseInt(input6.next());

        System.out.println("Stock:");
        Scanner input7 = new Scanner(System.in);
        input7.hasNext();
        choice = Integer.parseInt(input7.next());

        ArrayUnorderedList<Integer> clientes = new ArrayUnorderedList<>();
        clientes.addToRear(1);
        clientes.addToRear(20);

        Local novoMercado = new Local(name, tipo, choice2, choice, clientes);

        network.addVertex(novoMercado);
    }

    public void AddOrSetMarkets() {

        int menu;

        System.out.println("1- Mudar Mercado");
        System.out.println("2- Adicionar mercado");
        System.out.println("3 - exit");
        Scanner input = new Scanner(System.in);
        input.hasNext();
        menu = Integer.parseInt(input.next());

        while (menu != 3) {
            switch (menu) {
                case 1:
                    setMarket();
                    System.out.println("1- Mudar Mercado");
                    System.out.println("2- Adicionar mercado");
                    System.out.println("3 - exit");
                    Scanner input1 = new Scanner(System.in);
                    input1.hasNext();
                    menu = Integer.parseInt(input1.next());
                    break;
                case 2:
                    addMarket();
                    System.out.println("1- Mudar Mercado");
                    System.out.println("2- Adicionar mercado");
                    System.out.println("3 - exit");
                    Scanner input2 = new Scanner(System.in);
                    input2.hasNext();
                    menu = Integer.parseInt(input2.next());
                    break;
                default:
                    return;
            }
        }
    }





}
