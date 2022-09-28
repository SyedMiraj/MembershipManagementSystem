package com.assignment;

public class MMSlip {

    private Membership membership;
    private Utils utils;

    public MMSlip(Membership membership) {
        this.membership = membership;
        utils = new Utils();
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Utils getUtils() {
        return utils;
    }

    public void setUtils(Utils utils) {
        this.utils = utils;
    }

    public void printSlip() {
        System.out.println("Slip Details:");
        this.utils.slipHeader();
        System.out.format(this.utils.slipFormat, this.membership.getName(), this.membership.getExpense(), this.membership.getTotalCredit(), this.membership.getDollarAvailable(), this.membership.getType());
        this.utils.slipFooter();
    }
}
