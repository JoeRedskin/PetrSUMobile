//package com.example.petrsumobile.schedule
//
//import android.content.Intent
//import android.os.Bundle
//import android.preference.PreferenceManager
//import android.view.*
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
//import androidx.loader.app.LoaderManager
//import androidx.loader.content.Loader
//import androidx.recyclerview.widget.DefaultItemAnimator
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.petrsumobile.R
//import java.util.*
//
////import com.xwray.groupie.GroupAdapter;
///**
// * A simple [Fragment] subclass.
// */
//class ScheduleFragment : Fragment(), LoaderManager.LoaderCallbacks<ArrayList<ScheduleWeekType>?> {
//    private val scheduleWeekTypeArrayList = ArrayList<ScheduleWeekType>()
//    var scheduleWeekArrayList: ArrayList<ScheduleWeek?>? = ArrayList()
//    private var layoutManager: RecyclerView.LayoutManager? = null
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        updateRecyclerView()
//    }
//
//    fun updateRecyclerView() {
//        recyclerView = this.activity!!.findViewById<View>(R.id.recycle_view_weeks) as RecyclerView
//        layoutManager = LinearLayoutManager(activity)
//        recyclerView!!.layoutManager = layoutManager
//        recyclerView!!.itemAnimator = DefaultItemAnimator()
//        if (scheduleWeekTypeArrayList.size != 0) {
//            scheduleWeekArrayList = scheduleWeekTypeArrayList[0].scheduleWeekArrayList
//        }
//        adapter = ScheduleWeekAdapter(activity, scheduleWeekArrayList)
//        recyclerView!!.adapter = adapter
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view = inflater.inflate(R.layout.fragment_schedule, container, false)
//        setHasOptionsMenu(true)
//        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Расписание"
//        initLoaderManager(SCHEDULE_LOADER_ID)
//        // Log.d("TAG", String.valueOf(scheduleWeekdayTypeArrayList.size()));
//        return view
//    }
//
//    fun initLoaderManager(loaderId: Int) {
//        val loaderManager = loaderManager
//        loaderManager.initLoader(loaderId, null, this)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.settings_menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.action_settings -> {
//                val settingsIntent = Intent(activity, SettingsActivity::class.java)
//                startActivity(settingsIntent)
//            }
//        }
//        return true
//    }
//
//    override fun onCreateLoader(id: Int, args: Bundle?): Loader<ArrayList<ScheduleWeekType>?> {
//        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
//        val groupNumber = sharedPrefs.getString(
//                getString(R.string.settings_group_number_key),
//                getString(R.string.settings_group_number_default))
//        val scheduleUrl = SCHEDULE_REQUEST_URL + groupNumber
//        return ScheduleLoader(this.context!!, scheduleUrl)
//    }
//
//    override fun onLoadFinished(loader: Loader<ArrayList<ScheduleWeekType>?>, data: ArrayList<ScheduleWeekType>?) {
//        scheduleWeekTypeArrayList.clear()
//        scheduleWeekArrayList!!.clear()
//        if (data != null && !data.isEmpty()) {
//            //scheduleWeekdayTypeArrayList.addAll(data);
////            scheduleWeekdayArrayList = scheduleWeekdayTypeArrayList.
//////                    get(0).getScheduleWeekdayArrayList();
//            scheduleWeekArrayList!!.addAll(data[0].scheduleWeekArrayList)
//            adapter!!.notifyDataSetChanged()
//        }
//    }
//
//    override fun onLoaderReset(loader: Loader<ArrayList<ScheduleWeekType>?>) {
//        scheduleWeekTypeArrayList.clear()
//        scheduleWeekArrayList!!.clear()
//        adapter!!.notifyDataSetChanged()
//    }
//
//    companion object {
//        private var adapter: RecyclerView.Adapter<*>? = null
//        private var recyclerView: RecyclerView? = null
//        private const val SCHEDULE_REQUEST_URL = "https://petrsu.egipti.com/api/v2/schedule/"
//        private const val SCHEDULE_LOADER_ID = 1
//    }
//}