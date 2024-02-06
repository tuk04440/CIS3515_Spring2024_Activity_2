package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 1: Populate this array */
        val numberArray = Array(50) {i -> (i+1) *2}

        /* TODO Step 2: Create adapter to display items from array in Spinner */
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, numberArray)

        // TODO Step 3: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                view?.run{
                    val size = (this as TextView).text.toString().toFloat()
                    displayTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
                }        }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }
}