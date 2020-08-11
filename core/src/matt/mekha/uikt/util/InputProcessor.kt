package matt.mekha.uikt.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputAdapter
import matt.mekha.uikt.elements.Button
import matt.mekha.uikt.elements.Scene

object InputProcessor : InputAdapter() {

    init {
        Gdx.input.inputProcessor = this
    }

    private var buttonLastHover: Button? = null
    private var buttonLastMouseDown: Button? = null

    override fun touchDown(x: Int, y: Int, pointer: Int, button: Int): Boolean {
        val hit = Scene.raycast(x, y)
        hit?.onMouseDown()
        buttonLastMouseDown = hit

        return true
    }

    override fun touchUp(x: Int, y: Int, pointer: Int, button: Int): Boolean {
        val hit = Scene.raycast(x, y)
        buttonLastMouseDown?.onMouseUp()
        if (hit == buttonLastMouseDown) {
            buttonLastMouseDown?.onClick()
        }

        return true
    }

    override fun mouseMoved(x: Int, y: Int): Boolean {
        val hit = Scene.raycast(x, y)
        if (hit != buttonLastHover) {
            buttonLastHover?.onHoverExit()
            buttonLastHover = hit
            hit?.onHoverEnter()
        }

        return true
    }

}