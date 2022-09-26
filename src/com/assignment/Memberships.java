package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class Memberships {

    private List<Membership> memberships;

    public Memberships() {
        memberships = new ArrayList<>();
        memberships.add(new Membership(13697480, "Thomas Muller", "thomas.muller@uts.com", "99991111", "3 Byern St. Sydney 2001", 2134.5));
        memberships.add(new Membership(13697480, "Alice Stefan", "alice.stefan@uts.com", "99991111", "3 Byern St. Sydney 2001", 2134.5));
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }
}
