class CurveSmoother {

    fun clusterNumbers(numbers: List<Point>, delta: Double): List<List<Point>> {
        val clusters = mutableListOf<List<Point>>()
        var start = 0
        var end = 0

        while (start < numbers.size) {
            val endRange = numbers[start].x + delta
            while (end < numbers.size && numbers[end].x <= endRange) {
                end++
            }
            clusters.add(numbers.subList(start, end).toList())
            start = end
        }

        return clusters
    }

}