package matt.mekha.uikt.elements

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import matt.mekha.uikt.util.Transform

class Rectangle(var color: Color, transform: Transform) : Element(transform) {

    override fun draw() {
        val shapeRenderer = ShapeRenderer()
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        shapeRenderer.color = color
        shapeRenderer.rect(transform.trueX, transform.trueY, transform.trueWidth, transform.trueHeight)
        shapeRenderer.end()
    }

}