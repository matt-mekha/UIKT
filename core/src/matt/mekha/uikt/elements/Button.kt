package matt.mekha.uikt.elements

import matt.mekha.uikt.util.Transform

abstract class Button(transform: Transform) : Element(transform), Interactable {
    override fun onMouseDown() {}
    override fun onMouseUp() {}
    override fun onClick() {}
    override fun onHoverEnter() {}
    override fun onHoverExit() {}
}