package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> products = new ArrayList<>();
        products.add("Red-Hot Spicy Doritos");
        products.add("Cool Ranch Doritos");
        products.add("Coke");
        products.add("Pepsi");
        products.add("Diet Coke");
        products.add("Five Hour Energy");
        products.add("Mac Charger");
        products.add("Dell Charger");
        products.add("Sunflower Seeds");
        products.add("Peanuts");

        ArrayList<Double> productsprice = new ArrayList<>();
        productsprice.add(2.99);
        productsprice.add(2.99);
        productsprice.add(0.99);
        productsprice.add(0.99);
        productsprice.add(0.99);
        productsprice.add(3.99);
        productsprice.add(120.0);
        productsprice.add(50.0);
        productsprice.add(0.99);
        productsprice.add(0.99);

        ArrayList<String> CustomerItem = new ArrayList<>();
        ArrayList<Integer> CustomerItemAmounts = new ArrayList<>();
        String input;
        Scanner stringInput = new Scanner(System.in);

        StringBuilder output = new StringBuilder();
        double total;
        double grandTotal = 0.00;
        System.out.print("\nEnter the name of the customer: ");
        while(!(input = stringInput.nextLine()).equalsIgnoreCase("0"))   {
            output.append("\n").append(input);
            total = 0.00;
            System.out.println("Enter the name of items: (0 to end");


            for(int i = 0; i < products.size(); i++) {
                System.out.println(products.get(i) + " -------> " + productsprice.get(i));
            }

            while(!(input = stringInput.nextLine()).equalsIgnoreCase("0")) {
                for(String i:products) {
                    if(input.length() > 0 && (i.contains(input) || i.equalsIgnoreCase(input))) {
                        total += productsprice.get(products.indexOf(i));
                        output.append("\n\t").append(input);
                        if(!CustomerItem.contains(input)) {
                            CustomerItem.add(input);
                            CustomerItemAmounts.add(1);}
                        else {
                            int index = CustomerItem.indexOf(input);
                            CustomerItemAmounts.set(index, CustomerItemAmounts.get(index) + 1); }
                        break; }
                }
            }
            output.append("\n\t\t").append(total).append("\n");
            grandTotal += total;
            System.out.print("\nEnter the name of the next customer (0 to end): ");
        }
        System.out.println("Receipt: \n"+output);
        System.out.println("\nProducts Sold: ");
        for(String i:CustomerItem) {
            System.out.println("\t"+i+" ("+CustomerItemAmounts.get(CustomerItem.indexOf(i))+")");
        }
        DecimalFormat df = new
        DecimalFormat ("#########.##");
        System.out.println("\nGrand Total: "+df.format(grandTotal));
    }
}


