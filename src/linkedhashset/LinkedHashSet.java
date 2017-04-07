package linkedhashset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class LinkedHashSet<T> {
	
	private ArrayList<LinkedList<T>>arrayList;
	private int initialCap;
	
	
	public LinkedHashSet(int initialCap){
		 arrayList= new ArrayList<LinkedList<T>>(initialCap);
		 this.initialCap = initialCap;	
		 for(int i =0;i<initialCap;i++){
			 arrayList.add(new LinkedList<T>());
		 }
	}
	
public boolean add(T data){
	
	int hash = Math.abs(data.hashCode()% initialCap);
	//using the contains method of the linkedlist	
	if(!(arrayList.get(hash).contains(data))){
		arrayList.get(hash).addLast(data);
		return true;

	}
	return false;
	
}
public boolean contains(T data){
	if(arrayList.get(Math.abs(data.hashCode()%initialCap)).contains(data)){
		return true;
	}
	return false;
}
public boolean remove(T data){
	//find it based on hash
	int hash = Math.abs(data.hashCode()%initialCap);
	if(arrayList.get(hash).contains(data)){
		//remove it
		arrayList.remove(data);
		return true;
	}
	//otherwise, couldnt find it
	return false;
}
public boolean isEmpty(){
	return size()<=0;
}
public int size(){
	//returns size of the arrayList
	return arrayList.size();
}
public Iterator<LinkedList<T>> iterator(){
	 return arrayList.iterator();
}


} 


