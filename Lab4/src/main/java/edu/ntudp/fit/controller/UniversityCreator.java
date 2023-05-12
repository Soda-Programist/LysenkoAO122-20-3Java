package edu.ntudp.fit.controller;

import edu.ntudp.fit.model.Department;
import edu.ntudp.fit.model.Faculty;
import edu.ntudp.fit.model.University;

import java.util.ArrayList;

public class UniversityCreator {
    public University createTypycalUniversity(){
        var structure=new ArrayList<Faculty>();
        for (int i=0; i<Quantity; i++){
            structure.add(Creator.Create());
        }
        return new University(structure);
    }
    public FacultyCreator Creator;
    public int Quantity;

    public UniversityCreator(int quantity, FacultyCreator creator){
        this.Quantity=quantity;
        this.Creator=creator;
    }
}
