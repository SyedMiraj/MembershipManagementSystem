package com.assignment;

public class Membership {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String type;
    private double payPerCredit;
    private double totalCredit;
    private double deductionRate;
    private double gasDeductionRate;
    private double expense;
    private double dollarAvailable;

    public Membership(String id, String name, String email, String phone, String address, double expense) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.expense = expense;
        updateMembership(expense);
    }

    public void updateExpense(double expense){
        this.expense += expense;
        updateMembership(this.expense);
    }

    private void updateMembership(double expense){
        if(expense < 500){
            this.type = "Bronze";
            this.payPerCredit = 20;
            this.deductionRate = 0.05;
            this.gasDeductionRate = 0.1;
        } else if(expense >= 500 && expense < 1500){
            this.type = "Silver";
            this.payPerCredit = 10;
            this.deductionRate = 0.1;
            this.gasDeductionRate = 0.15;
        } else if(expense >= 1500 && expense < 3000){
            this.type = "Gold";
            this.payPerCredit = 8;
            this.deductionRate = 0.15;
            this.gasDeductionRate = 0.2;
        } else if(expense >= 3000 && expense < 5000){
            this.type = "Diamond";
            this.payPerCredit = 6;
            this.deductionRate = 0.2;
            this.gasDeductionRate = 0.25;
        } else {
            this.type = "Platinum";
            this.payPerCredit = 4;
            this.deductionRate = 0.25;
            this.gasDeductionRate = 0.3;
        }
        this.totalCredit = this.payPerCredit * expense;
        this.dollarAvailable = this.totalCredit / 200;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPayPerCredit() {
        return payPerCredit;
    }

    public void setPayPerCredit(double payPerCredit) {
        this.payPerCredit = payPerCredit;
    }

    public double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(double totalCredit) {
        this.totalCredit = totalCredit;
    }

    public double getDeductionRate() {
        return deductionRate;
    }

    public void setDeductionRate(double deductionRate) {
        this.deductionRate = deductionRate;
    }

    public double getGasDeductionRate() {
        return gasDeductionRate;
    }

    public void setGasDeductionRate(double gasDeductionRate) {
        this.gasDeductionRate = gasDeductionRate;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double getDollarAvailable() {
        return dollarAvailable;
    }

    public void setDollarAvailable(double dollarAvailable) {
        this.dollarAvailable = dollarAvailable;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", payPerCredit=" + payPerCredit +
                ", deductionRate=" + deductionRate +
                ", gasDeductionRate=" + gasDeductionRate +
                ", expense=" + expense +
                '}';
    }
}
