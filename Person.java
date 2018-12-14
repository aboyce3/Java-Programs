import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
 
public class Person {
 
    public enum Sex {
        MALE, FEMALE
    }
 
    String name;
    int age;
    Sex sex;
    String emailAddress;
 
    public int getAge() {
        return age;
    }
 
    public void printPerson() {
        System.out.println("Name: " + name + " Sex: " + sex + " Age: " + age + " Email: " + emailAddress);
    }
 
    public Sex getSex(){
        return sex;
    }
 
    public String getName() {
        return name;
    }
 
    public Person(String name, Sex sex, int age, String emailAddress){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.emailAddress = emailAddress;
    }
 
    public static void printMaleNames(List<Person> persons){
    persons.stream()
    .filter(e -> e.getSex() == Person.Sex.MALE)
    .forEach(e -> System.out.println(e.getName()));
    }
 
    public static void printUniqueFemaleNamesByLength(List<Person> persons){
        persons.stream()
	.filter(e -> e.getSex() == Person.Sex.FEMALE)
	.map(e -> e.getName())
        .distinct()
	.sorted((e1, e2) -> e1.length() - e2.length())
        .forEach(e -> System.out.println(e));
                                  }
 
    public static void main(String[] args){
        Person dan = new Person("Dan", Sex.MALE, 31, "daniel.schlegel@oswego.edu");
        Person phil = new Person("Phil", Sex.MALE, 22, "phil@philsdomain.org");
        Person julie = new Person("Julie", Sex.FEMALE, 35, "julue@google.com");
        Person julie2 = new Person("Julie", Sex.FEMALE, 19, "juliethesecond@facebook.com");
        Person alexis = new Person("Alexis", Sex.FEMALE, 44, "alexis@alexis.jp");
        Person evie = new Person("Evie", Sex.FEMALE, 25, "evie1997@yahoo.com");
 
        List<Person> persons = new ArrayList<>();
        persons.add(dan);
        persons.add(phil);
        persons.add(julie);
        persons.add(julie2);
        persons.add(alexis);
        persons.add(evie);
 
        System.out.println("--- Male Names ---");
        printMaleNames(persons);
 
        System.out.println("--- Unique, Sorted by Length, Female Names ---");
        printUniqueFemaleNamesByLength(persons);
    }
}
