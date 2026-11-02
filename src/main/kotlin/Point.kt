class Point (val position: Int, val polygonId: Int, val coordinate: Coordinate): IValueGetter {
    override fun getXValue(): Double {
        return coordinate.x
    }

}
