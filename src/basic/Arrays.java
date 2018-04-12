/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author farhaad
 */
public class Arrays {
    
    public static void main(String[] args){
        isItThereOrNot();
    }
    
    public static void isItThereOrNot(){
        
        int[] randomNumbers = new int[10];
        
        for(int i = 0; i < randomNumbers.length; i++){
               int random = generateRandomValues(1, 50);
               randomNumbers[i] = random;
               System.out.print(randomNumbers[i] + " ");      
        }
        System.out.println("");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Pick a number ");
        int num = sc.nextInt();
        List slots = new ArrayList();
        int largest = 0;
        
        for(int i = 0; i < randomNumbers.length; i++){
            if(randomNumbers[i] == num){
                slots.add(i + 1);
            }
            if(randomNumbers[i] > largest){
                largest = randomNumbers[i];
            }
            
        }
       
        if(slots.isEmpty()){
            System.out.print("Number not in array");
        }else{
            System.out.println("Number found in array with "  + slots.size() + " occurances");
            
            for(int i = 0; i < slots.size(); i ++){
                System.out.println("Found number " + num + " in slot " + slots.get(i));
            }
        }
        
        System.out.println("Largest number in array is " + largest);
    }
    
    public static int generateRandomValues(int lower, int upper){
        return (int) (Math.random() * upper - lower) +  lower;
    }
    
}
