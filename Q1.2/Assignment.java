/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. It uses the
 * provided class <b>Display</b> to show the results
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
import java.util.*;
public class Assignment {


     /** 
     * Random generator 
     */
     private static java.util.Random generator = new java.util.Random();

          /** 
     * In this second method, we will select a line at random.
     *    1) we select a line y = ax + b, with a randomly selected
     * between -100 and +100 and b randomly selected between 
     * -250 and +250
     *    2) we add 500 samples randomly selected on the line
     * between -100 and +300. For each sample we add a "noise" 
     * randomly selected between -1000 and +1000 (that is, for
     * each randomly selected x, we add the sample (x, ax+b+noise).
     * where "noise" is randomly selected between -1000 and 1000
     *  3) We create an instance of Display
     *  4) we iterate gradient descent (find a number of iterations,
     * a number of updates to the instance of Display, and a 
     * step alpha that seems to work
     */
     private static void randomLine(){

          double a= -100.0 + (200.0) * generator.nextDouble();//calculates the a and b values of the function
          double b= -250.0 + (500.0) * generator.nextDouble();
          int sampleSize= 500;
          LinearRegression lRR= new LinearRegression (sampleSize);
          Display graph =new Display(lRR);
          graph.setTarget(a,b);
          for (int i =0;i<sampleSize;i++){//adds the sample point using the given ranges 
               double x = -100.0 + (400.0) * generator.nextDouble();
               double rand= -1000.0 + (2000.0) * generator.nextDouble();
               double y= (a*x+b)+rand;
               lRR.addSample(x,y);

          }
          
          for (int j=0;j<=50;j++){
               lRR.gradientDescent( 0.00000007, 200);
               graph.update();
               System.out.println("Current Hypothesis: "+lRR.currentHypothesis());
               System.out.println("Current Cost: "+lRR.currentCost());
               System.out.println("Aiming for: "+b+" +"+a+"x_1");

          }

     }




     public static void main(String[] args) {

         StudentInfo.display();

        
          System.out.println("randomLine");
          randomLine();

     }

}