/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorters;

import comparators.ShapeComparator;
import shapes.Shape;

/**
 *
 * @author user
 */
public class InsertionSort<T extends Shape> extends Sorter<T> {

    public InsertionSort(T[] data) {
        super(data);
    }

    public InsertionSort(T[] data, ShapeComparator comparator) {
        super(data, comparator);
    }
    public void swap(int a, int b) {
        T temp = this.data[a];
        this.data[a] = this.data[b];
        this.data[b] = temp; 
    }
    @Override
    public void heightDesc() {
        //23  4 12 16 3 15
        // seperate 2 order position
        //sorted position and not sorterd position
        //get first element and suppose it sorted and compare
        int sizej=1;//index sorted
        for(int i=0;i<data.length;i++){
            for(int j=0;j<sizej;j++){
                if(data[i].compareTo(data[j])>0){
                    swap(i, j);
                }
            }
            sizej++;
        }
    }
    public void volumeDesc() {
        //23  4 12 16 3 15
        // seperate 2 order position
        //sorted position and not sorterd position
        //get first element and suppose it sorted and compare
        int sizej=1;//index sorted
        for(int i=0;i<data.length;i++){
            for(int j=0;j<sizej;j++){
                if(comparator.compare(data[i],data[j])>0){
                    swap(i, j);
                }
            }
            sizej++;
        }
    }
    public void baseAreaDesc() {
        //23  4 12 16 3 15
        // seperate 2 order position
        //sorted position and not sorterd position
        //get first element and suppose it sorted and compare
        int sizej=1;//index sorted
        for(int i=0;i<data.length;i++){
            for(int j=0;j<sizej;j++){
                if(comparator.compare(data[i],data[j])>0){
                    swap(i, j);
                }
            }
            sizej++;
        }
    }
    
}
