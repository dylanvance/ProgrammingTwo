package ProjectThree;

//Project3 Author: Dylan Vance (n01450847)
import java.io.*;
import java.util.*;

public class Project3 {

      public abstract class Shape {
              protected String Name;

              public String getName() {
                      return this.Name;
              }

              abstract double getArea();
      }

      private class Rectangle extends Shape {
              private double Side1;
              private double Side2;

              public Rectangle(String inName, double inSide1, double inSide2) {
                      this.Name = inName;
                      this.Side1 = inSide1;
                      this.Side2 = inSide2;
              }

              @Override
              public double getArea() {
                      return this.Side1 * this.Side2;
              }

              @Override
              public String toString() {
                      String s = new String();
                      s = "Rectangle " + this.Name + " With Area " + String.format("%.2f", this.getArea());
                      return s;
              }
      }
      
      private class Square extends Shape {
          private double Side;

          public Square(String inName, double inSide) {
                  this.Name = inName;
                  this.Side = inSide;
          }

          @Override
          public double getArea() {
                  return Math.pow(Side, 2);
          }

          @Override
          public String toString() {
                  String s = new String();
                  s = "Square " + this.Name + " With Area " + String.format("%.2f", this.getArea());
                  return s;
          }
      }
      
      private class Triangle extends Shape {
          private double Base;
          private double Height;

          public Triangle(String inName, double inBase, double inHeight) {
                  this.Name = inName;
                  this.Base = inBase;
                  this.Height = inHeight;
          }

          @Override
          public double getArea() {
                  return (this.Base * this.Height) / 2;
          }

          @Override
          public String toString() {
                  String s = new String();
                  s = "Triangle " + this.Name + " With Area " + String.format("%.2f", this.getArea());
                  return s;
          }
      }
      
      private class Circle extends Shape {
          private double Radius;

          public Circle(String inName, double inRadius) {
                  this.Name = inName;
                  this.Radius = inRadius;
          }

          @Override
          public double getArea() {
                  return Math.PI * Math.pow(Radius, 2);
          }

          @Override
          public String toString() {
                  String s = new String();
                  s = "Circle " + this.Name + " With Area " + String.format("%.2f", this.getArea());
                  return s;
          }
      }
      
      public double getCumulativeArea(ArrayList<Shape> inShapes) {
          double Areas = 0;

          for (int i = 0; i < inShapes.size(); i++) {
                  Areas += inShapes.get(i).getArea();
          }

          return Areas;
      }
      
      public String getLargestShape(ArrayList<Shape> inShapes) {
          String biggest = new String();
          double area = 0;

          for (int i = 0; i < inShapes.size(); i++) {
                  if (inShapes.get(i).getArea() > area) {
                          area = inShapes.get(i).getArea();
                          biggest = inShapes.get(i).getName();
                  }
          }

          return biggest;
      }
      
      public static void main(String[] args) {
          if (args.length < 1) {
                  System.out.println("Missing Filename");
                  System.out.println("Usage: java Project3 <filename>");
                  return;
          }

          Project3 prj3 = new Project3();
          ArrayList<Shape> shapes = new ArrayList<Shape>();

          try (
          FileInputStream fstream = new FileInputStream(args[0]);
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          ) {
        	  String strLine;
              Scanner inFS = new Scanner(fstream);
              String name;
              double side1;
              double side2;

              while (inFS.hasNext() || inFS.hasNextDouble()) {
                      strLine = inFS.next();

                      if (strLine.contains("Rectangle") || strLine.contains("rectangle")) {
                              if (!(inFS.hasNext())) { break; }
                              name = inFS.next();

                              if (!(inFS.hasNextDouble())) { break; }
                              side1 = inFS.nextDouble();

                              if (!(inFS.hasNextDouble())) { break; }
                              side2 = inFS.nextDouble();

                              shapes.add(prj3.new Rectangle(name, side1, side2));
                      }
                      else if (strLine.contains("Square") || strLine.contains("square")) {
                              if (!(inFS.hasNext())) { break; }
                              name = inFS.next();

                              if (!(inFS.hasNextDouble())) { break; }
                              side1 = inFS.nextDouble();

                              shapes.add(prj3.new Square(name, side1));
                      }
                      else if (strLine.contains("Triangle") || strLine.contains("triangle")) {
                          if (!(inFS.hasNext())) { break; }
                          name = inFS.next();

                          if (!(inFS.hasNextDouble())) { break; }
                          side1 = inFS.nextDouble();

                          if (!(inFS.hasNextDouble())) { break; }
                          side2 = inFS.nextDouble();

                          shapes.add(prj3.new Triangle(name, side1, side2));
                      }
                  	  else if (strLine.contains("Circle") || strLine.contains("circle")) {
                          if (!(inFS.hasNext())) { break; }
                          name = inFS.next();

                          if (!(inFS.hasNextDouble())) { break; }
                          side1 = inFS.nextDouble();

                          shapes.add(prj3.new Circle(name, side1));
                  	  }
                  	  else {
                          continue;
                  	  }
              }
          }
          catch (FileNotFoundException fnf) {
              System.out.println("Could not find file " + args[0]);
              System.out.println("Usage: java Project3 <filename>");
              return;
          }
          catch (InputMismatchException ime) {
              System.out.println("Error with values in file");
              System.out.println("Syntax: <Shape> <Name> <double> <double> (Rectangle/Triangle)");
              System.out.println("        <Shape> <Name> <double> (Square/Circle)");
              return;
      	  }
          catch (Exception Ex) {
              System.out.println("Error: " + Ex.toString());
              return;
      	  }

          for (int i = 0; i < shapes.size(); i++) {           //This just prints the objects
              System.out.print("Shape " + i + ": ");          //from the ArrayList.
              System.out.println(shapes.get(i));              //Used it for testing.
      	  }                                                   //Please disregard.

      	  System.out.print("Cumulative Area: ");
      	  System.out.printf("%.2f\n", prj3.getCumulativeArea(shapes));
      	  System.out.println("Largest Shape: " + prj3.getLargestShape(shapes));
      }
}