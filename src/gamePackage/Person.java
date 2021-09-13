package gamePackage;

public abstract class Person {
    final private String name;
    public Person(String name){
        this.name = name;
    }
    public Person(){
        this.name = "undefined";
    }
    public String getName (){
        return this.name;
    }
}
