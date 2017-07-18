
public class AVLTreeSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		 
        tree.root = tree.add(tree.root, 10);
        tree.root = tree.add(tree.root, 20);
        tree.root = tree.add(tree.root, 30);
        tree.root = tree.add(tree.root, 40);
        tree.root = tree.add(tree.root, 50);
        tree.root = tree.add(tree.root, 25);
	}

}

class AVLNode
{
	int data;
	int height;
	AVLNode left;
	AVLNode right;
	
	AVLNode(int data)
	{
		this.data = data;
	}
}

class AVLTree
{
	AVLNode root;
	
	//Utility methods
	public int heightOf(AVLNode root)
	{
		if(root != null)
		{
			return 1 + max(heightOf(root.left), heightOf(root.right));
		}
		return -1;
	}

	//A utility function to get maximum of two integers
	int max(int a, int b) {
	    return (a > b) ? a : b;
	}
	
	int balanceFactor(AVLNode root)
	{
		return heightOf(root.left) - heightOf(root.right);
	}
	
	//Left rotate means Right Right CASE
	AVLNode leftRotate(AVLNode root)
	{
		AVLNode temp = root.right;
		AVLNode temp1 = temp.left;
		
		root.right = temp1;
		temp.left = root;
		
		//Adjust Height
		root.height = heightOf(root);
		temp.height = heightOf(temp);
		return temp;
	}
	
	//Right rotate means Left Left CASE
	AVLNode rightRotate(AVLNode root)
	{
		AVLNode temp = root.left;
		AVLNode temp1 = temp.right;
		
		root.left = temp1;
		temp.right = root;
		
		//Adjust Height
		root.height = heightOf(root);
		temp.height = heightOf(temp);
		return temp;
	}
	
	public AVLNode add(AVLNode root, int data)
	{
		//Perform BST addition 
		if(root == null)
			return new AVLNode(data);
		if(root.data > data)
			root.left = add(root.left, data);
		else
			root.right = add(root.right, data);
		
		//Update Height
		root.height = heightOf(root);
		
		//Get the Balance Factor
		int bf = balanceFactor(root);
		
		//Rotate the Tree : Left Left Case : Right Rotate
		if(bf > 1 && data < root.left.data)
			return rightRotate(root);
		
		//Rotate the Tree : Right Right Case : Left Rotate
		if(bf < -1 && data > root.right.data)
			return leftRotate(root);
		
		//Rotate the Tree : Left Right Case : Left Rotate and then Right Rotate
		if(bf > 1 && data > root.left.data)
		{
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		
		//Rotate the Tree : Right Left Case : Right Rotate and then Left Rotate
		if(bf < -1 && data < root.right.data)
		{
			root.right = rightRotate(root.left);
			return leftRotate(root);
		}
		return root;
	}
	
}