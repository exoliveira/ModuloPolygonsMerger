class CurveSmoother {

    fun clusterPoints(
        points: List<Point>,
        delta: Double,
        coordinate: (Point) -> Double
    ): List<List<Point>> {

        val clusters = mutableListOf<List<Point>>()
        var start = 0
        var end = 0

        while (start < points.size) {
            val endRange = coordinate(points[start]) + delta

            while (end < points.size &&
                coordinate(points[end]) <= endRange) {
                end++
            }

            clusters.add(points.subList(start, end).toList())
            start = end
        }

        return clusters
    }

}