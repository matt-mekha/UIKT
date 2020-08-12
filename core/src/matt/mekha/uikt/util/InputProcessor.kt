package matt.mekha.uikt.util

import com.badlogic.gdx.InputAdapter
import matt.mekha.uikt.elements.Interactable
import matt.mekha.uikt.elements.Scene

object InputProcessor : InputAdapter() {

    private var buttonLastHover: Interactable? = null
    private var buttonLastMouseDown: Interactable? = null

    private fun raycast(x: Int, y: Int) : Interactable? = Scene.raycast(x.toFloat(), Scene.size.y - y)

    override fun touchDown(x: Int, y: Int, pointer: Int, button: Int): Boolean {
        val hit = raycast(x, y)
        hit?.mouseDown = true
        buttonLastMouseDown = hit

        return true
    }

    override fun touchUp(x: Int, y: Int, pointer: Int, button: Int): Boolean {
        val hit = raycast(x, y)
        buttonLastMouseDown?.mouseDown = false
        if (hit == buttonLastMouseDown) {
            buttonLastMouseDown?.onClick()
        }

        return true
    }

    override fun mouseMoved(x: Int, y: Int): Boolean {
        val hit = raycast(x, y)
        if (hit != buttonLastHover) {
            buttonLastHover?.mouseHovering = false
            buttonLastHover = hit
            hit?.mouseHovering = true
        }

        return true
    }

}