package id.buja.contacts.component

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

/**
 * Created by Julsapargi Nursam on 14/10/22
 * Mobile Engineer - Android
 */

class ContactToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    var titleText by mutableStateOf("")

    @Composable
    override fun Content() {
        MaterialTheme {
            ContactToolbar(
                title = titleText
            )
        }
    }
}

@Composable
fun ContactToolbar(title: String) {
    TopAppBar(
        backgroundColor = Color.White
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color(0xFF676767)
        )
    }
}

@Preview
@Composable
private fun ContactToolbarPreview() {
    ContactToolbar(
        title = "Contact"
    )
}