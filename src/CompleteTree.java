import java.util.LinkedList;
import java.util.Queue;


public class CompleteTree 
{
	
	public static void main(String[] args)
	{
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		
		one.left = two;
		one.right = three;
		two.left = four;
		String repr = serialize(one);
		
		System.out.println(repr.equals(serialize(deserialize(repr))));
	}
	
	public static TreeNode deserialize(String repr)
	{
		// Adding dummy variable for convenience.
		repr = "?" + repr;
		TreeNode[] arr = new TreeNode[repr.length()];

		for(int i = 1; i < repr.length(); i++)
		{
			if(repr.charAt(i) != '.')
			{
				arr[i] = new TreeNode(Integer.parseInt(repr.charAt(i) + ""));
			}
		}
		
		for(int i = 1; i < repr.length(); i++)
		{
			if(arr[i] != null)
			{
				arr[i].left = arr[left(i)];
				arr[i].right = arr[right(i)];
			}
		}
		return arr[1];
	}
	
	public static String serialize(TreeNode root)
	{
		Queue<TreeNode> q = 
				new LinkedList<TreeNode>();
		q.add(root);
		StringBuilder builder = new StringBuilder();
		
		while(!q.isEmpty())
		{
			TreeNode curr = q.remove();
			if(!curr.dummy)
			{
				builder.append(curr.val); 
				if(curr.left == null) q.add(new TreeNode());
				else q.add(curr.left);
				
				if(curr.right == null) q.add(new TreeNode());
				else q.add(curr.right);
			}
			else
			{
				builder.append(".");
			}
		}
		return builder.toString();
	}
	
	/*
	 * Non-functional utilities.
	 */
	
	private static int left(int i)
	{
		return 2 * i;
	}
	private static int right(int i)
	{
		return (2 * i) + 1;
	}
	
	public static class TreeNode
	{
		int val;
		public TreeNode left, right;
		public boolean dummy;
		public TreeNode() {dummy = true;}
		public TreeNode(int val)
		{
			this.val = val;
			dummy = false;
		}
	}
}
