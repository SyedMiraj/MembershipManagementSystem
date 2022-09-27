package com.assignment;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Session {

    private Supermarkets supermarkets;
    private Supermarket loggedInUser;
    private Utils utils;

    public Session() {
        supermarkets = new Supermarkets();
        supermarkets.setSupermarkets(initializeSupermarketsData());
        utils = new Utils();
    }

    private Supermarket loginScreen(Scanner scanner) {
        System.out.println("Please log in to enter into the system.");
        System.out.print("Enter email: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Supermarket supermarket = this.supermarkets
                .getSupermarkets()
                .stream()
                .filter(x -> x.getEmail().equals(username))
                .findFirst()
                .orElse(null);
        if (supermarket == null) {
            System.out.println("Bad username or password");
            return null;
        }
        if (!supermarket.getPassword().equals(password)) {
            System.out.println("Bad username or password");
            return null;
        }
        this.loggedInUser = supermarket;
        return supermarket;
    }

    private Map<String, String> menuList(){
        Map<String, String> menus = new HashMap<>();
        menus.put("1", "View Membership");
        menus.put("2", "Add Membership");
        menus.put("3", "Retrieve Membership");
        menus.put("4", "Update Membership");
        menus.put("5", "Delete Membership");
        menus.put("6", "Slip Report");
        menus.put("7", "MMS Report");
        menus.put("8", "Archive Report");
        menus.put("9", "Retrieve Report");
        menus.put("10", "Logout");
        return menus;
    }

    public void printMenus(){
        Map<String, String> menus = this.menuList();
        System.out.println("Select the menu id");
        for (Map.Entry<String, String> entry: menus.entrySet()){
            System.out.println(entry.getKey() + "  -->  " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Session session = new Session();
        Scanner scanner = new Scanner(System.in);
        Utils utils = session.getUtils();
        utils.welcomeScreen();
        while(session.getLoggedInUser() == null){
            Supermarket supermarket = session.loginScreen(scanner);
            if(supermarket != null){
                session.menuRedirection(scanner);
            } else {
                session.setLoggedInUser(null);
            }
        }

    }

    private void menuRedirection(Scanner scanner) {
        this.printMenus();
        System.out.print("Choose: ");
        String menuId = scanner.nextLine();
        switch (menuId){
            case "1": this.displayViewMembership(scanner);
                break;
            case "2": this.displayAddMembership(scanner);
                break;
            case "3": this.displayRetrieveMembership(scanner);
                break;
            case "4": this.displayUpdateMembership(scanner);
                break;
            case "5": this.displayDeleteMembership(scanner);
                break;
            case "6": this.displaySlipReport(scanner);
                break;
//                case "7": session.displayViewMembership();
//                    break;
//                case "8": session.displayViewMembership();
//                    break;
//                case "9": session.displayViewMembership();
//                    break;
                case "10": this.displayLogout(scanner);
                    break;
            default:
                System.out.println("Invalid menu selected");
                this.menuRedirection(scanner);
                break;
        }
    }

    private void displaySlipReport(Scanner scanner) {
    }

    private void displayDeleteMembership(Scanner scanner) {
        System.out.println("Which user want to remove ?");
        System.out.print("Type email: ");
        String email = scanner.nextLine();
        Optional<Membership> membership = this.loggedInUser.getMemberships().findMember(email);
        if(membership.isPresent()){
            this.loggedInUser.getMemberships().removeMembership(membership.get());
            System.out.println("Membership deleted");
        } else {
            System.out.println("No Membership found.");
        }
        this.menuRedirection(scanner);
    }

    private void displayLogout(Scanner scanner) {
        System.out.println("Are you want to logout? y/N");
        String response = scanner.nextLine();
        if(response.toUpperCase().startsWith("Y")){
            this.loggedInUser = null;
            System.out.println("You are logged out.");
        } else
        this.menuRedirection(scanner);
    }

    private void displayUpdateMembership(Scanner scanner) {
        System.out.println("Which user's expense want to update ?");
        System.out.print("Type email: ");
        String email = scanner.nextLine();
        Optional<Membership> membership = this.loggedInUser.getMemberships().findMember(email);
        if(membership.isPresent()){
            System.out.print("Enter expense amount: ");
            if(scanner.hasNextDouble()){
                double expense = scanner.nextDouble();
                this.loggedInUser.getMemberships().updateMember(email, expense);
                System.out.println("Membership updated");
            }
        }
        this.menuRedirection(scanner);
    }

    private void displayRetrieveMembership(Scanner scanner) {
        System.out.print("Please type a name or email or phone number: ");
        String nameOrEmailOrPhone = scanner.nextLine();
        List<Membership> filteredResult = this.loggedInUser.getMemberships().searchMembership(nameOrEmailOrPhone);
        this.utils.membershipHeader();
        for(Membership membership: filteredResult){
            System.out.format(this.utils.membershipFormat, membership.getName(), membership.getName(), membership.getPhone(), membership.getType());
        }
        backToMainMenu(scanner);
    }

    private void displayAddMembership(Scanner scanner) {
        System.out.println("Membership name: ");
        String memberName = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Phone: ");
        String phone = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();
        System.out.println("Expense: ");
        double expense = 0;
        if(scanner.hasNextDouble()){
            expense = scanner.nextDouble();
        }
        Membership newMembership = new Membership(ThreadLocalRandom.current().nextInt(14517880, 99999999 + 1), memberName, email, phone, address, expense);
        this.loggedInUser.getMemberships().addMembership(newMembership);
        System.out.println("New Membership added");
        backToMainMenu(scanner);
    }

    public void displayViewMembership(Scanner scanner) {
        this.utils.membershipHeader();
        for(Membership membership: this.loggedInUser.getMemberships().getMembershipList()){
            System.out.format(this.utils.membershipFormat, membership.getName(), membership.getEmail(), membership.getPhone(), membership.getType());
        }
        backToMainMenu(scanner);
    }

    public void backToMainMenu(Scanner scanner){
        System.out.println("Press any key to back...");
        scanner.nextLine();
        this.menuRedirection(scanner);
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

    public Supermarket getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Supermarket loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Utils getUtils() {
        return utils;
    }

    public void setUtils(Utils utils) {
        this.utils = utils;
    }
}
