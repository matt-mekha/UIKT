package matt.mekha.uikt

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import matt.mekha.uikt.elements.Scene

public object UIKT : ApplicationAdapter() {

    private lateinit var batch: SpriteBatch

    override fun create() {
        batch = SpriteBatch()
        Scene.resize()
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        Scene.drawEverything(batch)
        batch.end()
    }

    override fun resize(width: Int, height: Int) {
        Scene.resize()
    }

    override fun dispose() {
        batch.dispose()
    }

    public fun init(windowConfig: WindowConfig) {
        val config = LwjglApplicationConfiguration()

        config.width = windowConfig.width
        config.height = windowConfig.height
        config.resizable = windowConfig.resizeable
        config.fullscreen = windowConfig.fullscreen

        LwjglApplication(this, config)
    }

}