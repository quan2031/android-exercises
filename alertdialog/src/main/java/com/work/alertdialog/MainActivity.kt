package com.work.alertdialog

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    showDialogBtn.setOnClickListener { showDialog() }
  }
  private fun showDialog(){
    val builder = AlertDialog.Builder(this)
    builder.setTitle("Dialog")
    builder.setMessage("This is a message!")
    builder.setIcon(R.drawable.ic_launcher_background)
    builder.setPositiveButton("YES"){dialog: DialogInterface?, which: Int ->
      Toast.makeText(this, "CLICK YES!!", Toast.LENGTH_LONG).show()
    }
    builder.setNeutralButton("CANCEL"){dialog: DialogInterface?, which: Int ->
      Toast.makeText(this, "CLICK CANCEL!!", Toast.LENGTH_LONG).show()
    }
    val alertDialog: AlertDialog = builder.create()
    alertDialog.setCancelable(false)
    alertDialog.show()
  }
}
