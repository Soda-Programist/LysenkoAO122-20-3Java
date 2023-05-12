package edu.ntudp.fit.model;

import java.util.List;

public class Group extends Structure<Student>{
    public Group(List<Student> subordinates){
        super(subordinates);
    }
}
