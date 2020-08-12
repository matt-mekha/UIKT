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
                    yOffset = 60f
            ),
            "ButtonIdle.png",
            "ButtonHover.png",
            "ButtonHeld.png"
    ) { println("click one!") }

    val button2 = RectangleTintButton(
            Transform(
                    anchor = Vector2(0.5F, 0.5F),
                    width = 200f,
                    height = 100f,
                    yOffset = -60f
            ),
            idleImageTint = Color.BLUE,
            hoverImageTint = Color.SKY,
            heldImageTint = Color.YELLOW
    ) { println("click two!") }

    val rect = Rectangle(
            Transform(
                    anchor = Vector2(0.5f, 0.5f),
                    width = 240f,
                    height = 260f
            ),
            Color.GRAY
    )

    button1.parent = rect
    button2.parent = rect
    rect.parent = Scene
}