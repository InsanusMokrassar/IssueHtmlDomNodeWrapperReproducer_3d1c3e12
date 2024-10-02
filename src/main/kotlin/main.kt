import androidx.compose.runtime.*
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposableInBody

private lateinit var composition: Composition

fun main() {
    composition = renderComposableInBody {
        Body()
    }
}

@Composable
fun Body() {
    Div { Text("1 (Compose)") }
    Div { Text("2 (Compose)") }
    Div { Text("3 (Compose)") }

    var counter by remember { mutableStateOf(3) }

    remember(counter) {
        window.setTimeout(
            {
                if (counter > 0) {
                    counter--
                } else {
                    composition.dispose()
                }
            },
            1000
        )
    }

    Div { Text(counter.toString()) }
}
