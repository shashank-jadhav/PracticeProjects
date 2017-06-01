package co.shashank.lambda;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import co.shashank.lambda.Person.Sex;

public class Main {

	static List<Person> persons = new ArrayList<>();
	
	static List<String> stringList = new ArrayList<>();
	
	//This is for only single type
	interface CheckPerson {
	    List<Person> test(List<Person> person);
	    
	   
	}
	
	//this is for generics type
	interface Predicate<T>
	{
		boolean test(T t);
	}
	

	static
	{
		persons.add(new Person("shank" , 23 , Sex.MALE , "abc@com"));
		persons.add(new Person("vebo" ,24, Sex.MALE , "xys@com"));
		persons.add(new Person("mota" , 25 , Sex.FEMALE , "sas@com"));
		persons.add(new Person("niel" , 26 , Sex.FEMALE , "spos@com"));
		persons.add(new Person("kush" , 27 , Sex.MALE , "kushs@com"));
		
		stringList.add("shahshank");
		stringList.add("gaga");
		stringList.add("l");
		stringList.add("lo");
		
	}
	public static void main(String[] args) {
	
		 /*Main.printPerson(persons, (persons) -> {
			
			List<Person> pe = persons.stream().filter(p -> p.getGender() == Sex.MALE).collect(Collectors.toList());
			return pe;
		});
		
		
		
		Main.printUsingPredicate ( (String p) -> p.length() > 2 , stringList );*/
		
		processPersonsWithFunction(persons, p -> p.getGender() == Sex.MALE, p -> p.getAge(), name -> System.out.println(name));
	
	}
	
	public static void printPerson(List<Person> person , CheckPerson cp)
	{
		
		for (Person p : cp.test(person)) {
			p.printPerson();
		}
	}
	
	public static void printUsingPredicate(List<Person> persons , Predicate<Person> predicate)
	{
		for (Person pers : persons) {
			if(predicate.test(pers))
			pers.printPerson();
		}
	}
	
	public static void printUsingPredicate(Predicate<String> predicate , List<String> str)
	{
		
		for (String s : str) {
			if(predicate.test(s))
				System.out.println(s);
		}
	}
	
	//Get fileterd data and then perform operation on filtered data using mapper and then consume using block
	public static void processPersonsWithFunction(List<Person> persons, Predicate<Person> tester,
			Function<Person, Integer> mapper, Consumer<Integer> block) {
		for (Person p : persons) {
			if (tester.test(p)) {
				Integer data = mapper.apply(p);
				System.out.println("data :: " + data);
				block.accept(data);
			}
		}
	}
	
	// FOR Generic objects Get fileterd data and then perform operation on filtered data using mapper and then consume using block
	public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper,
			Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}	
}


