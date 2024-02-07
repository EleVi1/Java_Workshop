package fr.epita.assistants.fgen;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FGen {

    public FGen(final String inputPath) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(inputPath);
        StringBuilder path_process = new StringBuilder(".");
        try (InputStreamReader streamReader =
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                int len = line.length();
                if (len > 0) {
                    if (line.charAt(0) == '+') {
                        line = line.substring(2);
                        createDirFile(line, path_process);
                    }
                    if (line.charAt(0) == '-') {
                        line = line.substring(2);
                        removeDirFile(new File(path_process + "/" + line));
                    }
                    if (line.charAt(0) == '>') {
                        line = line.substring(2);
                        changePath(line, path_process);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createDirFile(String path, StringBuilder path_process)
    {
        StringBuilder copy = new StringBuilder(path_process);
        String[] paths = path.split("((?<=/))");
        int size;
        int i;
        for (i = 0; i < paths.length; i++)
        {
            size = paths[i].length();
            if (paths[i].charAt(size - 1) == '/')
            {
                File f = new File(copy + "/" + paths[i]);
                f.mkdirs();
                copy.append("/").append(paths[i], 0, size - 1);
            }
        }
        if (paths[i - 1].charAt(paths[i - 1].length() - 1) != '/')
        {
            File file = new File(copy + "/" + paths[i - 1]);
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void removeDirFile(File file)
    {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                removeDirFile(f);
            }
        }
        file.delete();
    }


    public void changePath(String line, StringBuilder path_process)
    {
        Path p = Paths.get(path_process + "/" + line);
        if (Files.isDirectory(p))
        {
            if (line.charAt(line.length() -1) == '/') {
                path_process.append("/").append(line.substring(0, line.length() - 1));
            }
            else
            {
                path_process.append("/").append(line.substring(0, line.length()));
            }
            //System.out.println("new: "+ path_process);
        }
        else {
            try {
                throw new Exception("cd failed for " + line);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
