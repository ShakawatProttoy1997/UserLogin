package com.example.myapplication.Supportive;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "users")
public class User {

    @ColumnInfo(userid = "created_at")
    public String created_at;

    @PrimaryKey
    public String userid;
    private String Password;
    public String Email;

    @ColumnInfo(userid = "updated_at")
    public String updated_at;
    private String UserId;

    public User(String UserId, String email, String password) {
        UserId = userid;
        email = Email;
        password = Password;
    }

    public User() {
    }

    public String getUserId() {
        return UserId;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @NonNull
    @Override
    public String toString() {

        return "Users{" +
                "ID='" + UserId + '\'' +
                ", Phone='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}