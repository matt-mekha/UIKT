package matt.mekha.uikt.elements

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import matt.mekha.uikt.UIKT
import matt.mekha.uikt.util.Transform

class Image(private val filePath: String, transform: Transform) : Element(transform) {

    init {
        UIKT.assetManager.load(filePath, Texture::class.java)
    }

    override fun draw() {
        if (!UIKT.assetManager.isLoaded(filePath)) {
            return
        }

        val batch = SpriteBatch()
        batch.begin()

        batch.draw(
                UIKT.assetManager.get(filePath, Texture::class.java),
                transform.trueX, transform.trueY, transform.trueWidth, transform.trueHeight
        )

        batch.end()
        batch.dispose() // TODO more efficient way
    }

}