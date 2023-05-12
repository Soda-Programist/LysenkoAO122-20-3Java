package edu.ntudp.fit.model;

import java.util.List;

public class Structure<T> {
    public String Name;
    public Human Head;
    public List<T> Subordinates;

    public Structure(){

    }

    public Structure(List<T> subordinates){
        Name="Human"+Math.random()*1000;
        Head=new Human();
        this.Subordinates=subordinates;
    }
}
