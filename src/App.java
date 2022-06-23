import java.util.List;
import java.util.stream.Collectors;

public class App {
    /*
        Przygotuj listę osób (imię + wiek).
        Dla każdego wieku wyznacz imiona osób w tym wieku.
    */

    record Person(String name, int age) {
    }

    public static void main(String[] args) {
        var people = List.of(
                new Person("ADAM", 23),
                new Person("EWA", 25),
                new Person("IZA", 23),
                new Person("OLA", 27),
                new Person("JAN", 27),
                new Person("KASIA", 25),
                new Person("PAWEL", 23)
        );

        var groupedNamesByAge = people
                .stream()
                .collect(Collectors.groupingBy(
                        Person::age,
                        Collectors.mapping(
                                Person::name,
                                Collectors.toList()
                        )
                ));

        groupedNamesByAge.forEach((age, peopleWithAge) ->
                System.out.printf("%d => %s%n", age, peopleWithAge));
    }
}
