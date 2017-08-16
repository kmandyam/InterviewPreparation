public class ValidateBinaryTree {

  // rough overview without defining treenode
  public boolean validateReal(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean validate(TreeNode root, long min, long max) {
    if(root == null) {
      return true;
    }

    if(root.val < max && min > root.min) {
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    } else {
      return false;
    }
  }




}
