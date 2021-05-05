package com.example.petrsumobile.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petrsumobile.R
import com.example.petrsumobile.schedule.ScheduleAdapter.ScheduleViewHolder

class ScheduleAdapter(private var scheduleList: List<Schedule>) : RecyclerView.Adapter<ScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.schedule_item, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, listPosition: Int) {
        val schedule = scheduleList[listPosition]
        val textViewScheduleClassroom = holder.textViewScheduleClassroom
        val textViewScheduleLecturer = holder.textViewScheduleLecturer
        val textViewScheduleTitle = holder.textViewScheduleTitle
        val textViewScheduleTimeEnd = holder.textViewScheduleTimeEnd
        val textViewScheduleTimeStart = holder.textViewScheduleTimeStart
        val textViewScheduleType = holder.textViewScheduleType
        val lineView = holder.lineView

        if (listPosition == scheduleList.size - 1) {
            lineView.visibility = View.GONE
        } else {
            lineView.visibility = View.VISIBLE
        }
        if (schedule.classroom == "") {
            textViewScheduleClassroom.visibility = View.GONE
        } else {
            textViewScheduleClassroom.visibility = View.VISIBLE
        }
        textViewScheduleClassroom.text = schedule.classroom
        textViewScheduleLecturer.text = schedule.lecturer
        textViewScheduleTitle.text = schedule.title
        textViewScheduleTimeEnd.text = schedule.endTime
        textViewScheduleTimeStart.text = schedule.startTime
        textViewScheduleType.text = schedule.type
    }

    override fun getItemCount(): Int = scheduleList.size

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewScheduleTitle = itemView.findViewById<View>(R.id.textViewScheduleTitle) as TextView
        var textViewScheduleTimeEnd = itemView.findViewById<View>(R.id.textViewScheduleTimeEnd) as TextView
        var textViewScheduleTimeStart = itemView.findViewById<View>(R.id.textViewScheduleTimeStart) as TextView
        var textViewScheduleType = itemView.findViewById<View>(R.id.textViewScheduleType) as TextView
        var textViewScheduleLecturer = itemView.findViewById<View>(R.id.textViewScheduleLecturer) as TextView
        var textViewScheduleClassroom = itemView.findViewById<View>(R.id.textViewScheduleClassroom) as TextView
        var lineView = itemView.findViewById(R.id.lineView) as View
    }
}