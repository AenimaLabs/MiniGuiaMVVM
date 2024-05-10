package jorgeandaurrios.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UserViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> get() = _name

    private val _greeting = MutableLiveData<String>()
    val greeting: LiveData<String> get() = _greeting

    fun setName(name: String) {
        _name.value = name
    }

    fun generateGreeting() {
        val currentName = _name.value ?: ""
        val greeting = "Hola, $currentName!"
        _greeting.value = greeting

    }
}