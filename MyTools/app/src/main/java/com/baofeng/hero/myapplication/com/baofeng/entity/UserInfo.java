package com.baofeng.hero.myapplication.com.baofeng.entity;

/**
 * Created by bander_xie on 2015/9/8.
 */
public class UserInfo {
    public String name;
    public  int age;
    public  String sex;
    public  String password;

    public  UserInfo(){
    }
    public  UserInfo(String name,String password){
        this.name=name;
        this.password=password;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
