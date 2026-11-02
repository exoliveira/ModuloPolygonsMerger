typealias PolygonId = Int
typealias SequentialPosition = Int
fun main(args: Array<String>) {

    var c = CurveSmoother()

    val mapPolysPerCoordinate = HashMap<String, MutableSet<Point>>()

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

    var listAll = listOf(p1_0, p1_1, p1_2, p1_3, p1_4, p2_4, p2_3, p2_2, p2_1, p2_0)

    for (point in listAll) {
        if (mapPolysPerCoordinate[point.coordinate.coordinateAsString()] == null) {
            mapPolysPerCoordinate[point.coordinate.coordinateAsString()] = mutableSetOf(point)
        }
        else {
            mapPolysPerCoordinate[point.coordinate.coordinateAsString()]!!.add(point)
        }
    }

    val mapaInvertido = mapPolysPerCoordinate.entries.associate { (k, v) -> v to k }

    mapaInvertido.keys.forEach {
        println("Points shared by theses polygons: ")
        it.stream().forEach{ println(it.polygonId )}
        println(" ... are ...")
        println(mapaInvertido[it])
    }

}