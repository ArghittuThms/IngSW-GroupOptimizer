package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for loading data from CSV files.
 * Provides a method to read a CSV file from the specified file path
 * and return its content as a list of string arrays.
 */
public class DataCSV {

    /**
     * Loads data from a CSV file located at the specified path and returns it as a list of string arrays.
     * Each string array represents a row of the CSV file, where each element corresponds to a cell in that row.
     *
     * @param path The file path of the CSV file to be loaded.
     * @return A list of string arrays containing the data from the CSV file.
     *         Each array represents a row of data from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     * @throws CsvException If an error occurs while parsing the CSV file.
     */
    public static List<String[]> loadCSVFile(String path) throws IOException, CsvException {
        List<String[]> data_csv = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            data_csv = reader.readAll();

            System.out.println("Data successfully loaded from CSV file " + path);
        }

        return data_csv;
    }
}