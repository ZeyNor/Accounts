package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Role {
    private String role;
    private List<String> privilages= new ArrayList<>();

    public Role(String role, List<String> privilages) {
        this.role = role;
        this.privilages = privilages;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getPrivilages() {
        return privilages;
    }

    public void setPrivilages(List<String> privilages) {
        this.privilages = privilages;
    }

    public void addPrivilage(String pri){
        privilages.add(pri);
    }


    @Override
    public String toString() {
        return  " " + getPrivilages();
    }
}
