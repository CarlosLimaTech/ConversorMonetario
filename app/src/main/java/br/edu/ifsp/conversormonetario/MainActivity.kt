package br.edu.ifsp.conversormonetario

import android.util.Log
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val dollarValue = 5.50

    private lateinit var inputEditText: EditText
    private lateinit var toRealButton: Button
    private lateinit var toDollarButton: Button
    private lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate() called")
        findById()
        configClickListener()
    }

    override fun onClick(v: View) {
        if (v == toDollarButton) {
            dollarConversion()
        } else if (v == toRealButton) {
            realConversion()
        }
    }

    private fun findById() {
        inputEditText = findViewById(R.id.edittext_value)
        toDollarButton = findViewById(R.id.button_covert_to_dollar)
        toRealButton = findViewById(R.id.button_covert_to_real)
        outputTextView = findViewById(R.id.textview_output)
        Log.d("MainActivity", "findById() called")
    }

    private fun configClickListener() {
        toRealButton.setOnClickListener(this)
        toDollarButton.setOnClickListener(this)
        Log.d("MainActivity", "configClickListener() called")
    }

    private fun getValue(): Double {
        return try {
            inputEditText.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }
    }

    private fun dollarConversion() {
        var value = getValue()
        value /= dollarValue
        outputTextView.text = getString(R.string.converted_value, "U$$value")
    }

    private fun realConversion() {
        var value = getValue()
        value *= dollarValue
        outputTextView.text = getString(R.string.converted_value, "R$$value")
    }
}
