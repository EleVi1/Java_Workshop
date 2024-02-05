package fr.epita.assistants.loggingbasics;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.apache.maven.plugin.logging.Log;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Trombinoscope {
    private final Logger logger;
    private final HashMap<String, Long> map;

    public Trombinoscope() {
        logger = (Logger) LoggerFactory.getLogger(Trombinoscope.class);
        logger.setLevel(Level.TRACE);

        logger.trace("Instantiating new Trombinoscope");
        map = new HashMap<>();
    }

    public Long putPerson(String name, long photoId) {
        logger.debug("Putting person (\"%s\", %d)".formatted(name, photoId));
        if (map.containsKey(name)) {
            logger.trace("Updated entry for person \"%s\"".formatted(name));
        }
        else
        {
            logger.trace("Added entry for person \"%s\"".formatted(name));
        }
        Long oldPhotoId = map.put(name, photoId);

        return oldPhotoId;
    }
}
