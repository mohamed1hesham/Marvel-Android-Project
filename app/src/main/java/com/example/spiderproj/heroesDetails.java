package com.example.spiderproj;

import com.google.gson.annotations.SerializedName;

public class heroesDetails {

    @SerializedName("name")
    private String name;
    @SerializedName("realname")
    private String realname;
    @SerializedName("team")
    private String team;
    @SerializedName("firstappearance")
    private String firstappearance;
    @SerializedName("createdby")
    private String createdby;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("imageurl")
    private String img;
    @SerializedName("bio")
    private String bio;




    public String getName() {
        return name;
    }

    public String getRaelname() { return realname;}

    public String getImg() {
        return img;
    }

    public String getTeam() {
        return team;
    }
    public String getBio() {
        return bio;
    }


    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

}
