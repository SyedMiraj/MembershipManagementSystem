package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class Memberships {

    private List<Membership> membershipList = new ArrayList<>();

    public Memberships() {
        membershipList.add(new Membership(13697480, "Thomas Muller", "thomas.muller@uts.com", "99991111", "3 Byern St. Sydney 2001", 2134.5));
        membershipList.add(new Membership(14517880, "Alice Stefan", "alice.stefan@uts.com", "88881111", "24 Pitt St. Sydney 2001", 4512.2));
        membershipList.add(new Membership(13267102, "Lucy Lu", "lucy.lu@uts.com", "98981100", "11 Hunter St. Sydney 2100", 158.4));
        membershipList.add(new Membership(13678020, "Andreas Brehme", "andread.b@uts.com", "900001222", "91 Sussex St. Sydney 2100", 7596.3));
    }

    public List<Membership> getMembershipList() {
        return membershipList;
    }

    public void setMembershipList(List<Membership> membershipList) {
        this.membershipList = membershipList;
    }
}
