package classifiers;

import weka.core.Instances;

public class Classifier {
	protected int classIndex;
	protected int classPossibilities;
	protected int dataSize;
	protected int confusionMatrix[][];
	protected Instances dataSource;
	protected double precision;
	protected double accuracy;
	protected double revocation;
	protected double errorRate;
	
	public String getResults(){
		StringBuilder results = new StringBuilder();
		int lastLine[] = new int[classPossibilities];
		int lineSum;
		for (int i = 0; i < classPossibilities; i++) {
			lineSum = 0;
			for (int j = 0; j < classPossibilities; j++) {
				results.append(this.confusionMatrix[i][j])
		  	  		   .append("\t");
				lineSum += this.confusionMatrix[i][j];
				lastLine[j] += this.confusionMatrix[i][j];
			}
			results.append("|\t")
				   .append(lineSum)
				   .append("\n");
		}
		results.append("------------------------------------------------\n");
		for (int i : lastLine) {
			results.append(i)
			  	   .append("\t");
			dataSize += i;
		}
		results.append("|\t")
			   .append(dataSize)
			   .append("\n\n")
			   .append("Accuracy: \t")
			   .append(String.format("%.3f", calculateAccuracy()))
			   .append("\n")
			   .append("Error Rate: \t")
			   .append(String.format("%.3f", calculateErrorRate()))
			   .append("\n");
		for(int i = 0; i < classPossibilities; i++){
			results.append("\n")
				   .append(i)
				   .append(":\tPrecision: ")
				   .append(String.format("%.3f", calculatePrecision(i)))
				   .append("\t")
				   .append("Revocation: ")
				   .append(String.format("%.3f", calculateRevocation(i)));
		}
		
		return results.toString();
	}
	
	public Double calculateAccuracy(){
		int total = 0;
		for(int i = 0; i < classPossibilities; i++){
			total += this.confusionMatrix[i][i];
		}
		return accuracy = (double)total / dataSize;
	}
	
	public Double calculateErrorRate(){
		return errorRate = 1 - calculateAccuracy();
	}
	
	public Double calculatePrecision(int varIndex){
		int realTotal = 0;
		for(int i = 0; i < classPossibilities; i++){
			realTotal += confusionMatrix[varIndex][i];
		}
		return precision = (double)confusionMatrix[varIndex][varIndex] / realTotal;
	}
	
	public Double calculateRevocation(int varIndex){
		int realTotal = 0;
		int classifiedTotal = 0;
		for(int i = 0; i < classPossibilities; i++){
			realTotal += confusionMatrix[varIndex][i];
			classifiedTotal += confusionMatrix[i][varIndex];
		}
		return revocation = (double)classifiedTotal / realTotal;
	}
	
	public int getClassIndex(){
		return classIndex;
	}
	
	public void setClassIndex(int classIndex){
		this.classIndex = classIndex;
	}
	
	public int getClassPossibilites() {
		return classPossibilities;
	}
	public void setClassPossibilites(int classPossibilites) {
		this.classPossibilities = classPossibilites;
	}
	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}

	public int[][] getConfusionMatrix() {
		return confusionMatrix;
	}
	public void setConfusionMatrix(int[][] confusionMatrix) {
		this.confusionMatrix = confusionMatrix;
	}
	public Instances getDataSource() {
		return dataSource;
	}
	public void setDataSource(Instances dataSource) {
		this.dataSource = dataSource;
	}
	public double getPrecision() {
		return precision;
	}
	public void setPrecision(double precision) {
		this.precision = precision;
	}
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	public double getRevocation() {
		return revocation;
	}
	public void setRevocation(double revocation) {
		this.revocation = revocation;
	}
	public double getErrorRate() {
		return errorRate;
	}
	public void setErrorRate(double errorRate) {
		this.errorRate = errorRate;
	}
}
