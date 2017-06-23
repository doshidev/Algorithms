/**
 * DOSHI DEVANG Huffman_4713
 */

import java.io.*;

public class hdec4713 {
    public static void main(String[] args) throws IOException {
        /* Read file */
        // Target File name
        String targetFilename = args[0].substring(0, args[0].length()-4);
        System.out.println(targetFilename);
        
        // Read a file as binary input from command line argument
        InputStream is = new BufferedInputStream(new FileInputStream(args[0]));
        
        /* Find out the size of serialized object */
        int ssize[] = new int[8];
        int serSize = 0;
        for (int i = 0; i < 8 ; i++) {
            ssize[i] = is.read();
            serSize+= ssize[i] * (int)(Math.pow(10,7-i));
        }
        System.out.println("Object size: " + serSize);
        
        /* Find out the size of original file */
        int fsize[] = new int[12];
        int fileSize = 0;
        for (int i = 0; i < 12 ; i++) {
            fsize[i] = is.read();
            fileSize+= fsize[i] * (int)(Math.pow(10,11-i));
        }
        System.out.println("File size: " + fileSize);
        
        /* Read serialized object and deserialize it to array */
        
        // The "frequency" array is serialized and stored in freq.ser
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("freq.ser"));
        for (int i = 0; i < serSize ; i++) {
            fos.write(is.read());
        }
        fos.close();
    
        henc4713.Node[] frequency;
        try {
            FileInputStream fis = new FileInputStream("freq.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            frequency = (henc4713.Node[])ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
                
        
        /* Read file and do a tree match */
        henc4713.Node[] fnodes = henc4713.huffman(frequency);
        StringBuilder sb = new StringBuilder();
        int fileByte;
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(targetFilename));
        henc4713.Node visit = fnodes[1];
        int cnt = 0;
        int fileWritten = 0;
    
        while((fileByte = is.read()) != -1){
            String fileWord = String.format("%8s", Integer.toBinaryString(fileByte)).replace(' ', '0');
            sb.append(fileWord);
            if(sb.length() > 16000){
               for (int i = 0; i < sb.length(); i++) {
                   if(fileWritten == fileSize){
                       break;
                   }
                   if(sb.charAt(i) == '1') {
                       visit = visit.right;
                   } else if (sb.charAt(i) == '0') {
                       visit = visit.left;
                   }
                   if(visit.left == null && visit.right == null){
                       os.write(visit.ascii);
                       visit = fnodes[1];
                       fileWritten++;
                   }
                   
                   cnt++;
               }
               sb.delete(0, cnt);
            }
        }
        
        visit = fnodes[1];
        for (int i = 0; i < sb.length(); i++) {
            if(fileWritten == fileSize){
                break;
            }
            if(sb.charAt(i) == '1') {
                visit = visit.right;
            } else if (sb.charAt(i) == '0') {
                visit = visit.left;
            }
            
            if(visit.left == null && visit.right == null){
                os.write(visit.ascii);
                visit = fnodes[1];
                fileWritten++;
                
            }
            
        }
        is.close();
        os.flush();
        os.close();
    
        System.out.println("File Written: " + fileWritten);
                
        
        /* Delete files */
        File f = new File(args[0]);
        f.delete();
        File s = new File("freq.ser");
        s.delete();
    }
}
