/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent with 1 variable.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class LinearRegression {


	/** 
     * Number of samples (usually "m" in litterature) 
     */
	private int nbreOfSamples;


	/** 
     * the sample vector
     */
	private double[] samples;

	/** 
     * the samples target values
     */
	private double[] samplesValues;

	/** 
     * the current hypthesis function: theta0 + theta1 x
     */
	private double theta0, theta1;


	/** 
     * used to ensure that the object is ready
     */
	private int currentNbreOfSamples;



	/** 
     * counts how many iterations have been performed
     */
	private int iteration;
	private int pos;//holds the position of the array that is being added to



	/** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is y = 0;
     * 
     * 
     * @param m the number of samples that we will have
	 *
     */
 	public LinearRegression(int m){

 		this.nbreOfSamples = m;
 		samplesValues = new double[m];
 		samples = new double[m];
 		iteration=0;
 		pos=0;

	}

	/** 
     * Adds a new sample to sample and to samplesValues. This
     * method must be iteratively called with all the samples
     * before the gradient descent can be started
     * 
     * @param x the new sample
     * @param y the corresponding expected value
     *
	 */
	public void addSample(double x, double y){

		samples[pos]=x;
		samplesValues[pos]=y;
		pos++;
	}

	/** 
     * Returns the current hypothesis for the value of the input
     * @param x the input for which we want the current hypothesis
     * 
	 * @return theta0 + theta1 x
	 */
	private double hypothesis(double x){
		double h;
		h=theta0+theta1*x;//hypothesis equation 
		return(h);

	}

	/** 
     * Returns a string representation of hypthesis function
     * 
	 * @return the string "theta0 + theta1 x"
	 */
	public String currentHypothesis(){
		return(theta0+" + "+theta1+"x");
	}

	/** 
     * Returns the current cost
     * 
	 * @return the current value of the cost function
	 */
	public double currentCost(){
		double cost=0;
		double temp=0;
		for (int i=0;i<nbreOfSamples;i++){//calculates the cost using the given formula
			temp+=(((hypothesis(samples[i]))-samplesValues[i])*((hypothesis(samples[i]))-samplesValues[i]));
		}
		cost=(1.0/(nbreOfSamples*1.0))*temp;
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
		

		for (int j=0;j<numberOfSteps;j++){
			double temp0=0;
			double temp1 =0;
			int len = nbreOfSamples;
			iteration++;

			for (int i=0;i<len;i++){//for loop that calculates the sumattion in the given equation
				temp0+= ((hypothesis(samples[i]))-samplesValues[i]);
				temp1+= (((hypothesis(samples[i]))-samplesValues[i])*samples[i]);
			}
			
			theta0= theta0-alpha*(2.0/(len*1.0))*temp0;//finds the theta values after the summation 
			theta1= theta1-alpha*(2.0/(len*1.0))*temp1;
		}

		
		
	}



	/** 
     * Getter for theta0
     *
	 * @return theta0
	 */

	public double getTheta0(){
		return(theta0);
	}

	/** 
     * Getter for theta1
     *
	 * @return theta1
	 */

	public double getTheta1(){
		return(theta1);
	}

	/** 
     * Getter for samples
     *
	 * @return samples
	 */

	public double[] getSamples(){
		return samples;
	}

	/** 
     * Getter for getSamplesValues
     *
	 * @return getSamplesValues
	 */

	public double[] getSamplesValues(){
		return samplesValues;
	}

	/** 
     * Getter for iteration
     *
	 * @return iteration
	 */

	public int getIteration(){
		return (iteration);
	}
}