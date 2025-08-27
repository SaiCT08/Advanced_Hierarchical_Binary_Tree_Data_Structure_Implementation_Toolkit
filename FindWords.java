package binarytreeproject;

/**
 *
 * @author Sai Thupakula
 * 235420
 */

import java.util.Comparator;

/**
 * Comparator for comparing words based on whether they start with the prefix given by user
 */
public class FindWords implements Comparator<String> 
{
    /**
     * Compares a key (prefix) with a word.
     * @param prefix the key (prefix), expected to be a String.
     * @param word the word to compare, expected to be a String.
     * @return 0 if the word starts with the prefix; otherwise, the result of prefix.compareTo(word).
     */
    @Override
    public int compare(String prefix, String word) 
    {
        if (word.startsWith(prefix)) 
        {
            return 0; // Match found
        }
        return prefix.compareTo(word); // keeps correct order
    }
}
