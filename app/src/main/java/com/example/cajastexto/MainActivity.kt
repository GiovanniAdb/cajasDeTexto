package com.example.cajastexto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val autoComplement = findViewById<AutoCompleteTextView>(R.id.autoComplementText)
        val opciones = resources.getStringArray(R.array.opciones)

        val materiaFavorit = findViewById<TextInputEditText>(R.id.materiaFavorita)
        val btn = findViewById<Button>(R.id.registrarBtn)

        var adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, opciones
        )
        autoComplement.setAdapter(adapter)

        val multiAutoComplete = findViewById<MultiAutoCompleteTextView>(R.id.lugares)
        val opcionesLugares = resources.getStringArray(R.array.opcionesLugares)
        var adapterLugares = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line, opcionesLugares
        )
        multiAutoComplete.setAdapter(adapterLugares)
        multiAutoComplete.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        val optionSBackground: CheckedTextView = findViewById(R.id.optionSBackground)
        optionSBackground.isChecked = optionSBackground.isChecked

        optionSBackground.setCheckMarkDrawable(android.R.drawable.checkbox_off_background)

        optionSBackground.setOnClickListener {

            optionSBackground.isChecked = !optionSBackground.isChecked

            optionSBackground.setCheckMarkDrawable(
                if (optionSBackground.isChecked) {
                    android.R.drawable.checkbox_off_background
                } else {
                    android.R.drawable.checkbox_on_background
                }
            )
        }
    }
    fun displayToast(view: View) =
        Toast.makeText(this, "Usuario registrado con exito",Toast.LENGTH_LONG).show()
}