package testers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import git.Blob;

class BlobJUnitTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Path p = Paths.get("test.txt");
        try {
            Files.writeString(p, "example", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		File toDelete = new File ("test.txt");
		toDelete.delete();
	}

	@Test
	void test() throws IOException {
		Blob b = new Blob ("test.txt");
		File sha1File = new File ("./Testing/objects/c3499c2729730a7f807efb8676a92dcb6f8a3f8f.txt");
		assertTrue (sha1File.exists());
		//assertTrue (readFile ("c3499c2729730a7f807efb8676a92dcb6f8a3f8f.txt",StandardCharsets.ISO_8859_1).equals(readFile ("test.txt",StandardCharsets.ISO_8859_1)));
		
		Path originalPath = Path.of("test.txt");
		String originalContents = Files.readString(originalPath);
		
		Path newPath = Path.of("./Testing/objects/c3499c2729730a7f807efb8676a92dcb6f8a3f8f.txt");
		String newContents = Files.readString(newPath);
		
		assertTrue (originalContents.equals (newContents));
	}

}
