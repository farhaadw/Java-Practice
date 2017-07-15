package basic;

public class CalculateArea {
    
    private static final double pi = 3.14;
    
    public static void main(String[] args){
        parameterOfCircle();
        areaOfCircle();
        areaOfSphere();
        volumeOfSphere();
        volumeOfCylinder();
    }
    
    public static void parameterOfCircle(){
        double radius = 12;
        double area = 2 * pi * radius;
        System.out.println("The parameter of circle is: " + area);
    }   
    
    public static void areaOfCircle(){
        double radius = 12;
        double area = pi * (radius * radius);
        System.out.println("The area of circle is: " + area);
    }
    
    public static void areaOfSphere(){
        double radius = 10;
        double area = 4 * pi * (radius * radius);
        System.out.println("The area of sphere is " + area);
    }
    
    public static void volumeOfSphere(){
        double radius = 10;
        double volume = (4 / 3) * pi * (radius * radius * radius);
        System.out.println("The volume of sphere is " + volume);
    }
    
    public static void areaOfCylinder(){
        double radius = 10;
        double height = 10;
        double surfaceArea = 2 * pi * radius * (radius + height);
        System.out.println("The surface area is " + surfaceArea);      
    }
    
    public static void volumeOfCylinder(){
        double radius = 10;
        double height = 10;
        double volume = pi * (radius * radius) * height;
        System.out.println("The volume of cylinder is " + volume);
    }
}