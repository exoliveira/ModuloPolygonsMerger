fun main(args: Array<String>) {
    println("Hello World!")

    var c = CurveSmoother()

    var result = c.clusterNumbers( listOf(1.1, 2.2, 3.3), 2.1)

    for (sublist in result) {
        // You can perform actions per sublist here (e.g., initialize a row sum)
        for (value in sublist) {
            print(value)
        }
        println("Ended this cluster")
    }


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}