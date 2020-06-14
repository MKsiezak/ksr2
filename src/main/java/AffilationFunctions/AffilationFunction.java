package AffilationFunctions;

public interface AffilationFunction {


    double countMembership(double x);

    String getLabel();

    void setLabel(String label);

    //bierze a
    double getFirst();

    //bierze c lub d
    double getLast();

    double getA();

    double getB();

    double getC();

    double getD();

}
