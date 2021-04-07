//package com.example.petrsumobile.schedule
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
//import com.example.petrsumobile.R
//import com.example.petrsumobile.schedule.ScheduleWeekAdapter.ScheduleWeekViewHolder
//import java.util.*
//
//class ScheduleWeekAdapter(private val context: Context?, private val scheduleWeekArrayList: ArrayList<ScheduleWeek?>?) : RecyclerView.Adapter<ScheduleWeekViewHolder>() {
//    private val viewPool = RecycledViewPool()
//
//    class ScheduleWeekViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val textViewScheduleWeek: TextView
//        val rvSubItem: RecyclerView
//
//        init {
//            textViewScheduleWeek = itemView.findViewById<View>(R.id.textViewScheduleWeek) as TextView
//            rvSubItem = itemView.findViewById(R.id.recycle_view_schedule_subitem)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleWeekViewHolder {
//        val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.schedule_list, parent, false)
//        return ScheduleWeekViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ScheduleWeekViewHolder, listPosition: Int) {
//        val scheduleWeek = scheduleWeekArrayList!![listPosition]
//        holder.textViewScheduleWeek.text = scheduleWeek.getNameWeek()
//        val layoutManager = LinearLayoutManager(holder.rvSubItem.context)
//        layoutManager.initialPrefetchItemCount = scheduleWeek.getScheduleArrayList().size
//        val subItemAdapter = ScheduleAdapter(context, scheduleWeek.getScheduleArrayList())
//        holder.rvSubItem.layoutManager = layoutManager
//        holder.rvSubItem.adapter = subItemAdapter
//        holder.rvSubItem.setRecycledViewPool(viewPool)
//    }
//
//    override fun getItemCount(): Int {
//        return scheduleWeekArrayList!!.size
//    }
//}