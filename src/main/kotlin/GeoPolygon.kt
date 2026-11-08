class GeoPolygon(listOfPoints: MutableList<Point>) {

    var listOfClusters = mutableListOf<GeoCluster>()

    init {
        listOfClusters.add(GeoCluster(listOfPoints))
    }

    fun addCluster(cluster: GeoCluster) {
        listOfClusters.add(cluster)
    }


}