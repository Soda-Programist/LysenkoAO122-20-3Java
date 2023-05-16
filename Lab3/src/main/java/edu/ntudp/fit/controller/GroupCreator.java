package edu.ntudp.fit.controller;

import edu.ntudp.fit.model.Group;
import edu.ntudp.fit.model.Student;

import java.util.ArrayList;

public class GroupCreator {
    public int Quantity;

    public GroupCreator(int quantity){
        this.Quantity=quantity;
    }

    public Group Create(){
        var structure=new ArrayList<Student>();
        for (int i=0; i<Quantity; i++){
            structure.add(new Student());
        }
        return new Group(structure);
    }
}
