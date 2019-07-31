/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent for multiple variables
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class LinearRegression{


	/** 
     * Number of features (usually "n" in litterature) 
     */
	private int nbreOfFeatures;

	/** 
     * Number of samples (usually "m" in litterature) 
     */
	private int nbreOfSamples;


	/** 
     * the nbreOfFeatures X nbreOfSamples Matrix of samples
     */
	private double[][] samplesMatrix;

	/** 
     * the nbreOfSamples Matrix of samples target values
     */
	private double[] samplesValues;

	/** 
     * the nbreOfFeatures Matrix theta of current hypthesis function
     */
	private double[] theta;


	/** 
     * number of samples received so far
     */
	private int currentNbreOfSamples;

	/** 
     * a place holder for theta during descent calculation
     */
	private double[] tempTheta;


	/** 
     * counts how many iterations have been performed
     */
	private int iteration;
	private int pos;//holds the current position of the array that is being added to 


	/** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is theta[i]=0.0 for all i
     * 
     * @param n the number of features that we will have
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int n, int m){

		this.nbreOfFeatures = n+1;//makes calulations easier 
		this.nbreOfSamples =m;
		samplesMatrix = new double[nbreOfSamples][nbreOfFeatures];
		samplesValues = new double[nbreOfSamples];
		iteration=0;
		pos=0;
		theta= new double[nbreOfFeatures];
		tempTheta = new double[nbreOfFeatures];
		for (int i =0;i<nbreOfFeatures;i++){//sets all the theta values to 0.0
			theta[i]=0.0;
			tempTheta[i]=0.0;
		}

	}

	/** 
     * Add a new sample to samplesMatrix and samplesValues
     * 
     * @param x the vectors of samples
     * @param y the coresponding expected value
     *
	 */
	public void addSample(double[] x, double y){

		double[] temp;
		temp = new double[x.length];//used to create a copy of x rather than a reference to stop some issues that can occur 
		for (int i=0;i<x.length;i++){
			temp[i]=x[i];
		}
		samplesMatrix[pos]=temp;
		

		
		
		samplesValues[pos]=y;
		pos++;

	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input vector for which we want the current hypothesis
     * 
	 * @return h(x)
	 */

	private double hypothesis(double[] x){

		double h,temp;
		h=0;
		for (int i=0;i<x.length;i++){//calculates the hypothesis 
			h+=theta[i]*x[i];
		}

		return h;

	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 x_0 + theta1 x_1 + .. thetan x_n"
	 */

	public String currentHypothesis(){

		String fin="";
		for (int i=0;i<theta.length;i++){//create a string that holds all the x values 
			fin+= Double.toString(theta[i])+"x_"+i+" ";
		}
		return (fin);

	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */

	public double currentCost(){

		double cost=0;
		double temp=0;
		for (int i=0;i<nbreOfSamples;i++){//for loop for the summation in the cost function 
			temp+=(((hypothesis(samplesMatrix[i]))-samplesValues[i])*((hypothesis(samplesMatrix[i]))-samplesValues[i]));
		}
		cost=(1.0/(nbreOfSamples))*temp;
		return(cost);

	}

	/** 
     * runs several iterations of the gradient descent algorithm
     * 
     * @param alpha the learning rate
     *
     * @param numberOfSteps how many iteration of the algorithm to run
     */

	public void gradientDescent(double alpha, int numberOfSteps) {


		for (int k=0;k<numberOfSteps;k++){//for loop for the number of iterations 
			int len = nbreOfSamples;
			iteration++;

			for (int i=0;i<nbreOfFeatures;i++){
				double sum=0;
				for (int j=0;j<len;j++){//calculates the summation in the given function 
					sum+= ((hypothesis(samplesMatrix[j]))-samplesValues[j])*samplesMatrix[j][i];
					
					
					
				}
				tempTheta[i]=sum;
				
			}
			for (int d=0;d<tempTheta.length;d++){
					theta[d]= theta[d]-alpha*(2.0/(len))*tempTheta[d];
				}
			
		}

	}


	/** 
     * Getter for theta
     *
	 * @return theta
	 */

	public double[] getTheta(){

		return theta;

	}

	/** 
     * Getter for iteration
     *
	 * @return iteration
	 */

	public int getIteration(){

		return iteration;

	}
}