package fr.epita.assistants.loggingThreads;

import java.math.*;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class TimeWaster {

    private final Logger logger;
    public TimeWaster() {
        logger = (Logger) LoggerFactory.getLogger(TimeWaster.class);
        logger.setLevel(Level.TRACE);
    }

    /**
     * @param n Last natural number to sum
     * @return The sum of integers from 0 to n
     */
    public BigInteger sumUpTo(int n) {
        logger.trace("Calculating");

        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            sum = sum.add(BigInteger.valueOf(i));
        }
        logger.debug("Finished calculating sum up to " + n + ": " + sum);
        return sum;
    }

    public void doImportantThing() {
        logger.info("Waiting");
        try {
            Thread.sleep(2000);
            logger.info("Successfully waited");
        }
        catch (final Exception exception)
        {
            logger.error("Wait interrupted");
        }

        // FIXME: Wait for 2s, logging an error in case of interruption
    }
}
