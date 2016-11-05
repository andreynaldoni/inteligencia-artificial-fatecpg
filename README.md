# Artificial Intelligence
#### Faculdade de Tecnologia de Praia Grande - São Paulo - Brazil
##### Teacher: [Leonardo Villani](http://lattes.cnpq.br/3176057392240845)
##### Autors: [Andrey Naldoni](https://github.com/andreynaldoni),[Yunes Noronha](https://github.com/yunesnoronha) and [Paulo Barros](https://github.com/paulosbarros)

This project is an aplication of A.I. concepts using [Weka] for show the use of Nearest Neighbor and K-Nearest Neighbor algorithm.

Concepts you need know before enjoy this project.
* [Java] - Programming Language
* [Weka] - library for Java
* [Artificial Intelligence] - machine learning and data mining
  - [Nearest Neighbor] - algorithm
  - [K-Nearest Neighbor] - algorithm

An small explain about Weka...

> Weka is a collection of machine learning algorithms for data mining tasks. The algorithms can either be applied directly to a dataset or called from your own Java code. Weka contains tools for data pre-processing, classification, regression, clustering, association rules, and visualization. It is also well-suited for developing new machine learning schemes.

### Installation

This project requires [JDK 8+],[JRE 8+] and Java IDE, we recommend [Eclipse](https://eclipse.org/) to run.

After install this programs, clone our project and use the class CarroClassify.java to test our data source or use as an example to test any other.

In CarroClassify.java you can see this code to set parameters about your machine learning data
```sh
String dataSourceToLearn = "carro.arff";
String dataSourceToClassify = "carro-a-classificar.arff";
int classIndex = 6;
int classPossibilites = 4;
int partitions = 5;
int iterations = 5;
```
Questions about that variables? Consult the documentation about [IBK](http://weka.sourceforge.net/doc.dev/weka/classifiers/lazy/IBk.html) implementations to understand these parameters

This code below is to apply the Nearest Neighbor algorithms in the base as you have been set in the parameters
```sh
NearestNeighbor nn;

System.out.println("==========Using Nearest Neighbor==========\n");
nn = new NearestNeighbor(dataSourceToLearn, dataSourceToClassify, classIndex, classPossibilites);
System.out.println(nn.getResults());
```

If you want to use K-Nearest Neighbor, use this code below
```sh
KNearestNeighbor knn;

System.out.println("\n=========Using K-NearestNeighbor=========\n");
knn = new KNearestNeighbor(partitions, iterations, dataSourceToLearn, classIndex, classPossibilites);
System.out.println(knn.getResults());
```

### Libraries

Weka.jar file is disponible in the project root, if Eclipse acuses an error in this deppendence update the file path.

### Development

Want to contribute? Great!

Send your commit and we'll see your code an answer!

License
----
Thank you for visiting and use this project as you want!

**Free Software, Yeah!**

   [java]: <https://go.java/index.html>
   [weka]: <http://www.cs.waikato.ac.nz/ml/weka/>
   [Artificial Intelligence]: <https://en.wikipedia.org/wiki/Artificial_intelligence>
   [Nearest Neighbor]: <https://en.wikipedia.org/wiki/Nearest_neighbour_algorithm>
   [K-Nearest Neighbor]: <https://en.wikipedia.org/wiki/K-nearest_neighbors_algorithm>
   [JDK 8+]: <http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html>
   [JRE 8+]: <http://www.oracle.com/technetwork/pt/java/javase/downloads/jre8-downloads-2133155.html>