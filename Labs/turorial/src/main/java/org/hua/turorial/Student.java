package org.hua.turorial;

public class Student implements Person {
    
    private int am;
    private String firstName;
    private String lastName;
    private int age;
    
    public Student(int am, String firstName, String lastName){
        this.am=am;
        this.firstName= firstName;
        this.lastName= lastName;
        this.age= age;
    }

    public int getAm() {
        return am;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
   
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } 
        
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    
    public String getNmae(){
        return firstName + " " + lastName;
    }
    
    public int getAge(){
        return age;
    }
    
    public String toString(){
      return "{ \"am\":" + am + ", \"firstName\":\"" + firstName + "\", \"lastName\":\"" + lastName + "\" }";  
    }
           
}
