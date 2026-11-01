class Point (val position: Int, val polygonId: Int, val x: Double, val y: Double): IValueGetter {
    override fun getXValue(): Double {
        return x
    }

}
