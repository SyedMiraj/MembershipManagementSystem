package com.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Session {

    Supermarket loggedInUser;

    private boolean login(String username, String password, List<Supermarket> supermarkets) {
        this.loggedInUser = supermarkets
                .stream()
                .filter(x -> x.getEmail().equals(username))
                .findFirst()
                .orElse(null);
        if (this.loggedInUser == null) {
            System.out.println("Bad username or password");
            return false;
        }
        if (!this.loggedInUser.getPassword().equals(password)) {
            System.out.println("Bad username or password");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Session session = new Session();
        List<Membership> memberships = session.initializeMembershipsData();
        List<Supermarket> supermarkets = session.initializeSupermarketsData();
        System.out.println("+------------------+---------------+------------+");
        System.out.println("|--- Welcome to Membership Management System ---|");
        System.out.println("+------------------+---------------+------------+");
        System.out.println("Please log in to enter into the system.");
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter email: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            isLoggedIn = session.login(username, password, supermarkets);
        }

        while (isLoggedIn) {
            System.out.println("Hi " + session.loggedInUser.getName());
            isLoggedIn = false;
        }
    }

    private List<Supermarket> initializeSupermarketsData() {
        List<Supermarket> supermarkets = new ArrayList<>();
        supermarkets.add(new Supermarket("John Smith", "john.smith@uts.com", "user222"));
        supermarkets.add(new Supermarket("Jane Tyler", "jane.tyler@uts.com", "super123"));
        return supermarkets;
    }

    private List<Membership> initializeMembershipsData() {
        List<Membership> memberships = new ArrayList<>();
        memberships.add(new Membership(13697480, "Thomas Muller", "thomas.muller@uts.com", "99991111", "3 Byern St. Sydney 2001", 2134.5));
        memberships.add(new Membership(14517880, "Alice Stefan", "alice.stefan@uts.com", "88881111", "24 Pitt St. Sydney 2001", 4512.2));
        memberships.add(new Membership(13267102, "Lucy Lu", "lucy.lu@uts.com", "98981100", "11 Hunter St. Sydney 2100", 158.4));
        memberships.add(new Membership(13678020, "Andreas Brehme", "andread.b@uts.com", "900001222", "91 Sussex St. Sydney 2100", 7596.3));
        // todo two more datas left to add
        return memberships;
    }

}
