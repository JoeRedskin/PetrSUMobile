package com.example.petrsumobile.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.example.petrsumobile.R
import com.example.petrsumobile.schedule.ScheduleWeekAdapter.ScheduleWeekViewHolder

class ScheduleWeekAdapter : RecyclerView.Adapter<ScheduleWeekViewHolder>() {
    private val viewPool = RecycledViewPool()
    private val scheduleWeekList = mutableListOf<List<Schedule>>()
    private val weekNames = arrayOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleWeekViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.schedule_list, parent, false)
        return ScheduleWeekViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleWeekViewHolder, listPosition: Int) {
        val scheduleList = scheduleWeekList[listPosition]
        val subItemAdapter = ScheduleAdapter(scheduleList)

        holder.textViewScheduleWeek.text = weekNames[listPosition]
        holder.rvSubItem.adapter = subItemAdapter
        holder.rvSubItem.setRecycledViewPool(viewPool)
    }

    override fun getItemCount(): Int = scheduleWeekList.size

    fun updateList(list: List<List<Schedule>>) {
        scheduleWeekList.clear()
        scheduleWeekList.addAll(list)
        notifyDataSetChanged()
    }

    class ScheduleWeekViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewScheduleWeek: TextView = itemView.findViewById<View>(R.id.textViewScheduleWeek) as TextView
        val rvSubItem: RecyclerView = itemView.findViewById(R.id.recycle_view_schedule_subitem)
    }
}