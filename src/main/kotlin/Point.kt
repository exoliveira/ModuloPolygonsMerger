class Point (val position: SequentialPosition, val polygonId: PolygonId, val coordinate: Coordinate): IValueGetter {
    override fun getXValue(): Double {
        return coordinate.x
    }

}
