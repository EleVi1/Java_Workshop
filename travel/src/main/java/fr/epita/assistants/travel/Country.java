package fr.epita.assistants.travel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import com.opencsv.*;

public class Country {

    String countryName;
    ZoneId countryZone;
    public Map<String, Integer> travelTimes;

    public Country(String countryName, String countryZone, String inputFilePath) {
        this.countryName = countryName;
        this.countryZone = ZoneId.of(countryZone);
        this.travelTimes = initTravelTimes(inputFilePath);
    }

    public Map<String, Integer> initTravelTimes(String inputFilePath) {
        Map<String, Integer> res = new HashMap<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(inputFilePath));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                if (values[0].matches(countryName))
                {
                    res.putIfAbsent(values[1], Integer.valueOf(values[2]));
                }
                else if (values[1].matches(countryName))
                {
                    res.putIfAbsent(values[0], Integer.valueOf(values[2]));
                }
            }
            return res;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
