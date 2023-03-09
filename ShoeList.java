package SPoudel_Project01;

//Sujan Poudel and Dev Wahi
//03/06/23
//Period 1 ADSB
//Purpose: Use arrays to create ArrayList implementation

import java.lang.Math;
import java.util.Random;

//Sujan Poudel and Dev Wahi
//03/06/23
//Period 1 ADSB
//Purpose: Use arrays to create ArrayList implementation

import java.lang.Math;
import java.util.Random;

class ShoeList {
	private Shoe[] data;
	private int size;
	private int capacity;
	
	public ShoeList() {
	  this.data = new Shoe[10];
	  this.size = 0;
	  this.capacity = 10;
	}
	
	public ShoeList(int capacity) {
	  this.data = new Shoe[capacity];
	  this.size = 0;
	  this.capacity = capacity;
	}
	
	public void add(int index, Shoe element) {
	  if (index < 0 || index > this.capacity) throw new IndexOutOfBoundsException();
	  
	  if (this.data[index] == null) {
	    this.set(index, element);
	  } else {
	    Shoe[] tempArray = new Shoe[this.capacity];
	    for (int i = 0; i < index; ++i) {
	      tempArray[i] = this.data[i];
	    }
	    
	    for (int i = index + 1; i < capacity; ++i) {
	      tempArray[i] = this.data[i - 1];
	    }
	
	    tempArray[index] = element;
	    this.data = tempArray;
	    this.size++;
	  }
	
	  if (this.data[this.capacity - 1] != null) {
	  	ensureCapacity(this.capacity * 2);
	  }
	}
	
	public int capacity() {
	  return this.capacity;
	}
	
	public void clear() {
	  for (int i = 0; i < this.capacity; ++i) {
	    this.data[i] = null;
	  }
	  this.size = 0;
	}
	
	public boolean contains(Shoe E) {
	  for (Shoe s : this.data) {
	    if (s == E) {
	      return true;
	    }
	  }
	  return false;
	}
	
	public Shoe get(int index) {
	  return this.data[index];
	}
	
	public int indexOf(Shoe element) {
	  for (int i = 0; i < this.capacity; ++i) {
		  if (this.data[i] == element) {
			  return i;
		  }
	  }
	  return -1;
	}
	
	public boolean isEmpty() {
	  return this.size == 0;
	}
	
	public int size() {
	  return this.size;
	}
	
	public Shoe set(int index, Shoe element) {
	  Shoe tempShoe = this.data[index];
	  this.data[index] = element;
	    
	  if (tempShoe == null) 
	    	this.size++;
	    
	  return tempShoe;
	}
	
	public void ensureCapacity(int minCapacity) {
	  if (minCapacity > this.capacity) {
	    Shoe[] tempArray = new Shoe[Math.max(minCapacity, this.capacity * 2)];
		for (int i = 0; i < this.capacity; ++i) {
		  tempArray[i] = this.data[i];
		}
		this.data = tempArray;
		this.capacity = Math.max(minCapacity, this.capacity * 2);
	  }
    }

}