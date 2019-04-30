package com.herbtea.study.datastructure.LinkedList;

import java.util.LinkedList;

enum AnymalType{
    DOG, CAT;
}
abstract class Animal {
    AnymalType type;
    String name;
    int order;
    public Animal(AnymalType type, String name) {
        this.type = type;
        this.name = name;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    String info() {
        return order + ") type : " + type + ", name = " + name;
    }
}
class Dog extends Animal {
    Dog(String name){
        super(AnymalType.DOG, name);
    }
}
class Cat extends Animal {
    Cat(String name){
        super(AnymalType.CAT, name);
    }
}
public class AnimalShelter {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    int order;

    public AnimalShelter() {
        order = 1;
    }

    void enqueue(Animal animal){
        animal.setOrder(order);
        order++;
        if(animal.type == AnymalType.DOG) {
            dogs.addLast((Dog) animal);
        } else if(animal.type == AnymalType.CAT) {
            cats.addLast((Cat) animal);
        }
    }
    Animal dequeueDog() {
        return dogs.poll();
    }
    Animal dequeueCat() {
        return cats.poll();
    }
    Animal dequeue() {
        if(dogs.size() == 0 && cats.size() ==0) {
            return null;
        } else if(dogs.size() == 0) {
            return cats.poll();
        } else if(cats.size() == 0) {
            return dogs.poll();
        }
        Animal dog = dogs.peek();
        Animal cat = cats.peek();
        if(dog.order > cat.order) {
            return cats.poll();
        } else {
            return dogs.poll();
        }
    }
}

class Test{
    public static void main(String[] args) {
        Dog d1 = new Dog("puppy");
        Cat c1 = new Cat("shasha");
        Dog d2 = new Dog("chichi");
        Cat c2 = new Cat("cumo");
        Dog d3 = new Dog("choco");
        Cat c3 = new Cat("miamia");

        AnimalShelter as = new AnimalShelter();
        as.enqueue(d1);
        as.enqueue(c1);
        as.enqueue(d2);
        as.enqueue(c2);
        as.enqueue(d3);
        as.enqueue(c3);

        System.out.println(as.dequeueCat().info());
        System.out.println(as.dequeueDog().info());
        System.out.println(as.dequeue().info());
        System.out.println(as.dequeue().info());
        System.out.println(as.dequeue().info());
        System.out.println(as.dequeue().info());
    }
}
