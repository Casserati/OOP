package hslu.oop.sw11.csv;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvReaderTest {

    private static File csv_valid = Paths.get("src/test/resources/testdata.csv").toFile();
    private static File csv_empty = Paths.get("src/test/resources/testdata_empty.csv").toFile();
    private static File csv_corrupt = Paths.get("src/test/resources/testdata_corrupt.csv").toFile();
    private static File csv_notFound = Paths.get("src/test/resources/none.csv").toFile();

    @Test
    void readCsv_returnList(){
        List<Measurement> measurements = CsvReader.readCsvFile(csv_valid);

        assertEquals(5, measurements.size());
    }

    @Test
    void readCsv_empty(){
        List<Measurement> measurements = CsvReader.readCsvFile(csv_empty);

        assertEquals(0, measurements.size());
    }

    @Test
    void readCsv_corrupt(){
        List<Measurement> measurements = CsvReader.readCsvFile(csv_corrupt);

        assertNull(measurements);
    }

    @Test
    void readCsv_notFound(){
        List<Measurement> measurements = CsvReader.readCsvFile(csv_notFound);

        assertNull(measurements);
    }
}