package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class Memberships {

    private List<Membership> memberships;

    public Memberships() {
        memberships = new ArrayList<>();

    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }
}
