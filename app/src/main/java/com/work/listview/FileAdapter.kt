package com.work.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class FileAdapter(private val context: Context, private val listFile: Array<File>): BaseAdapter() {
    class ViewHolder(row: View){
        var name: TextView
        var date: TextView
        init {
            name = row.findViewById(R.id.name) as TextView
            date = row.findViewById(R.id.date) as TextView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null){
            var layoutInflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.custom_row, null)
            viewHolder =
                ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }
        var file: File = getItem(position) as File
        viewHolder.name.text = file.name
        viewHolder.date.text = file.date.toString()
        return view as View
    }

    override fun getItem(position: Int): Any {
        return listFile.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listFile.size
    }
}