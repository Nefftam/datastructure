public class TreeSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree t1 = new Tree();
		t1.add(20);
		t1.add(15);
		t1.add(10);
		t1.add(18);
		t1.add(30);
		t1.add(25);
		t1.add(35);
		t1.add(37);
		
		int heightOfTree = t1.heightOfTree(t1.root);
		System.out.println("Height of the Tree " + heightOfTree);
		
		int elementHeight = 35; 
		int treeNodeHeight = t1.heightOfTreeNode(t1.root, elementHeight);
		System.out.println("TreeNode Height " + treeNodeHeight);
		
		/*Tree t2 = new Tree();
		t2.root = t2.addWithRecursion(t2.root, 20);
		t2.root = t2.addWithRecursion(t2.root, 15);
		t2.root = t2.addWithRecursion(t2.root, 10);
		t2.root = t2.addWithRecursion(t2.root, 18);*/
		
		/*t1.preOrder(t1.root);
		t1.postOrder(t1.root);
		t1.inOrder(t1.root);*/
		String[] arr = new String[heightOfTree +1];
		t1.traverseInLevelOrder(t1.root, arr, 0);
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + "-->>>>>");
		}
		System.out.println();
		
		t1.printAllNodesInIncreasingOrder(t1.root);
		System.out.println("-------------------");
		
		t1.printAllNodesInDecreasingOrder(t1.root);
		System.out.println("-------------------");
		
		int element = 37;
		TreeNode searchRoot = t1.searchElement(t1.root, element);
		
		
		TreeNode copyTree = t1.copyTree(t1.root);
		System.out.println("Copied Tree");
		
		TreeNode mirrorTree = t1.mirrorTree(t1.root);
		System.out.println("Mirror Tree");
		
		int elementDepth = 35;
		int count =0;
		int treeNodeDepth = t1.depthOfTreeNode_recursion(t1.root, elementDepth, count);
		System.out.println("Tree Node Depth " + treeNodeDepth);
		
		//Size of tree = Total number of TreeNodes present in tree
		int sizeOfTree = t1.sizeOfTree(t1.root);
		System.out.println("Size of Tree " + sizeOfTree);
		
		TreeNode minTreeNode = t1.minimumTreeNode(t1.root);
		System.out.println("Min TreeNode " + minTreeNode.data);
		
		t1.printAllLeafNodes(t1.root);
		System.out.println();
		
		int imediateAncestor = 37;
		t1.printImediateAncestor(t1.root, imediateAncestor);
		System.out.println();
		
		t1.printAllAncestor(t1.root, imediateAncestor);
		
		t1.printLeftViewOfTree(t1.root);
		
		t1.printRightViewOfTree(t1.root);
		
	}

}

class Tree
{
	TreeNode root;
	
	public void add(int data)
	{
		if(root == null)
			root = new TreeNode(data);
		else
		{
			TreeNode prev = null;
			TreeNode curr = root;
			while(curr != null)
			{
				prev = curr;
				if(curr.data > data)
					curr = curr.left;
				else
					curr = curr.right;
			}
			if(prev.data > data)
				prev.left = new TreeNode(data);
			else
				prev.right = new TreeNode(data);
		}
	}
	
	public void printRightViewOfTree(TreeNode root) 
	{
		int height = heightOfTree(root);
		String[] arr = new String[height + 1];
		printRighttView(root, arr, 0);
		
		System.out.println();
		System.out.println("Right View");
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + "-->>>>>");
		}
		System.out.println();
	}

	private void printRighttView(TreeNode root, String[] arr, int level) 
	{
		if(root != null)
		{
			if(arr[level] == null || arr[level].length() <= 0)
				arr[level] = Integer.toString(root.data);
			printRighttView(root.right, arr, level+1);
			printRighttView(root.left, arr, level+1);
		}
	}

	public void printLeftViewOfTree(TreeNode root) 
	{
		int height = heightOfTree(root);
		String[] arr = new String[height + 1];
		printLeftView(root, arr, 0);
		
		System.out.println();
		System.out.println("Left View");
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + "-->>>>>");
		}
		System.out.println();
	}

	private void printLeftView(TreeNode root, String[] arr, int level) 
	{
		if(root != null)
		{
			if(arr[level] == null || arr[level].length() <= 0)
				arr[level] = Integer.toString(root.data);
			printLeftView(root.left, arr, level+1);
			printLeftView(root.right, arr, level+1);
		}
	}

	public boolean printAllAncestor(TreeNode root, int imediateAncestor) 
	{
		if(root != null)
		{
			if(root.data == imediateAncestor)
				return true;
			if(root.data > imediateAncestor)
			{
				if(printAllAncestor(root.left, imediateAncestor))
					System.out.println(root.data);
				return true;
			}
			else
			{
				if(printAllAncestor(root.right, imediateAncestor))
					System.out.println(root.data);
				return true;
			}
		}
		return false;
	}

	public void printImediateAncestor(TreeNode root, int imediateAncestor) 
	{
		if(root == null)
			return;
		TreeNode prev = root;
		while(root != null)
		{
			if(root.data == imediateAncestor)
			{
				System.out.print("Ancestor is " + prev.data);
				break;
			}
			else
			{
				if(imediateAncestor < root.data)
				{
					prev = root;
					root = root.left;
				}
				else
				{
					prev = root;
					root = root.right;
				}
			}
			
		}
	}

	public void printAllLeafNodes(TreeNode root)
	{
		if(root != null)
		{
			if(root.left == null && root.right == null)
				System.out.print(root.data + "--->");
			printAllLeafNodes(root.left);
			printAllLeafNodes(root.right);
		}
	}

	public TreeNode minimumTreeNode(TreeNode root) 
	{
		if(root == null)
			return null;
		if(root.left == null)
			return root;
		return minimumTreeNode(root.left);
	}

	public int sizeOfTree(TreeNode root) 
	{
		if(root != null)
		{
			return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
		}
		return 0;
	}

	public int depthOfTreeNode_recursion(TreeNode root, int elementDepth, int count) 
	{
		if(root != null)
		{
			if(root.data == elementDepth)
				return count;
			if(root.data > elementDepth)
				count = depthOfTreeNode_recursion(root.left, elementDepth, count+1);
			else
				count = depthOfTreeNode_recursion(root.right, elementDepth, count+1);
		}
		return count;
	}

	public int depthOfTreeNode(TreeNode root, int ele) 
	{
		int count  = -1;
		if(root != null)
		{
			TreeNode curr = root;
			while(curr != null)
			{
				count = count + 1;
				if(curr.data == ele)
				{
					System.out.println("Element Found " + ele + " TreeNode " + curr.data);
					return count;
				}
				else
				{
					if(curr.data > ele)
					{
						curr = curr.left;
					}
					else
					{
						curr = curr.right;
					}
				}
			}
			if(curr == null)
			{
				count = -1;
				System.out.println("Element not found");
			}
		}
		return count;
	}

	public int heightOfTreeNode(TreeNode root, int elementHeight) 
	{
		TreeNode temp = searchElement(root, elementHeight);
		if(temp != null)
		{
			return heightOfTree(temp);
		}
		return -1;
	}

	public int heightOfTree(TreeNode root) 
	{
		if(root != null)
		{
			return 1 +  max(heightOfTree(root.left), heightOfTree(root.right));
		}
		return -1;
	}
	
	private int max(int lData, int rData) 
	{
		if(lData > rData)
			return lData;
		else
			return rData;
	}
	
	public void traverseInLevelOrder(TreeNode root, String[] arr, int level) 
	{
		if(root != null)
		{
			if(arr[level] == null || arr[level].length() <= 0)
				arr[level] = Integer.toString(root.data);
			else
				arr[level] = arr[level] + "," + Integer.toString(root.data);
			traverseInLevelOrder(root.left, arr, level+1);
			traverseInLevelOrder(root.right, arr, level+1);
		}
	}
	public TreeNode searchElement(TreeNode root, int element) 
	{
		if(root != null) 
		{
			if(root.data == element)
			{
				return root;
			}
			if(root.data > element)
				root = searchElement(root.left, element);
			if(root.data < element)
				root = searchElement(root.right, element);
		}
		
		return root;
	}
	public TreeNode mirrorTree(TreeNode root) 
	{
		TreeNode mirrorNode = null;
		if (root != null)
		{
			mirrorNode = new TreeNode(root.data);
			mirrorNode.left = mirrorTree(root.right);
			mirrorNode.right = mirrorTree(root.left);
		}
		return mirrorNode;
	}
	public TreeNode copyTree(TreeNode root) 
	{
		TreeNode copyNode = null;
		if (root != null)
		{
			copyNode = new TreeNode(root.data);
			copyNode.left = copyTree(root.left);
			copyNode.right = copyTree(root.right);
		}
		return copyNode;
	}
	public void printAllNodesInDecreasingOrder(TreeNode root) 
	{
		if(root != null)
		{
			printAllNodesInDecreasingOrder(root.right);
			System.out.println(root.data);
			printAllNodesInDecreasingOrder(root.left);
		}
	}
	
	public void printAllNodesInIncreasingOrder(TreeNode root) 
	{
		inOrder(root);
	}
	public void postOrder(TreeNode root) 
	{
		if(root != null)
		{
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
	}
	public void inOrder(TreeNode root) 
	{
		if(root != null)
		{
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	public void preOrder(TreeNode root) 
	{
		if(root != null)
		{
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public TreeNode addWithRecursion(TreeNode root, int data)
	{
		if(root == null)
			return new TreeNode(data);
		if(root.data > data)
			root.left = addWithRecursion(root.left, data);
		else
			root.right = addWithRecursion(root.right, data);
		return root;
	}
}

class TreeNode
{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode( int d)
	{
		data =d;
	}
}
