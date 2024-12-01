package appDomain;

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import shapes.Shape;
import shapes.Cylinder;
import shapes.Cone;
import shapes.Pyramid;
import shapes.Prism;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import shapes.PentagonalPrism;
import shapes.OctagonalPrism;

/**
 * Utility class for handling file input/output operations related to Shape objects.
 * Includes methods for fetching file paths based on user input and parsing files
 * to create Shape objects.
 *
 * @author David Palacios
 */
public class FileIO {

    /**
     * Retrieves the file path and expected array size based on the input option.
     * Validates the file's existence and prepares the required information for reading.
     *
     * @param option The input specifying the file path or shorthand identifier.
     * @return A list containing the file path as a String and the array size as an Integer.
     * @throws IllegalArgumentException If the provided option is invalid.
     */
    public static List<Object> GetFilePath(String option) {
        List<Object> mapper = new ArrayList<>();
        String filePath = "";
        int arrSize = 0;

        // Determine file path and array size based on the input option
        if (option.equals("res/shapes1.txt") || option.equals("shapes1.txt") || option.equals("C:\\temp\\shapes1.txt") || option.equals("shapes1")) {
            filePath = "../res/shapes1.txt";
            arrSize = 10;
        } else if (option.equals("res/shapes2.txt") || option.equals("shapes2.txt") || option.equals("C:\\temp\\shapes2.txt") || option.equals("shapes2")) {
            filePath = "../res/shapes2.txt";
            arrSize = 1000;
        } else if (option.equals("res/shapes3.txt") || option.equals("shapes3.txt") || option.equals("C:\\temp\\shapes3.txt") || option.equals("shapes3")) {
            filePath = "../res/shapes3.txt";
            arrSize = 1000000;
        } else {
            throw new IllegalArgumentException("Invalid file path: " + option);
        }

        // Validate the existence of the file
        Path file = Paths.get(filePath);
        if (!Files.exists(file)) {
            System.err.println("File does not exist: " + file.toString());
        }

        System.out.println("Reading from: " + file.toString());

        // Add file path and array size to the mapper list
        mapper.add(filePath);
        mapper.add(arrSize);

        return mapper;
    }

    /**
     * Reads the specified file and parses its contents to create an array of Shape objects.
     *
     * @param filename The name of the file to read.
     * @return An array of Shape objects parsed from the file.
     */
    public static Shape[] ReadFile(String filename) {
        List<Object> mapper = GetFilePath(filename);
        Shape[] objectsArray = new Shape[(int) mapper.get(1)];
        int index = 0;

        try {
            // Read all lines from the specified file
            List<String> lines = Files.readAllLines(Paths.get((String) mapper.get(0)));
            int objectCount = 0;
            boolean firstLine = true;

            for (String line : lines) {
                if (firstLine) {
                    // Parse the first line to determine the object count
                    objectCount = Integer.parseInt(line);
                    firstLine = false;

                    if (objectCount <= 0) {
                        System.out.println("Object count is not greater than zero");
                        return new Shape[0];
                    }
                } else {
                    // Process subsequent lines to create Shape objects
                    String[] values = line.split(" ");
                    double height = 0;
                    double radius = 0;
                    double side = 0;

                    // Ensure the array has enough space
                    if (index >= objectsArray.length) {
                        Shape[] newArray = new Shape[objectsArray.length + 1];
                        System.arraycopy(objectsArray, 0, newArray, 0, objectsArray.length);
                        objectsArray = newArray;
                    }

                    // Create Shape objects based on the specified type
                    switch (values[0]) {
                        case "Cylinder":
                            height = Double.parseDouble(values[1]);
                            radius = Double.parseDouble(values[2]);
                            objectsArray[index++] = new Cylinder(height, radius);
                            break;

                        case "Cone":
                            height = Double.parseDouble(values[1]);
                            radius = Double.parseDouble(values[2]);
                            objectsArray[index++] = new Cone(height, radius);
                            break;

                        case "Pyramid":
                            height = Double.parseDouble(values[1]);
                            side = Double.parseDouble(values[2]);
                            objectsArray[index++] = new Pyramid(height, side);
                            break;

                        case "SquarePrism":
                            height = Double.parseDouble(values[1]);
                            side = Double.parseDouble(values[2]);
                            objectsArray[index++] = new SquarePrism(height, side);
                            break;

                        case "TriangularPrism":
                            height = Double.parseDouble(values[1]);
                            side = Double.parseDouble(values[2]);
                            objectsArray[index++] = new TriangularPrism(height, side);
                            break;

                        case "PentagonalPrism":
                            height = Double.parseDouble(values[1]);
                            side = Double.parseDouble(values[2]);
                            objectsArray[index++] = new PentagonalPrism(height, side);
                            break;

                        case "OctagonalPrism":
                            height = Double.parseDouble(values[1]);
                            side = Double.parseDouble(values[2]);
                            objectsArray[index++] = new OctagonalPrism(height, side);
                            break;

                        default:
                            System.out.println("Unknown object type: '" + values[0] + "' in line: " + line);
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Number format error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Trims the array to the actual size of populated objects
        Shape[] confirmedArr = new Shape[index];
        System.arraycopy(objectsArray, 0, confirmedArr, 0, index);

        return confirmedArr;
    }
}
