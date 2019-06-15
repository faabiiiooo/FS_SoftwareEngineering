package lesson6_familyHashMap;


import java.util.HashMap;
import java.util.Iterator;

/**
 * This class may contains errors!
 * Find them with the test class, and correct them
 */
public class Family {
	//private Person[] members;
	private HashMap<Integer, Person> members;
	
	public Family() {
		members = new HashMap<>();
	}
	
	public int size() {
		return members.size();
	}
	
	public void add(Person p) {
		members.put(p.getID(),p);
	}
	
	public Person getTallest() {
		Person tallest = null;
		Iterator<Person> iterator = members.values().iterator();
		while(iterator.hasNext()){
			Person p = iterator.next();
			if(tallest == null || tallest.getHeight() < p.getHeight()){
				tallest = p;
			}
		}
		return tallest;
	}
	
	public boolean isMember(Person p) {
		return members.containsValue(p);
	}

	public void printFamily(){
		Iterator<Integer> i = members.keySet().iterator();
		while (i.hasNext()){
			int id = i.next();
			Person p = members.get(id);
			System.out.println(p);
		}
	}
}
