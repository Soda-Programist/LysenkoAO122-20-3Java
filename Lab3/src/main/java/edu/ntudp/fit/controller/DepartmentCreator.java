package edu.ntudp.fit.controller;

import edu.ntudp.fit.model.Department;
import edu.ntudp.fit.model.Group;
import edu.ntudp.fit.model.Student;

import java.util.ArrayList;

public class DepartmentCreator {
    public GroupCreator Creator;
    public int Quantity;

    public DepartmentCreator(int quantity, GroupCreator creator){
        this.Quantity=quantity;
        this.Creator=creator;
    }

    public Department Create(){
        var structure=new ArrayList<Group>();
        for (int i=0; i<Quantity; i++){
            structure.add(Creator.Create());
        }
        return new Department(structure);
    }
}
