package jorgeandaurrios.myapplication.view

import android.os.Bundle
import android.text.SpannableString
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import jorgeandaurrios.myapplication.R
import jorgeandaurrios.myapplication.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val textViewGreeting = findViewById<TextView>(R.id.txt_greeting)
        val buttonGenerateGreeting = findViewById<Button>(R.id.buttonGenerateGreeting)

        //Observa el nombre ingresado por el usuario
        viewModel.name.observe(this) { name ->
            editTextName.setText(name)
        }

        //Observa el saludo generado por el ViewModel
        viewModel.greeting.observe(this) { greeting ->
            val spannableGreeting = SpannableString(greeting)
            textViewGreeting.text = spannableGreeting
        }

        //Activa el botón para generar el saludo
        buttonGenerateGreeting.setOnClickListener {
            val name = editTextName.text.toString()
            viewModel.setName(name)
            viewModel.generateGreeting()
        }
    }
}