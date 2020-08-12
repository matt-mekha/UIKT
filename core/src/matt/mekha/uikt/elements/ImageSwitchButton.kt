package matt.mekha.uikt.elements

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import matt.mekha.uikt.UIKT
import matt.mekha.uikt.util.Transform

class ImageSwitchButton(
        transform: Transform,
        private val idleImageFilePath: String,
        private val hoverImageFilePath: String,
        private val heldImageFilePath: String,
        onClickAction: (() -> Unit)?
) : Button(transform, onClickAction) {

    init {
        UIKT.assetManager.load(idleImageFilePath, Texture::class.java)
        UIKT.assetManager.load(hoverImageFilePath, Texture::class.java)
        UIKT.assetManager.load(heldImageFilePath, Texture::class.java)
    }

    override fun draw(batch: SpriteBatch) {
        val filePath = when (buttonState) {
            ButtonState.IDLE -> idleImageFilePath
            ButtonState.HOVER -> hoverImageFilePath
            ButtonState.HELD -> heldImageFilePath
        }

        if (!UIKT.assetManager.isLoaded(filePath)) {
            return
        }

        batch.draw(
                UIKT.assetManager.get(filePath, Texture::class.java),
                transform.trueX, transform.trueY, transform.trueWidth, transform.trueHeight
        )
    }

}