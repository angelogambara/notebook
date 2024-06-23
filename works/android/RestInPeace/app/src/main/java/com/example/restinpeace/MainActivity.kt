package com.example.restinpeace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var buttonSend: Button
    private lateinit var httpResponse: TextView
    private lateinit var httpStatus: TextView
    private lateinit var inputMethod: EditText
    private lateinit var inputName: EditText
    private lateinit var inputSurname: EditText
    private lateinit var inputPhone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = getText(R.string.app_name)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        buttonSend = findViewById(R.id.buttonSend)
        httpResponse = findViewById(R.id.httpResponse)
        httpStatus = findViewById(R.id.httpStatus)
        inputMethod = findViewById(R.id.inputMethod)
        inputName = findViewById(R.id.inputName)
        inputSurname = findViewById(R.id.inputSurname)
        inputPhone = findViewById(R.id.inputPhone)

        val payload =  "{\"telefono\":\"${inputPhone.text}\",\"nome\":\"${inputName.text}\",\"cognome\":\"${inputSurname.text}\"}"



    }
}