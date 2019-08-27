package com.tws.refactoring.extract_method;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class OwingPrinter {
    void printOwing(String name, List<Order> orders) {

        printBanner();
        double outstanding = culOwings(orders);
            // print details
        printDetails("name: " + name, "amount: " + outstanding);

    }

    private void printDetails(String s, String s2) {
        System.out.println(s);
        System.out.println(s2);
    }


    public Double culOwings(List<Order> orders){
        Iterator<Order> elements = orders.iterator();
        double outstanding = 0.0;
        // print owings
        while (elements.hasNext()) {
            Order each = (Order) elements.next();
            outstanding += each.getAmount();
        }
        return outstanding;
    }

    public void printBanner(){
        // print banner
        System.out.println ("*****************************");
        System.out.println ("****** Customer totals ******");
        System.out.println ("*****************************");
    }

}



class Order {
    private  double amount;//delete final

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
