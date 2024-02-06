package fr.epita.assistants.mykitten;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;

public class MyKitten {
    /**
     * Initializer.
     *
     * @param srcPath Source file path.
     */
    String path;
    Stream<String> stream_content;
    public MyKitten(String srcPath) {
        path = srcPath;
        try {
            streamContent = Files.lines(Paths.get(srcPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use the streamContent to replace `wordToReplace` with "miaou". Don't forget
     * to add the line number beforehand for each line. Store the new
     * result directly in the streamContent field.
     *
     * @param wordToReplace The word to replace
     */
    public void replaceByMiaou(String wordToReplace) {
        final int[] line_nb = {1};
        streamContent = streamContent.map(line -> (line_nb[0]++) + " " + line.replaceAll(wordToReplace, "miaou"));
    }

    /**
     * Use the streamContent to write the content into the destination file.
     *
     * @param destPath Destination file path.
     */
    public void toFile(String destPath) {
        try {
            Files.write(Paths.get(destPath), streamContent.toList(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates an instance of MyKitten and calls the above methods to do it
     * straightforwardly.
     *
     * @param srcPath       Source file path
     * @param destPath      Destination file path
     * @param wordToReplace Word to replace
     */
    public static void miaou(String srcPath, String destPath,
                             String wordToReplace) {
        MyKitten kitt = new MyKitten(srcPath);
        kitt.replaceByMiaou(wordToReplace);
        kitt.toFile(destPath);
    }

    public Stream<String> streamContent;
}
