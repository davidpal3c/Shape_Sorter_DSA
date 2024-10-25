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
public class BubbleS<T extends Shape> extends Sorter<T> {

    public BubbleS(T[] data) {
        super(data);
    }

    public BubbleS(T[] data, ShapeComparator comparator) {
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
        boolean flag=true;
        while(flag==true){
            boolean flag_swap=false;
            for(int i=0;i<data.length - 1;i++){
                if(data[i].compareTo(data[i+1])<0){
                    swap(i,i+1);
                    flag_swap=true;
                }
            }
            if(flag_swap==false){
                flag=false;
            }
        }
    }
    public void volumeDesc() {
        //23  4 12 16 3 15
        boolean flag=true;
        while(flag==true){
            boolean flag_swap=false;
            for(int i=0;i<data.length - 1;i++){
                if(comparator.compare(data[i], data[i+1])<0){
                    swap(i,i+1);
                    flag_swap=true;
                }
            }
            if(flag_swap==false){
                flag=false;
            }
        }
    }
    public void baseAreaDesc() {
        //23  4 12 16 3 15
        boolean flag=true;
        while(flag==true){
            boolean flag_swap=false;
            for(int i=0;i<data.length - 1;i++){
                if(comparator.compare(data[i], data[i+1])<0){
                    swap(i,i+1);
                    flag_swap=true;
                }
            }
            if(flag_swap==false){
                flag=false;
            }
        }
    }
    
}
