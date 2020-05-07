package Data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    private static final String CSV_FILE_PATH = "src/main/java/Data/players_20.csv";

    public static List<Player> readPlayersFromCsv() throws IOException {
        try {
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());
                List players = new ArrayList<Player>();
                 for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                     try {
                         if (csvRecord.get("team_position").equals("GK")== false ) {
                             int playerId = Integer.parseInt(csvRecord.get("sofifa_id"));
                             String playerName = csvRecord.get("short_name");
                             int age = Integer.parseInt(csvRecord.get("age"));
                             int height = Integer.parseInt(csvRecord.get("height_cm"));
                             int weight = Integer.parseInt(csvRecord.get("weight_kg"));
                             int overall = Integer.parseInt(csvRecord.get("overall"));
                             int value_eur = Integer.parseInt(csvRecord.get("value_eur"));
                             int pace = Integer.parseInt(csvRecord.get("pace"));
                             int shooting = Integer.parseInt(csvRecord.get("shooting"));
                             int passing = Integer.parseInt(csvRecord.get("passing"));
                             int dribbling = Integer.parseInt(csvRecord.get("dribbling"));
                             int defending = Integer.parseInt(csvRecord.get("defending"));
                             int physic = Integer.parseInt(csvRecord.get("physic"));

                             players.add(new Player(playerId, playerName, age, height, weight, overall, value_eur, pace, shooting, passing, dribbling, defending, physic));
                         }
                         }
                     catch (NumberFormatException numE)
                     {
                         System.out.println(numE);
                     }
            }

    return players;
    }
        catch (Exception e)
        {
        System.out.println(e);
        return null;
        }
    }
}
