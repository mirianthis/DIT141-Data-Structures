package org.hua.test;
        
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
 
import javax.lang.model.type.NullType;
public class Payroll{
 
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Scanner sc = null;
        String userInput;
        int count = 0;
        int[] frequency = new int[7];
        String textFile = "";
 
        //Prompts the user to enter in the file     
     //   System.out.println("Enter in the file name.");
     //   String userFile = input.nextLine();
 
        //Scans the inputed file and counts the capitals
        try{
            sc = new Scanner(new File("C:\\Users\\35797\\Desktop\\ΧΑΡΟΚΟΠΕΙΟ\\3ο ΕΞΑΜΗΝΟ\\ΔΟΜΕΣ ΔΕΔΟΜΕΝΩΝ\\ΕΡΓΑΣΙΕΣ\\Ask2\\frequencies.dat"));
            while(sc.hasNext()){
                String line = sc.nextLine();
                textFile += line;
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'A')
                        frequency[0]++;
                    if(line.charAt(i) == 'B')
                        frequency[1]++;
                    if(line.charAt(i) == 'C')
                        frequency[2]++;
                    if(line.charAt(i) == 'D')
                        frequency[3]++;
                    if(line.charAt(i) == 'E')
                        frequency[4]++;
                    if(line.charAt(i) == 'F')
                        frequency[5]++;
                    if(line.charAt(i) == 'G')
                        frequency[6]++;               
                }
            }
            //Catch if file is entered wrong        
        }catch(FileNotFoundException e){
            System.out.println("File not found, exiting program");
            System.exit(0);
        }
        finally{
            sc.close();
        }
        final HuffmanNode root = buildTree(frequency);
        final Map<String, String> charCode = generateCodes(root, frequency);
        final String encodedMessage = encodeMessage(charCode, textFile);
 
        // Menu for the user to select the output    
        while(true){
            System.out.println(" __________________________");
            System.out.println("|           Menu           |");
            System.out.println("|      Enter in a char     |");
            System.out.println("|==========================|");
            System.out.println("|a = The Huffman tree.     |");
            System.out.println("|b = The Code Table.       |");
            System.out.println("|c = The Binary Encoding.  |");
            System.out.println("|d = The A-G.              |");
            System.out.println("|e = Exit the program.     |");
            System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~");
            userInput = input.next();
 
            if(userInput.equals("a")){
                System.out.println(" ");
                printTree(root);
                System.out.println(" ");
                System.out.println("Try b next.");
            }
            if(userInput.equals("b")){
                System.out.println(" ");
                System.out.println(charCode);
                System.out.println(" ");
                System.out.println("Try c next.");
            }
            if(userInput.equals("c")){
                System.out.println(" ");
                System.out.println(encodedMessage);
                System.out.println(" ");
                System.out.println("Try d next.");
            }
            if(userInput.equals("d")){
                System.out.println(" ");
                System.out.println(decodeMessage(encodedMessage, charCode));
                System.out.println(" ");
            }
            if(userInput.equals("e")){
                System.out.println(" ");
                System.out.println("Exiting");
                System.exit(0);
            }
        }
    }
    private static class HuffmanNode{
 
        String x;
        int count;
        HuffmanNode leftChild;
        HuffmanNode rightChild;
 
 
        HuffmanNode(String x, int count, HuffmanNode leftChild, HuffmanNode rightChild){
            this.x = x;
            this.count = count;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
    //Implement a comparator to compare the frequency count
    private static class HuffManComparator implements Comparator<HuffmanNode>{
        @Override
        public int compare(HuffmanNode node1, HuffmanNode node2){
            return node1.count - node2.count;
        }
    }
    //Implements a Priority Queue
    private static Queue<HuffmanNode> createNodeQueue(int [] array){
        final Queue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(11, new HuffManComparator());
        for(int i = 0; i < array.length; i++){
            pq.add(new HuffmanNode(Integer.toString(array[i]), array[i], null, null));
        }
        return pq;
    }
    //Builds the tree
    private static HuffmanNode buildTree(int []array){
        final Queue<HuffmanNode> nodeQueue = createNodeQueue(array);
 
        while(nodeQueue.size() > 1){
            final HuffmanNode node1 = nodeQueue.remove();
            final HuffmanNode node2 = nodeQueue.remove();
            HuffmanNode combinedNode = new HuffmanNode(Integer.toString(node1.count + node2.count), node1.count + node2.count, node1, node2);
            nodeQueue.add(combinedNode);
        }
 
        return nodeQueue.remove();
    }
    private static void printTree(HuffmanNode root){
        Queue<HuffmanNode> level = new LinkedList<>();
        Queue<HuffmanNode> newLevel = new LinkedList<>();
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        //boolean flag = true;
        int counter = 0;
        level.add(root);
        System.out.println(
                "...........................................");
        while(!level.isEmpty()){
            Iterator<HuffmanNode> itr = level.iterator();
            while(itr.hasNext()){
                HuffmanNode node = itr.next();
                if(node.leftChild != null){
                    newLevel.add(node.leftChild);
                }
                if(node.rightChild != null){
                    newLevel.add(node.rightChild);
                }
                if(node.leftChild == null && node.rightChild == null){
//                  HuffmanNode emptyChildren = new HuffmanNode("__ __", 0, null, null);
//                  if(counter <= level.size()){
//                      newLevel.add(emptyChildren);
//                  }
//                  counter++;
                }
                System.out.print("  " + node.x + "  ");    
 
            }
            System.out.println();
            level = newLevel;
            newLevel = new LinkedList<HuffmanNode>();
 
        }
        System.out.println(
                "...........................................");
    }  
    private static Map<String, String> generateCodes(HuffmanNode node, int[] frequencyTable){
        final Map<String, String> map = new HashMap<String, String>();
        String [] stringArray = new String[7];
        stringArray[0] = "A";
        stringArray[1] = "B";
        stringArray[2] = "C";
        stringArray[3] = "D";
        stringArray[4] = "E";
        stringArray[5] = "F";
        stringArray[6] = "G";
        Map<String, String> freqChar = new HashMap<String, String>();
        doGenerateCode(node, map, "");
        for(int j = 0; j < frequencyTable.length; j++){
            freqChar.put(stringArray[j], map.get(Integer.toString(frequencyTable[j])));
        }
        return freqChar;
    }
 
    private static void doGenerateCode(HuffmanNode node, Map<String, String> map, String s){
 
        if(node.leftChild == null && node.rightChild == null){
            map.put(node.x,s);
            return;
        }
        doGenerateCode(node.leftChild, map, s + "0");
        doGenerateCode(node.rightChild, map, s + "1");
    }
 
    private static String encodeMessage(Map<String, String> charCode, String sentence) {
        String c = "";
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'G'){
                c += charCode.get(sentence.charAt(i));
            }
        }
        return c;
    }  
    private static String decodeMessage(String s, Map<String, String> charCode){
        String temp = "";
        String result = "";
 
        for(int i =0; i < s.length(); i++){
            temp += s.charAt(i);
            if(charCode.containsValue(temp)){
                for(Entry<String, String> entry: charCode.entrySet()){
                    if(Objects.equals(temp, entry.getValue())){
                        result = result + entry.getKey();
                        temp = new String();
                    }
                }
            }
        }
        return result;
    }                 
}