package matt.mekha.uikt.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Vector2
import matt.mekha.uikt.Main

public class Transform(
        var anchorMin: Vector2,
        var anchorMax: Vector2,
        var left: Float?,
        var top: Float?,
        var right: Float?,
        var bottom: Float?,
        var width: Float?,
        var height: Float?,
        var xOffset: Float?,
        var yOffset: Float?
    ) {

    var trueX = 0F
    var trueY = 0F
    var trueWidth = 0F
    var trueHeight = 0F

    var lastResize = 0
    lateinit var trueAnchorMin: Vector2
    lateinit var trueAnchorMax: Vector2

    private fun scale(anchor: Vector2, screenSize: Vector2) = anchor * screenSize

    private fun calculate() {
        if (anchorMin.x == anchorMax.x) {
            trueX = anchorMin.x - width!!/2
            trueWidth = width!!
        } else {

        }

        if (anchorMin.y == anchorMax.y) {
            trueY = anchorMin.y - height!!/2
            trueHeight = height!!
        } else {

        }
    }

    public fun resize() {
        lastResize = Main.resizeCount;
        val screenSize = Vector2(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())

        trueAnchorMin = scale(anchorMin, screenSize)
        trueAnchorMax = scale(anchorMax, screenSize)
    }

    init {
        resize()
        calculate()
    }

}

private operator fun Vector2.times(vector2: Vector2): Vector2 {
    return Vector2(x * vector2.x, y * vector2.y)
}
