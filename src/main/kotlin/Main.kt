fun main(args: Array<String>) {
    var c = CurveSmoother()

    var p1 = Point(1, 1, 1.1, 1.1)
    var p2 = Point(1, 1, 2.2, 1.1)
    var p3 = Point(1, 1, 23.3, 1.1)
    var p4 = Point(1, 1, 23.4, 1.1)

    var result = c.clusterNumbers( listOf(p1, p2, p3, p4), 0.1)

    for (sublist in result) {
        // You can perform actions per sublist here (e.g., initialize a row sum)
        for (value in sublist) {
            print(value.x)
        }
        println("Ended this cluster")
    }


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}