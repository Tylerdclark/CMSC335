package dev.tylerdclark;

public class Specifications {
    
    public static Specification[] specificationArray;

    static class Specification {
        String name;
        int measureCount;
        String[] measures;

     public Specification(String name, int measureCount, String[] measures) {
         this.name = name;
         this.measureCount = measureCount;
         this.measures = measures;
     }
 }
}
