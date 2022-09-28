package com.assignment;

import java.util.*;

public class Session {

    private Supermarkets supermarkets;
    private Supermarket supermarket;
    private Utils utils;

    public Session() {
        supermarkets = new Supermarkets();
        supermarkets.setSupermarkets(initializeSupermarketsData());
        utils = new Utils();
    }

    private Supermarket loginScreen(Scanner scanner) {
        Supermarket loggedInUser = null;
        while (loggedInUser == null){
            System.out.print("Email: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            loggedInUser = this.supermarkets
                    .getSupermarkets()
                    .stream()
                    .filter(x -> x.getEmail().equals(username))
                    .findFirst()
                    .orElse(null);
            if (loggedInUser == null) {
                System.out.println("Bad username or password");
            }
            if (loggedInUser != null && !loggedInUser.getPassword().equals(password)) {
                System.out.println("Bad username or password");
                return null;
            }
        }
        return loggedInUser;
    }

    private Map<String, String> adminMenu() {
        Map<String, String> adminMenus = new LinkedHashMap<>();
        adminMenus.put("C", "Add Membership");
        adminMenus.put("R", "View Membership");
        adminMenus.put("U", "Update Membership");
        adminMenus.put("D", "Delete Membership");
        adminMenus.put("V", "View Memberships");
        adminMenus.put("M", "MMS Menu");
        adminMenus.put("X", "Logout");
        return adminMenus;
    }

    private Map<String, String> mmsMenu() {
        Map<String, String> mmsMenus = new LinkedHashMap<>();
        mmsMenus.put("F", "Find Slip Details");
        mmsMenus.put("V", "View MMS Report");
        mmsMenus.put("A", "Archive MMS Report");
        mmsMenus.put("R", "Retrieve MMS Report");
        mmsMenus.put("S", "Show MMS Log");
        mmsMenus.put("X", "Close");
        return mmsMenus;
    }

    private Map<String, String> startMenu() {
        Map<String, String> startMenus = new LinkedHashMap<>();
        startMenus.put("L", "Login");
        startMenus.put("X", "Exit");
        return startMenus;
    }

    public void printAdminMenus() {
        System.out.println("Admin Menu:");
        for (Map.Entry<String, String> entry : this.adminMenu().entrySet()) {
            System.out.println(entry.getKey() + "- " + entry.getValue());
        }
    }

    public void printMMSMenus() {
        System.out.println("MMS Menu:");
        for (Map.Entry<String, String> entry : this.mmsMenu().entrySet()) {
            System.out.println(entry.getKey() + "- " + entry.getValue());
        }
    }

    public void printStartMenus() {
        for (Map.Entry<String, String> entry : this.startMenu().entrySet()) {
            System.out.println(entry.getKey() + "- " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Session session = new Session();
        Scanner scanner = new Scanner(System.in);
        Utils utils = session.getUtils();
        utils.welcomeScreen();
        Supermarket loggedInUser = session.startMenuRoutes(scanner);
        if(loggedInUser != null){
            session.printAdminMenus();
            session.adminMenuRoutes(scanner, loggedInUser);
        }
    }

    private Supermarket startMenuRoutes(Scanner scanner) {
        this.printStartMenus();
        System.out.print("Command (L/X): ");
        String menuId = scanner.nextLine();
        Supermarket supermarket = null;
        switch (menuId) {
            case "L":
                supermarket =  this.loginScreen(scanner);
                break;
            case "X":
                this.terminate();
                break;
            default:
                System.out.println("Invalid menu selected");
                this.startMenuRoutes(scanner);
                break;
        }
        return supermarket;
    }

    private void terminate() {
        System.out.println("Session Terminated!");
    }

    private void adminMenuRoutes(Scanner scanner, Supermarket loggedInUser) {
        System.out.print("Session Admin: " + loggedInUser.getName() + " - Commands (C/R/U/D/V/M/X): ");
        String menuId = scanner.nextLine();
        switch (menuId) {
            case "C":
                this.displayAddMembership(scanner, loggedInUser);
                break;
            case "R":
                this.displayMembership(scanner, loggedInUser);
                break;
            case "U":
                this.displayUpdateMembership(scanner, loggedInUser);
                break;
            case "D":
                this.displayDeleteMembership(scanner, loggedInUser);
                break;
            case "V":
                this.displayMemberships(scanner, loggedInUser);
                break;
            case "M":
                this.displaySlipReport(scanner, loggedInUser);
                break;
            case "X":
                this.displayLogout(scanner);
                break;
            default:
                System.out.println("Invalid menu selected");
                this.adminMenuRoutes(scanner, loggedInUser);
                break;
        }
    }

    private void displaySlipReport(Scanner scanner, Supermarket loggedinuser) {
        this.printMMSMenus();
        this.mmsMenuRoutes(scanner, loggedinuser);
    }

    private void mmsMenuRoutes(Scanner scanner, Supermarket loggedInUser) {
        System.out.print("Session Admin: " + loggedInUser.getName() + " - Commands (F/V/A/R/S/X): ");
        String menuId = scanner.nextLine();
        switch (menuId) {
            case "F":
                this.displaySlipDetails(scanner, loggedInUser);
                break;
            case "V":
                this.displayMMSReport(scanner, loggedInUser);
                break;
            case "A":
                this.displayArchiveMMSReport(scanner, loggedInUser);
                break;
            case "R":
                this.displayRetrieveMMSReport(scanner, loggedInUser);
                break;
            case "S":
                this.displayShowMMSLog(scanner, loggedInUser);
                break;
            case "X":
                this.displayClose(scanner, loggedInUser);
                break;
            default:
                System.out.println("Invalid menu selected");
                this.mmsMenuRoutes(scanner, loggedInUser);
                break;
        }
    }

    private void displayClose(Scanner scanner, Supermarket loggedInUser) {
        this.adminMenuRoutes(scanner, loggedInUser);
    }

    private void displayShowMMSLog(Scanner scanner, Supermarket loggedInUser) {
    }

    private void displayRetrieveMMSReport(Scanner scanner, Supermarket loggedInUser) {
    }

    private void displayArchiveMMSReport(Scanner scanner, Supermarket loggedInUser) {
    }

    private void displayMMSReport(Scanner scanner, Supermarket loggedInUser) {
        MMS mms = new MMS(loggedInUser, loggedInUser.getMemberships());
        mms.printMMSReport();
        this.mmsMenuRoutes(scanner, loggedInUser);
    }

    private void displaySlipDetails(Scanner scanner, Supermarket loggedInUser) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        Optional<Membership> membership = loggedInUser.getMemberships().findMember(name);
        if (membership.isPresent()) {
            MMSlip mmSlip = new MMSlip(membership.get());
            mmSlip.printSlip();
        } else {
            System.out.println(name + " record does not exist!");
        }
        this.mmsMenuRoutes(scanner, loggedInUser);
    }

    private void displayDeleteMembership(Scanner scanner, Supermarket loggedInUser) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        Optional<Membership> membership = loggedInUser.getMemberships().findMember(name);
        if (membership.isPresent()) {
            loggedInUser.getMemberships().removeMembership(membership.get());
            System.out.println(name + " record has been deleted.");
        } else {
            System.out.println(name + " record does not exist!");
        }
        this.adminMenuRoutes(scanner, loggedInUser);
    }

    private void displayLogout(Scanner scanner) {
        this.terminate();
    }

    private void displayUpdateMembership(Scanner scanner, Supermarket loggedInUser) {
        System.out.println("Which user's expense want to update ?");
        System.out.print("Type email: ");
        String email = scanner.nextLine();
        Optional<Membership> membership = this.supermarket.getMemberships().findMember(email);
        if (membership.isPresent()) {
            System.out.print("Enter expense amount: ");
            if (scanner.hasNextDouble()) {
                double expense = scanner.nextDouble();
                this.supermarket.getMemberships().updateMember(email, expense);
                System.out.println("Membership updated");
            }
        }
        this.adminMenuRoutes(scanner, loggedInUser);
    }

    private void displayMembership(Scanner scanner, Supermarket loggedInUser) {
        System.out.print("Name or email or phone number: ");
        String nameOrEmailOrPhone = scanner.nextLine();
        List<Membership> filteredResult = loggedInUser.getMemberships().searchMembership(nameOrEmailOrPhone);
        this.utils.membershipHeader();
        for (Membership membership : filteredResult) {
            System.out.format(this.utils.membershipFormat, membership.getName(), membership.getName(), membership.getPhone(), membership.getType());
        }
        this.utils.membershipFooter();
        backToAdminMenu(scanner, loggedInUser);
    }

    private void displayAddMembership(Scanner scanner, Supermarket loggedInUser) {
        System.out.print("Name: ");
        String memberName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Expense: ");
        double expense = 0;
        if (scanner.hasNextDouble()) {
            expense = scanner.nextDouble();
        }
        Membership newMembership = new Membership(id, memberName, email, phone, address, expense);
        loggedInUser.getMemberships().addMembership(newMembership);
        System.out.println(memberName + " record has been created.");
        backToAdminMenu(scanner, loggedInUser);
    }

    public void displayMemberships(Scanner scanner, Supermarket loggedInUser) {
        this.utils.membershipHeader();
        for (Membership membership : loggedInUser.getMemberships().getMembershipList()) {
            System.out.format(this.utils.membershipFormat, membership.getName(), membership.getEmail(), membership.getPhone(), membership.getType());
        }
        this.utils.membershipFooter();
        backToAdminMenu(scanner, loggedInUser);
    }

    public void backToAdminMenu(Scanner scanner, Supermarket loggedInUser) {
        this.adminMenuRoutes(scanner, loggedInUser);
    }

    private List<Supermarket> initializeSupermarketsData() {
        List<Supermarket> supermarkets = new ArrayList<>();
        supermarkets.add(new Supermarket("John Smith", "john.smith@uts.com", "user222"));
        supermarkets.add(new Supermarket("Jane Tyler", "jane.tyler@uts.com", "super123"));
        return supermarkets;
    }

    public Supermarkets getSupermarkets() {
        return supermarkets;
    }

    public void setSupermarkets(Supermarkets supermarkets) {
        this.supermarkets = supermarkets;
    }

    public Supermarket getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

    public Utils getUtils() {
        return utils;
    }

    public void setUtils(Utils utils) {
        this.utils = utils;
    }
}
