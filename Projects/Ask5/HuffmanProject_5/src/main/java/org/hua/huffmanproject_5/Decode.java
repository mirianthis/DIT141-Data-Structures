package org.hua.huffmanproject_5;

public class Decode {

    public String decode(String S, HuffmanNode root) {
        String file = "";        
        StringBuilder output = new StringBuilder();
        HuffmanNode base = root;
        while (!S.isEmpty()) {
            if (S.charAt(0) == '1') {
                base = base.right;
                S = S.substring(1);
            } else {
                base = base.left;
                S = S.substring(1);
            }
            if (base.left == null && base.right == null) {
                output.append(base.c);
                base = root;
            }

        }
        file += output.toString();

        return file;
    }
}
