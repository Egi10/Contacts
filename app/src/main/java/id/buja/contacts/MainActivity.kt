package id.buja.contacts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import id.buja.contacts.component.ContactToolbar
import id.buja.contacts.model.Contact

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalLifecycleComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val data = viewModel.uiState.collectAsStateWithLifecycle()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ContactToolbar(
                    title = getString(R.string.contacts)
                )

                LazyColumn(
                    contentPadding = PaddingValues(
                        all = 16.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    content = {
                        items(
                            items = data.value.list,
                            key = {
                                it.title
                            }
                        ) {
                            ItemContact(
                                contact = it
                            )
                        }
                    }
                )
            }
        }
    }
}

@Composable
internal fun ItemContact(
    contact: Contact
) {
    // Runtime
    var sizeImage by remember { mutableStateOf(Size.Zero) }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = contact.image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .onGloballyPositioned { coordinates ->
                    sizeImage = coordinates.size.toSize()
                }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(
                    height = with(LocalDensity.current) {
                        sizeImage.width.toDp()
                    }
                )
                .padding(start = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = contact.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = contact.description
            )
        }
    }
}

@Preview
@Composable
private fun ItemContentPreview() {
    ItemContact(
        contact = Contact(
            image = R.drawable.electric_car_rf_rmpl_01,
            title = "Tesla",
            description = "Apo kaba yuang ?"
        )
    )
}