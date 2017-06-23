/**
 * DOSHI DEVANG Huffman_4713
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class henc4713 {
    public static void main(String[] args) throws IOException {
        
        String inputFile = args[0];
        long startTime = System.currentTimeMillis();
    
        // Read a file as binary input from command line argument
        InputStream is = new BufferedInputStream(new FileInputStream(args[0]));
        int fileByte;
        Node[] frequency = new Node[256];
    
        for (int i = 0; i < frequency.length; i++) {
            frequency[i] = new Node(i, 0);
        }
        
        while((fileByte = is.read()) != -1){
            frequency[fileByte].frequency++;
        }
    
        long endTime = System.currentTimeMillis();
        System.out.println("Time to read:" + (endTime - startTime) + " ms");
    
        // Calculate frequency of each byte
        
        int totalBytes = 0;
        for (int i = 0; i < frequency.length ; i++) {
            System.out.println(i + "= " + frequency[i].frequency);
            totalBytes+= frequency[i].frequency;
        }
        System.out.println("Total : " + totalBytes + " bytes");
    
        Node[] fnodes = huffman(frequency);
        
        /* The "frequency" array is serialized and stored in freq.ser */
        try {
            FileOutputStream fos = new FileOutputStream("freq.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(frequency);
            oos.close();
            fos.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        
        /* Read serialized file */
        InputStream sis = new BufferedInputStream(new FileInputStream("freq.ser"));
        int serSize = 0;
        
        /* Find out size of serialized file */
        while((sis.read()) != -1){
            serSize++;
        }
        
        
        /* Write .huf file */
        try {
            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(inputFile + ".huf"));
            
            /* convert serSize to bytes and write to file */
            int[] ssize = createSizeBytes(serSize, 8);
    
            for (int i = 0; i < ssize.length ; i++) {
                os.write(ssize[i]);
            }
            
            /* convert original file size to bytes and write to file */
            int[] fsize = createSizeBytes(totalBytes, 12);
            for (int i = 0; i < fsize.length ; i++) {
                os.write(fsize[i]);
            }
            
            /* write serialized object */
            int serByte;
            sis = new BufferedInputStream(new FileInputStream("freq.ser"));
            while((serByte = sis.read()) != -1){
                os.write(serByte);
            }
            
            /* read original file and convert it to string */
            /* padd requisite amount of zeros to make is divisible by 8 */
            /* convert every 8 chars to integers */
    
            is = new BufferedInputStream(new FileInputStream(args[0]));
            
            // String buff = new String();
            StringBuilder buff = new StringBuilder();
            while((fileByte = is.read()) != -1){
               buff.append(frequency[fileByte].prefix);
               
               if(buff.length() > 16000){
                   buff = new StringBuilder(writeBuff(buff, os, 0));
               }
            }
            if(buff.length() > 0){
                writeBuff(buff, os, 1);
            }
            
            os.flush();
            os.close();
            
            is.close();
            
            /* Delete files */
            File f = new File(args[0]);
            f.delete();
            File s = new File("freq.ser");
            s.delete();
            
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        endTime = System.currentTimeMillis();
        System.out.println("Total Time: " + (endTime - startTime) + " ms");
    }
    
    public static Node[] huffman(Node[] frequency){
        // Generate MaxHeap
        Node[] fnodes = new Node[257];
        fnodes[0] = new Node(0,0);
        for (int i = 1; i < fnodes.length ; i++) {
            if(frequency[i-1].frequency > 0)
                insert(fnodes, frequency[i-1]);
        }
        
        // Extract two min nodes and add an internal node
        int internal = 1001;
        
        while(fnodes[0].frequency > 1){
            Node m1 = extract(fnodes);
            Node m2 = extract(fnodes);
            Node newNode = combine(m1, m2, internal++);
            insert(fnodes, newNode);
        }
        
        // Print MinHeap of frequencies
        for (int i = 1; i <= fnodes[0].frequency; i++) {
            System.out.println(i + "= " + fnodes[i].ascii + " " + fnodes[i].frequency);
        }
        
        printTree(fnodes[1]);
        return fnodes;
    }
     
    public static int[] createSizeBytes(int value, int size){
        int[] result = new int[size];
        char[] c = Integer.toString(value).toCharArray();
        for (int i = 0; i < size - c.length; i++) {
            result[i] = 0;
        }
        int j = 0;
        for (int i = size-c.length; i < size; i++) {
            result[i] = Character.getNumericValue(c[j++]);
        }
        return result;
    }
    
    public static StringBuilder writeBuff(StringBuilder buff, BufferedOutputStream os, int action) throws IOException {
        
        if(buff.length() < 8){
            int c = buff.length();
            for (int i = 0; i < c ; i++) {
                buff.append('0');
            }
            int word = Integer.parseInt(buff.toString(),2);
            os.write(word);
            buff.delete(0,8);
            return buff;
        } else {
            while(buff.length() > 7){
                int word = Integer.parseInt(buff.substring(0, 8),2);
                os.write(word);
                buff.delete(0,8);
            }
            
            if(action == 1){
                int c = buff.length();
                if(c < 8){
                    for (int i = 0; i < 8-c ; i++) {
                        buff.append('0');
                    }
                    int word = Integer.parseInt(buff.toString(),2);
                    os.write(word);
                }
            }
            return buff;
        }
    }
    
    public static void insert(Node[] A, Node n){
        int i = A[0].frequency + 1;
        A[i] = n;
        int p = parent(i);
        int c = i;
    
        if(i > 1){
            while(p > 0 && A[p].frequency > A[c].frequency){
                swap(A, p, c);
                c = p;
                p = parent(p);
            }
        }
        A[0].frequency++;
    }
    
    public static Node extract(Node[] A){
        if(A[0].frequency < 1){
            return null;
        }
        Node result = A[1];
        A[1] = A[A[0].frequency];
        // MinHeapify
        int i = 1;
        int l = left(A,i);
        int r = right(A, i);
        if(l != -1 && r != -1){
            while(A[i].frequency > A[l].frequency || A[i].frequency > A[r].frequency){
                // if value is bigger than both child
                if(A[i].frequency > A[l].frequency && A[i].frequency > A[r].frequency){
                    if(A[l].frequency < A[r].frequency){
                        swap(A, i, l);
                        i = l;
                    } else {
                        swap(A, i, r);
                        i = r;
                    }
                } else if(A[i].frequency > A[r].frequency){
                    swap(A, i, r);
                    i = r;
                } else {
                    swap(A, i, l);
                    i = l;
                }
                l = left(A,i);
                r = right(A,i);
                if(l == -1 || r == -1){
                    break;
                }
            }
        }
        
        A[0].frequency--;
        return result;
    }
    
    public static Node combine(Node one, Node two, int ascii){
        int f = one.frequency + two.frequency;
        Node result = new Node(ascii, f, one, two);
        return result;
    }
    
    public static void swap(Node[] A, int p1, int p2){
        Node temp = A[p1];
        A[p1] = A[p2];
        A[p2] = temp;
    }
    
    public static int left(Node[] A, int i){
        if(2 * i <= A[0].frequency){
            return 2 * i;
        }
        return -1;
    }
    
    public static int right(Node[] A, int i){
        if(2 * i + 1 <= A[0].frequency){
            return 2 * i + 1;
        }
        return -1;
    }
    
    public static int parent(int i){
        if(i == 1) {
            return -1;
        } else {
            return i/2;
        }
    }
    
    public static void printTree(Node n){
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        int sum = 0;
        while(!q.isEmpty()){
            Node c = q.remove();
            
            if(c.right == null && c.left == null){
                // System.out.print(c);
                System.out.print(" --- "+ c.prefix + " ---");
                sum+= (c.frequency * c.prefix.length());
            }
    
            System.out.println(c);
            
            if(c.left != null){
                q.add(c.left);
                c.left.prefix = c.prefix + "0";
            }
            
            if(c.right != null){
                q.add(c.right);
                c.right.prefix = c.prefix + "1";
            }
            
            
        }
    
        System.out.println("Compressed Bytes = " + sum / 8);
        
    }
    
    protected static class Node implements Serializable{
        protected Node left;
        protected Node right;
        protected int ascii;
        protected int frequency;
        protected String prefix;
        
    
        protected Node() {
            
        }
        protected Node(int ascii, int frequency) {
            this.ascii = ascii;
            this.frequency = frequency;
            this.prefix = new String();
        }
    
        protected Node(int ascii, int frequency, Node left, Node right) {
            this.ascii = ascii;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
            this.prefix = new String();
        }
        
        public String toString(){
            return "[" + this.ascii + "]: " + this.frequency + " -> " + this.prefix;
        }
    }
}


