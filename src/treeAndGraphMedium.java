import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class treeAndGraphMedium {
	 public void inorderTraversal(TreeNode root,ArrayList<Integer > l) {
		 if(root==null) return;
		 inorderTraversal(root.left, l);
		 l.add(root.val);
		 inorderTraversal(root.right,l);
	 }
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	
   
     ArrayList<Integer> l=new ArrayList<>();
     inorderTraversal(root,l);
/*     
    Stack<TreeNode> s=new Stack<>();
  if(root==null) return l;
     TreeNode n=root;
     while(n!=null) {
    	 s.push(n);
    	 n=n.left;
    	 
     }
     
     while(n!=null) {
    	 s.push(n);
    	 n=n.left;
    	 
     } */
     return l;
    }
    public static void zigzagLevelOrder(ArrayList<ArrayList<Integer>> l,Stack<TreeNode> s,boolean direction) {
        if(s.isEmpty()) return;
    	Stack<TreeNode> s1=new Stack<>();
        ArrayList<Integer> temp=new ArrayList<>();
        while(!s.isEmpty()) {
       	 TreeNode node=s.pop();
       	 temp.add(node.val);
       	 if(direction) {
       		 if(node.left!=null) s1.push(node.left);
       		 if(node.right!=null) s1.push(node.right);
       	 }
       	 else {
       		 if(node.right!=null) s1.push(node.right);
       		if(node.left!=null) s1.push(node.left);
       	 }
       	 
       	 
        }
        l.add(temp);
        zigzagLevelOrder(l, s1,!direction);
    }
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
     ArrayList<ArrayList<Integer>> l=new ArrayList<>();
     if(root==null) return l;
     Stack<TreeNode> s=new Stack<>();
     s.push(root);
     zigzagLevelOrder(l,s,true);
    return l;
    }
    static int index=0;
    public static TreeNode buildTree(int[] preorder,HashMap<Integer, Integer> hm,int l,int r) {
        
        if(l>r || index>preorder.length-1) return null;
    	TreeNode root=new TreeNode(preorder[index++]);
        int i=hm.get(root.val);
    	root.left=buildTree(preorder,hm,l,i-1);
    	root.right=buildTree(preorder,hm,i+1,r);
    	System.out.println(root.val);
    	return root;
    	
    	
    	
    }
    public Node connect(Node root) {
        if(root==null||root.left==null) return root;
        
        if(root.next!=null) {
        	root.right.next=root.next.left;
        }
        root.left.next=root.right;
         connect(root.left);
         connect(root.right);
         return root;
        
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        	hm.put(inorder[i], i);
    	return buildTree(preorder,hm,0,inorder.length-1);
        
    }
    public void inorder(TreeNode root,ArrayList<Integer> arr) {
    	if(root==null) return ;
    	inorder(root.left, arr);
    	arr.add(root.val);
    	inorder(root.right, arr);
    }
    public int kthSmallest(TreeNode root, int k) {
     ArrayList<Integer> arr=new ArrayList<>();
     inorder(root, arr);
     return arr.get(k-1);
    }
    public static void numIslands(char[][] grid,int i,int j) {
    	if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j]=='0'|| grid[i][j]=='2') return; 
    	grid[i][j]='2';
    	numIslands(grid,i-1,j);
    	numIslands(grid,i+1,j);
    	numIslands(grid,i,j-1);
    	numIslands(grid,i,j+1);
}
    public static int numIslands(char[][] grid) {
    	int counter=0;
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[0].length;j++) {
        		if(grid[i][j]=='2'|| grid[i][j]=='0') continue;
        		counter++;
        		numIslands(grid,i,j);
        	}
        }
    return counter;
    }
	public static void main(String[] args) {
	//int[][] grid="1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]

	}

}
