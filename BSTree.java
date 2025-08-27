package binarytreeproject;

/**
 *
 * @author Sai Thupakula
 * 235420
 */

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A generic Binary Search Tree implementation.
 * @param <T> the type of elements stored in the tree
 */
public class BSTree<T extends Comparable<T>> 
{
    private TreeNode<T> root;
    
    /**
     * Constructs an empty binary search tree.
     * Post-condition: The tree is initialized with a null root.
     */
    public BSTree() 
    {
        this.root = null;
    }
    
    /**
     * Constructs a binary search tree with a specified initial root value.
     * @param rootValue the value for the root node
     * Pre-condition: A valid value of type T is provided.
     * Post-condition: The tree is initialized with a root containing the given value.
     */
    public BSTree(T rootValue) 
    {
        this.root = new TreeNode<>(rootValue);
    }
    
    /**
     * Determines if the tree contains a specific value.
     * @param value the value to find
     * @return true if the value is present, false otherwise
     * Pre-condition: A valid value of type T is provided.
     * Post-condition: The result indicates whether the value exists in the tree.
     */
    public boolean contains(T value) 
    {
        return contains(value, root);
    }
    
    /**
     * Recursively searches for the specified value in the subtree rooted at the given node.
     * @param value the value to find
     * @param node the current node to check
     * @return true if the value is found, false otherwise
     * Pre-condition: Valid inputs for value and node.
     * Post-condition: The method returns true if the value exists within the subtree.
     */
    private boolean contains(T value, TreeNode<T> node) 
    {
        if (node != null) 
        {
            if (node.getValue().equals(value)) 
            {
                return true;
            }
            else if (node.getValue().compareTo(value) > 0) 
            {
                return contains(value, node.getLeftNode());
            }
            else 
            {
                return contains(value, node.getRightNode());
            }
        }
        return false;
    }
    
    /**
     * Inserts a new value into the tree.
     * @param value the value to insert
     * @return true if insertion is successful, false if the value already exists
     * Pre-condition: A valid value of type T is provided.
     * Post-condition: The tree includes the value if it was not previously present.
     */
    public boolean add(T value) 
    {
        if (contains(value)) 
        {
            return false;
        }
        root = add(value, root);
        return true;
    }
    
    /**
     * Recursively inserts a value into the subtree.
     * @param value the value to insert
     * @param node the current node in the subtree
     * @return the updated subtree with the new value inserted
     * Pre-condition: Valid inputs for value and node.
     * Post-condition: The subtree is updated with the new value if it wasn't present before.
     */
    private TreeNode<T> add(T value, TreeNode<T> node) 
    {
        if (node == null) 
        {
            return new TreeNode<>(value);
        }
        if (node.getValue().compareTo(value) > 0) 
        {
            node.setLeftNode(add(value, node.getLeftNode()));
        }
        else if (node.getValue().compareTo(value) < 0) 
        {
            node.setRightNode(add(value, node.getRightNode()));
        }
        return node;
    }
    
    /**
     * Executes a pre-order traversal of the tree.
     * @return a list of values in pre-order sequence
     * Pre-condition: The tree exists.
     * Post-condition: The list contains the tree's elements in pre-order order.
     */
    public ArrayList<T> preOrder() 
    {
        ArrayList<T> ans = new ArrayList<>();
        preOrder(ans, root);
        return ans;
    }
    
    /**
     * Recursively performs a pre-order traversal of the subtree.
     * @param ans the list to collect traversal results
     * @param node the current node in the traversal
     * Pre-condition: Valid list and node provided.
     * Post-condition: The list is populated with elements in pre-order sequence.
     */
    private void preOrder(ArrayList<T> ans, TreeNode<T> node) 
    {
        if (node == null) 
        {
            return;
        }
        ans.add(node.getValue());
        preOrder(ans, node.getLeftNode());
        preOrder(ans, node.getRightNode());
    }
    
    /**
     * Executes an in-order traversal of the tree.
     * @return a list of values in in-order sequence
     * Pre-condition: The tree exists.
     * Post-condition: The list contains elements in in-order order.
     */
    public ArrayList<T> inOrder() 
    {
        ArrayList<T> ans = new ArrayList<>();
        inOrder(ans, root);
        return ans;
    }
    
    /**
     * Recursively performs an in-order traversal of the subtree.
     * @param ans the list to collect traversal results
     * @param node the current node in the traversal
     * Pre-condition: Valid list and node provided.
     * Post-condition: The list is populated with elements in in-order sequence.
     */
    private void inOrder(ArrayList<T> ans, TreeNode<T> node) 
    {
        if (node == null) 
        {
            return;
        }
        inOrder(ans, node.getLeftNode());
        ans.add(node.getValue());
        inOrder(ans, node.getRightNode());
    }
    
    /**
     * Executes a post-order traversal of the tree.
     * @return a list of values in post-order sequence
     * Pre-condition: The tree exists.
     * Post-condition: The list contains elements in post-order order.
     */
    public ArrayList<T> postOrder() 
    {
        ArrayList<T> ans = new ArrayList<>();
        postOrder(ans, root);
        return ans;
    }

    /**
     * Recursively performs a post-order traversal of the subtree.
     * @param ans the list to collect traversal results
     * @param node the current node in the traversal
     * Pre-condition: Valid list and node provided.
     * Post-condition: The list is populated with elements in post-order sequence.
     */
    private void postOrder(ArrayList<T> ans, TreeNode<T> node) 
    {
        if (node == null) 
        {
            return;
        }
        postOrder(ans, node.getLeftNode());
        postOrder(ans, node.getRightNode());
        ans.add(node.getValue());
    }
    
    /**
     * Checks if a node is a leaf.
     * @param node the node to check
     * @return true if the node is a leaf, false otherwise
     */
    private boolean isLeaf(TreeNode<T> node) 
    {
        return node != null && node.getLeftNode() == null && node.getRightNode() == null;
    }
    
    /**
     * Counts the total number of leaf nodes in the tree.
     * @return the count of leaf nodes
     */
    public int countLeafs() 
    {
        return countLeafs(root);
    }
    
    /**
     * Recursively counts leaf nodes in the subtree.
     * @param node the current node in the subtree
     * @return the count of leaf nodes in the subtree
     */
    private int countLeafs(TreeNode<T> node) 
    {
        if (node == null) 
        {
            return 0;
        }
        if (isLeaf(node)) 
        {
            return 1;
        }
        return countLeafs(node.getLeftNode()) + countLeafs(node.getRightNode());
    }
    
    /**
     * Calculates the total number of levels in the tree.
     * @return the tree's level count
     */
    public int countLevels() 
    {
        return countLevels(root);
    }
    
    /**
     * Recursively computes the number of levels in the subtree.
     * @param node the current node
     * @return the count of levels in the subtree
     */
    private int countLevels(TreeNode<T> node) 
    {
        if (node == null) 
        {
            return 0;
        }
        int leftLevels = countLevels(node.getLeftNode());
        int rightLevels = countLevels(node.getRightNode());
        return 1 + Math.max(leftLevels, rightLevels);
    }
    
    /**
     * Retrieves the height of the tree.
     * @return the height of the tree
     */
    public int getHeight() 
    {
        return countLevels() - 1;
    }

    /**
     * Counts the total number of nodes in the tree.
     * @return the count of nodes
     */
    public int numNodes() 
    {
        return numNodes(root);
    }
    
    /**
     * Recursively counts nodes in the subtree.
     * @param node the current node
     * @return the count of nodes in the subtree
     */
    private int numNodes(TreeNode<T> node) 
    {
        if (node == null) 
        {
            return 0;
        }
        return 1 + numNodes(node.getLeftNode()) + numNodes(node.getRightNode());
    }

    /**
     * Counts the number of internal nodes (non-leaf and non-root) in the tree.
     * @return the number of internal nodes
     */
    public int numInternalNodes() 
    {
        if (root == null || (root.getLeftNode() == null && root.getRightNode() == null)) 
        {
            return 0;
        }
        return numNodes() - countLeafs() - 1;
    }

    /**
     * Checks if the tree is a full binary tree.
     * @return true if full, false otherwise
     */
    public boolean isFull() 
    {
        return isFull(root);
    }

    /**
     * Recursively checks if the subtree is full.
     * @param node the subtree's root node
     * @return true if the subtree is full, false otherwise
     */
    private boolean isFull(TreeNode<T> node) 
    {
        if (node == null) 
        {
            return true;
        }
        if (isLeaf(node)) 
        {
            return true;
        }
        if (node.getLeftNode() != null && node.getRightNode() != null) 
        {
            return isFull(node.getLeftNode()) && isFull(node.getRightNode());
        }
        return false;
    }

    /**
     * Removes a value from the tree.
     * @param value the value to remove
     * @return true if removed, false if not found
     */
    public boolean remove(T value) 
    {
        if (!contains(value)) 
        {
            return false;
        }
        root = remove(value, root);
        return true;
    }

    /**
     * Recursively removes a value from the subtree.
     * @param value the value to remove
     * @param node the subtree's root node
     * @return the subtree after removal
     */
    private TreeNode<T> remove(T value, TreeNode<T> node) 
    {
        if (node == null) 
        {
            return null;
        }
        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) 
        {
            node.setLeftNode(remove(value, node.getLeftNode()));
        } 
        else if (cmp > 0) 
        {
            node.setRightNode(remove(value, node.getRightNode()));
        } 
        else 
        {
            if (node.getLeftNode() == null && node.getRightNode() == null) 
            {
                return null;
            }
            if (node.getLeftNode() == null) 
            {
                return node.getRightNode();
            } 
            else if (node.getRightNode() == null) 
            {
                return node.getLeftNode();
            }
            TreeNode<T> minNode = findMin(node.getRightNode());
            node.setValue(minNode.getValue());
            node.setRightNode(remove(minNode.getValue(), node.getRightNode()));
        }
        return node;
    }

    /**
     * Finds the node with the minimum value in the subtree.
     * @param node the subtree's root node
     * @return the node with the smallest value
     */
    private TreeNode<T> findMin(TreeNode<T> node) 
    {
        if (node.getLeftNode() == null) 
        {
            return node;
        }
        return findMin(node.getLeftNode());
    }

    /**
     * Builds a balanced binary search tree from a sorted list.
     * @param list a sorted list of elements
     * Pre-condition: The list is sorted.
     * Post-condition: The tree is rebuilt as a balanced tree.
     */
    public void buildBalancedTree(ArrayList<T> list) 
    {
        root = null;
        buildBalancedTree(list, 0, list.size() - 1);
    }

    /**
     * Recursively constructs a balanced tree from a sorted list.
     * @param list the sorted list
     * @param start the starting index
     * @param stop the ending index
     */
    private void buildBalancedTree(ArrayList<T> list, int start, int stop) 
    {
        if (start > stop) 
        {
            return;
        }
        int mid = (start + stop) / 2;
        add(list.get(mid));
        buildBalancedTree(list, start, mid - 1);
        buildBalancedTree(list, mid + 1, stop);
    }

    /**
     * Retrieves elements that match a given criterion.
     * @param key the matching key
     * @param comp a comparator that defines the matching logic
     * @return a list of elements that match the criterion
     */
    public ArrayList<T> getGroup(Object key, Comparator comp) 
    {
        ArrayList<T> group = new ArrayList<>();
        getGroup(root, key, comp, group);
        return group;
    }

    /**
     * Recursively finds elements that match the given key based on the comparator.
     * @param node the subtree's root node
     * @param key the matching key
     * @param comp the comparator defining the matching logic
     * @param group the list to collect matching elements
     */
    private void getGroup(TreeNode<T> node, Object key, Comparator<T> comp, ArrayList<T> group) 
    {
        if (node == null) 
        {
            return;
        }
        String prefix = (String) key;
        String value = node.getValue().toString();

        getGroup(node.getLeftNode(), key, comp, group);

        if (value.startsWith(prefix)) 
        {
            group.add(node.getValue());
        }

        getGroup(node.getRightNode(), key, comp, group);
    }

}
