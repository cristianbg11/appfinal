
import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Kmeans {

    private int seeds;
    private int clusters;
    private SimpleKMeans kmeans;
    private Instances data;

    public Kmeans(int seeds, int clusters) throws Exception {
        this.seeds = seeds;
        this.clusters = clusters;
        kmeans = new SimpleKMeans();
        kmeans.setSeed(seeds);
        kmeans.setPreserveInstancesOrder(true);
        kmeans.setNumClusters(clusters);

        BufferedReader datafile = readDataFile(System.getProperty("user.dir") + "/covid19.arff");
        data = new Instances(datafile);
        kmeans.buildClusterer(data);
    }

    private BufferedReader readDataFile(String filename) {
        BufferedReader inputReader = null;

        try {
            inputReader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + filename);
        }

        return inputReader;
    }

    ArrayList<Instancia> clusterar() throws Exception {
        // This array returns the cluster number (starting with 0) for each instance
        // The array has as many elements as the number of instances
        int[] assignments = kmeans.getAssignments();

        int i = 0;
        ArrayList<Instancia> clusters = new ArrayList<>();
        for (int clusterNum : assignments) {
            Instancia instancia = new Instancia();
            //"Dia: %d Casos.positivos: %d latitud: %f longitud: %f provincia: %s -> Cluster %d\n",
            instancia.Dia = (int) (data.instance(i).value(1));
            instancia.Casos = (int) (data.instance(i).value(3));
            instancia.Latitud = data.instance(i).value(4);
            instancia.Longitud = data.instance(i).value(5);
            instancia.Provinvia = data.instance(i).stringValue(6);
            instancia.Cluster = clusterNum;
            clusters.add(instancia);
            i++;
        }
        return clusters;
    }

    ArrayList<Instancia> centroides() {
        ArrayList<Instancia> centroids = new ArrayList<>();
        for (Instance instance : kmeans.getClusterCentroids()) {
            Instancia instancia = new Instancia();
            instancia.Dia = (int) (instance.value(1));
            instancia.Casos = (int) (instance.value(3));
            instancia.Latitud = instance.value(4);
            instancia.Longitud = instance.value(5);
            instancia.Provinvia = instance.stringValue(6);
            instancia.Region = instance.stringValue(0);
            instancia.North = instance.stringValue(7);
            instancia.South = instance.stringValue(8);
            instancia.East = instance.stringValue(9);
            instancia.West = instance.stringValue(10);
            centroids.add(instancia);
        }
        return centroids;
    }
}
