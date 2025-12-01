package hslu.oop.sw11;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void test_file_exists(){
        File file = Paths.get("src/main/resources/file.txt").toFile();

        assertTrue(file.exists());
    }

}