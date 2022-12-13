package com.miu.curriculumvitae.common

import java.io.Serializable

class Person(
    var avatar: Int,
    var fname: String,
    var lname: String,
    var password: String,
    var profession: String,
    var about: String,
    var certificates: ArrayList<String>,
    var skills: ArrayList<String>,
    var educations: ArrayList<Education>,
    var contact: Contact,
    var projects: ArrayList<Project>,
    var works: ArrayList<Work>
    ) : Serializable {

    fun add(newSkill:String) {
        this.skills.add(newSkill)
    }

    fun removeLastSkill() {
        this.skills.removeLast()
    }
}