public class BSTFindMinimumValue {
    public static class TreeNode{
        int data ;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //Create a function to visite the BST inOrder
    public static void inOrderTraversal(TreeNode node){
        if(node == null){
            return ;
        }
        inOrderTraversal(node.left);
        System.out.println(node.data + ",");
        inOrderTraversal(node.right);
    }
    //Find the minValue
    public static TreeNode minValueNode(TreeNode node){
        TreeNode current = node;
        while(current != null && current.left != null){
            current = current.left;
        }
        return current;
    }

    public static void main(String[] args) {
      TreeNode root = new TreeNode(13);
        TreeNode node7 = new TreeNode(7);
       TreeNode node15 = new TreeNode(15);
        TreeNode node3 = new TreeNode(3);
       TreeNode node8 = new TreeNode(8);
        TreeNode node14 = new TreeNode(14);
        TreeNode node19 = new TreeNode(19);
        TreeNode node18 = new TreeNode(18);

        root.left = node7;
        root.right = node15;

        node7.left = node3;
        node7.right = node8;

        node15.left = node14;
        node15.right = node19;

        node19.left = node18;

        TreeNode minNode = minValueNode(root);
        System.out.println("The Lowest value is : " + minNode.data);
    }
}
