fun main(args: Array<String>) {
    var c = CurveSmoother()

    var p1 = Point(1, 1, Coordinate(1.1, 1.1))
    var p2 = Point(2, 1, Coordinate( 2.2, 1.1))
    var p3 = Point(3, 1, Coordinate( 23.3, 1.1))
    var p4 = Point(4, 1, Coordinate( 23.4, 2.1))

    var resultX = c.clusterPoints( listOf(p1, p2, p3, p4), 0.1) { it.coordinate.x}

    for (sublist in resultX) {
        for (value in sublist) {
            print(value.coordinate.x)
        }
        println("Ended this cluster in x")
        var resultY = c.clusterPoints(sublist, 1.0) { it.coordinate.y}
        for (value in resultY) {
            println(" Y = ${value.get(0).coordinate.y}")
        }

    }


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
}