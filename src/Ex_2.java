import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Ex_2 {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt");
             FileOutputStream out = new FileOutputStream("output.txt")) {
            byte[] arr = new byte[in.available()];
            in.read(arr);
            String[] input = new String(arr).split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            out.write(a / b);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (NumberFormatException ne) {
            System.out.println("An error during parsing integers");
            throw new NumberFormatException(ne.getMessage());
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("File has less than two integers");
            throw new ArrayIndexOutOfBoundsException(ae.getMessage());
        }
    }
}
