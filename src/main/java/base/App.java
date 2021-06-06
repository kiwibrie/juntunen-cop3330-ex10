package base;

/*
 *  UCF COP3330 Summer 2021 Assignment 10 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.util.Scanner;
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        App myApp = new App();

        float itemPrice1 = myApp.prompt("price", 1);
        float itemQuant1 = myApp.prompt("quantity", 1);
        float itemPrice2 = myApp.prompt("price", 2);
        float itemQuant2 = myApp.prompt("quantity", 2);
        float itemPrice3 = myApp.prompt("price", 3);
        float itemQuant3 = myApp.prompt("quantity", 3);

        float subtotal = myApp.calculateSubtotal(itemPrice1, itemPrice2, itemPrice3,
                itemQuant1, itemQuant2, itemQuant3);
        float tax = myApp.calculateTax(subtotal);
        float total = myApp.calculateTotal(subtotal, tax);

        myApp.printOutput(subtotal, tax, total);
    }

    public void printOutput(float subtotal, float tax, float total){
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Tax: $%.2f\n", tax);
        System.out.printf("Total: $%.2f", total);
    }

    public float calculateSubtotal(float ip1, float ip2, float ip3, float iq1, float iq2, float iq3){
        return (ip1 * iq1) + (ip2 * iq2) + (ip3 * iq3);
    }

    public float calculateTax(float subtotal){
        float salesTax = (float) 0.055; //5.5%
        return subtotal * salesTax;
    }

    public float calculateTotal(float subtotal, float tax){
        return subtotal + tax;
    }

    public float prompt(String prompt, int x){
        System.out.printf("Enter the %s of item %d: ", prompt, x);
        return in.nextFloat();
    }
}
