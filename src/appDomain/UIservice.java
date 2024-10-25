/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appDomain;

import shapes.Shape;

/**
 *
 * @author user
 */
public class UIservice {
    
    public static void displayResultVol(Shape[] objectList) {                                             
        if (objectList.length > 1000) {
            for(int i = 0; i < objectList.length; i+=1000) {
                System.out.println("The " + (i+1) + "000-th element is:  The polygon: " + objectList[i].toStringVolume());
            }     
        } else {
            for (int i = 0; i < objectList.length; i++) { 
                System.out.println("The " + (i+1) + "-th element is:  The polygon: " + objectList[i].toStringVolume());  
            }
        }        
    }

    public static void displayResultBaseArea(Shape[] objectList) {                                             
        if (objectList.length > 1000) {
            for(int i = 0; i < objectList.length; i+=1000) {
                System.out.println("The " + (i+1) + "000-th element is:  The polygon: " + objectList[i].toStringBaseArea());
            }     
        } else {
            for (int i = 0; i < objectList.length; i++) { 
                System.out.println("The " + (i+1) + "-th element is:  The polygon: " + objectList[i].toStringBaseArea());  
            }
        }        
    }

    public static void displayResultHeight(Shape[] objectList) {                                             
        if (objectList.length > 1000) {
            for(int i = 0; i < objectList.length; i+=1000) {
                System.out.println("The " + (i+1) + "000-th element is:  The polygon: " + objectList[i].toString());
            }     
        } else {
            for (int i = 0; i < objectList.length; i++) { 
                System.out.println("The " + (i+1) + "-th element is:  The polygon: " + objectList[i].toString());  
            }
        }        
    }
        
}
