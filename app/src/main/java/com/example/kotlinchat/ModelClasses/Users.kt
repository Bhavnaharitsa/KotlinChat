package com.example.kotlinchat.ModelClasses

class Users{
private var uid: String =""
private var username: String =""
private var profile: String =""
private var cover: String =""
private var facebook: String =""
private var instagram: String =""
private var search: String =""
private var status: String =""
private var website: String =""

    constructor()

    constructor(
        uid: String,
        username: String,
        profile: String,
        cover: String,
        facebook: String,
        instagram: String,
        search: String,
        status: String,
        website: String
    ) {
        this.uid = uid
        this.username = username
        this.profile = profile
        this.cover = cover
        this.facebook = facebook
        this.instagram = instagram
        this.search = search
        this.status = status
        this.website = website
    }
    fun getUID() : String?{
        return uid
    }
    fun setUID(uid: String){
        this.uid= uid
    }

    fun getUserName() : String?{
        return username
    }
    fun setUserName(username: String){
        this.username= username
    }



    fun getProfile() : String?{
        return profile
    }
    fun setProfile(profile: String){
        this.profile= profile
    }


    fun getCover() : String?{
        return cover
    }
    fun setCover(cover: String){
        this.cover= cover
    }


    fun getStatus() : String?{
        return status
    }
    fun setStatus(status: String){
        this.status= status
    }


    fun getSearch() : String?{
        return search
    }
    fun setSearch(search: String){
        this.search= search
    }


    fun getFacebook() : String?{
        return facebook
    }
    fun setFacebook(facebook:String){
        this.facebook= facebook
    }


    fun getInstagram() : String?{
        return instagram
    }
    fun setInstragram(instagram: String){
        this.instagram= instagram
    }


    fun getWebsite() : String?{
        return website
    }
    fun setWebsite(website: String){
        this.website= website
    }


}