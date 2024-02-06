package fr.epita.assistants.streamstudent;

import java.util.Optional;
import java.util.stream.Stream;

public class Streamer {
    private Stream<Pair<Integer, String>> grade_login;

    public Stream<Pair<Integer, String>> validator(Stream<Pair<Integer, String>> stream) {
        return (stream.filter(grade_login -> grade_login.getKey() >= 0 && grade_login.getKey() <= 100
                && grade_login.getValue().matches("^*(_|.)*$")));
    }

    public Stream<Pair<Integer, String>> orderGrade(Stream<Pair<Integer, String>> stream) {
        return (stream.sorted((i, j) -> {
            if (j.getKey().equals(i.getKey())) {
                return j.getValue().compareTo(i.getValue());
            }
            return i.getKey().compareTo(j.getKey());
        }));
    }

    public Stream<Pair<Integer, String>> lowercase(Stream<Pair<Integer, String>> stream) {
        return (stream.map(i -> {
        if (i.getValue().matches("^*[A-Z]*$"))
        {
            return new Pair<>(i.getKey() /2 , i.getValue());
        }
        return i;}));
    }

    public Optional<Pair<Integer, String>> headOfTheClass(Stream<Pair<Integer, String>> stream) {
        return (stream.max((i, j) ->
                {
                    if (i.getKey().equals(j.getKey()))
                    {
                        return i.getValue().compareTo(j.getValue());
                    }
                    return i.getKey().compareTo(j.getKey());
                }
        ));
    }

    public Stream<Pair<Integer, String>> quickFix(Stream<Pair<Integer, String>> stream) {
        return (stream.map(i ->
        {
            if (i.getValue().matches("^(ma|mA|Ma|MA)*$") || i.getValue().matches("^(l|L)*(x|X)$"))
            {
                return new Pair<>((i.getKey()*2) % 101, i.getValue());
            }
            return i;
        })
        );
    }

    public Stream<Pair<Integer, String>> encryption(Stream<Pair<Integer, String>> stream) {
        return (stream.map(i -> {
            String first = i.getValue().substring(0, i.getValue().length()/2);
            String second = i.getValue().substring(i.getValue().length()/2);

            return new Pair<>(i.getKey(), second.concat(first));
                }
        ));
    }
}
