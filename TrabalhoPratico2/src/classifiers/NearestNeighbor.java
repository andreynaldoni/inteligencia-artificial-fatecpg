package classifiers;

import java.io.FileReader;

import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Debug.Random;

public class NearestNeighbor extends Classifier {
	Instances dataSourceToClassify;
	
	public NearestNeighbor(String dataSourceToLearn, String dataSourceToClassify, int classIndex, int classPossibilities){
		this.dataSourceToClassify = prepareDataSource(dataSourceToClassify, classIndex);
		super.dataSource = prepareDataSource(dataSourceToLearn, classIndex);
		super.classPossibilities = classPossibilities;
		super.classIndex = classIndex;
		super.classPossibilities = classPossibilities;
		classify();
	}
	
	public void classify(){
		IBk nereastNeighbor = new IBk();
		int realClass = 0;
		int resultClass = 0;
		this.confusionMatrix = new int[classPossibilities][classPossibilities];
		try {
			nereastNeighbor.buildClassifier(this.dataSource);
			for (int i = 0; i < this.dataSourceToClassify.numInstances(); i++) {
				Instance example = this.dataSourceToClassify.instance(i);
				realClass = (int)example.value(classIndex);
				example.setClassMissing();
				resultClass = (int)nereastNeighbor.classifyInstance(example);
				this.confusionMatrix[realClass][resultClass]++;								
			}	
		} catch(Exception e) {
			e.printStackTrace();
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
}
