package org.hua.turorial;

public class App {
    
   public static void main(String args[]){
            
        Person s1=new Student(1,"Miris","Aposto",18);
        Person s2=new Student(2,"Giannis","Kousvos",20);
        
        System.out.println("Student: " + s1 + s1.getAm() + s1.getFirstName()+ s1.getLastName());
        System.out.println("Student: " + s2 + s2.getAm() + s2.getFirstName()+ s2.getLastName());
        
        System.out.println(s1);
    }
    
}
