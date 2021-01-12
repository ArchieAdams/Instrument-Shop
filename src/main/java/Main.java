import com.harleyoconnor.javautilities.FileUtils;
import com.harleyoconnor.javautilities.InputUtils;
import com.harleyoconnor.javautilities.IntegerUtils;
import javafx.application.Application;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static ArrayList<Instrument> instrumentArrayList = new ArrayList<>();
    public static HashMap<String, Instrument> reservationsMap = new HashMap<>();
    public static boolean isStaff = false;
    private static String password = "password"; //Very secure

    public static void main(String[] args) {
        instrumentArrayList.add(new Instrument("Piano", "Piano 5000", "Archie", 12.23d,14, "1234"));
        instrumentArrayList.add(new Instrument("Piano", "Piano 5000", "Archie", 12.00d,15, "3453"));
        menu();
    }

    private static void menu(){
        System.out.println("Welcome to this amazing instrument shop that is definitely real");
        while (true){
            System.out.println("What would you like to do?" +
                    "\n1.\tQuit" +
                    "\n2.\tView Items" +
                    "\n3.\tReserve Item");
            if (!isStaff){
                System.out.println("4.\tLogin as staff");
            }
            if (isStaff){
                System.out.println("4.\tEdit Item" +
                        "\n5.\tDelete Item" +
                        "\n6.\tAdd Item");
            }

            switch(InputUtils.getIntInput("\n")) {
                case 1:
                    System.exit(0);
                    break;
                case 2:
                    viewInstrument();
                    break;
                case 3:
                    reserveInstrument();
                    break;
                case 4:
                    if (isStaff){
                        editInstrument();
                    }
                    if (!isStaff){
                        login();
                    }
                    break;
                case 5:
                    deleteInstrument();
                    break;
                case 6:
                    addInstrument();
                    break;
                default:
            }
        }
    }

    private static void addInstrument(){
        instrumentArrayList.add(new Instrument (InputUtils.getInput("Instr\t"),
                                                InputUtils.getInput("Name\t"),
                                                InputUtils.getInput("Manuf\t"),
                                                Double.parseDouble(InputUtils.getInput("Price\t")),
                                                InputUtils.getIntInput("Stock\t"),
                                                InputUtils.getInput("ISBN\t")));
    }

    private static void viewInstrument(){
        instrumentArrayList.forEach(instrument -> System.out.println(
                (instrumentArrayList.indexOf(instrument)+1)+"." +
                "\nInstr\t "+instrument.getInstrument()+
                "\nName\t "+instrument.getName()+
                "\nManuf\t "+instrument.getManufacturer()+
                "\nPrice\t £"+instrument.getPrice()+
                "\nStock\t "+instrument.getStock()+
                "\nISBN\t "+instrument.getISBN()+"\n"));
    }

    private static void reserveInstrument(){
        int indexOfInstrument;
        while (true) {
            indexOfInstrument = findInstrument(InputUtils.getInput("What the ISBN of the product you want to reserve?"));
            if (indexOfInstrument == -1) {
                System.out.println("Please renter the ISBN"); //add way out if forgot it
            }
            if (instrumentArrayList.get(indexOfInstrument).getStock() == 0){
                System.out.println("This item is out of stock");
            }
            else{
                removeStock(instrumentArrayList.get(indexOfInstrument));
                break;
            }
        }
        reservationsMap.put(InputUtils.getInput("What is your name?"), instrumentArrayList.get(indexOfInstrument));
    }

    private static int findInstrument(String ISBN){
        //int indexOfInstrument = instrumentArrayList.forEach(instrument -> instrument.getISBN().equals(ISBN) ? instrumentArrayList.indexOf(instrument): -1);
        for (int i = 0; i < instrumentArrayList.size(); i++) {
            if (instrumentArrayList.get(i).getISBN().equals(ISBN)){
                return i;
            }
        }
        return -1;
    }

    private static void removeStock(Instrument instrument){
        instrument.setStock(instrument.getStock()-1);
    }

    private static void deleteInstrument(){
        instrumentArrayList.remove(findInstrument(InputUtils.getInput("What the ISBN of the product you want to remove?")));
    }

    private static void login(){
        if (InputUtils.getInput("What is the password?").equals(password)){
            isStaff = true;
            System.out.println("Successful logged in");
        }
        else{
            System.out.println("Wrong password");
        }
    }

    private static void editInstrument(){
        boolean loop = true;
        Instrument instrument = instrumentArrayList.get(findInstrument(InputUtils.getInput("What the ISBN of the product you want to edit?")));
        while (loop) {
            System.out.println("What would you like to edit?" +
                    "\n1.Instr\t" + instrument.getInstrument() +
                    "\n2.Name\t" + instrument.getName() +
                    "\n3.Manuf\t" + instrument.getManufacturer() +
                    "\n4.Price\t £" + instrument.getPrice() +
                    "\n5.Stock\t" + instrument.getStock() +
                    "\n6.ISBN\t" + instrument.getISBN() +
                    "\n7.Save\n");


            switch (InputUtils.getIntInput("\n")) {
                case 1:
                    instrument.setInstrument(InputUtils.getInput(""));
                    break;
                case 2:
                    instrument.setName(InputUtils.getInput(""));
                    break;
                case 3:
                    instrument.setManufacturer(InputUtils.getInput(""));
                    break;
                case 4:
                    instrument.setPrice(Double.parseDouble(InputUtils.getInput("")));
                    break;
                case 5:
                    instrument.setStock(InputUtils.getIntInput(""));
                    break;
                case 6:
                    instrument.setISBN(InputUtils.getInput(""));
                    break;
                case 7:
                    loop=false;
                    break;
                default:
            }
        }
    }



}
