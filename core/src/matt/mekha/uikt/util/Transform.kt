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
        var zIndex: Int = 0
    ) {

    var trueX = 0F
    var trueY = 0F
    var trueWidth = 0F
    var trueHeight = 0F

    private val containerSize
        get() = Vector2(trueWidth, trueHeight)
    val bounds
        get() = Rectangle(trueX, trueY, trueWidth, trueHeight)

    private lateinit var trueAnchorMin: Vector2
    private lateinit var trueAnchorMax: Vector2

    private fun scale(anchor: Vector2, containerSize: Vector2) = anchor * containerSize

    fun calculate(attachedElement: Element) {
        val containerSize = attachedElement.parent?.transform?.containerSize ?: Scene.size

        val oneAnchor = anchor != null

        if(oneAnchor) {
            anchorMin = anchor!!
            anchorMax = anchor!!
        }

        trueAnchorMin = scale(anchorMin!!, containerSize)
        trueAnchorMax = scale(anchorMax!!, containerSize)

        if (oneAnchor || anchorMin!!.x == anchorMax!!.x) {
            trueX = trueAnchorMin.x - width!! * xPivot + xOffset
            trueWidth = width!!
        } else {
            trueX = trueAnchorMin.x + left
            trueWidth = trueAnchorMax.x - trueAnchorMin.x - right - left
        }

        if (oneAnchor || anchorMin!!.y == anchorMax!!.y) {
            trueY = trueAnchorMin.y - height!! * yPivot + yOffset
            trueHeight = height!!
        } else {
            trueY = trueAnchorMin.y + bottom
            trueHeight = trueAnchorMax.y - trueAnchorMin.y - top - bottom
        }

        trueX += attachedElement.parent?.transform?.trueX ?: 0F
        trueY += attachedElement.parent?.transform?.trueY ?: 0F
    }

}

private operator fun Vector2.times(vector2: Vector2): Vector2 {
    return Vector2(x * vector2.x, y * vector2.y)
}
