//Author: Trenton C. Perez
//class ID: 424
//assignment #1
//This file has no main just a bunch of methods that belong to SimpleList.java
//It creates a an array of size 10 and then has certain methods that do 
// certain actions on the array. the methods are, add, remove, count, search,
//and toString. 
//add - adds element to the front of the list and shifts everything down; if 
//the array is full the last element "falls off the array"
//remove - removes the first occurence of an element
//count - returns how many elements are in the array
//search - finds the first occurence of an element
//toString - prints the array as a string

package cse360assign2;

public class SimpleList {
	
	//count keeps track of the number of elements.
	private int count;
	//this is the array that will be manipulated
	private int[] list;
	
	//constructor for the class 
	
	public SimpleList() {
		this.count = 0;
		this.list = new int[10];
	}
	
	//adds an element to the first spot in list. if the array is full the
	//array is shifted to the right and we set list[0] to the element
	//being added to the array.
	
	public void add(int x) {
		count++;
		
		if(count == list.length) {
			int calc = list.length + (list.length/2);
			int[] temp = new int[calc]; 
			for(int i = 0; i < list.length; i++) {
				temp[i] = list[i];
			}
			list = temp;
		}
		
		//this is if we count one to many
		//if(count > 10) {
		  //count--;
		//}
	  
	  //this is if there is no elements in the array
	  
	  if(count == 1) {
		  list[0] = x;
	  }
	  else {
		  
		  //shifts all the elements right
		
		  for(int i = count - 1; i > 0; i--) {
			list[i] = list[i - 1];
			if(i == 1) {
			
				//sets the first element in the array to the element
				//being inserted
				
				list[0] = x;
			}
		}  
	  }
	}
	  
	//this removes an element of the array.
	
	public void remove(int x) {
	
		//this is to find the index of the element that is being removed.
		
		int index = search(x);
		
		//this is to make sure it exsists in the array.
		
		if(index != -1) {
		
			//this case is if the array is full
			
			if(index == 9) {
				count--;
			} 
				else 
				{
			
					//we shift all the elements left
					
					for(int i = index; i < list.length - 1; i++)
					{
						list[i] = list[i + 1];
					}
					
					//then we get rid of the last element
					
					count--;
				}
		}
	}
		
	//this searches for the first occurence of an element
	
	public int search(int x) {
	
		//this is a temp varaible so we don't manipulate count
		//when it is not needed
		
		int temp = 0;
		
		//loop until you find the element being searched for or
		//return -1.
		
		while(temp < count) {
			
			if(list[temp] == x) {
				return temp;
			}
			
			temp++;
		}
		return -1;
	}
	
	//returns the number of elements in the array
	
	int count() {
		return count;
	}
	
	//returns the array as a string
	
	public String toString() {
		int temp = 0;
		String stringList = new String();
	
		//adds the elements of the array one at a time.
		
		while(temp  < count) {
			stringList = stringList + list[temp] + " ";
			temp++;
		}
		
		//gets rid of the extra space at the end.
		
		stringList = stringList.trim();
		return stringList;
	}
	
}

	