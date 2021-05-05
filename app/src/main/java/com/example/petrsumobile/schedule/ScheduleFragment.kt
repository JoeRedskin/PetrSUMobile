package com.example.petrsumobile.schedule

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.petrsumobile.R
import com.example.petrsumobile.ScheduleDatabase
import com.google.android.material.tabs.TabLayout


class ScheduleFragment : Fragment() {

    private val recyclerView: RecyclerView by lazy {
        view?.findViewById<View>(R.id.recycle_view_weeks) as RecyclerView
    }
    private val tabLayout: TabLayout by lazy {
        view?.findViewById<View>(R.id.tabLayout) as TabLayout
    }
    private lateinit var viewModel: ScheduleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_schedule, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setupWithNavController(toolbar, findNavController())
        setHasOptionsMenu(true)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Room.databaseBuilder(view.context,
                ScheduleDatabase::class.java, "populus-database").fallbackToDestructiveMigration().build()
        val adapter = ScheduleWeekAdapter()

        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this, ScheduleViewModelFactory(ScheduleRepository(ScheduleRetrofitClient.retrofit, db.scheduleDao))).get(ScheduleViewModel::class.java)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(view.context)
        val groupNumber = sharedPreferences.getString(getString(R.string.settings_group_number_key),"")

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val schedule = viewModel.scheduleWeekType.value
                if (schedule != null){
                    if (tab.position == 0) {
                        adapter.updateList(schedule.numerator)
                    } else {
                        adapter.updateList(schedule.denominator)
                    }
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab) = Unit
            override fun onTabUnselected(tab: TabLayout.Tab) = Unit
        })

        viewModel.fetchSchedule(groupNumber.toString())
        viewModel.scheduleWeekType.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.updateList(it.denominator)
                print(it)
                if (tabLayout.selectedTabPosition == 0) {
                    adapter.updateList(it.numerator)
                } else {
                    adapter.updateList(it.denominator)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.settings_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settingsFragment -> {
                item.onNavDestinationSelected(findNavController())
            }
        }
        return true
    }

//    override fun onCreateLoader(id: Int, args: Bundle?): Loader<ArrayList<ScheduleWeekType>?> {
//        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
//        val groupNumber = sharedPrefs.getString(
//                getString(R.string.settings_group_number_key),
//                getString(R.string.settings_group_number_default))
//        val scheduleUrl = SCHEDULE_REQUEST_URL + groupNumber
//        return ScheduleLoader(this.context!!, scheduleUrl)
//    }

}