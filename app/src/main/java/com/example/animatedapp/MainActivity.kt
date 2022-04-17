package com.example.animatedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonShowFragmentA = findViewById<Button>(R.id.button_show_fragment)

        if (savedInstanceState == null) {
            buttonShowFragmentA.setOnClickListener {
                showFragmentA()
            }
        }
    }

    private fun showFragmentA() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.right_in,
                R.anim.right_out,
                R.anim.right_in,
                R.anim.right_out
            )
            .replace(R.id.fragment_container_view, FragmentA())
            .addToBackStack(null)
            .commit()
    }
}