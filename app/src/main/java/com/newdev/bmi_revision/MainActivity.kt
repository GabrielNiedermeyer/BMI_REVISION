 package com.newdev.bmi_revision

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight : EditText = findViewById(R.id.edt_Weight)
        val edtHeight :EditText = findViewById(R.id.edt_Height)
        val btnCalculate : Button = findViewById(R.id.btn_Calculate)

        btnCalculate.setOnClickListener {
            val weighStr = edtWeight.text.toString()
            val heightStr = edtHeight.text.toString()

            if (weighStr.isNotEmpty() && heightStr.isNotEmpty()){
                val weight : Float = weighStr.toFloat()
                val height : Float = heightStr.toFloat()

                val finalHeight : Float = height * height
                val result :  Float = weight / finalHeight

                val intent = Intent(this, ResultActivity:: class.java)

                    .apply {
                        putExtra("EXTRA_RESULT",result)
                    }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Fill up all empty spaces !!", Toast.LENGTH_LONG).show()
            }
        }
    }
}