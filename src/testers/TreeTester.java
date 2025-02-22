package testers;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import git.Tree;

class TreeTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void TreeTest() throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		list.add("blob : 81e0268c84067377a0a1fdfb5cc996c93f6dcf9f fileName1.txt");
		list.add("blob : 01d82591292494afd1602d175e165f94992f6f5f fileName2.txt");
		list.add("blob : f1d82236ab908c86ed095023b1d2e6ddf78a6d83 fileName3.txt");
		list.add("tree : bd1ccec139dead5ee0d8c3a0499b42a7d43ac44b fileName4.txt");
		list.add("tree : e7d79898d3342fd15daf6ec36f4cb095b52fd976 fileName5.txt");
		
		//Initialize tree with list, check if file with correct sha1 exists in objects
		Tree tree = new Tree(list);
		File file = new File("Test/Objects/936b6f30d7d72a2613289d109a195fb65292035f");
		assertTrue(file.exists());
		
		//Check if all lines exist and are correct 
		Scanner scanner = new Scanner(file);
		assertTrue(scanner.nextLine().equals("blob : 81e0268c84067377a0a1fdfb5cc996c93f6dcf9f fileName1.txt"));
		assertTrue(scanner.nextLine().equals("blob : 01d82591292494afd1602d175e165f94992f6f5f fileName2.txt"));
		assertTrue(scanner.nextLine().equals("blob : f1d82236ab908c86ed095023b1d2e6ddf78a6d83 fileName3.txt"));
		assertTrue(scanner.nextLine().equals("tree : bd1ccec139dead5ee0d8c3a0499b42a7d43ac44b fileName4.txt"));
		assertTrue(scanner.nextLine().equals("tree : e7d79898d3342fd15daf6ec36f4cb095b52fd976 fileName5.txt"));
		file.delete();
	}

}
