package com.learning.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class CollectionMap {
	private Map empHashMap = new HashMap<String, Employee>();
	private Map empLinkedHashMap = new HashMap<String, Employee>();
	private Map empTreeMap = new HashMap<String, Employee>();
	
	public void addMapItems(Employee e) {
		empHashMap.put(e.getEmployeeId().toString(), e);
	}
	
	public void printMap(String ind) {
		System.out.println(" Printing ind "+ind);
		if(ind.equalsIgnoreCase("hashMap"))
			this.printMapItems(empHashMap);
		else if (ind.equalsIgnoreCase("linkedHashMap")) 
			this.printMapItems(empLinkedHashMap);
		else
			this.printMapItems(empTreeMap);
	}
	
	public void printMapItems(Map<String, Employee> empMap) {
		for(Map.Entry<String, Employee> e : empMap.entrySet())
			System.out.println(" Key "+e.getKey() +" Value "+e.getValue().toString());
	}
	
	public static void main(String args[]) {
		Employee e1 = new Employee(11111, "Employee 1", 8);
		Employee e2 = new Employee(22222, "Employee 2", 10);
		Employee e3 = new Employee(33333, "Employee 3", 10);
		Employee e4 = new Employee(11111, "Employee Test", 20); // Trying to add duplicate item
		
		CollectionMap collectionMap = new CollectionMap();
		collectionMap.addMapItems(e1);
		collectionMap.addMapItems(e2);
		collectionMap.addMapItems(e3);
		collectionMap.addMapItems(e4);
		
		collectionMap.empLinkedHashMap.putAll(collectionMap.empHashMap);
		collectionMap.empTreeMap.putAll(collectionMap.empHashMap);
		
		collectionMap.printMap("hashMap");
		collectionMap.printMap("linkedHashMap");
		collectionMap.printMap("treeMap");
		
	}
}
