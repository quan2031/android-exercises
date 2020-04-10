package com.work.flipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import com.work.listview.R
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.util.*

data class File(val name: String, val date: LocalDate)
fun selector(p: File): String = p.name

class MainActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    nextBtn.setOnClickListener{nextView()}
    preBtn.setOnClickListener { previousView() }
  }

  private fun nextView(){
    viewFlipper.setInAnimation(this, android.R.anim.slide_in_left)
    viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right)
    viewFlipper.showNext()
  }
  private fun previousView(){
    viewFlipper.setInAnimation(this, R.anim.slide_in_right)
    viewFlipper.setOutAnimation(this, R.anim.slide_out_left)
    viewFlipper.showPrevious()
  }

}
