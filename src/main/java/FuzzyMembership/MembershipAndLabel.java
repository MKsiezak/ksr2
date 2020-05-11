package FuzzyMembership;

//potrzebne do fuzzyclassifier
public class MembershipAndLabel {
    String label;
    double membership;

    public MembershipAndLabel(String label, double membership) {
        this.label = label;
        this.membership = membership;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getMembership() {
        return membership;
    }

    public void setMembership(double membership) {
        this.membership = membership;
    }
}
