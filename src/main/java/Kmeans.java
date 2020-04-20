
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Kmeans{

    private BufferedReader readDataFile(String filename) {
        BufferedReader inputReader = null;

        try {
            inputReader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + filename);
        }

        return inputReader;
    }

    ArrayList<Instancia> inicializar(int seeds, int clusters) throws Exception
    {
        SimpleKMeans kmeans = new SimpleKMeans();

        kmeans.setSeed(seeds);

        //important parameter to set: preserver order, number of cluster.
        kmeans.setPreserveInstancesOrder(true);
        kmeans.setNumClusters(clusters);

        BufferedReader datafile = readDataFile(System.getProperty("user.dir")+"/covid19.arff");
        Instances data = new Instances(datafile);


        kmeans.buildClusterer(data);

        // This array returns the cluster number (starting with 0) for each instance
        // The array has as many elements as the number of instances
        int[] assignments = kmeans.getAssignments();

        int i=0;
        ArrayList<Instancia> instancias = new ArrayList<>();
        for(int clusterNum : assignments) {
            Instancia instancia = new Instancia();
            //"Dia: %d Casos.positivos: %d latitud: %f longitud: %f provincia: %s -> Cluster %d\n",
                    instancia.Dia = (int)(data.instance(i).value(1));
                    instancia.Casos = (int)(data.instance(i).value(3));
                    instancia.Latitud = data.instance(i).value(4);
                    instancia.Longitud = data.instance(i).value(5);
                    instancia.Provinvia = data.instance(i).stringValue(6);
                    instancia.Cluster = clusterNum;
                    instancias.add(instancia);
            i++;
        }
        return instancias;
    }
}
