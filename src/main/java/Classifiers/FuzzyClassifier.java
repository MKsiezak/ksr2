package Classifiers;

import AffilationFunctions.AffilationFunction;
import Data.AttributesSpaces;
import Data.Player;
import FuzzyMembership.Membership;
import FuzzyMembership.MembershipAndLabel;
import Sets.FuzzySet;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

//dodajemy np ceche jako wiek
// dodajemy funkcje przynaleznosci z etykietami
// zbior jaki chcemy utworzyc, zgodnie z etykieta, powinna go wypluc metoda typu createSet
//klasyfikatory tworzymy i serializujemy, trzeba do nich dodac pole wzgledne i bezwzgledne
// jak wzgledne trzeba tez przekazac info o licznosci zbioru

public class FuzzyClassifier {
    protected List<AffilationFunction> affilation;
    protected AttributesSpaces allPlayers;
    protected String featureName;

    //dodajemy np ceche (feature) jako wiek
    // dodajemy funkcje przynaleznosci z etykietami
    // zbior jaki chcemy utworzyc, zgodnie z etykieta, powinna go wypluc metoda typu createSet
    //klasyfikatory tworzymy i serializujemy, trzeba do nich dodac pole wzgledne i bezwzgledne
    // jak bezwzgledne trzeba tez przekazac info o licznosci zbioru

    //gdy user wybierze np wiek jako kryterium wtedy wybierze klasyfikator z wikeiem pozniej wybiera ceche ktora jest w affilation

    protected List<Membership> playersWithMembershipValue;

    public FuzzyClassifier(AttributesSpaces allPlayers, String featureName) {
        this.allPlayers = allPlayers;
        this.featureName = featureName;
        this.affilation=new ArrayList<AffilationFunction>();
    }

    public boolean addAffilationFunction(AffilationFunction function){
        try {
            affilation.add(function);
            return true;
        }
        catch ( Exception e){
            System.out.println(e);
            return false;
        }
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    //tworzy zbior rozmyty dla danej etykiety ktora musi byc w affilation
    public FuzzySet createSet (String label){
        try {
            double featureValue;
            MembershipAndLabel labelNameAndValue;
            List<Membership> playerList = new ArrayList<Membership>();


            PropertyDescriptor pd = new PropertyDescriptor(featureName, Player.class);
            Method getter = pd.getReadMethod();
            for (int i = 0; i < allPlayers.getListOfPlayers().size(); i++) {
                Object o = getter.invoke(allPlayers.getListOfPlayers().get(i));
                featureValue = Double.parseDouble(o.toString());
                labelNameAndValue = membershipLabelName(featureValue);
                if (labelNameAndValue != null)
                    if (labelNameAndValue.getLabel().equals(label)) {
                        playerList.add(new Membership(allPlayers.getListOfPlayers().get(i), labelNameAndValue.getMembership()));

                    }
            }



            return new FuzzySet(playerList,label, allPlayers.getListOfPlayers().size());
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    //zwraca nazwe labela do jakiej przynalezy dany pilkarz i jego wartosc f przynaleznosci
    public MembershipAndLabel membershipLabelName(double featureValue){
        HashMap<String, Double> affilations = new HashMap<String, Double>();

        for (int k=0; k < affilation.size(); k++)
        {
            affilations.put(affilation.get(k).getLabel(),affilation.get(k).countMembership(featureValue));
        }
        double maxValue = (double) Collections.max(affilations.values());
        String biggestMembership =null;
        for (Object o : affilations.keySet()) {
            if (affilations.get(o) == maxValue) {
                biggestMembership =  o.toString();
            }
        }

        // przechowujemy tu nazwe etykiety z najwieksza funkcja przynaleznosci oraz wartoc funkcji
        MembershipAndLabel membAndLabel = new MembershipAndLabel(biggestMembership,maxValue);
        return membAndLabel;

    }
}