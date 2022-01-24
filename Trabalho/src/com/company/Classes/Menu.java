package com.company.Classes;

import com.company.Estruturas.*;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu {

    private String docFileName = null;
    private Empresa empresa = new Empresa();
    private Gestor gestor = new Gestor(empresa.getVendedors());

    public Menu() { }

    public void run() throws IOException, InvalidIndexException, EmptyException, NotFoundException, ParseException, NoComparableException, EmptyCollectionException, org.json.simple.parser.ParseException {
        int choice = 0;
        System.out.println("Welcome!");
        while (choice != 7) {
            choice = initialMenu();

            switch (choice) {
                case 1:
                    isDocRead();
                    empresa.readJson(docFileName);
                    break;
                case 2:
                    System.out.println(empresa.toString());
                    break;
                case 3:
                    gestor.printSellersToShow();
                    break;
                case 4:
                    changeSeller();
                default:
            }
        }
    }

    private boolean isDocRead() throws NoComparableException, IOException, EmptyCollectionException {
        boolean isread = false;

        if (this.docFileName == null) {
            String mapFileName = readDoc();
            this.docFileName = "Documents/" + mapFileName;
            isread = true;
        }

        return isread;
    }

    private String readDoc() {
        ArrayUnorderedList<String> results = new ArrayUnorderedList<>();
        int counter = 1;
        System.out.println("Choose a file");

        File[] files = new File("src/Documents").listFiles();

        for (File file : files) {
            if (file.isFile()) {
                results.addToRear(file.getName());
                System.out.println(counter + " - " + file.getName());
                counter++;
            }
        }

        int mapFile;
        Scanner inputMoves = new Scanner(System.in);

        mapFile = inputMoves.nextInt();
        if (mapFile <= results.size()) {
            System.out.println("Valid file!");
        } else {
            return "NotFound";
        }

        return results.getIndex(mapFile - 1);
    }

    public Integer initialMenu() {

        Scanner input = new Scanner(System.in);
        String choice;

            System.out.println("Choose from these choices");
            System.out.println("-------------------------\n");
            System.out.println("1 - Import Document");
            System.out.println("2 - View All Enterprise Info");
            System.out.println("3 - View All sellers");
            System.out.println("4 - Update ser");

            choice = input.next();

        return Integer.valueOf(choice);
    }

    /*

    public Integer changeUser() {

        Scanner input = new Scanner(System.in);
        String choice1;

        System.out.println("Qual utilizador quer alterar?");
        System.out.println("-------------------------\n");
        printSellers();
        choice1 = input.next();

        return Integer.valueOf(choice1);
    }

    public void printSellers(){
        int number = 0;

        ArrayUnorderedList<Vendedor> vendedores = empresa.getVendedors();

        for (int i= 0; i < vendedores.size(); i++){
            System.out.println(number + vendedores.getIndex(i).toString());
            number++;
        }
    }

    public Integer changeAtribute() {

        Scanner input = new Scanner(System.in);
        String choice1;

        System.out.println("Qual atributo quer alterar?");
        System.out.println("-------------------------\n");
        System.out.println("1-Nome");
        System.out.println("2-Capacidade");
        System.out.println("3-Sair");
        choice1 = input.next();

        return Integer.valueOf(choice1);
    }


    public String changeName() {

        Scanner input = new Scanner(System.in);
        String choice;

        System.out.println("Qual nome?");
        choice = input.next();

        return String.valueOf(choice);
    }

    public long changeCapacidade(){
        Scanner input = new Scanner(System.in);
        String choice;

        System.out.println("Qual capacidade?");
        choice = input.next();

        return valueOf(choice);
    }
*/

    public void changeSeller() throws IOException, InvalidIndexException, EmptyException, NotFoundException, ParseException, NoComparableException, EmptyCollectionException, org.json.simple.parser.ParseException {

        int sellectSeller = 0;
        int sellectAtribut = 0;
        sellectSeller = gestor.changeUser();
        ArrayUnorderedList<Vendedor> vendedores = empresa.getVendedors();
        sellectAtribut = gestor.changeAtribute();
            switch (sellectAtribut) {
                case 1:
                    Vendedor vendedor = vendedores.getIndex(sellectSeller);
                    String string = gestor.changeName();
                    vendedor.setNome(string);
                    break;
                case 2:
                    Vendedor vendedor2 = vendedores.getIndex(sellectSeller);
                    long capacidade = gestor.changeCapacidade();
                    vendedor2.setCapacidade(capacidade);
                    break;
                default:
            }
        }
}
