/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. 
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class Assignment {


     /** 
     * Random generator 
     */
     private static java.util.Random generator = new java.util.Random();


     /** 
     * In this second method, we will select a plane at random.
     *    1) we select a line z = ax + by + c, with a, b and c 
     * randomly selected between -100 and +100 
     *    2) we add 5000 samples randomly selected on the plane
     * with x and y both randomly selected between 50 and 4000. 
     * For each sample we add a "noise" 
     * randomly selected between -20 and +20 (that is, for
     * each randomly selected x and y we add the sample 
     *[ (x,y), ax+by+c+noise).
     * where "noise" is randomly selected between -20 and 20
     *  4) we iterate gradient descent (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     */

     private static void randomPlane(){

          int sampS =5000;
          double a= -100.0 + (200.0) * generator.nextDouble();//a,b,c used are random values for the plane
          double b= -100.0 + (200.0) * generator.nextDouble();
          double c= -100.0 + (200.0) * generator.nextDouble();
          LinearRegression lR = new LinearRegression(2, sampS);
          double x1;
          double x2;
          double z;
          double noise;
          double[] temp = new double[3];
          temp[0]=1.0;//x0 is always 1
          for (int i=0;i<sampS;i++){
               x1= 50.0 + (3950.0) * generator.nextDouble();//finds random x values for the plane
               x2= 50.0 + (3950.0) * generator.nextDouble();
               noise= -20.0 + (40.0) * generator.nextDouble();
               z= a*x1 + b*x2 + c +noise;//finds the z value for the plane given the x values 
               temp[1]=x1;
               temp[2]=x2;
               lR.addSample(temp,z);
          }
          for (int j=0;j<=10;j++){
               
               System.out.println("Current Hypothesis: "+lR.currentHypothesis());
               System.out.println("Current Cost: "+lR.currentCost());
               lR.gradientDescent( 0.00000009, 1000);
           }



     }


     public static void main(String[] args) {

          StudentInfo.display();

          System.out.println("randomPlane");
          randomPlane();



     }

}