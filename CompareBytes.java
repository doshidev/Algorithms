import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Devang on 4/17/2017.
 */
public class CompareBytes {
    public static void main(String[] args) throws IOException {
        BufferedInputStream b1 = new BufferedInputStream(new FileInputStream(args[0]));
        BufferedInputStream b2 = new BufferedInputStream(new FileInputStream(args[1]));
        
        int read1, read2, i = 1;
        while((read1 = b1.read()) != -1){
            read2 = b2.read();
            if(read1 == read2){
                System.out.println(i++ + ": " + read1 + ", " + read2);
            } else {
                System.out.println("\t\t" + i++ + ": " + read1 + ", " + read2);
            }
            
        }
    }
}
