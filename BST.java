// the BST class to build the Binary Tree
public class BST<T>
{
	// the root of the tree
	BSTnode Root = null;

	// the find function to tell if the value is inside the tree
	public boolean find(Comparable value)
	{
			return find(Root,value);
	}

	// the recursive find function, return false until it can find the value
	public boolean find(BSTnode root, Comparable value)
	{
		if (root == null)
		{
			return false;
		}
		if (value.compareTo(root.c) == 0)
		{
			return true;
		}
		else if(value.compareTo(root.c) < 0)
		{
			return find(root.left,value);
		}
		else
		{
			return find(root.right,value);
		}
	}

	// the insert function to insert a value into the tree
	public void insert(Comparable value)
	{
		if(!find(value))
		{
			Root = insert(Root,value);
		}
	}

	// the recursive insert function
	public BSTnode insert(BSTnode root, Comparable value)
	{
		if (root == null)
		{
			BSTnode newNode = new BSTnode(value);
			return newNode;
		}
		else if (root.c.compareTo(value) < 0)
		{
			root.right = insert(root.right,value);
			return root;
		}
		else
		{
			root.left = insert(root.left,value);
			return root;
		}
	}

	// print the values in the tree from small to big
	public void print()
	{
		print(Root);
	}

	// the recursive print function
	public void print(BSTnode root)
	{
		if (root != null)
		{
			print(root.left);
			System.out.print(root.c+ " ");
			print(root.right);
		}
	}

	// to delete a value in the tree
	public void delete(Comparable value)
	{
		if(find(value))
		{
			Root = delete(Root,value);
		}
	}

	// the recursive delete function
	public BSTnode delete(BSTnode root, Comparable value)
	{
		if (root == null)
		{
			return null;
		}
		if (root.c.compareTo(value) == 0)
		{
			if (root.left == null)
			{
				return root.right;
			}
			else if(root.right == null)
			{
				return root.left;
			}
			else
			{
				if (root.right.left == null)
				{
					root.c = root.right.c;
					root.right = root.right.right;
					return root;
				}
				else
				{
					root.c = removeSmallest(root.right);
					return root;
				}
			}
		}
		else if(root.c.compareTo(value) > 0)
		{
			delete(root.left,value);
			return root;
		}
		else
		{
			delete(root.right,value);
			return root;
		}
	}

	// the removeSmallest function would be called in the delete function if a value which has two children is going to be deleted.
	public Comparable removeSmallest(BSTnode root)
	{
		if ( root.left.left == null)
		{
			Comparable smallest = root.left.c;
			root.left = root.left.right;
			return smallest;
		}
		else
		{
			return removeSmallest(root.left);
		}
	}

}












