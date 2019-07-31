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
     * In this first method, we are simply using sample points that are
     * on a straight plane. We will use the plane z= x + 2x.
     * In his method, 
     * 	1) we create an instance of LinearRegression.
     * 	2) we add 2,000 samples from the plane z= x + 2x as follows:
     * 		add the sample [(i, 2i), 5i] for 0<=i<=999
     * 		add the sample [(2i, i), 4i] for 0<=i<=999
     *  3) we iterate gradient descent 10,000, printing out the
     * current hypothesis and the current cost every 1,000 
     * iterations, using a step alpha of 0.000000003
     */
    private static void setPlane(){

        int sampS =2000;
        double temp1[]= new double[3];
        double temp2[]= new double[3];//temp arrays holds the planes x values when they are being added to the Linear regression object
        temp1[0]=1.0;
        temp2[0]=1.0;
        LinearRegression lR = new LinearRegression(2, sampS);
        for (int i =0;i<sampS/2;i++){
            temp1[1]=i;
            temp1[2]=2.0*i;
            temp2[1]=2.0*i;
            temp2[2]=i;
            lR.addSample(temp1,5.0*i);//adds for both the desired paramters for the x values given in the assignment
            lR.addSample(temp2,4.0*i);

        }
        for (int j=0;j<=10;j++){
               
               System.out.println("Current Hypothesis: "+lR.currentHypothesis());
               System.out.println("Current Cost: "+lR.currentCost());
               lR.gradientDescent( 0.000000003, 1000);
           }
	}




	public static void main(String[] args) {

		StudentInfo.display();

		System.out.println("setPlane");
		setPlane();


	}

}