import oop.ex6.main.Sjavac;

/**
 * @author Omri Kaplan
 */
public class IdanTester {
    public static void main(String[] args){
        String path = "C:\\Users\\Omri\\OneDrive\\Documents\\huji\\hw\\oop\\ex6\\tests\\tests\\";
        String test = "test";
        String suffix = ".sjava";
        for (int i=4;i<203;i++){
            String[] array = new String[1];
            array[0] = path+test+i+suffix;
            System.out.println(i);
            Sjavac.main(array);
        }

    }
}
