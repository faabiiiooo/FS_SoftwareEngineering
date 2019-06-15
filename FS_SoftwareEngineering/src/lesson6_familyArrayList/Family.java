package lesson6_familyArrayList;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class may contains errors!
 * Find them with the test class, and correct them
 */
public class Family {
	//private Person[] members;
	private ArrayList<Person> members;
	
	public Family() {
		members = new ArrayList<>();
	}
	
	public int size() {
		return members.size();
	}
	
	public void add(Person p) {
		members.add(p);
	}
	
	public Person getTallest() {
		Person tallest = null;
		for (Person p : members) {
			if (tallest == null || tallest.getHeight() < p.getHeight()) {
				tallest = p;
			}
		}
		return tallest;
	}
	
	public boolean isMember(Person p) {
		boolean isMember = members.contains(p);

		return isMember;
	}

	public void printFamily(){
		Iterator<Person> i = members.iterator();
		while (i.hasNext()){
			Person p = i.next();
			System.out.println(p);
		}
	}
}
