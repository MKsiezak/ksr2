package FuzzyMembership;

import Data.Player;

//zrezygnowac na rzecz hashmapy?
public class Membership {
    protected Player player;
    protected double membershipValue;

    public Membership(Player player, double membershipValue) {
        this.player = player;
        if (membershipValue <0)
            this.membershipValue=0;
        if (membershipValue > 1)
            this.membershipValue=1;
        this.membershipValue = membershipValue;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public double getMembershipValue() {
        return membershipValue;
    }

    public void setMembershipValue(double membershipValue) {
        if (membershipValue <0)
            this.membershipValue=0;
        if (membershipValue > 1)
            this.membershipValue=1;
        this.membershipValue = membershipValue;
    }
}
