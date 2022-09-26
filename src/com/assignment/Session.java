package com.assignment;

import java.util.Scanner;

public class Session {

    public Session() {
    }

    public static void main(String[] args) {

        boolean isLoggedIn = false;
        while (!isLoggedIn){
            Scanner scanner = new Scanner(System.in);
            System.out.println("+------------------+---------------+------------+");
            System.out.println("|--- Welcome to Membership Management System ---|");
            System.out.println("+------------------+---------------+------------+");
//            System.out.println("Enter email: ");
//            String username = scanner.nextLine();
            Memberships memberships = new Memberships();
            Utils.membershipHeader();
            memberships.getMemberships().forEach(member -> System.out.format(Utils.membershipFormat, member.getName(), member.getEmail(), member.getPhone(), member.getType()));
            isLoggedIn = true;
        }
    }
}
