/**
 * Complexity and Sorting Program - CPRG304 - SAIT
 * This program demonstrates the use of various sorting algorithms to sort Shape objects
 * based on specific criteria such as height, volume, or base area.
 *
 * Authors: Emily Thieu, Ngoc Tam Nguyen, Yaling Wei, David Palacios
 * Instructor: Hani Mohammed
 * Date: October 24, 2024
 */

package appDomain;

import sorters.Sorter;
import java.util.List;
import java.util.ArrayList;
import comparators.ShapeComparator;
import comparators.BaseComparator;
import comparators.VolumeComparator;
import shapes.Shape;
import sorters.BubbleS;
import sorters.InsertionSort;
import sorters.QuickSort;
import sorters.SelectionSort;
import sorters.MergeSort;
import sorters.HeapSort;

/**
 * Main driver class for the application.
 * Handles user input, invokes file reading, and performs sorting operations based on selected criteria.
 */
public class AppDriver {

    /**
     * Entry point of the application.
     * Parses command-line arguments, reads the shape data, and performs sorting operations.
     *
     * @param args Command-line arguments specifying file name, comparison criteria, and sorting algorithm.
     */
    public static void main(String[] args) {
        String filename = ""; // File name containing the shapes data
        char compareBy = 'x'; // Criteria for comparison: 'h' (height), 'v' (volume), 'a' (base area)
        char sortAlgorithm = 'y'; // Sorting algorithm: 'b', 'i', 's', 'm', 'q', 'h'

        try {
            // Parse command-line arguments
            for (int i = 0; i < args.length; i++) {
                String arg = args[i].toLowerCase();

                if (arg.startsWith("-f")) { // File name argument
                    filename = arg.substring(2);
                    System.out.println("Filename: " + filename);

                    if (filename.isEmpty()) {
                        System.err.println("Missing filename after '-f'. Please enter a file name.");
                    }
                } else if (arg.startsWith("-t")) { // Comparison criteria argument
                    if (arg.length() > 2) {
                        compareBy = arg.charAt(2);
                    } else {
                        System.err.println("Missing 'compare by' command after '-t'.");
                    }
                } else if (arg.startsWith("-s")) { // Sorting algorithm argument
                    if (arg.length() > 2) {
                        sortAlgorithm = arg.charAt(2);
                    } else {
                        System.err.println("Missing sort algorithm after '-s'.");
                    }
                } else {
                    System.err.println("Unknown command: " + args[i]);
                }
            }

            filename = filename.trim();

            // Populate an array with Shape objects from the specified file
            Shape[] objectList = FileIO.ReadFile(filename);

            // Start measuring time for the sorting operation
            long startTime = System.nanoTime();

            // Initialize the appropriate comparator based on the criteria
            ShapeComparator comparator = null;
            if (compareBy == 'v') {
                comparator = new VolumeComparator();
            } else if (compareBy == 'a') {
                comparator = new BaseComparator();
            }

            // Perform sorting based on the selected algorithm and criteria
            switch (sortAlgorithm) {
                case 'b': // Bubble Sort
                    System.out.println("Bubble Sort");
                    performSort(new BubbleS<>(objectList, comparator), compareBy, objectList);
                    break;

                case 'i': // Insertion Sort
                    System.out.println("Insertion Sort");
                    performSort(new InsertionSort<>(objectList, comparator), compareBy, objectList);
                    break;

                case 's': // Selection Sort
                    System.out.println("Selection Sort");
                    performSort(new SelectionSort<>(objectList, comparator), compareBy, objectList);
                    break;

                case 'm': // Merge Sort
                    System.out.println("Merge Sort");
                    performSort(new MergeSort<>(objectList, comparator), compareBy, objectList);
                    break;

                case 'q': // Quick Sort
                    System.out.println("Quick Sort");
                    performSort(new QuickSort<>(objectList, comparator), compareBy, objectList);
                    break;

                case 'h': // Heap Sort
                    System.out.println("Heap Sort");
                    performSort(new HeapSort<>(objectList, comparator), compareBy, objectList);
                    break;

                default:
                    System.out.println("Unknown sort algorithm.");
            }

            // End measuring time and display the sorting duration
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("Sort time: " + totalTime + " ns");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Performs the sorting operation and displays the sorted results.
     *
     * @param sorter     The sorter object to perform sorting.
     * @param compareBy  The criteria for comparison ('h', 'v', 'a').
     * @param objectList The array of Shape objects to sort.
     */
    private static void performSort(Sorter<Shape> sorter, char compareBy, Shape[] objectList) {
        if (compareBy == 'h') { // Sort by height
            System.out.println("Compare by height");
            sorter.sortByHeightDesc();
            UIservice.displayResultHeight(objectList);
        } else if (compareBy == 'v') { // Sort by volume
            System.out.println("Compare by volume");
            sorter.sortByVolumeDesc();
            UIservice.displayResultVol(objectList);
        } else if (compareBy == 'a') { // Sort by base area
            System.out.println("Compare by base area");
            sorter.sortByBaseAreaDesc();
            UIservice.displayResultBaseArea(objectList);
        }
    }
}
