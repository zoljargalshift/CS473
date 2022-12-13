package com.miu.curriculumvitae.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miu.curriculumvitae.R
import com.miu.curriculumvitae.common.Person
import kotlinx.android.synthetic.main.home.view.*

class HomeFragment : Fragment() {

    private val KEY = "user"
    private lateinit var person: Person

    fun newInstance(person: Person): HomeFragment {
        val args = Bundle()
        val fragment = HomeFragment()
        args.putSerializable(KEY, person)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.home, container, false)
        person = arguments?.getSerializable(KEY) as Person

        view.name.text = "${person.fname} ${person.lname}"
        view.position.text = person.profession
        view.about.text = person.about
        view.avatar.setImageResource(person.avatar)

        return view
    }
}
