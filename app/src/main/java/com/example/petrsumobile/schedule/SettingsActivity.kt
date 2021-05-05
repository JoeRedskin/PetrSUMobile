package com.example.petrsumobile.schedule

import android.os.Bundle
import android.preference.Preference
import android.preference.Preference.OnPreferenceChangeListener
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.example.petrsumobile.R

//class SettingsActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.schedule_setting_fragment)
//    }
//
//    class SchedulePreferenceFragment : PreferenceFragment(), OnPreferenceChangeListener {
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            addPreferencesFromResource(R.xml.settings)
//            val groupNumber = findPreference(getString(R.string.settings_group_number_key))
//            bindPreferenceSummaryToValue(groupNumber)
//        }
//
//        override fun onPreferenceChange(preference: Preference, value: Any): Boolean {
//            val stringValue = value.toString()
//            preference.summary = stringValue
//            return true
//        }
//
//        private fun bindPreferenceSummaryToValue(preference: Preference) {
//            preference.onPreferenceChangeListener = this
//            val preferences = PreferenceManager.getDefaultSharedPreferences(preference.context)
//            val preferenceString = preferences.getString(preference.key, "")
//            onPreferenceChange(preference, preferenceString!!)
//        }
//    }
//}