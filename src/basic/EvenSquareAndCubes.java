package basic;

/**
 *
 * Displays first 10 numbers squared, cubed etc. 
 */
public class EvenSquareAndCubes {
    
    public static void main(String[] args){
        
        for(int i=2; i <= 20; i+=2){
            if(i == 2){
             System.out.println("Even" + " \t" + "Square" + " \t" + "Cube");   
            } 
            System.out.println(i + " \t" + i*i + " \t" + i*i*i);
        }
        
    }
    
}
