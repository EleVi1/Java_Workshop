package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public class StaticSingletonLogger implements Logger {

    int info_counter = 0;
    int error_counter = 0;
    int warn_counter = 0;
    private StaticSingletonLogger() {
    }
    private static class InstanceHolder {
        private static StaticSingletonLogger _INSTANCE;
    }

    static StaticSingletonLogger getInstance()
    {
        return InstanceHolder._INSTANCE;
    }

    @Override
    public void log(Level level, String message) {
        if (level == Level.INFO)
        {
            info_counter++;
            System.err.println("[INFO] " + message);
        }
        if (level == Level.WARN)
        {
            warn_counter++;
            System.err.println("[WARN] " + message);
        }
        if (level == Level.ERROR)
        {
            error_counter++;
            System.err.println("[ERROR] " + message);
        }
    }

    @Override
    public int getInfoCounter() {
        return info_counter;
    }

    @Override
    public int getWarnCounter() {
        return warn_counter;
    }

    @Override
    public int getErrorCounter() {
        return error_counter;
    }

    @Override
    public void reset() {
        info_counter = 0;
        warn_counter = 0;
        error_counter = 0;
    }
}
