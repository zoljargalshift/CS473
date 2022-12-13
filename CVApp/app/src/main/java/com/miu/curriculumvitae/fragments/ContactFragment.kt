package com.miu.curriculumvitae.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.miu.curriculumvitae.R
import com.miu.curriculumvitae.common.Person
import kotlinx.android.synthetic.main.contact.view.*

class ContactFragment : Fragment() {
    private val KEY = "user"
    private lateinit var person: Person

    fun newInstance(person: Person): ContactFragment {
        val args = Bundle()
        val fragment = ContactFragment()
        args.putSerializable(KEY, person)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var contact = inflater.inflate(R.layout.contact, container, false)
        person = arguments?.getSerializable(KEY) as Person
        contact.txt_phone.text = "${person.contact.phone}"
        var phone = contact.findViewById<LinearLayout>(R.id.phone)
        phone.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                var phone = Intent(Intent.ACTION_VIEW, Uri.parse("tel:${person.contact.phone}"));
                startActivity(phone);
            }
        })

        var email = contact.findViewById<LinearLayout>(R.id.gmail)
        email.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val uriText = "mailto:${person.contact.email}" +
                        "?subject=" + Uri.encode("From the Curriculum Vitae") +
                        "&body=" + Uri.encode("Hi ${person.fname}!")
                val url = Uri.parse(uriText)
                val sendIntent = Intent(Intent.ACTION_SENDTO)
                sendIntent.data = url
                startActivity(Intent.createChooser(sendIntent, "Send email"))
            }
        })

        return contact
    }

}
