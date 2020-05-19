package AffilationFunctions;

public class TrapezoidalFuzzyFunction implements AffilationFunction {


    // zmienic na trapez
    double a,b,c,d;
    String label;

    public TrapezoidalFuzzyFunction(double a, double b, double c,double d, String label) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.label = label;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public String getLabel() {
        return label;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public double countMembership(double x) {
        if (x<=a)
            return 0;
        if (x>a && x<b){
            return (x-a)/(b-a);
        }
        if (x >= b && x<=c)
            return 1;
        if (x>c && x<d ){
            return (d-x)/(d-c);
        }
        if (x>=d)
            return 0;
        return 0;
    }
}
