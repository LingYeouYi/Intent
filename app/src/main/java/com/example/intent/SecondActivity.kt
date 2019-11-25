package com.example.intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra(MainActivity.KEY)
        val num = intent.getIntExtra(MainActivity.LUCKY, 0)
        textView2.text = String.format("%s %s", getString(R.string.message), message)
        textViewLuckyNum.text = String.format("%s %d", getString(R.string.lucky_num), num)

        button2.setOnClickListener{
            if(!editTextReply.text.isEmpty()){
                val reply = editTextReply.text.toString()
                val intent = getIntent()  // return the MainActivity intent
                intent.putExtra(MainActivity.REPLY, reply)

                // Inform the MainActivity that everything is okay
                setResult(Activity.RESULT_OK, intent)
            }
            else{
                setResult(Activity.RESULT_CANCELED)
            }

            finish()
        }
    }
}
