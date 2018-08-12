package br.com.rnsolucoesweb.modelologin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Student extends AppCompatActivity {

    private String studentID;
    private String Pin;
    private String course;
    private String level;

    public Student() {

    }

    public Student(String studentID, String pin, String course, String level) {
        this.studentID = studentID;
        this.Pin = pin;
        this.course = course;
        this.level = level;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String pin) {
        Pin = pin;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
