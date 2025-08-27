/**
 *
 * @author Sai Thupakula
 * 235420
 */

package binarytreeproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Morse Code Tester");
        MorseTree decoder = new MorseTree("src/binarytreeproject/MorseCodeInput.dat");
        System.out.println(decoder.translate("-")); //T
        System.out.println(decoder.translate(".")); //E
        System.out.println(decoder.translate("..-")); //U
        System.out.println(decoder.translate(".---")); //J
        System.out.println(decoder.translate("--")); //M
        System.out.println(decoder.translate(".-")); //A         
        System.out.println(decoder.translate(".-.")); //R
        System.out.println(decoder.translate("---")); //O
        System.out.println(decoder.translate("-..")); //D
        System.out.println(decoder.translate(".....")); //5
        System.out.println(decoder.translate("...--")); //3
        System.out.println(decoder.translate("--...")); //7 
        System.out.println(decoder.translateLines("--. --- --- -.. -... -.-- .")); //GOODBYE
        System.out.println(decoder.translateLines(".-. . -.-. ..- .-. ... .. --- -.")); //RECURSION
        System.out.println(decoder.translateLines("-.-. --- -- .--. ..- - . .-.")); //COMPUTER
        System.out.println(decoder.translateLines("... -.-. .. . -. -.-. .")); //SCIENCE
        System.out.println(decoder.translateLines(".... . .-.. .--. ..-. ..- .-..")); //HELPFUL       
        System.out.println(decoder.translateLines(".... . .-.. .-.. ---")); //HELLO 
        System.out.println(decoder.translateLines(".-- . / .- .-. . / - .... . / ... .- -. -.. ... / --- ..-. / - .. -- ."));
        System.out.println(decoder.translateLines("-.-. --- -- .--. ..- - . .-. / ... -.-. .. . -. -.-. . / .. ... / .- .-- . ... --- -- ."));
        System.out.println(decoder.translateLines(".- .-.. .-.. / - .... . / .-- --- .-. .-.. -.. / .. ... / .- / ... - .- --. . / ... --- / . -..- .. - / .-. .. --. .... - / -.-. ..- --.. / -. --- -... --- -.. -.-- / - . .-.. .-.. ... / -.-- --- ..- / .-- .... .- - / - --- / -.. ---"));
    
        System.out.println();
        System.out.println();
        
        System.out.println("BSTree Tests");
        //Tree 1
        System.out.println("Tree 1 Tests");
        BSTree<Integer> tree1 = new BSTree<Integer>(10);
        Integer[] nums = {8, 14, 6, 9, 12, 18, 3, 7, 11, 13, 19, 21, 23, 25, 28, 1, 0, -1, -2, -3};        
        for(Integer n : nums)
        {
            tree1.add(n);
        }
        System.out.println("Pre Order: " + tree1.preOrder());
        System.out.println("In order: " + tree1.inOrder());
        System.out.println("Post Order: " + tree1.postOrder());
        System.out.println("Does contain 18: " + tree1.contains(18));
        System.out.println("Does contain -2: " +tree1.contains(-2));
        System.out.println("Does contain 50: " +tree1.contains(50));
        System.out.println("Number of Leafs: " + tree1.countLeafs());
        System.out.println("Number of levels: " + tree1.countLevels());
        System.out.println("Number of Nodes: " + tree1.numNodes());
        System.out.println("Number of Internal Nodes: " + tree1.numInternalNodes());
        System.out.println("Height of the tree: " + tree1.getHeight());
        System.out.println("Is tree 1 full: " + tree1.isFull()); 
        System.out.println("Did it remove 14: " + tree1.remove(14));
        System.out.println("Tree One with out 14: " + tree1.inOrder());
        System.out.println("Did it remove 1: " + tree1.remove(1));
        System.out.println("Tree One with out 1: " + tree1.inOrder());
        System.out.println("Did it remove 21: " + tree1.remove(21));
        System.out.println("Tree One with out 21: " + tree1.inOrder());
        System.out.println("Did it remove 10: " + tree1.remove(10));
        System.out.println("Tree One with out 10:(preOrder) " + tree1.preOrder());
        System.out.println("Did it remove 50: " + tree1.remove(50));
        System.out.println("Number of Nodes: " + tree1.numNodes());
        System.out.println("Number of Internal Nodes: " + tree1.numInternalNodes());
        
        System.out.println();
        System.out.println("Tree 4 Tests");
        
        Integer[] nums2 = {20, 10, 35, 5, 40, 15, 24};
        BSTree<Integer> tree4 = new BSTree<Integer>();
        for(Integer n : nums2)
        {
            tree4.add(n);
        }
        System.out.println("Number of Leafs: " + tree4.countLeafs());
        System.out.println("Number of levels: " + tree4.countLevels());
        System.out.println("Number of Nodes: " + tree4.numNodes());
        System.out.println("Number of Internal Nodes: " + tree4.numInternalNodes());
        System.out.println("Height of the tree: " + tree4.getHeight());
        System.out.println("Is tree 4 full: " + tree4.isFull());
        
        
        System.out.println();
        System.out.println("Tree 2 Tests");
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        ArrayList<String> alpha = new ArrayList<String>();
        for(String x : alphabet)
        {
            alpha.add(x);
        }
        BSTree<String> tree2 = new BSTree<String>();
        tree2.buildBalancedTree(alpha);
        System.out.println(tree2.inOrder());        
        System.out.println(tree2.preOrder());
        System.out.println("Number of Leafs: " + tree2.countLeafs());
        System.out.println("Number of levels: " + tree2.countLevels());
        System.out.println("Number of Nodes: " + tree2.numNodes());
        System.out.println("Number of Internal Nodes: " + tree2.numInternalNodes());
        System.out.println("Height of the tree: " + tree2.getHeight());
        System.out.println("Is tree 2 full: " + tree2.isFull()); 
        
        System.out.println();
        System.out.println("Tree 3 Tests");        
        Scanner input = new Scanner(new File("src/binarytreeproject/BSTDictionary.txt"));
        ArrayList<String> dict = new ArrayList<String>();
        while(input.hasNext())
        {
            dict.add(input.nextLine());
        }
        System.out.println(dict.size());
        BSTree<String> tree3 = new BSTree<String>();
        tree3.buildBalancedTree(dict);
        System.out.println("Number of Leafs: " + tree3.countLeafs());
        System.out.println("Number of levels: " + tree3.countLevels());
        System.out.println("Number of Nodes: " + tree3.numNodes());
        System.out.println("Number of Internal Nodes: " + tree3.numInternalNodes());
        System.out.println("Height of the tree: " + tree3.getHeight());
        System.out.println("Is tree 3 full: " + tree3.isFull());
        FindWords comp = new FindWords();
        ArrayList<String> group = tree3.getGroup("ZY", comp);        
        System.out.println(group);
        String[] words = {"ZYMASE", "ZYMASES", "ZYME", "ZYMES", "ZYMOGEN", "ZYMOGENE", "ZYMOGENES", "ZYMOGENS", "ZYMOLOGIES", "ZYMOLOGY", "ZYMOSES", "ZYMOSIS", "ZYMOTIC", "ZYMURGIES", "ZYMURGY", "ZYZZYVA", "ZYZZYVAS", "ZZZZZZZ"};
        for(String str : words)
        {
            System.out.println("Remove " + str + " : " + tree3.remove(str));
        }        
        group = tree3.getGroup("ZY", comp);        
        System.out.println(group);    
    }
    
}
