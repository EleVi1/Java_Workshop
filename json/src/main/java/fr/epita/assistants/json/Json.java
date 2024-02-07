package fr.epita.assistants.json;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

    public static void addToJson(String name, String value, String file)
    {
        File f = new File(file);
        try {
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path path = Path.of(file);
        StringBuilder content = new StringBuilder();

        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {

            stream.forEach(s -> content.append(s).append(System.lineSeparator()));
        } catch (IOException e) {
            throw new RuntimeException();
        }

        String youhou = content.toString();
        final ObjectMapper obj = new ObjectMapper();
        Map<String, Object> map = null;
        try {
            map = obj.readValue(youhou, new TypeReference<>(){});
        } catch (IOException e) {
            map = new HashMap<>();
        }
        if (map == null)
        {
            map = new HashMap<>();
        }
        map.put(name, value);
        try {
            obj.writeValue(f, map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}