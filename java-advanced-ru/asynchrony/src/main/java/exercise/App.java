package exercise;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String path1, String path2, String outPathFile) {
        Path pathToFile1 = Paths.get(path1);
        Path pathToFile2 = Paths.get(path2);
        Path outFile = Paths.get(outPathFile);
        CompletableFuture<String> futureFile1 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(pathToFile1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> futureFile2 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(pathToFile2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> futureResult = futureFile1.thenCombine(futureFile2, (data1, data2) -> {
            String result = data1 + data2;
            try {
                Files.writeString(outFile, result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return null;
        });

        return futureResult;
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN

        // END
    }
}

