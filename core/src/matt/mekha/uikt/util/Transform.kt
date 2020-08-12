package matt.mekha.uikt.util

import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import matt.mekha.uikt.elements.Element
import matt.mekha.uikt.elements.Scene

class Transform (
        var anchor: Vector2? = null,
        var anchorMin: Vector2? = null,
        var anchorMax: Vector2? = null,
        var left: Float = 0F,
        var top: Float = 0F,
        var right: Float = 0F,
        var bottom: Float = 0F,
        var width: Float? = null,
        var height: Float? = null,
        var xOffset: Float = 0F,
        var yOffset: Float = 0F,
        var xPivot: Float = 0.5F,
        var yPivot: Float = 0.5F,
        var xScale: Float = 1f,
        var yScale: Float = 1f,
        var zIndex: Int = 0
    ) {

    var trueX = 0F
        private set
    var trueY = 0F
        private set
    var trueWidth = 0F
        private set
    var trueHeight = 0F
        private set
    var trueXScale = 0F
        private set
    var trueYScale = 0F
        private set

    private val containerSize
        get() = Vector2(trueWidth, trueHeight)
    val bounds
        get() = Rectangle(trueX, trueY, trueWidth, trueHeight)

    private lateinit var trueAnchorMin: Vector2
    private lateinit var trueAnchorMax: Vector2

    fun calculate(attachedElement: Element) {
        val oneAnchor = anchor != null

        if(oneAnchor) {
            anchorMin = anchor!!
            anchorMax = anchor!!
        }

        val parentContainerSize = attachedElement.parent?.transform?.containerSize ?: Scene.size
        trueAnchorMin = anchorMin!! * parentContainerSize
        trueAnchorMax = anchorMax!! * parentContainerSize

        val parentXScale = attachedElement.parent?.transform?.trueXScale ?: 1f
        trueXScale = xScale * parentXScale

        val parentYScale = attachedElement.parent?.transform?.trueYScale ?: 1f
        trueYScale = yScale * parentYScale

        if (oneAnchor || anchorMin!!.x == anchorMax!!.x) {
            trueX = trueAnchorMin.x - (width!! * xPivot * trueXScale) + (xOffset * parentXScale)
            trueWidth = width!! * trueXScale
        } else {
            trueX = trueAnchorMin.x + (left * parentXScale)
            trueWidth = trueAnchorMax.x - trueAnchorMin.x - (right + left) * parentXScale
        }

        if (oneAnchor || anchorMin!!.y == anchorMax!!.y) {
            trueY = trueAnchorMin.y - (height!! * yPivot * trueYScale) + (yOffset * parentYScale)
            trueHeight = height!! * trueYScale
        } else {
            trueY = trueAnchorMin.y + (bottom * parentYScale)
            trueHeight = trueAnchorMax.y - trueAnchorMin.y - (top + bottom) * parentYScale
        }

        trueX += attachedElement.parent?.transform?.trueX ?: 0F
        trueY += attachedElement.parent?.transform?.trueY ?: 0F
    }

}

private operator fun Vector2.times(vector2: Vector2): Vector2 {
    return Vector2(x * vector2.x, y * vector2.y)
}
