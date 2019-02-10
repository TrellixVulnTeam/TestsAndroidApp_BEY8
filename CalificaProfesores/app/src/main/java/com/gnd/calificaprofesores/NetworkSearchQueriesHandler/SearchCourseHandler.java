package com.gnd.calificaprofesores.NetworkSearchQueriesHandler;

import android.bluetooth.le.AdvertiseData;
import android.support.annotation.NonNull;

import com.gnd.calificaprofesores.NetworkHandler.CourseData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class SearchCourseHandler {
    private DatabaseReference mDatabase;
    private GotCourseListener listener;
    private Set<CourseData> courses;
    private long uniId;
    private String uniName;


    public SearchCourseHandler(Long _uniId){
        mDatabase = FirebaseDatabase.getInstance().getReference().getRef();
        courses = new TreeSet<>();
        uniId = _uniId;

        mDatabase.child("Facultades").child(Long.toString(uniId))
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        uniName = (String)dataSnapshot.child("Name").getValue();
                        uniName.toUpperCase();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    public void Search(String text) {
        text.toLowerCase();
        courses.clear();

        mDatabase
                .child("MateriasPorFacultad")
                .child(Long.toString(uniId))
                .orderByChild("Name")
                .startAt(text)
                .endAt(text + "\uf8ff")
                .limitToFirst(10)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        AddPackage(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
    public void AddPackage(@NonNull DataSnapshot dataSnapshot){
        courses.clear();
        for (final DataSnapshot postSnapshot : dataSnapshot.getChildren()){
            courses.add(new CourseData(
                    (Long)postSnapshot.child("id").getValue(),
                    (String)postSnapshot.child("ShownName").getValue(),
                    uniName.toUpperCase()
            ));
        }

        listener.onGotCourse(courses);
    }
    public void AddOnGotCourseListener(GotCourseListener listener){
        this.listener = listener;
    }
    public String GetUniName(){
        return uniName;
    }
}
