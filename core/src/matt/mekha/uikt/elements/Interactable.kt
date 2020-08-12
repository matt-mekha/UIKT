package matt.mekha.uikt.elements

import matt.mekha.uikt.util.Transform

interface Interactable {
    val transform: Transform

    var mouseHovering: Boolean
    var mouseDown: Boolean

    fun onClick()
}