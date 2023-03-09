package SPoudel_Project01;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

import org.junit.jupiter.api.Test;

class ShoeListTesting {
	
	public static Shoe randomShoe() {
	  Random myRandGenerator = new Random();
	  
	  String randomBrand = "";
	  String randomModel = "";
	  int randomYear = myRandGenerator.nextInt(100);
	  double randomSize = myRandGenerator.nextDouble();
	  int randomSKU = myRandGenerator.nextInt(200);
	  
	  for (int i = 0; i < 7; ++i) {
		  randomBrand += (char) myRandGenerator.nextInt(97);
		  randomModel += (char) myRandGenerator.nextInt(97);
	  }
	  
	  return new Shoe(randomBrand, randomModel, randomYear, randomSize, randomSKU);
	}

	@Test
	public void testConstructorNoArgs() {
		ShoeList shoes = new ShoeList();
		assertEquals(shoes.size(), 0);
		assertEquals(shoes.capacity(), 10);
	}
	
	@Test
	public void testConstructorArgs() {
		ShoeList shoes = new ShoeList(5);
		assertEquals(shoes.size(), 0);
		assertEquals(shoes.capacity(), 5);
	}
	
	@Test
	public void testIsEmpty() {
		ShoeList shoes = new ShoeList();
		assertEquals(shoes.isEmpty(), true);
		shoes.add(0, randomShoe());
		assertEquals(shoes.isEmpty(), false);
	}

	@Test
	public void testAddItemCapacityTwo() {
		ShoeList shoes = new ShoeList(2);
		shoes.add(0, randomShoe());
		shoes.add(0, randomShoe());
		assertEquals(shoes.size(), 2);
		assertEquals(shoes.capacity(), 4);
	}
	
	@Test
	public void testAddItemCapacityDefault() {
		ShoeList shoes = new ShoeList();
		shoes.add(0, randomShoe());
		shoes.add(0, randomShoe());
		assertEquals(shoes.size(), 2);
		assertEquals(shoes.capacity(), 10);
	}
	
	@Test
	public void testContains() {
		ShoeList shoes = new ShoeList(2);
		assertEquals(shoes.contains(randomShoe()), false);
	}
	
	@Test
	public void testContainsElement() {
		ShoeList shoes = new ShoeList();
		Shoe shoeToBeAdded = randomShoe();
		shoes.add(5, shoeToBeAdded);
		assertEquals(shoes.contains(shoeToBeAdded), true);
	}
	
	@Test
	public void testGetShoe() {
		ShoeList shoes = new ShoeList();
		Shoe shoeToBeAdded = randomShoe();
		shoes.add(4, shoeToBeAdded);
		assertEquals(shoes.get(4), shoeToBeAdded);
		
	}
	
	@Test
	public void testGetShoeGreaterThanSize() {
		ShoeList shoes = new ShoeList();
		for (int i = 0; i < 4; ++i) {
			shoes.add(i, randomShoe());
		}
		//list now has size 4 and capacity 10
		
		Shoe shoeToBeAdded = randomShoe();
		shoes.add(6, shoeToBeAdded);
		assertEquals(shoes.get(6), shoeToBeAdded);
	}
	
	@Test
	public void testIndexOfMultipleElements() {
		ShoeList shoes = new ShoeList();
		Shoe[] randomShoes = {randomShoe(), randomShoe(), randomShoe(), randomShoe(), randomShoe(), randomShoe()};
		for (int i = 0; i < randomShoes.length; ++i) {
			shoes.add(i, randomShoes[i]);
		}
		//list now has size 6 and capacity 10
		
		assertEquals(shoes.indexOf(randomShoes[0]), 0);
		assertEquals(shoes.indexOf(randomShoe()), -1);
		
	}
	
	@Test
	public void testClear() {
		ShoeList shoes = new ShoeList(5);
		shoes.add(0, randomShoe());
		shoes.add(1, randomShoe());
		shoes.add(2, randomShoe());
		shoes.add(3, randomShoe());
		//list has size 4, capacity 5
		shoes.clear();
		//list now has size 0, capacity 5
		assertEquals(shoes.size(), 0);
		assertEquals(shoes.capacity(), 5);
	}
	
}
