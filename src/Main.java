import java.util.LinkedList;
import java.util.Queue;


public class Main 
{
	
	public static void main(String[] args)
	{
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		
		one.left = two;
		one.right = three;
		three.left = four;
		serialize(one);
	}
	
	public static TreeNode deserialize()
	{
		
		
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
				builder.append(curr.val).append(" "); 
				if(curr.left == null) q.add(new TreeNode());
				else q.add(curr.left);
				
				if(curr.right == null) q.add(new TreeNode());
				else q.add(curr.right);
			}
			else
			{
				builder.append(".").append(" ");
			}
			
		}
		
		return builder.toString();
		
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
