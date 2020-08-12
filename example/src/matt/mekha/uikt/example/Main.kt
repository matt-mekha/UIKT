package matt.mekha.uikt.example

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Vector2
import matt.mekha.uikt.UIKT
import matt.mekha.uikt.elements.*
import matt.mekha.uikt.util.WindowConfig
import matt.mekha.uikt.util.Transform

fun main() {
    UIKT.init(WindowConfig())

    val button1 = ImageSwitchButton(
            Transform(
                    anchor = Vector2(0.5F, 0.5F),
                    width = 200f,
                    height = 100f,
                    yPivot = 0f,
                    yOffset = 10f
            ),
            "ButtonIdle.png",
            "ButtonHover.png",
            "ButtonHeld.png"
    ) { println("click!") }

    val button2 = ImageTintButton(
            Transform(
                    anchor = Vector2(0.5F, 0.5F),
                    width = 200f,
                    height = 100f,
                    yPivot = 1f,
                    yOffset = -10f
            ),
            "ButtonIdle.png",
            hoverImageTint = Color.SKY,
            heldImageTint = Color.YELLOW
    ) { println("click!") }

    button1.parent = Scene
    button2.parent = Scene
}