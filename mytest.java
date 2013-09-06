// run in Netbeans
package test1;
 
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
 
class Utils {
	public static Object copy(Serializable oldObj) {
//	public static Object copy(Object oldObj) {
		Object obj = null;
		try {
			// Write the object out to a byte array
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			try (ObjectOutputStream out = new ObjectOutputStream(bos)) {
				out.writeObject(oldObj);
				out.flush();
				out.close();
			}
 
			// Retrieve an input stream from the byte array and read
			// a copy of the object back in.
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bis);
			obj = in.readObject();
		} catch (	IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
 
public class Test1 {
	public static void main(String[] args) throws IOException {
//		Object clonedObject = Utils.copy(new Object());
		Object clonedObject = Utils.copy("Hello");
		PrintStream out = System.out;
		out.println(clonedObject.getClass().toString());
	}
}

// run result:
// class java.lang.String
