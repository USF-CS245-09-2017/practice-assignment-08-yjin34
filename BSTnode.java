// the BSTnode class is to contain each value in the tree
public class BSTnode<T>
{
	Comparable c;
	BSTnode left;
	BSTnode right;

	// the constuctor to give the value to a BSTnode
	public BSTnode(Comparable value)
	{
		c = value;
		left = null;
		right = null;
	}
}