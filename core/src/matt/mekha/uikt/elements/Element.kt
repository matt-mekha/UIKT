package matt.mekha.uikt.elements

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

    private fun removeChild(child: Element) {
        children.remove(child)
    }

    private fun addChild(child: Element) {
        children.add(child)
    }

    fun drawEverything() {
        draw()
        children.sortBy { it.transform.zIndex }
        for (child in children) {
            child.drawEverything()
        }
    }

    open fun resize() {
        transform.calculate(this)
        for (child in children) {
            child.resize()
        }
    }

    open fun draw() {
        throw NotImplementedError()
    }

}