package Data;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AttributesSpaces {
   final private List<Player> listOfPlayers;

    private List<Double> listOfAges;
    private List<Double> listOfHeights;
    private List<Double> listOfWeights;
    private List<Double> listOfOveralls;
    private List<Double> listOfValues;
    private List<Double> listOfPace;
    private List<Double> listOfShooting;
    private List<Double> listOfPassing;
    private List<Double> listOfDribbling;
    private List<Double> listOfDefending;
    private List<Double> listOfPhysic;

    // dla kazdej etykiety musze przechowywac obiekty reprezentujace funkcje przynaleznosci
    //kwantyfikator wzgledny - do calego zboiru
            //bezwzgledny - okolo 1000

    public AttributesSpaces() throws IOException {
        this.listOfPlayers = ReadData.readPlayersFromCsv();
        dataToLists();


    }

    public void dataToLists(){
        this.listOfAges = new ArrayList<>();
        this.listOfHeights = new ArrayList<>();
        this.listOfWeights = new ArrayList<>();
        this.listOfOveralls = new ArrayList<>();
        this.listOfValues = new ArrayList<>();
        this.listOfPace = new ArrayList<>();
        this.listOfShooting = new ArrayList<>();
        this.listOfPassing = new ArrayList<>();
        this.listOfDribbling = new ArrayList<>();
        this.listOfDefending = new ArrayList<>();
        this.listOfPhysic = new ArrayList<>();

        for(Player player : listOfPlayers)
        {
            this.listOfAges.add((double) player.getAge());
            this.listOfHeights.add((double) player.getWeight());
            this.listOfWeights.add((double) player.getWeight());
            this.listOfOveralls.add((double) player.getOverall());
            this.listOfValues.add((double) player.getValue_eur());
            this.listOfPace.add((double) player.getPace());
            this.listOfShooting.add((double) player.getShooting());
            this.listOfPassing.add((double) player.getPassing());
            this.listOfDribbling.add((double) player.getDribbling());
            this.listOfDefending.add((double) player.getDefending());
            this.listOfPhysic.add((double) player.getPhysic());
        }
    }

    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public List<Double> getListOfAges() {
        return listOfAges;
    }

    public List<Double> getListOfHeights() {
        return listOfHeights;
    }

    public List<Double> getListOfWeights() {
        return listOfWeights;
    }

    public List<Double> getListOfOveralls() {
        return listOfOveralls;
    }

    public List<Double> getListOfValues() {
        return listOfValues;
    }

    public List<Double> getListOfPace() {
        return listOfPace;
    }

    public List<Double> getListOfShooting() {
        return listOfShooting;
    }

    public List<Double> getListOfPassing() {
        return listOfPassing;
    }

    public List<Double> getListOfDribbling() {
        return listOfDribbling;
    }

    public List<Double> getListOfDefending() {
        return listOfDefending;
    }

    public List<Double> getListOfPhysic() {
        return listOfPhysic;
    }

    public double getRangeFor(String featureName){
        if (featureName.equals("age"))
        {
            Collections.sort(listOfAges);
            return (double)listOfAges.get(listOfAges.size()-1)-listOfAges.get(0);
        }
        if (featureName.equals("height"))
        {
            Collections.sort(listOfHeights);
            return (double)listOfHeights.get(listOfHeights.size()-1)-listOfHeights.get(0);
        }
        if (featureName.equals("weight"))
        {
            Collections.sort(listOfWeights);
            return (double)listOfWeights.get(listOfWeights.size()-1)-listOfWeights.get(0);
        }
        if (featureName.equals("value_eur"))
        {
            Collections.sort(listOfValues);
            return (double)listOfValues.get(listOfValues.size()-1)-listOfValues.get(0);
        }
        if (featureName.equals("pace"))
        {
            Collections.sort(listOfPace);
            return (double)listOfPace.get(listOfPace.size()-1)-listOfPace.get(0);
        }
        if (featureName.equals("shooting"))
        {
            Collections.sort(listOfShooting);
            return (double)listOfShooting.get(listOfShooting.size()-1)-listOfShooting.get(0);
        }
        if (featureName.equals("passing"))
        {
            Collections.sort(listOfPassing);
            return (double)listOfPassing.get(listOfPassing.size()-1)-listOfPassing.get(0);
        }
        if (featureName.equals("dribbling"))
        {
            Collections.sort(listOfDribbling);
            return (double)listOfDribbling.get(listOfDribbling.size()-1)-listOfDribbling.get(0);
        }
        if (featureName.equals("defending"))
        {
            Collections.sort(listOfDefending);
            return (double)listOfDefending.get(listOfDefending.size()-1)-listOfDefending.get(0);
        }
        if (featureName.equals("physic"))
        {
            Collections.sort(listOfPhysic);
            return (double)listOfPhysic.get(listOfPhysic.size()-1)-listOfPhysic.get(0);
        }
        if (featureName.equals("overall"))
        {
            Collections.sort(listOfOveralls);
            return (double)listOfOveralls.get(listOfOveralls.size()-1)-listOfOveralls.get(0);
        }


    return 2137;
    }
}