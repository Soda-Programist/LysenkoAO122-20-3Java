package edu.ntudp.fit.model;

import java.util.ArrayList;

public class University extends Structure<Faculty>{
    public University(ArrayList<Faculty> structure) {
        super(structure);
    }

    @Override
    public boolean equals(Object obj) {
        try{
            var newUniversity=(University)obj;
            for (int i1=0;i1<newUniversity.Subordinates.size();i1++){
                var faculty=newUniversity.Subordinates.get(i1);
                var faculty1=Subordinates.get(i1);
                for (int i2=0;i2<faculty.Subordinates.size();i2++){
                    var department=faculty.Subordinates.get(i2);
                    var department1=faculty1.Subordinates.get(i2);
                    for (int i3=0;i3<department.Subordinates.size();i3++){
                        var group=department.Subordinates.get(i3);
                        var group1=department1.Subordinates.get(i3);
                        for (int i4=0;i4<group.Subordinates.size();i4++){
                            var student=group.Subordinates.get(i4);
                            var student1=group1.Subordinates.get(i4);
                            if (student.equals(student1)){
                                return false;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
