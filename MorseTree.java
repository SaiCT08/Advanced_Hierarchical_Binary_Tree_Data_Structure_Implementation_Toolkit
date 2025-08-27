/**
 *
 * @author Sai Thupakula
 * 235420
 */

package binarytreeproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * class representing a Morse Code translation tree.
 */
public class MorseTree 
{
    private TreeNode<String> root;

    /**
     * Constructor that initializes the MorseTree and populates it using a file.
     * @param fileName - The file containing Morse Code translations.
     */
    public MorseTree(String fileName) 
    {
        root = new TreeNode<>("start");
        emptyTree(root, 5);
        loadMorseCode(fileName);
    }

    /**
     * Creates an empty binary tree of the given height.
     * @param node - The current node being initialized.
     * @param height - The remaining height of the tree.
     */
    private void emptyTree(TreeNode<String> node, int height) 
    {
        if (height == 0) return;

        node.setLeftNode(new TreeNode<>(""));
        emptyTree(node.getLeftNode(), height - 1);

        node.setRightNode(new TreeNode<>(""));
        emptyTree(node.getRightNode(), height - 1);
    }

    /**
     * Adds Morse Code mappings from given file and populates tree.
     * @param fileName - The file containing Morse Code mappings.
     */
    private void loadMorseCode(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split("\t");

                if (parts.length == 2) 
                {
                    String letter = parts[0].trim();
                    String morseCode = parts[1].replace('•', '.').replace('─', '-'); // Normalize Morse symbols
                    addMorseCode(morseCode, letter);
                }
            }
        } catch (IOException e) 
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Adds a Morse Code mapping into the tree.
     * @param morseCode - The Morse Code representation.
     * @param letter - The letter corresponding to the Morse Code.
     */
    private void addMorseCode(String morseCode, String letter) 
    {
        TreeNode<String> current = root;

        for (char c : morseCode.toCharArray()) 
        {
            if (c == '.') { // Dot moves left
                if (current.getLeftNode() == null) 
                {
                    current.setLeftNode(new TreeNode<>(""));
                }
                current = current.getLeftNode();
            } 
            else if (c == '-') // Dash moves right
            {
                if (current.getRightNode() == null) 
                {
                    current.setRightNode(new TreeNode<>(""));
                }
                current = current.getRightNode();
            }
        }

        current.setValue(letter);
    }

    /**
     * Translates a single Morse Code sequence into a character or word.
     * @param morseCode - The Morse Code sequence.
     * @return The translated character or word.
     */
    public String translate(String morseCode) 
    {
        if (morseCode == null || morseCode.isEmpty()) return "?";

        morseCode = morseCode.replace('•', '.').replace('‧', '.'); // Normalize Morse symbols

        StringBuilder translatedWord = new StringBuilder();
        String[] letters = morseCode.trim().split("\\s+"); // Split into individual Morse letters

        for (String letter : letters) 
        {
            TreeNode<String> current = root;

            for (char c : letter.toCharArray()) 
            {
                if (c == '.') // Dot moves left
                {
                    if (current.getLeftNode() == null) return "?";
                    current = current.getLeftNode();
                } 
                else if (c == '-') // Dash moves right
                {
                    if (current.getRightNode() == null) return "?";
                    current = current.getRightNode();
                } 
                else 
                {
                    return "?"; // Invalid character in input
                }
            }

            translatedWord.append(current.getValue() != null && !current.getValue().isEmpty() ? current.getValue() : "?");
        }

        return translatedWord.toString();
    }

    /**
     * Translates a line of Morse Code into a readable sentence.
     * @param morseLine - The Morse Code sentence.
     * @return The translated sentence.
     */
    public String translateLines(String morseLine) 
    {
        StringBuilder result = new StringBuilder();
        String[] words = morseLine.trim().split("\\s*/\\s*"); // Split words using "/"

        for (String word : words) 
        {
            String[] letters = word.trim().split("\\s+");
            for (String letter : letters) 
            {
                if (!letter.isEmpty()) 
                {
                    result.append(translate(letter));
                }
            }
            result.append(" "); // Add space in between words
        }

        return result.toString().trim();
    }

    /**
     * Prints the Morse code tree
     */
    public void printTree(TreeNode<String> node, String morseCode) 
    {
        if (node == null) return;
        if (!node.getValue().equals("")) 
        {
            System.out.println("Morse Code: " + morseCode + " => Letter: " + node.getValue());
        }
        printTree(node.getLeftNode(), morseCode + ".");
        printTree(node.getRightNode(), morseCode + "-");
    }
}
