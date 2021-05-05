package com.example.petrsumobile.schedule

import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.preference.EditTextPreference
import androidx.preference.Preference.SummaryProvider
import androidx.preference.PreferenceFragmentCompat
import com.example.petrsumobile.R


class SettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.schedule_setting_fragment, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        NavigationUI.setupWithNavController(toolbar, findNavController())

        parentFragmentManager.beginTransaction().replace(
                R.id.settings_container,
                SchedulePreferenceFragment()
        ).commit()

        return view
    }

    class SchedulePreferenceFragment : PreferenceFragmentCompat() {

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            addPreferencesFromResource(R.xml.settings)

            val numberPreference: EditTextPreference? = findPreference(getString(R.string.settings_group_number_key))

            numberPreference?.summaryProvider = SummaryProvider<EditTextPreference> { preference ->
                val text = preference.text
                if (TextUtils.isEmpty(text)) {
                    "Группа не указана"
                } else {
                    numberPreference?.setDefaultValue(text)
                    text
                }
            }
            numberPreference?.setOnBindEditTextListener { editText ->
                editText.inputType = InputType.TYPE_CLASS_NUMBER
            }
        }
    }
}