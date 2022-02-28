package ProjectOne;

import java.util.Scanner;
  
/**
 * A class that represents a Sphere and
 * its radius, surface area, and volume.
 * @author Dylan Vance
 */
public class Sphere extends Object
implements Comparable<Sphere> {

        /**
        * The Radius of the Sphere.
        */
        private double Radius = 0;

        /**
        * The Surface Area of the Sphere.
        */
        private double SurfaceArea = 0;

        /**
        * The Volume of the Sphere.
        */
        private double Volume = 0;

        /**
        * Default Constructor.
        */
        public Sphere() { this(0); }
        
        /**
         * Second Constructor.
         * Sets Radius to 0 if input is less than 0.
         * @param radius The intake value for the radius.
         */
         public Sphere(double radius) {
                 if (radius < 0) { this.SetRadius(0); }
                 else { this.SetRadius(radius); }
         }

         /**
         * Returns Radius.
         * @return Radius
         */
         public double GetRadius() { return this.Radius; }

         /**
         * Returns Surface Area.
         * @return SurfaceArea
         */
         public double SurfaceArea() { return this.SurfaceArea; }

         /**
         * Returns Volume.
         * @return Volume
         */
         public double Volume() { return this.Volume; }
         
         /**
          * Mutator.
          * Sets Radius.
          * Sets Radius to 0 if input is less than 0.
          * Calls UpdateSurfaceAreaAndVolume method.
          * @param NewRadius The intake value for the radius.
          */
          public void SetRadius (double NewRadius) {
                  if (NewRadius > 0) {
                          this.Radius = NewRadius;
                          UpdateSurfaceAreaAndVolume();
                  }
                  else {
                          this.Radius = 0;
                          UpdateSurfaceAreaAndVolume();
                  }
          }

          /**
          * Calculates and Updates the Surface Area and Volume.
          * Called when the Radius is modified.
          */
          private void UpdateSurfaceAreaAndVolume() {
                  this.SurfaceArea = 4 * Math.PI * Math.pow(Radius, 2);
                  this.Volume = (4.0/3.0) * Math.PI * Math.pow(Radius, 3);
          }

          /**
          * Returns the String representation of a Sphere object.
          * @return The String representation of a Sphere object.
          */
          public String toString() {
                  String Temp = new String();

                  Temp = "I am a Sphere with a radius of " + this.GetRadius() + ". My Surface Area is " + this.SurfaceArea + ". My Volume is " + this.Volume();

                  return Temp;
          }
          
          /**
           * Comparable Interface.
           * @param Test Sphere object used for comparison.
           * @return Returns -1 if less than, 0 if equal to, and 1 if greater than the parameter.
           */
           public int compareTo(Sphere Test) {
                   int Result = 0;

                   if (this.Radius < Test.Radius)  { Result = -1; }
                   if (this.Radius == Test.Radius) { Result =  0; }
                   if (this.Radius > Test.Radius)  { Result =  1; }

                   return Result;
           }
           
           /**
            * A Testbench for the Sphere Class.
            * Tests each method individually, basic values (1-100), 
            * basic values with high decimal precision, border cases (999, -999),
            * and the comparable interface.
            * Includes an option to skip over a test.
            * @param Args Command Line Arguments.
            */
            public static void main(String Args[]) {
                    int i = 0;
                    double j = 0;
                    Sphere Test = new Sphere();
                    Scanner input = new Scanner(System.in);
                    char userIn;

                    System.out.println("Test: Individual Methods");
                    System.out.println("Continue? (Enter Y / N)");
                    userIn = input.next().charAt(0);
                    if (userIn == 'Y' || userIn == 'y') {
                            Test.SetRadius(10);
                            if (Test.GetRadius() != 10) { System.out.println("Test 1 Failed"); }
                            if (Test.SurfaceArea != 1256.6370614359173) { System.out.println("Test 2 Failed"); }
                            if (Test.Volume != 4188.790204786391) { System.out.println("Test 3 Failed"); }
                            System.out.println(Test.toString());
                            System.out.println("Test Done.");
                    }

                    System.out.println("Test: Basic Values");
                    System.out.println("Continue? (Y/N)");
                    userIn = input.next().charAt(0);
                    if (userIn == 'Y' || userIn == 'y') {
                            for (i = 1; i <= 100; i++) {
                                    Test.SetRadius(i);
                                    System.out.println(Test.toString());
                            }
                            System.out.println("Test Done.");
                    }
                    
                    System.out.println("Test: High Decimal Precision");
                    System.out.println("Continue? (Y/N)");
                    userIn = input.next().charAt(0);
                    if (userIn == 'Y' || userIn == 'y') {
                            for (j = 1; j <= 100; j++) {
                                    Test.SetRadius(j + 0.11111111111111);
                                    System.out.println(Test.toString());
                            }
                            System.out.println("Test Done.");
                    }

                    System.out.println("Test: Border Cases");
                    System.out.println("Continue? (Y/N)");
                    userIn = input.next().charAt(0);
                    if (userIn == 'Y' || userIn == 'y') {
                            System.out.println("Setting Radius to 999");
                            Test.SetRadius(999);
                            System.out.println(Test.toString());

                            System.out.println("Setting Radius to -999");
                            Test.SetRadius(-999);
                            System.out.println(Test.toString());

                            System.out.println("Test Done");
                    }

                    System.out.println("Test: Comparable");
                    System.out.println("Continue? (Y/N)");
                    userIn = input.next().charAt(0);
                    if (userIn == 'Y' || userIn == 'y') {
                        Sphere A = new Sphere(0);
                        Sphere B = new Sphere(0);

                        if (A.compareTo(B) != 0) { System.out.println("Test Failed."); }

                        A.SetRadius(1);

                        if (A.compareTo(B) != 1) { System.out.println("Test Failed."); }

                        if (B.compareTo(A) != -1) { System.out.println("Test Failed."); }

                        System.out.println("Test Done.");
                }                    
        }
}
        
        