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

class WorkFragment : Fragment() {
    private val KEY = "user"
    private lateinit var person: Person

    fun newInstance(person: Person): WorkFragment {
        val args = Bundle()
        val fragment = WorkFragment()
        args.putSerializable(KEY, person)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.work, container, false)
        person = arguments?.getSerializable(KEY) as Person

        val workParent = view.findViewById<LinearLayout>(R.id.works)
        val projectParent = view.findViewById<LinearLayout>(R.id.projects)
        val skillParent = view.findViewById<FlowLayout>(R.id.skills)

        for (wr in person.works) {
            val item = inflater.inflate(R.layout.item, container, false)
            item.title.text = wr.position
            item.place.text = wr.company
            item.year.text = wr.year
            workParent.addView(item)
        }
        for (pr in person.projects) {
            val item = inflater.inflate(R.layout.item, container, false)
            item.item_background.setBackgroundResource(R.drawable.yellow)
            item.title.text = pr.title
            item.place.text = pr.subsidy
            item.year.text = pr.year
            projectParent.addView(item)
        }

        renderSkills(inflater, container, skillParent)

        return view
    }

    private fun renderSkills(inflater: LayoutInflater, container: ViewGroup?, parent: FlowLayout) {
        parent.removeAllViews()
        for (sk in person.skills) {
            val item = inflater.inflate(R.layout.item_small, container, false)
            item.item_txtView.text = sk
            parent.addView(item)
        }
    }
}
