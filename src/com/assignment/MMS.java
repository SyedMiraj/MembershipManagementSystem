package com.assignment;

public class MMS {

    private Supermarket supermarket;
    private Memberships memberships;

    public MMS(Supermarket supermarket, Memberships memberships) {
        this.supermarket = supermarket;
        this.memberships = memberships;
    }

    public Supermarket getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

    public Memberships getMemberships() {
        return memberships;
    }

    public void setMemberships(Memberships memberships) {
        this.memberships = memberships;
    }
}
