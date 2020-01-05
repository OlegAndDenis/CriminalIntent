package com.example.android.criminalintent


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_crime.*
import kotlinx.android.synthetic.main.fragment_crime.view.*

/**
 * A simple [Fragment] subclass.
 */
class CrimeFragment : Fragment() {
    private lateinit var crime: Crime
//    private lateinit var titleField: EditText
//    private lateinit var dateButton: Button
//    private lateinit var solvedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)

//        titleField = view.findViewById(R.id.crime_title) as EditText
//        dateButton = view.findViewById(R.id.crime_date) as Button
//        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox

        view.crime_date.apply {
            text = crime.date.toString()
            isEnabled = false
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                // This space intentionally left blank
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {
                // This one too
            }
        }

        crime_title.addTextChangedListener(titleWatcher)

        crime_solved.apply {
            setOnCheckedChangeListener { _, isChecked ->
                crime.isSolved = isChecked
            }
        }

    }
}