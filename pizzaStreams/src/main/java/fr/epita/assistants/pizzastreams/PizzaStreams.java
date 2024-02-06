package fr.epita.assistants.pizzastreams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.epita.assistants.pizzastreams.Topping.*;

import static java.lang.Double.NaN;

public class PizzaStreams {
    /**
     * @return The sum of the prices of all the pizzas in the stream
     */
    public static Integer getTotalPrice(Stream<Pizza> pizzaStream) {
        return (pizzaStream.mapToInt(pizz -> (pizz.getPrice()))).sum();
    }

    /**
     * @return The average price of the pizzas in the stream, or the
     * double NaN if the stream is empty
     */
    public static Double getAveragePrice(Stream<Pizza> pizzaStream) {
        OptionalDouble res = (pizzaStream.mapToDouble(pizz -> (pizz.getPrice()))).average();
        try {
            return res.getAsDouble();
        } catch (Exception exception) {
            ;
            return NaN;
        }
    }

    /**
     * @return Names of the pizzas, sorted by price in ascending order
     */
    public static List<String> sortByPrice(Stream<Pizza> pizzaStream) {
        return (pizzaStream.sorted(Comparator.comparingInt(Pizza::getPrice))).map(Pizza::getName).collect(Collectors.toList());
    }

    /**
     * @return The Pizza object that has the lowest price, or null by default
     */
    public static Pizza getCheapest(Stream<Pizza> pizzaStream) {
        return (pizzaStream.min((pizz, pizz2) -> pizz.getPrice().compareTo(pizz2.getPrice()))).orElse(null);
    }

    /**
     * @return Names of the pizzas with meat (Protein)
     */
    public static List<String> getCarnivorous(Stream<Pizza> pizzaStream) {
        return pizzaStream.filter(pizz -> pizz.getTopping().getProtein().isPresent()).map(Pizza::getName).collect(Collectors.toList());
    }

    /**
     * @return Names of the pizzas with at least one Vegetable and no Proteins
     */
    public static List<String> getVeggies(Stream<Pizza> pizzaStream) {
        return pizzaStream.filter(pizz -> !pizz.getTopping().getVegetableList().isEmpty()
        && !pizz.getTopping().getProtein().isPresent()).map(Pizza::getName).collect(Collectors.toList());
    }

    /**
     * @return true if all the pizzas with a nature dough are based with tomato
     * and mozzarella (italian pizza criteria), false otherwise
     */
    public static boolean areAllNatureItalians(Stream<Pizza> pizzaStream) {
        return (pizzaStream.filter(pizza -> pizza.getDough().equals(Dough.NATURE)).allMatch(pizz ->
                pizz.getTopping().getSauce().equals(Sauce.TOMATO) &&
                pizz.getTopping().getCheese().equals(Cheese.MOZZARELLA)));
    }
}
