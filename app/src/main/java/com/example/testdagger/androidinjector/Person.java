package com.example.testdagger.androidinjector;

public class Person implements Comparable<Person>{
    String name ;
    public Person(){

    }

    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (o != null){
            return this.name.compareTo(o.name);
        }
        return 0;
    }
}
