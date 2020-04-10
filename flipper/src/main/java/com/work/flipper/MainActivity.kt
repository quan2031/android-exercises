package com.work.flipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast
import com.work.listview.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popup.*
import kotlinx.android.synthetic.main.webview.*
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
    showPopup.setOnClickListener { showPopup() }
    webView.loadUrl("https://www.javatpoint.com/kotlin-android-webview")
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

  private fun showPopup(){
    val popupMemu = PopupMenu(this, showPopup)
    popupMemu.menuInflater.inflate(R.menu.menu_popup, popupMemu.menu)
    popupMemu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
      Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
      true
    })
    popupMemu.show()
  }
}
