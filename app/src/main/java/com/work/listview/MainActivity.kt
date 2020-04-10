package com.work.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.util.*

data class File(val name: String, val date: LocalDate)
fun selector(p: File): String = p.name

class MainActivity : AppCompatActivity() {
  private var listFile = arrayOf(
    File("FILE 1", LocalDate.parse("2020-01-07")),
    File("ALa 2", LocalDate.parse("2020-03-06")),
    File("FILE 3", LocalDate.parse("2020-01-05")),
    File("BIY 4", LocalDate.parse("2020-02-04")),
    File("TMP 5", LocalDate.parse("2020-01-03")),
    File("BOOT 6", LocalDate.parse("2020-07-02")),
    File("SDA 7", LocalDate.parse("2020-01-01"))
  )
  private var sortDateAsc: Boolean = true
  private var sortNameAsc: Boolean = true
  private var sortIcon: String = "▼"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    lisview.adapter = FileAdapter(this, listFile)
    sortDateBtn.setOnClickListener{sortByDate()}
    sortNameBtn.setOnClickListener{sortByName()}
  }

  private fun sortByDate(){
    if (sortDateAsc) {
      listFile.sortBy { it.date }
      sortIcon = "▲"
    }else {
      sortIcon = "▼"
      listFile.sortByDescending { it.date }
    }
    sortDateBtn.text = sortIcon
    sortNameBtn.text = "■"
    sortDateAsc = !sortDateAsc
    lisview.adapter = FileAdapter(this, listFile)
  }
  private fun sortByName(){
    if (sortNameAsc) {
      listFile.sortBy { it.name }
      sortIcon = "▼"
    }else {
      sortIcon = "▲"
      listFile.sortByDescending { it.name }
    }
    sortNameBtn.text = sortIcon
    sortDateBtn.text = "■"
    sortNameAsc = !sortNameAsc
    lisview.adapter = FileAdapter(this, listFile)
  }
}
