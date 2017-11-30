package com.emptryrunningproject;

import java.io.Serializable;

public class User implements Serializable {
    String name = "", uid = "", city = "", distance = "", profilePicUrl = "", profilePicUrlLarge = "", fgcmToken = "", gender = "", time = "", chatcount = "", categoryName = "";
    public String categoryvalue = "", dateTypeUrl = "",dateId="";
    boolean canChat, isExclusive = false, isPrivacyOn = false;

    public int dateoMeterLevel = 3;
    public int unFriend = 0;
    //    0= Normal Chat, 1= Date Chat,2= Exclusive Chat
    public int chatType = 0;
    // 0= Offline User, 1= Online User
    public int onlineStatus = 0;
    public int isActive=0;


    //TODO For Hold list Screen
    public int age = 0;


    public User() {
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }


    public void setDistance(String distance) {
        this.distance = distance;
    }


    public String getProfilePicUrlLarge() {
        return profilePicUrlLarge;
    }

    public void setProfilePicUrlLarge(String profilePicUrlLarge) {
        this.profilePicUrlLarge = profilePicUrlLarge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isExclusive() {
        return isExclusive;
    }

    public void setExclusive(boolean exclusive) {
        isExclusive = exclusive;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChatcount() {
        return chatcount;
    }

    public void setChatcount(String chatcount) {
        this.chatcount = chatcount;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }


    public int getChatType() {
        return chatType;
    }

    public void setChatType(int chatType) {
        this.chatType = chatType;
    }

    public void setDateTypeUrl(String dateTypeUrl) {
        this.dateTypeUrl = dateTypeUrl;
    }

    public String getDateTypeUrl() {
        return dateTypeUrl;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public String getDateId() {
        return dateId;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getIsActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                ", city='" + city + '\'' +
                ", distance='" + distance + '\'' +
                ", profilePicUrl='" + profilePicUrl + '\'' +
                ", profilePicUrlLarge='" + profilePicUrlLarge + '\'' +
                ", fgcmToken='" + fgcmToken + '\'' +
                ", gender='" + gender + '\'' +
                ", time='" + time + '\'' +
                ", chatcount='" + chatcount + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", canChat=" + canChat +
                ", isExclusive=" + isExclusive +
                ", isOnline=" + onlineStatus +
                ", isPrivacyOn=" + isPrivacyOn +
                ", categoryvalue='" + categoryvalue + '\'' +
                ", dateoMeterLevel=" + dateoMeterLevel +
                ", unFriend=" + unFriend +
                '}';
    }
}
