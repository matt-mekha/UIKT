package matt.mekha.uikt.elements

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import matt.mekha.uikt.util.Transform

class RectangleTintButton(
        transform: Transform,
        private val idleImageTint: Color = Color.WHITE,
        private val hoverImageTint: Color = Color.WHITE,
        private val heldImageTint: Color = Color.WHITE,
        onClickAction: (() -> Unit)?
) : Button(transform, onClickAction) {

    private lateinit var texture: Texture

    override fun firstDraw() {
        val pixmap = Pixmap(1, 1, Pixmap.Format.RGB888)
        pixmap.setColor(Color.WHITE)
        pixmap.fill()

        texture = Texture(pixmap)
    }

    override fun draw(batch: SpriteBatch) {
        batch.color = when (buttonState) {
            ButtonState.IDLE -> idleImageTint
            ButtonState.HOVER -> hoverImageTint
            ButtonState.HELD -> heldImageTint
        }

        batch.draw(
                texture,
                transform.trueX, transform.trueY, transform.trueWidth, transform.trueHeight
        )

        batch.color = Color.WHITE
    }

}