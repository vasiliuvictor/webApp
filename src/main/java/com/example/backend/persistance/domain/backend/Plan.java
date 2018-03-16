package com.example.backend.persistance.domain.backend;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Plan implements Serializable{

    public static final long serialVersionUID =1L;

    @Id
    private int id;


    private String name;

    public Plan(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj==null || getClass() != obj.getClass()) return false;
        Plan plan = (Plan) obj;


        return  id==plan.id;

    }
}
