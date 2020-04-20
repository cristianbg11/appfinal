public class Instancia {
    public int Dia;
    public int Casos;
    public double Latitud;
    public double Longitud;
    public String Provinvia;
    public int Cluster;

    public Instancia(int dia, int casos, double latitud, double longitud, String provinvia, int cluster) {
        Dia = dia;
        Casos = casos;
        Latitud = latitud;
        Longitud = longitud;
        Provinvia = provinvia;
        Cluster = cluster;
    }

    public Instancia() {

    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int dia) {
        Dia = dia;
    }

    public int getCasos() {
        return Casos;
    }

    public void setCasos(int casos) {
        Casos = casos;
    }

    public double getLatitud() {
        return Latitud;
    }

    public void setLatitud(double latitud) {
        Latitud = latitud;
    }

    public double getLongitud() {
        return Longitud;
    }

    public void setLongitud(double longitud) {
        Longitud = longitud;
    }

    public String getProvinvia() {
        return Provinvia;
    }

    public void setProvinvia(String provinvia) {
        Provinvia = provinvia;
    }

    public int getCluster() {
        return Cluster;
    }

    public void setCluster(int cluster) {
        Cluster = cluster;
    }
}
