public class Instancia {
    public int Dia;
    public int Casos;
    public double Latitud;
    public double Longitud;
    public String Provinvia;
    public int Cluster;
    public String Region;
    public String North;
    public String South;
    public String East;
    public String West;

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

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getNorth() {
        return North;
    }

    public void setNorth(String north) {
        North = north;
    }

    public String getSouth() {
        return South;
    }

    public void setSouth(String south) {
        South = south;
    }

    public String getEast() {
        return East;
    }

    public void setEast(String east) {
        East = east;
    }

    public String getWest() {
        return West;
    }

    public void setWest(String west) {
        West = west;
    }
}
