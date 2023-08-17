package com.newdev.bmi_revision

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ResultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)


        val tvResult = findViewById<TextView>(R.id.textViewResult)
        val tvClassification = findViewById<TextView>(R.id.textViewClassification)
        val result = intent.getFloatExtra("EXTRA_RESULT",0.1f)

        tvResult.text = result.toString()

        val classification = if (result < 18.5f){
            "Under Wheight"
        }else if(result in 18.5f..24.9f){
            "Normal Wheight"
        }else if(result in 25f..29.9f){
            "Over Wheight"
            }else if(result in 30f..34.9f){
                "Obese"
            }else {
                "Extremely obese"
}
        tvClassification.text = getString(R.string.MessageClassification,classification)
        tvClassification.setTextColor(ContextCompat.getColor(this, R.color.purple))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}
