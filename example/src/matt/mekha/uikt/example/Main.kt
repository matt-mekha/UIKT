package matt.mekha.uikt.example

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Vector2
import matt.mekha.uikt.UIKT
import matt.mekha.uikt.WindowConfig
import matt.mekha.uikt.elements.Rectangle
import matt.mekha.uikt.elements.Scene
import matt.mekha.uikt.util.Transform


fun main() {
    val config = WindowConfig()
    UIKT.init(config)

    val bigRect = Rectangle(Color.RED, Transform(anchorMin = Vector2(0F, 0F), anchorMax = Vector2(0.5F, 0.5F)))
    val smallRect = Rectangle(Color.BLUE, Transform(anchor = Vector2(0.5F, 0.5F), width = 100F, height = 100F))

    bigRect.parent = Scene
    smallRect.parent = bigRect
}