package edu.ntudp.fit.model;

public class Human {
    public String Name;
    public String Surname;
    public String ByFather;
    public Sex Sex;

    public Human(){
        Name="Name"+Math.random()*1000;
        Surname="Name"+Math.random()*1000;
        ByFather="Name"+Math.random()*1000;
        if (Math.random()>0.5){
            Sex=Sex.Male;
        }else{
            Sex=Sex.Female;
        }
    }

    public Human(String Name, String Surname, String ByFather, Sex Sex){
        this.Name=Name;
        this.Surname=Surname;
        this.ByFather=ByFather;
        this.Sex=Sex;
    }
}
