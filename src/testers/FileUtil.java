import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
	public FileUtil () {
		
	}

	public static void writeStringToFile (String fileName) {
		Path p = Paths.get("test.txt"); // where it is on your laptop 
        try {
            Files.writeString(p, "example", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public static void deleteStringToFile (String fileName) {
		Path path = FileSystems.getDefault().getPath("test.txt");
        try {
            Files.deleteIfExists(path);
        } catch (IOException x) {
            System.err.println(x);
        }
	}
	
	

}
