package edu.ntudp.fit.controller;

import edu.ntudp.fit.model.Department;
import edu.ntudp.fit.model.Faculty;
import edu.ntudp.fit.model.Group;

import java.util.ArrayList;

public class FacultyCreator {
    public DepartmentCreator Creator;
    public int Quantity;

    public FacultyCreator(int quantity, DepartmentCreator creator){
        this.Quantity=quantity;
        this.Creator=creator;
    }

    public Faculty Create(){
        var structure=new ArrayList<Department>();
        for (int i=0; i<Quantity; i++){
            structure.add(Creator.Create());
        }
        return new Faculty(structure);
    }
}
