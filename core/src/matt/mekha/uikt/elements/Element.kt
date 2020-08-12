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

    open fun draw() {
        throw NotImplementedError()
    }

}