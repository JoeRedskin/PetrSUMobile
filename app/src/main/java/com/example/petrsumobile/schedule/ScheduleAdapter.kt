//package com.example.petrsumobile.schedule
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageButton
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.petrsumobile.R
//import com.example.petrsumobile.schedule.ScheduleAdapter.ScheduleViewHolder
//import java.util.*
//
//class ScheduleAdapter(private val context: Context?, private val scheduleArrayList: ArrayList<Schedule?>?) : RecyclerView.Adapter<ScheduleViewHolder>() {
//    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var textViewScheduleTitle: TextView
//        var textViewScheduleTimeEnd: TextView
//        var textViewScheduleTimeStart: TextView
//        var textViewScheduleType: TextView
//        var textViewScheduleLecturer: TextView
//        var textViewScheduleClassroom: TextView
//        var showOnMapButton: ImageButton
//        var lineView: View
//
//        init {
//            textViewScheduleTitle = itemView.findViewById<View>(R.id.textViewScheduleTitle) as TextView
//            textViewScheduleTimeEnd = itemView.findViewById<View>(R.id.textViewScheduleTimeEnd) as TextView
//            textViewScheduleTimeStart = itemView.findViewById<View>(R.id.textViewScheduleTimeStart) as TextView
//            textViewScheduleType = itemView.findViewById<View>(R.id.textViewScheduleType) as TextView
//            textViewScheduleLecturer = itemView.findViewById<View>(R.id.textViewScheduleLecturer) as TextView
//            textViewScheduleClassroom = itemView.findViewById<View>(R.id.textViewScheduleClassroom) as TextView
//            showOnMapButton = itemView.findViewById<View>(R.id.showOnMapButton) as ImageButton
//            lineView = itemView.findViewById(R.id.lineView) as View
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
//        val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.schedule_item, parent, false)
//        return ScheduleViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ScheduleViewHolder, listPosition: Int) {
//        val schedule = scheduleArrayList!![listPosition]
//        val textViewScheduleClassroom = holder.textViewScheduleClassroom
//        val textViewScheduleLecturer = holder.textViewScheduleLecturer
//        val textViewScheduleTitle = holder.textViewScheduleTitle
//        val textViewScheduleTimeEnd = holder.textViewScheduleTimeEnd
//        val textViewScheduleTimeStart = holder.textViewScheduleTimeStart
//        val textViewScheduleType = holder.textViewScheduleType
//        val showOnMapButton = holder.showOnMapButton
//        val lineView = holder.lineView
//
//
////        String titleBefore = schedule.getTitle().toUpperCase();
////        String[] titles = titleBefore.split(" ");
////        StringBuilder titleAfter = new StringBuilder();
////        for (String title : titles) {
////            switch (title) {
////                case "ЛАБОРАТОРНЫЕ":
////                    titleAfter.append("Лаборарная работа ");
////                    break;
////                case "ЛЕКЦИИ":
////                    titleAfter.append("Лекция ");
////                    break;
////                case "ДИСТАНТ":
////                    titleAfter.append("Дистант ");
////                    break;
////                default:
////                    titleAfter.append("ЛАБ");
////                    break;
////            }
////        }
//        if (listPosition == scheduleArrayList.size - 1) {
//            lineView.visibility = View.GONE
//        } else {
//            lineView.visibility = View.VISIBLE
//        }
//        if (schedule.getClassroom() == "") {
//            textViewScheduleClassroom.visibility = View.GONE
//            showOnMapButton.visibility = View.INVISIBLE
//        } else {
//            textViewScheduleClassroom.visibility = View.VISIBLE
//            //TODO: убрать эту строку
//            showOnMapButton.visibility = View.INVISIBLE
//            //            showOnMapButton.setVisibility(View.VISIBLE);
//        }
//        textViewScheduleClassroom.text = schedule.getClassroom()
//        textViewScheduleLecturer.text = schedule.getLecturer()
//        textViewScheduleTitle.text = schedule.getTitle()
//        textViewScheduleTimeEnd.text = schedule.getEndTime()
//        textViewScheduleTimeStart.text = schedule.getStartTime()
//        textViewScheduleType.text = schedule.getType()
//    }
//
//    override fun getItemCount(): Int {
//        return scheduleArrayList!!.size
//    }
//}