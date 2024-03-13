package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Entityとは、「物体」みたいな意味。Userって、IDとか名前とか年齢とかの情報あると思うけど、それの定義をする場所と思っとけばOK
// （Entityの解釈は人によって本当に様々なので、詳しくなったらべんきょうしてみて）

// このアノテーションも、今はおまじないと思ってくれたらOK。このクラスは、Entityだと、という宣言なんだなーぐらい。
@Entity
public class User {
    @Id
    private int userId;
    private String userName;
    private int age;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
