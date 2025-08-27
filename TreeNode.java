package binarytreeproject;

/**
 * @author Sai Thupakula
 * 235420
 */

/**
 * A generic node class for use in a binary tree.
 * @param <T> - The type of data stored in the node.
 */
public class TreeNode<T> 
{
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    /**
     * Creates a TreeNode with default values.
     * Pre-condition: No input required.
     * Post-condition: Node created with value, left, and right set to null.
     */
    public TreeNode() 
    {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Creates a TreeNode with a specified value.
     * @param value - The value to be stored in the node.
     * Pre-condition: A valid value of type T is provided.
     * Post-condition: Node created with the given value and no children.
     */
    public TreeNode(T value) 
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Creates a TreeNode with a given value and specified child nodes.
     * @param value - The value to store.
     * @param left - Reference to the left child node.
     * @param right - Reference to the right child node.
     * Pre-condition: Valid value and optional child nodes are provided.
     * Post-condition: Node created with specified value and children.
     */
    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) 
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * Retrieves the value stored in the node.
     * @return The node's value.
     * Pre-condition: None.
     * Post-condition: The stored value is returned.
     */
    public T getValue() 
    {
        return value;
    }

    /**
     * Accesses the left child of the node.
     * @return The left child node.
     * Pre-condition: None.
     * Post-condition: The left child is returned.
     */
    public TreeNode<T> getLeftNode() 
    {
        return left;
    }

    /**
     * Accesses the right child of the node.
     * @return The right child node.
     * Pre-condition: None.
     * Post-condition: The right child is returned.
     */
    public TreeNode<T> getRightNode() 
    {
        return right;
    }

    /**
     * Updates the node's value.
     * @param value - The new value to assign.
     * Pre-condition: A valid value of type T is provided.
     * Post-condition: Node's value is updated.
     */
    public void setValue(T value) 
    {
        this.value = value;
    }

    /**
     * Sets the left child node.
     * @param left - The new left child.
     * Pre-condition: A valid TreeNode or null.
     * Post-condition: Left child is updated.
     */
    public void setLeftNode(TreeNode<T> left) 
    {
        this.left = left;
    }

    /**
     * Sets the right child node.
     * @param right - The new right child.
     * Pre-condition: A valid TreeNode or null.
     * Post-condition: Right child is updated.
     */
    public void setRightNode(TreeNode<T> right) 
    {
        this.right = right;
    }

    /**
     * Provides a string representation of the node.
     * @return A string displaying the node's value and its children.
     * Pre-condition: None.
     * Post-condition: String representation of the node is returned.
     */
    @Override
    public String toString() 
    {
        return "TreeNode{" + "value=" + value + ", left=" + (left != null ? left.getValue() : "null") + ", right=" + (right != null ? right.getValue() : "null") + '}';
    }
}
