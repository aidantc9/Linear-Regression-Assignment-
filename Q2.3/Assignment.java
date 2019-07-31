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
     * In this third method, we will follow the same approach
     * that the one followed in the method  randomPlane, but
     * this time we will have a variable number of dimensions,
     * specified by the parameter "dimension". We will
     * create 5000 samples of "dimension" dimension, where each
     * dimension will be ranmly selected between  -100 and +100,
     * and a randomly selected noise between -20 and +20 will be
     * added to the result.We will then iterate gradient descent 
     * (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     *
     * @param dimension the number of features
     */
	private static void randomDimension(int dimension){

          int sampS=5000;
          int n = dimension+1;//add one to help make the formula easier to calculate 
          double[] coe= new double [n];//holds all the coefficients for the formula with n dimensions 
          double[] tempX= new double [n];
          double r ;
          for (int i=0;i<coe.length;i++){//fills the array with random coefficients
               coe[i]= -100.0 + (200.0) * generator.nextDouble();
          }
          LinearRegression lR = new LinearRegression(dimension, sampS);
          tempX[0]=1.0;
          for (int j=0;j<sampS;j++){
               r=0;
               for (int i=1;i<tempX.length;i++){//generates random x values for n dimesions 
                    tempX[i]=50.0 + (3950.0) * generator.nextDouble();
               }
               for (int i=0;i<coe.length;i++){//finds the respective r values for all the x values 
                    r+= coe[i]*tempX[i];
               }
               r+= -20.0 + (40.0) * generator.nextDouble();//adds noise
               lR.addSample(tempX,r);
          }
          for (int j=0;j<=10;j++){
               
               System.out.println("Current Hypothesis: "+lR.currentHypothesis());
               System.out.println("Current Cost: "+lR.currentCost());
               lR.gradientDescent( 0.0000000009, 200);
           }

	}


	public static void main(String[] args) {

		StudentInfo.display();

		System.out.println("randomDimension");
		randomDimension(50);


	}

}