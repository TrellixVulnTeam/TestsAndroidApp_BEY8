package com.gnd.calificaprofesores.NetworkAdd;

import com.gnd.calificaprofesores.NetworkHandler.ProfData;

import java.util.Map;

public class CompleteClassData {
    String name;
    String facultadId;
    String facultadName;
    String classId;

    Map<String, String> prof;

    public CompleteClassData(String name, String facultadId, String facultadName, String classId, Map<String, String> prof) {
        this.name = name;
        this.facultadId = facultadId;
        this.facultadName = facultadName;
        this.prof = prof;
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(String facultadId) {
        this.facultadId = facultadId;
    }

    public String getFacultadName() {
        return facultadName;
    }

    public void setFacultadName(String facultadName) {
        this.facultadName = facultadName;
    }

    public Map<String, String> getProf() {
        return prof;
    }

    public void setProf(Map<String, String> prof) {
        this.prof = prof;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
