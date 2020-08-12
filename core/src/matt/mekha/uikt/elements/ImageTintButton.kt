package matt.mekha.uikt.elements

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import matt.mekha.uikt.UIKT
import matt.mekha.uikt.util.Transform

class ImageTintButton(
        transform: Transform,
        private val imageFilePath: String,
        private val idleImageTint: Color = Color.WHITE,
        private val hoverImageTint: Color = Color.WHITE,
        private val heldImageTint: Color = Color.WHITE,
        onClickAction: (() -> Unit)?
) : Button(transform, onClickAction) {

    init {
        UIKT.assetManager.load(imageFilePath, Texture::class.java)
    }

    override fun draw() {
        if (!UIKT.assetManager.isLoaded(imageFilePath)) {
            return
        }

        val batch = SpriteBatch()
        batch.begin()

        batch.color = when (buttonState) {
            ButtonState.IDLE -> idleImageTint
            ButtonState.HOVER -> hoverImageTint
            ButtonState.HELD -> heldImageTint
        }

        batch.draw(
                UIKT.assetManager.get(imageFilePath, Texture::class.java),
                transform.trueX, transform.trueY, transform.trueWidth, transform.trueHeight
        )

        batch.end()
        batch.dispose() // TODO more efficient way
    }

}