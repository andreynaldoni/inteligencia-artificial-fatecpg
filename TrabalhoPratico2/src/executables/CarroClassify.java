package executables;

import classifiers.KNearestNeighbor;
import classifiers.NearestNeighbor;

public class CarroClassify {
	public static void main(String[] args) {
		String dataSourceToLearn = "carro.arff";
		String dataSourceToClassify = "carro-a-classificar.arff";
		int classIndex = 6;
		int classPossibilites = 4;
		int partitions = 5;
		int iterations = 5;
		
		NearestNeighbor nn;
		
		System.out.println("\n==========Using Nearest Neighbor==========\n");
		nn = new NearestNeighbor(dataSourceToLearn, dataSourceToClassify, classIndex, classPossibilites);
		System.out.println(nn.getResults());
		
		KNearestNeighbor knn;
		
		System.out.println("\n=========Using K-NearestNeighbor=========\n");
		knn = new KNearestNeighbor(partitions, iterations, dataSourceToLearn, classIndex, classPossibilites);
		System.out.println(knn.getResults());
	}
}
