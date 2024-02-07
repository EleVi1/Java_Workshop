package fr.epita.assistants.fgen;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FGen {

    String pwd = "./";
    public FGen(final String inputPath) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(inputPath);
        StringBuilder path_process = new StringBuilder("./");
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
                        removeDirFile(line);
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
        String[] paths = path.split("((?<=/))");
        int size;
        int i;
        for (i = 0; i < paths.length; i++)
        {
            size = paths[i].length();
            if (paths[i].charAt(size - 1) == '/')
            {
                File f = new File(path_process + "/" + paths[i]);
                f.mkdirs();
                path_process.append("/").append(paths[i], 0, size - 1);
            }
        }
        if (paths[i - 1].charAt(paths[i - 1].length() - 1) != '/')
        {
            File file = new File(path_process + "/" + paths[i - 1]);
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void removeDirFile(String path)
    {
        String[] paths = path.split("/");
        Path path_name = Paths.get(paths[0]);
        File file = path_name.toFile();
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDirectory(f);
            }
        }
        if (path.length() == 1 || path.matches("^[^/]*/$"))
        {
            file.delete();
        }
    }

    public void deleteDirectory(File file)
    {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDirectory(f);
            }
        }
        file.delete();
    }

    public void changePath(String path, StringBuilder path_process)
    {
        Path p = Paths.get(path);
        if (Files.isDirectory(p))
        {
            path_process.append("/").append(path.substring(0, path.length() - 1));
        }
        else {
            try {
                throw new Exception("cd failed for " + path);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
