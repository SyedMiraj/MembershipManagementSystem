package com.assignment;

public class Utils {

    public final String membershipFormat = "|%-20s|%-25s|%-10s|%-10s|%n";
    public void membershipHeader(){
        System.out.println("+--------------------+-------------------------+----------+----------+");
        System.out.println("|   Membership Name  |   Email                 |   Phone  |   Type   |");
        System.out.println("+--------------------+-------------------------+----------+----------+");
    }
    public void membershipFooter(){
        System.out.println("+--------------------+-------------------------+----------+----------+");
    }

    public final String slipFormat = "|%-18s|%-14.2f|%-20.2f|%-16.2f|%-16s|%n";
    public void slipHeader(){
        System.out.println("+------------------+--------------+--------------------+----------------+----------------+");
        System.out.println("|  Membership Name |   Expense    |   Credit           |   Dollars      |   Type         |");
        System.out.println("+------------------+--------------+--------------------+----------------+----------------+");
    }
    public void slipFooter(){
        System.out.println("+------------------+--------------+--------------------+----------------+----------------+");
    }

    public final String sumFormat = "|%-29s|%-11.2f|%n";
    public void sumHeader(){
        System.out.println("+-----------------------------+-----------+");
        System.out.println("|   Title                     |   Value   |");
        System.out.println("+-----------------------------+-----------+");
    }
    public void sumFooter(){
        System.out.println("+-----------------------------+-----------+");
    }

    public final String logFormat = "|%-12s|%-20s|%n";
    public void logHeader(){
        System.out.println("+------------+--------------------+");
        System.out.println("| MMS Record |   RecordID         |");
        System.out.println("+------------+--------------------+");
    }
    public void logFooter(){
        System.out.println("+------------+--------------------+");
    }

    public void welcomeScreen(){
        System.out.println("+------------------+---------------+------------+");
        System.out.println("|--- Welcome to Membership Management System ---|");
        System.out.println("+------------------+---------------+------------+");
    }
}
