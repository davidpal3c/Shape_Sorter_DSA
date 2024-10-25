/**
*
* Complexity and Sorting Program - CPRG304 - SAIT
* Authors: Emily Thieu, Ngoc Tam Nguyen, Yaling Wei, David Palacios
* Instructor: Hani Mohammed
* Date: October 24, 2024
 */

package appDomain;

//import java.io.File;
import sorters.Sorter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
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


public class AppDriver
{    
    public static void main(String[] args)
    {
        String filename = "";
        char compareBy = 'x'; 
        char sortAlgorithm = 'y';

        //test
//        filename = "shapes1";
//        compareBy = 'h';
//        sortAlgorithm = 'm';                        

        try {

            for (int i = 0; i < args.length; i++) { 

                String arg = args[i].toLowerCase();

                if (arg.startsWith("-f")) {
                    filename = arg.substring(2);                         
                    System.out.println("Filename: " + filename);

                    if(filename.isEmpty())
                        System.err.println("Missing filename after '-f'. Please enter file name. ");

                } else if (arg.startsWith("-t")) {

                    if(arg.length() > 2)
                        compareBy = arg.charAt(2);                         
                    else
                        System.err.println("Missing 'compare by' command after 't'");

                } else if (arg.startsWith("-s")) {

                    if(arg.length() > 2)
                        sortAlgorithm = arg.charAt(2);                             
                    else
                        System.err.println("Missing sort algorithm criteria 's'");

                } else {
                    System.err.println("Unknown command " + args[i]);
                }
            }    
            filename = filename.trim();

            // populate list with shape objects
            Shape[] objectList = FileIO.ReadFile(filename);

//                for (Shape obj : objectList) {
//                    System.out.println(obj.toString());
//                }       

            long startTime = System.nanoTime();

            ShapeComparator comparator = null;
            if (compareBy == 'v') {
                comparator = new VolumeComparator();  
            } else if (compareBy == 'a') {
                comparator=new BaseComparator();
            }


            // Invoking respective sort/compare methods                
            switch(sortAlgorithm){

                case 'b':     
                    System.out.print("Bubble Sort \n"); 
                    if(compareBy == 'h') {
                        System.out.print("Compare by height \n");
                        BubbleS<Shape> bubleSort = new BubbleS(objectList);                            
                        bubleSort.heightDesc();
                        UIservice.displayResultHeight(objectList);

                    }                                             
                    else if(compareBy == 'v') {
                        System.out.print("Comparing by volume \n"); 
                        BubbleS<Shape> bubleSort = new BubbleS<>(objectList, comparator);                            
                        bubleSort.volumeDesc();
                        UIservice.displayResultVol(objectList);
                    }
                    else if(compareBy == 'a') {
                        System.out.print("Comparing by base area \n");
                        BubbleS<Shape> bubleSort = new BubbleS(objectList, comparator); 
                        bubleSort.volumeDesc();
                        UIservice.displayResultBaseArea(objectList);
                    }   
                    break;

                case 'i':      
                    System.out.print("Insertion Sort \n");
                    if(compareBy == 'h') {
                        System.out.print("Compare by height \n");
                        InsertionSort<Shape> insertionSort = new InsertionSort(objectList);                            
                        insertionSort.heightDesc();
                        UIservice.displayResultHeight(objectList);

                    }                                             
                    else if(compareBy == 'v') {
                        System.out.print("Comparing by volume \n"); 
                        InsertionSort<Shape> insertionSort = new InsertionSort<>(objectList, comparator);                            
                        insertionSort.volumeDesc();
                        UIservice.displayResultVol(objectList);
                    }
                    else if(compareBy == 'a') {
                        System.out.print("Comparing by base area \n");
                        InsertionSort<Shape> insertionSort = new InsertionSort<>(objectList, comparator);  
                        insertionSort.baseAreaDesc();
                        UIservice.displayResultBaseArea(objectList);
                    }   
                    break;

                case 's':      
                    System.out.print("Selection sort \n");

                    // method call (specifying compareBy h/v/b

                    if(compareBy == 'h') {
                        System.out.print("Compare by height \n");
                        SelectionSort<Shape> selectionSort = new SelectionSort(objectList);                            
                        selectionSort.heightDesc();
                        UIservice.displayResultHeight(objectList);

                    }                                             
                    else if(compareBy == 'v') {
                        System.out.print("Comparing by volume \n");
                        
                        SelectionSort<Shape> selectionSort = new SelectionSort<>(objectList, comparator);                            
                        selectionSort.volumeDesc();
                        UIservice.displayResultVol(objectList);

                    }
                    else if(compareBy == 'a') {
                        System.out.print("Comparing by base area \n");

                        SelectionSort<Shape> selectionSort = new SelectionSort(objectList, comparator); 
                        selectionSort.volumeDesc();
                        UIservice.displayResultBaseArea(objectList);
                    }     

                    break;

                case 'm':      
                    System.out.print("Merge sort \n");
                    
                    if(compareBy == 'h') {
                        System.out.print("Compare by height \n");
                        MergeSort<Shape> mergeSort = new MergeSort(objectList, comparator);                            
                        mergeSort.heightDesc(objectList);
                        UIservice.displayResultHeight(objectList);

                    }                                             
                    else if(compareBy == 'v') {
                        System.out.print("Comparing by volume \n");
                        MergeSort<Shape> mergeSort = new MergeSort(objectList, comparator);                            
                        mergeSort.sortByVolOrBaseDesc(objectList);
                        UIservice.displayResultVol(objectList);

                    }
                    else if(compareBy == 'a') {
                        System.out.print("Comparing by volume \n");
                        MergeSort<Shape> mergeSort = new MergeSort(objectList, comparator);                            
                        mergeSort.sortByVolOrBaseDesc(objectList);
                        UIservice.displayResultBaseArea(objectList);
                    }
                    
                    break;

                case 'q':       
                    System.out.print("Quick sort");
                    if(compareBy == 'h') {
                        System.out.print("Compare by height: \n");
                        //Sorter<Shape> quickSort = new QuickSort(objectList); 
                        QuickSort<Shape> quickSort=new QuickSort(objectList);
                        quickSort.QuickSortDescByHeight(0, objectList.length - 1);
                        UIservice.displayResultHeight(objectList);

                    }
                    else if(compareBy == 'v') {
                        System.out.print("Comparing by: volume: \n");                         
                        QuickSort<Shape> quickSort=new QuickSort(objectList, comparator);                            
                        quickSort.QuickSortDescByVolumeAndBase(0, objectList.length - 1);
                        UIservice.displayResultVol(objectList);

                    }
                    else if(compareBy == 'a') {
                        System.out.print("Comparing by base area: \n");                         
                        QuickSort<Shape> quickSort=new QuickSort(objectList, comparator);                            
                        quickSort.QuickSortDescByVolumeAndBase(0, objectList.length - 1);
                        UIservice.displayResultBaseArea(objectList);
                   
                    }  
                    break;

                case 'h':      
                    System.out.print("Heap Sort \n");
                    if(compareBy == 'h') {
                        System.out.print("Compare by height: \n");
                        HeapSort<Shape> heapSort=new HeapSort(objectList);
                        
                        UIservice.displayResultHeight(objectList);

                    }
                    else if(compareBy == 'v') {
                        System.out.print("Comparing by: volume: \n");                         
                        HeapSort<Shape> heapSort=new HeapSort(objectList, comparator);                         
                        heapSort.sortByVolumeOrBaseArea();
                        UIservice.displayResultVol(objectList);

                    }
                    else if(compareBy == 'a') {
                        System.out.print("Comparing by base area: \n");                         
                        HeapSort<Shape> heapSort=new HeapSort(objectList, comparator);                              
                        heapSort.sortByVolumeOrBaseArea();
                        UIservice.displayResultBaseArea(objectList);
                   
                    }  
                    break;

                default:
                    System.out.print("unknown error");

            }


            // print result: sorted list
//                for (Shape obj : objectList) {
//                    System.out.println(obj.toString());
//                }  
//                


            long endTime = System.nanoTime();

            long totalTime = endTime - startTime;
            System.out.println("Sort time: " + totalTime + " ns");


        } catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

}
