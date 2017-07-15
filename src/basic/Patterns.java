package basic;

public class Patterns {

    public static void main(String[] args) {
        pattern1();
    }

    public static void pattern1() {

        for (int i = 1; i <= 4; i++) {
            
            for (int j = 1; j <= 4; j++) {
                
                if(j == 1){
                 
                System.out.print("x");
                   
                }
            }

            System.out.println("");

        }
    }
}
