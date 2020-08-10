package matt.mekha.uikt.elements

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Vector2
import matt.mekha.uikt.util.Transform

object Scene : Element(Transform(anchorMin = Vector2(0F, 0F), anchorMax = Vector2(1F, 1F))) {

    val size: Vector2 = Vector2.Zero

    override fun resize() {
        size.set(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        super.resize()
    }

    override fun draw() {}

}