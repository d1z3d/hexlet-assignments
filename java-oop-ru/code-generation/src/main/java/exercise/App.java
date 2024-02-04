package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws JsonProcessingException {
        String data = car.serialize();
        File file = new File(path.toString());
        try (OutputStream fileOutputStream = new FileOutputStream(file)) {
            byte[] result = data.getBytes();
            fileOutputStream.write(result);
        } catch (Exception e) {
            System.out.println("problems");
        }
    }

    public static Car extract(Path path) throws IOException {
        String data = Files.readString(path);
        return Car.unserialize(data);
    }
}
// END
