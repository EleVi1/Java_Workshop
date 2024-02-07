package fr.epita.assistants.travel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Travel {

    public static void travelTo(Country source, Country destination) {
        System.out.println("Boarding in " + source.countryName + ", local date and time is: " + ZonedDateTime.now(source.countryZone).format(DateTimeFormatter.RFC_1123_DATE_TIME));
        System.out.println("Loading in " + destination.countryName + ", local date and time on arrival will be: " + ZonedDateTime.now(destination.countryZone).format(DateTimeFormatter.RFC_1123_DATE_TIME));
    }
}
