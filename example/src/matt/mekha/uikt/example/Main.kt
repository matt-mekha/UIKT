package matt.mekha.uikt.example

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Vector2
import matt.mekha.uikt.UIKT
import matt.mekha.uikt.elements.Image
import matt.mekha.uikt.elements.Rectangle
import matt.mekha.uikt.util.WindowConfig
import matt.mekha.uikt.elements.Scene
import matt.mekha.uikt.util.Transform

fun main() {
    UIKT.init(WindowConfig())

    val rect = Rectangle(Color.GRAY, Transform(
            anchor = Vector2(0.5F, 0.5F),
            width = 300f,
            height = 300f
    ))

    val img = Image("image.png", Transform(
            anchor = Vector2(0.5F, 0.5F),
            width = 256f,
            height = 256f,
            zIndex = 1
    ))

    rect.parent = Scene
    img.parent = Scene
}