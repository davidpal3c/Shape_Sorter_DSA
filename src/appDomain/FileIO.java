/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appDomain;

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
//import java.io.IOException;
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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author David Palacios
 */
public class FileIO {
       
    
    public static List<Object> GetFilePath(String option) {
        
        List<Object> mapper = new ArrayList<>();
        
        String filePath = "";
        int arrSize = 0;
        
//        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        
        if (option.equals("res/shapes1.txt") || option.equals("shapes1.txt") || option.equals("C:\temp\shapes1.txt") || option.equals("shapes1")) {
            filePath = "../res/shapes1.txt";
            arrSize = 10;
            
        } else if (option.equals("res/shapes2.txt") || option.equals("shapes2.txt") || option.equals("C:\temp\shapes2.txt") || option.equals("shapes2")) {
            filePath = "../res/shapes2.txt";   
            arrSize = 1000;
            
        } else if (option.equals("res/shapes3.txt") || option.equals("shapes3.txt") || option.equals("C:\temp\shapes3.txt") || option.equals("shapes3")) {
            filePath = "../res/shapes3.txt";
            arrSize = 1000000;
            
        } else 
            throw new IllegalArgumentException("Invalid file path: " + option);
        
               
        Path file = Paths.get(filePath);
        if (!Files.exists(file)) {
            System.err.println("File does not exist: " + file.toString());
        }

        System.out.println("Reading from: " + file.toString());  
        
        mapper.add(filePath);
        mapper.add(arrSize);
        
        return mapper;        
    }
        
    
    public static Shape[] ReadFile(String filename) {
               
        List<Object> mapper = GetFilePath(filename);
        
//        String filePath = (String) mapper.get(0);
//        int objCount = (int) mapper.get(1);

        Shape[] objectsArray = new Shape[(int) mapper.get(1)];
        
        int index = 0;                          
        
        try {
            
            List<String> lines = Files.readAllLines(Paths.get((String) mapper.get(0)));

            int objectCount = 0;
            boolean firstLine = true;

            for (String line : lines) {

                if (firstLine) {
                    objectCount = Integer.parseInt(line);
                    firstLine = false;                                             

                    if(objectCount <= 0){
                        System.out.println("Object count is not greater than zero");
                        return new Shape[0];
                    }
                    
                }               
                else {       
                    
                    String[] values = line.split(" ");

                    double height = 0;
                    double radius = 0;
                    double side = 0;
                    
                    if (index >= objectsArray.length) {
                        Shape[] newArray = new Shape[objectsArray.length + 1];
                        System.arraycopy(objectsArray, 0, newArray, 0 ,objectsArray.length);
                        objectsArray = newArray;
                    }
                    
                    switch(values[0]) {
                    
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
        }
        catch (NumberFormatException e) {
            System.err.println("Number format error: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        } 
                
        Shape[] confirmedArr = new Shape[index];
        System.arraycopy(objectsArray, 0, confirmedArr, 0, index);
        
        objectsArray = confirmedArr;
        
        return objectsArray;
        
    }
    
}
