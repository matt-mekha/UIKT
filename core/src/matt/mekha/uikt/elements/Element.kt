package matt.mekha.uikt.elements

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import matt.mekha.uikt.util.Transform

abstract class Element {

    public var transform: Transform? = null
        set(value) {
            value?.attachedElement = this
            field = value
        }

    public var parent: Element? = null
        set(value) {
            parent?.removeChild(this)
            value?.addChild(this)

            field = value

            transform?.calculate()
        }
    private val children = ArrayList<Element>()

    private fun removeChild(child: Element) {
        children.remove(child)
    }

    private fun addChild(child: Element) {
        children.add(child)
    }

    fun drawEverything(batch: SpriteBatch) {
        draw(batch)
        for (child in children) {
            child.draw(batch)
        }
    }

    open fun resize() {
        transform?.calculate()
        for (child in children) {
            child.resize()
        }
    }

    open fun draw(batch: SpriteBatch) {
        throw NotImplementedError()
    }

}