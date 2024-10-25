/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparators;

import shapes.Shape;

/**
 *
 * @author mailt
 */
public class VolumeComparator extends ShapeComparator {

    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.calcVolume() > o2.calcVolume())return 1;
        else if(o1.calcVolume() < o2.calcVolume())return -1;
        else return 0;
    }
    
}
