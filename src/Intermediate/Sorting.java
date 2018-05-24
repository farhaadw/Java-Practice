/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intermediate;

import java.util.Arrays;

/**
 *
 * @author farhaad
 */
public class Sorting {
    
    public static void main(String[] args){
        int[] num = {7, 12, 8, 1, 22};
        System.out.println(Arrays.toString(bubbleSort(num)));
        System.out.println(Arrays.toString(insertionSort(num)));
        
    }

    public static int[] bubbleSort(int [ ] num) {
        for(int i = 0; i < num.length -1; i++){   
            for(int j = 0; j < num.length - i - 1; j++){
                
               if (num[j] > num[j+1]) {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
            
        }    
        return num;
    }
    
    public static int[] insertionSort(int[] num){
        int i, j, key, temp;
        
        for(i = 1; i < num.length -1; i++){
            key = num[i];
            j = i -1;
            
            while((j >= 0) && (key < num[j])){
                    temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                j--;
            }
            
        }   
        return num;
    }
    
}
    