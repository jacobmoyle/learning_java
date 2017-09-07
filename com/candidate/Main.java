package com.candidate;


public class Main {
    public static void main(String []args) {

        String inputOne = "1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85";
        String inputTwo = "1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50";
        String inputThree = "1 imported bottle of perfume at 27.99\n1 bottle of perfume at 18.99\n1 packet of headache pills at 9.75\n1 box of imported chocolates at 11.25\n";

        System.out.print("\n\n----- Input One -----\n\n");
        System.out.println(new Order(inputOne).getOrder());

        System.out.print("\n\n----- Input Two -----\n\n");
        System.out.println(new Order(inputTwo).getOrder());

        System.out.print("\n\n----- Input Three -----\n\n");
        System.out.println(new Order(inputThree).getOrder());

    }
}