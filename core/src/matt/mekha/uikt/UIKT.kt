package matt.mekha.uikt

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import matt.mekha.uikt.elements.Scene
import matt.mekha.uikt.util.InputProcessor
import matt.mekha.uikt.util.WindowConfig

object UIKT : ApplicationAdapter() {

    internal val assetManager = AssetManager()

    override fun create() {
        Gdx.input.inputProcessor = InputProcessor
        Scene.resize()
    }

    override fun render() {
        assetManager.update()
        Scene.drawEverything()
    }

    override fun resize(width: Int, height: Int) {
        Scene.resize()
    }

    override fun dispose() {
        // TODO Scene.dispose()
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