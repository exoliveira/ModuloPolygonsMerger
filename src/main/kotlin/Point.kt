import com.sun.org.apache.xpath.internal.operations.Bool

class Point (val position: SequentialPosition, val polygonId: PolygonId, val coordinate: Coordinate): IValueGetter {
    override fun getXValue(): Double {
        return coordinate.x
    }

    fun hasSameCoordinates(point: Point): Boolean {
        return point.coordinate.x.equals(this.coordinate.x) && point.coordinate.y.equals(this.coordinate.y)
    }

}
