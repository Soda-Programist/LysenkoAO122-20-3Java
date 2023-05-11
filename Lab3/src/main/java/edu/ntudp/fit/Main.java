package edu.ntudp.fit;

import edu.ntudp.fit.controller.DepartmentCreator;
import edu.ntudp.fit.controller.FacultyCreator;
import edu.ntudp.fit.controller.GroupCreator;
import edu.ntudp.fit.controller.UniversityCreator;

public class Main {
    public static void main(String[] args) {
        var groupCreator=new GroupCreator(10);
        var departmentCreator=new DepartmentCreator(4, groupCreator);
        var facultyCreator=new FacultyCreator(2, departmentCreator);
        var universityCreator=new UniversityCreator(5, facultyCreator);
        var university=universityCreator.createTypycalUniversity();
        System.out.println(university);
    }
}