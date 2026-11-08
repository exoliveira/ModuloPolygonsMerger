import kotlin.math.absoluteValue

typealias PolygonId = Int
typealias SequentialPosition = Int
fun main(args: Array<String>) {

    var c = CurveSmoother()

    val globalMapCoordinateToPoints = LinkedHashMap<String, MutableSet<Point>>()
    val globalMapCoordinateToPolygons = LinkedHashMap<String, MutableSet<PolygonId>>()

    var p1_0 = Point(0, 1, Coordinate(0.0, 0.0))
    var p1_1 = Point(1, 1, Coordinate(1.1, 1.1))
    var p1_2 = Point(2, 1, Coordinate( 2.2, 2.2))
    var p1_3 = Point(3, 1, Coordinate( 3.3, 3.3))
    var p1_4 = Point(4, 1, Coordinate(5.5, 5.5))

    var p2_0 = Point(0, 2, Coordinate(10.0, 1.0))
    var p2_1 = Point(1, 2, Coordinate(1.1, 1.1))
    var p2_2 = Point(2, 2, Coordinate( 2.2, 2.2))
    var p2_3 = Point(3, 2, Coordinate( 3.3, 3.3))
    var p2_4 = Point(4, 2, Coordinate(15.5, 15.5))

    var joinedListAll = mutableListOf<Point>()
    val listOfPointsOfPolygon1 = mutableListOf(p1_0, p1_1, p1_2, p1_3, p1_4)
    val listOfPointsOfPolygon2 = mutableListOf(p2_0, p2_1, p2_2, p2_3, p2_4)



    joinedListAll.addAll(listOfPointsOfPolygon1)
    joinedListAll.addAll(listOfPointsOfPolygon2)

    var poly1 = GeoPolygon(listOfPointsOfPolygon1)
    var poly2 = GeoPolygon(listOfPointsOfPolygon2)



    // TEM QUE SER INSERIDO NA ORDEM EM QUE SÃO LIDOS!!!
//    var listAll = listOf(p1_0, p1_1, p1_2, p1_3, p1_4, p2_4, p2_3, p2_2, p2_1, p2_0)

    for (point in joinedListAll) {
        if (globalMapCoordinateToPoints[point.coordinate.coordinateAsString] == null) {
            globalMapCoordinateToPoints[point.coordinate.coordinateAsString] = mutableSetOf(point)
            globalMapCoordinateToPolygons[point.coordinate.coordinateAsString] = mutableSetOf(point.polygonId)
        }
        else {
            globalMapCoordinateToPoints[point.coordinate.coordinateAsString]!!.add(point)
            globalMapCoordinateToPolygons[point.coordinate.coordinateAsString]!!.add(point.polygonId)

        }
    }


    var currentPolygonsId: MutableSet<PolygonId> = mutableSetOf()

    var currentListOfPointsInCluster: MutableSet<Point> = mutableSetOf()
    var listOfClusters: MutableSet<MutableSet<Point>> = mutableSetOf()


    listOfPointsOfPolygon1.forEach { point ->
        if (globalMapCoordinateToPolygons[point.coordinate.coordinateAsString] == currentPolygonsId) {
//            currentListOfPointsInCluster.add(point)
        }
        else {
            println("Ficou diferente!")
            currentPolygonsId = globalMapCoordinateToPolygons[point.coordinate.coordinateAsString]!!
            if (currentListOfPointsInCluster.size > 0) {
                listOfClusters.add(currentListOfPointsInCluster)
            }
            currentListOfPointsInCluster = mutableSetOf()
        }
        currentListOfPointsInCluster.add(point)
    }
    listOfClusters.add(currentListOfPointsInCluster)

    listOfPointsOfPolygon2.forEach { point ->
        if (globalMapCoordinateToPolygons[point.coordinate.coordinateAsString] == currentPolygonsId) {
//            currentListOfPointsInCluster.add(point)
        }
        else {
            println("Ficou diferente!")
            currentPolygonsId = globalMapCoordinateToPolygons[point.coordinate.coordinateAsString]!!
            if (currentListOfPointsInCluster.size > 0) {
                listOfClusters.add(currentListOfPointsInCluster)
            }
            currentListOfPointsInCluster = mutableSetOf()
        }
        currentListOfPointsInCluster.add(point)
    }
    listOfClusters.add(currentListOfPointsInCluster)


    applyResolution(globalMapCoordinateToPoints, 1.1)

//    val mapaInvertido = globalMapCoordinateToPoints.entries.associate { (k, v) -> v to k }
//
//    mapaInvertido.keys.forEach {
//        println("Points shared by theses polygons: ")
//        it.stream().forEach{ println(it.polygonId )}
//        println(" ... are ...")
//        println(mapaInvertido[it])
//    }

}

fun applyResolution(originalMap: LinkedHashMap<String, MutableSet<Point>>, resolution: Double): LinkedHashMap<String, MutableSet<Point>> {

    val mapaInvertido = originalMap.entries.associate { (k, v) -> v to k }
    val listaQuePreciso = originalMap.values.toList()


    originalMap.forEach { key, points ->
        var start = 0
        var end = 0


        val pointsAsList = points

        val pointsIterator = points.iterator()
//        while (pointsIterator.hasNext()) {
//            val point = pointsIterator.next()
//            val startX = point.coordinate.x
//            val startY = point.coordinate.y
//
//
//            while (end < points.size &&
//                (startX - points[end].coordinate.x).absoluteValue <= resolution &&
//                (startY - points[end].coordinate.y).absoluteValue <= resolution) {
//                end++
//            }
//        }
//
//        while (start < points.size) {
//            val startX = points[start].coordinate.x
//            val startY = points[start].coordinate.y
//
//            while (end < points.size &&
//                (startX - points[end].coordinate.x).absoluteValue <= resolution &&
//                (startY - points[end].coordinate.y).absoluteValue <= resolution) {
//                end++
//            }
//
//            clusters.add(points.subList(start, end).toList())
//            start = end
//        }
//        var i = 0
//        while(point[i) {
//
        }

    return originalMap
}

fun applyResolution(
    points: List<Point>,
    resolution: Double
): List<List<Point>> {

    val clusters = mutableListOf<List<Point>>()
    var start = 0
    var end = 0

    while (start < points.size) {
        val startX = points[start].coordinate.x
        val startY = points[start].coordinate.y

        while (end < points.size &&
            (startX - points[end].coordinate.x).absoluteValue <= resolution &&
            (startY - points[end].coordinate.y).absoluteValue <= resolution) {
            end++
        }

        clusters.add(points.subList(start, end).toList())
        start = end
    }

    return clusters
}

//
//val globalMapCoordinateToPoints = HashMap<String, MutableSet<Point>>()

/*
fun merge(polygons: List<GeoPolygon>) {

    var checkPoints = mutableListOf<Point>()
    polygons[0].listOfClusters.forEach {
        cluster ->
        cluster.listOfPoints.forEach {
            point -> checkPoints.add(point)
        }
    }

    var i = 0
    while (i < polygons[1].listOfClusters.size) {
        
        i++
    }
    polygons[1].listOfClusters.forEach {
        cluster ->
        cluster.listOf
    }

    polygons.forEach {

    }

}

 */