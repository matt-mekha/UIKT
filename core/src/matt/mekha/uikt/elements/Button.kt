package matt.mekha.uikt.elements

import matt.mekha.uikt.util.Transform

abstract class Button(transform: Transform) : Element(transform) {
    fun onMouseDown() {}
    fun onMouseUp() {}
    fun onClick() {}
    fun onHoverEnter() {}
    fun onHoverExit() {}
}