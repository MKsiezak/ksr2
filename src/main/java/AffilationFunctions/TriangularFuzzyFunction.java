package AffilationFunctions;

public class TriangularFuzzyFunction implements AffilationFunction {

    double a,b,c;
    String label;

    public TriangularFuzzyFunction(double a, double b, double c, String label) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    @Override
    public double getD() {
        return -1;
    }

    public void setC(double c) {
        this.c = c;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label=label;
    }

    @Override
    public double getFirst() {
        return a;
    }

    @Override
    public double getLast() {
        return c;
    }


    @Override
    public double countMembership(double x) {
        if (x<=a)
            return 0;
        if (x>a && x<b){
            return (x-a)/(b-a);
        }
        if (x == b)
            return 1;
        if (x>b && x<c ){
            return (c-x)/(c-b);
        }
        if (x>=c)
            return 0;
        return 0;

    }
}
