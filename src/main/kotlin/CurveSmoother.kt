class CurveSmoother {

    fun clusterNumbers(numbers: List<Double>, delta: Double): List<List<Double>> {
        val clusters = mutableListOf<List<Double>>()
        var start = 0
        var end = 0

        while (start < numbers.size) {
            val endRange = numbers[start] + delta
            while (end < numbers.size && numbers[end] <= endRange) {
                end++
            }
            clusters.add(numbers.subList(start, end).toList())
            start = end
        }

        return clusters
    }

    fun clusterNumbers12(numbers: List<Double>, delta: Double): List<List<Double>> {
        val clusters = mutableListOf<List<Double>>()
        var start = 0
        var end = 0

        for (i in numbers.indices) {
            val current = numbers[i]
            val minLimit = current - delta
            val maxLimit = current + delta

            // Avança o início da janela até o primeiro número >= (x - delta)
            while (start < numbers.size && numbers[start] < minLimit) {
                start++
            }

            // Avança o fim da janela enquanto os números forem <= (x + delta)
            while (end < numbers.size && numbers[end] <= maxLimit) {
                end++
            }

            // Captura todos os números que estão dentro do intervalo centralizado
            clusters.add(numbers.subList(start, end).toList())
        }

        return clusters
    }

}