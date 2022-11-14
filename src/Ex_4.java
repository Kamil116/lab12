import java.io.*;
import java.net.URL;

public class Ex_4 {
    public static void main(String[] args) {
        saveImage("https://wallpaper-mania.com/wp-content/uploads/2018/09/High_resolution_wallpaper_background_ID_77701372504.jpg");
    }

    public static void saveImage(String ImageUrl) {
        try {
            URL url = new URL(ImageUrl);
            String destName = "output.jpg";
            System.out.println(destName);

            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destName);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != 1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        } catch (IOException ex) {
            System.out.println("Some problems with the file");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Index is out of range");
        } finally {
            System.out.println("Finally");
        }
    }
}
