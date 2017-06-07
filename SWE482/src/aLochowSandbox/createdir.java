/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create_DBFilelocation;

/**
 *
 * @author Andrew Lochow
 */
import java.io.File;
 
public class createdir {
 
	public static void main(String args[]) {

		File file = new File("C://sqlite/db/");
 
		boolean b = false;
 
		/*
		 * exists() method tests whether the file or directory denoted by this
		 * abstract pathname exists or not accordingly it will return TRUE /
		 * FALSE.
		 */
 
		if (!file.exists()) {
			/*
			 * mkdirs() method creates the directory mentioned by this abstract
			 * pathname including any necessary but nonexistent parent
			 * directories.
			 * 
			 * Accordingly it will return TRUE or FALSE if directory created
			 * successfully or not. If this operation fails it may have
			 * succeeded in creating some of the necessary parent directories.
			 */
			b = file.mkdirs();
		}
		if (b)
			System.out.println("Directory successfully created");
		else
			System.out.println("Failed to create directory");
	}
}

