package matt.mekha.uikt

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import matt.mekha.uikt.elements.Scene
import matt.mekha.uikt.util.InputProcessor
import matt.mekha.uikt.util.WindowConfig

object UIKT : ApplicationAdapter() {

    internal val assetManager = AssetManager()
    private lateinit var spriteBatch: SpriteBatch

    override fun create() {
        spriteBatch = SpriteBatch()
        Gdx.input.inputProcessor = InputProcessor
        Scene.resize()
    }

    override fun render() {
        assetManager.update()
        spriteBatch.begin()
        Scene.drawEverything(spriteBatch)
        spriteBatch.end()
    }

    override fun resize(width: Int, height: Int) {
        Scene.resize()
    }

    override fun dispose() {
        spriteBatch.dispose()
    }

    fun init(windowConfig: WindowConfig) {
        val config = LwjglApplicationConfiguration()

        config.width = windowConfig.width
        config.height = windowConfig.height
        config.resizable = windowConfig.resizeable
        config.fullscreen = windowConfig.fullscreen

        LwjglApplication(this, config)
    }

}