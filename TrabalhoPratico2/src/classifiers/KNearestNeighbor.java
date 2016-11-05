package classifiers;

import java.io.FileReader;

import weka.core.Debug.Random;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;

public class KNearestNeighbor extends Classifier {
	private int partitions;
	private int iterations;
	
	public KNearestNeighbor(int partitions, int iterations, String dataSourceName, int classIndex, int classPossibilities){
		this.partitions = partitions;
		this.iterations = iterations;
		super.dataSource = prepareDataSource(dataSourceName, classIndex);
		super.classIndex = classIndex;
		super.classPossibilities = classPossibilities;
		classify();
	}
	
	public void classify(){
		super.confusionMatrix = new int[classPossibilities][classPossibilities];
		for (int i = 0; i < iterations; i++) {
			dataSource.resample(new Random());
			Instances dataTrain = dataSource.trainCV(partitions,i);
			Instances dataTest = dataSource.testCV(partitions, i);
			IBk nereastNeighbor = new IBk(this.partitions);
			int realClass = 0;
			int resultClass = 0;
			try {
				nereastNeighbor.buildClassifier(dataTrain);
				for (int j = 0; j < dataTest.numInstances(); j++) {
					Instance example = dataTest.instance(j);
					realClass = (int)example.value(classIndex);
					example.setClassMissing();
					resultClass = (int)nereastNeighbor.classifyInstance(example);
					this.confusionMatrix[realClass][resultClass]++;								
				}	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private Instances prepareDataSource(String dataSourceName, int classIndex){
		Instances dataSource = null; 
		try {
			dataSource = new Instances(new FileReader(dataSourceName));
			dataSource.setClassIndex(classIndex);
			dataSource.resample(new Random());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	public int getPartitions() {
		return partitions;
	}

	public void setPartitions(int partitions) {
		this.partitions = partitions;
	}

	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}
}