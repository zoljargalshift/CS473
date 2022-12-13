package com.miu.curriculumvitae.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.miu.curriculumvitae.R
import com.miu.curriculumvitae.common.FlowLayout
import com.miu.curriculumvitae.common.Person
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.item_small.view.*


class EduFragment : Fragment() {
    private val KEY = "user"
    private lateinit var person: Person

    fun newInstance(person: Person): EduFragment {
        val args = Bundle()
        val fragment = EduFragment()
        args.putSerializable(KEY, person)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.about, container, false)
        person = arguments?.getSerializable(KEY) as Person

        val education = view.findViewById<LinearLayout>(R.id.educations)
        val cert = view.findViewById<FlowLayout>(R.id.certificates)

        for (edu in person.educations) {
            val item = inflater.inflate(R.layout.item, container, false)
            item.title.text= edu.title
            item.place.text= edu.school
            item.year.text=edu.year
            education.addView(item)
        }

        for (certificate in person.certificates) {
            val item = inflater.inflate(R.layout.item_small, container, false)
            item.item_txtView.text = certificate
            item.item_txtView.setBackgroundResource(R.drawable.yellow)
            cert.addView(item)
        }

        return view
    }
}
