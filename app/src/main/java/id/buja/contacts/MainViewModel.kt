package id.buja.contacts

import androidx.lifecycle.ViewModel
import id.buja.contacts.model.Contact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by Julsapargi Nursam on 14/10/22
 * Mobile Engineer - Android
 */

class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState get() = _uiState.asStateFlow()

    init {
        val list: MutableList<Contact> = mutableListOf()
        repeat(10) {
            list.add(
                Contact(
                    title = "Tesla $it",
                    description = "Apo Kaba kini ko, lai sehat ?",
                    image = R.drawable.electric_car_rf_rmpl_01
                )
            )
        }
        _uiState.update {
            it.copy(
                list = list
            )
        }
    }
}

data class MainUiState(
    val list: List<Contact> = emptyList()
)