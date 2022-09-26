package com.assignment;

public class Utils {

    public static final String membershipFormat = "|%-20s|%-25s|%-10s|%-10s|%n";
    public static void membershipHeader(){
        System.out.println("+--------------------+-------------------------+----------+----------+");
        System.out.println("|   Membership Name  |   Email                 |   Phone  |   Type   |");
        System.out.println("+--------------------+-------------------------+----------+----------+");
    }

    public static final String slipFormat = "|%-18s|%-12.f|%-18.2f|%-16d|%-14.2f|%-14d|%-10s|%n";
    public static void slipHeader(){
        System.out.println("+------------------+--------------+--------------------+----------------+----------------+");
        System.out.println("|  Membership Name |   Expense    |   Credit           |   Dollars      |   Type         |");
        System.out.println("+------------------+--------------+--------------------+----------------+----------------+");
    }

    public static final String sumFormat = "|%-18s|%-9.2f|%n";
    public static void sumHeader(){
        System.out.println("+-----------------+-----------+");
        System.out.println("|   Title         |   Value   |");
        System.out.println("+-----------------+-----------+");
    }

    public static final String logFormat = "|%-12s|%-20s|";
    public static void logHeader(){
        System.out.println("+------------+--------------------+");
        System.out.println("| MMS Record |   RecordID         |");
        System.out.println("+------------+--------------------+");
    }
}
