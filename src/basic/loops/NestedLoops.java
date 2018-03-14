package basic.loops;

/**
 *
 * @author farhaad
 */
public class NestedLoops {
    
    public static void main(String[] args){
        
        square();
        
    }
    
    public static void square(){
        
        int size = 8;
        
        for(int y =0; y < size; y++){
            for(int x = 0; x < size; x++){
                System.out.print(" x ");
            }
            System.out.println("");
        }
        
    }
    
}
