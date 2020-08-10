package matt.mekha.uikt

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import matt.mekha.uikt.elements.Scene

object UIKT : ApplicationAdapter() {

    override fun create() {
        Scene.resize()
    }

    override fun render() {
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