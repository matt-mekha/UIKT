package matt.mekha.uikt.elements

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import matt.mekha.uikt.util.Transform

abstract class Element(val transform: Transform) {

    var parent: Element? = null
        set(value) {
            parent?.removeChild(this)
            value?.addChild(this)

            field = value

            resize()
        }
    private val children = ArrayList<Element>()

    private var firstDraw = true

    private fun removeChild(child: Element) {
        children.remove(child)
    }

    private fun addChild(child: Element) {
        children.add(child)
    }

    open fun resize() {
        transform.calculate(this)
        for (child in children) {
            child.resize()
        }
    }

    fun raycast(x: Float, y: Float) : Interactable? {
        var bestResult: Interactable? = null
        for (child in children) {
            val result = child.raycast(x, y)
            if (result != null && (bestResult == null || result.transform.zIndex >= bestResult.transform.zIndex)) {
                bestResult = result
            }
        }
        return if (bestResult == null && this is Button && transform.bounds.contains(x, y)) {
            this
        } else {
            bestResult
        }
    }

    fun drawEverything(batch: SpriteBatch) {
        if(firstDraw) {
            firstDraw = false
            firstDraw()
        }
        draw(batch)
        children.sortBy { it.transform.zIndex }
        for (child in children) {
            child.drawEverything(batch)
        }
    }

    open fun firstDraw() {}

    open fun draw(batch: SpriteBatch) {
        throw NotImplementedError()
    }

}