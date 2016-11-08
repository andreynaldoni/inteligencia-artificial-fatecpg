package executables;

import classifiers.KNearestNeighbor;
import classifiers.NearestNeighbor;

public class CarroClassify {
	public static void main(String[] args) {
//		Common setting's to execute NN and K-NN 
		String dataSourceToLearn = "carro.arff";
		int classIndex = 6;
		int classPossibilites = 4;
				
//		Nearest Neighbor data to classify and run
		String dataSourceToClassify = "carro-a-classificar.arff";
		
//		Running NN		
		NearestNeighbor nn;
		
		System.out.println("\n==========Using Nearest Neighbor==========\n");
		nn = new NearestNeighbor(dataSourceToLearn, dataSourceToClassify, classIndex, classPossibilites);
		System.out.println(nn.getResults());
		
//		Specific settings to execute K-NN, number of partitions, iterations and neighbors
//		The selected method is Leave on Out using the number of instances to Iterate and Partitioning
		int partitions = 1500;
		int iterations = 1500;
		int neighbors = 3;
		
//		Running	K-NN	
		KNearestNeighbor knn;
		
		System.out.println("\n=========Using K-NearestNeighbor=========\n");
		knn = new KNearestNeighbor(partitions, iterations, dataSourceToLearn, classIndex, classPossibilites, neighbors);
		System.out.println(knn.getResults());
	}
}
