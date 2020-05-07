package Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttributesSpaces {
    private List<Player> listOfPlayers;

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

}