package matt.mekha.uikt.elements

import matt.mekha.uikt.util.Transform

abstract class Button(transform: Transform, private val onClickAction: (() -> Unit)?) : Element(transform), Interactable {

    var buttonState = ButtonState.IDLE

    override var mouseDown = false
        set(value) {
            field = value
            updateDisplay()
        }

    override var mouseHovering = false
        set(value) {
            field = value
            updateDisplay()
        }

    override fun onClick() {
        onClickAction?.invoke()
    }

    private fun updateDisplay() {
        buttonState = when {
            mouseDown -> ButtonState.HELD
            mouseHovering -> ButtonState.HOVER
            else -> ButtonState.IDLE
        }
    }

    enum class ButtonState {
        IDLE,
        HOVER,
        HELD
    }

}