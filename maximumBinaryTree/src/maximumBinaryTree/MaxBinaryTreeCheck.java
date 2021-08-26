package maximumBinaryTree;


public class MaxBinaryTreeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 6, 0, 5 };
		
		BinaryTree bt = new BinaryTree();
		TreeNode binaryTree = bt.createBinaryTree(nums, 0 , nums.length);
		
		int level = 1;
		while(printLevel(binaryTree, level)) {
			level++;
		}
		
	}
	
	
//	public static void printTree(TreeNode root) {
//		if(root != null) {
//			System.out.print(root.value + " ");
//			
//		}else {
//			System.out.print("null ");
//		}
//		if(root.left == null && root.right == null) {
//			return;
//		}else {
//			printTree(root.left);
//			printTree(root.right);
//		}
//		return;
////		else {
////			
////		}
////		
////		if(root.left == null) {
////			System.out.print("null ");
////			return;
////		}else {
////			printTree(root.left);
////		}
////		if(root.right == null) {
////			System.out.print("null ");
////			return;
////		}else {
////			printTree(root.right);
////		}
//		
//	}	
		
	
	
	public static boolean printLevel(TreeNode root, int level){
        if (root == null) {
        	//System.out.print("null "); //if(root.left != null && root.right != null)
            return false;
        }
         
        if (level == 1)
        {
            System.out.print(root.value + " ");                   
            return true;
        }
       
    	//if(root.left == null) { System.out.print("null ");}
    	//if(root.right == null) { System.out.print("null "); }
        boolean left = printLevel(root.left, level - 1);
		boolean right = printLevel(root.right, level - 1);
    	
        
		return left || right;

    }
}

class BinaryTree {
	public TreeNode createBinaryTree(int[] nums, int left, int right) {
		
		if(left == right) {
			return null;
		}
		
		int maxIndex = findMaxIndex(nums,left, right);
		TreeNode root = new TreeNode(nums[maxIndex]);
		root.left = createBinaryTree(nums, left, maxIndex);
		root.right = createBinaryTree(nums, maxIndex + 1, right);
		
		return root;
			
	}
	private int findMaxIndex(int[] nums, int left, int right) {
		int maxIndex = left;
		for(int i= left;i < right; i++) {
			maxIndex = nums[i] > nums[maxIndex] ? i : maxIndex;
		}
		return maxIndex;
	}

}
