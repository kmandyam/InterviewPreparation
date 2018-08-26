import java.util.*;

public class Notes {
  private static class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
      this.value = x;
    }

    public String toString() {
      String toString = value + "";
      if (left != null) {
        toString = toString + ", " + left.toString();
      }
      if (right != null) {
        toString = toString + ", " + right.toString();
      }
      return toString;
    }
  }

  public static void main(String[] args) {
    List<TreeNode> answers = generateTrees(3);
    for (int i = 0; i < answers.size(); i++) {
      System.out.println(answers.get(i));
    }
  }

  public static List<TreeNode> generateTrees(int n) {
    List<Integer> choices = new ArrayList<Integer>();
    for (int i = 1; i <= n; i++) {
      choices.add(i);
    }

    List<TreeNode> answers = new ArrayList<TreeNode>();
    generateHelper(choices, answers, true);
    return answers;
  }

  public static TreeNode generateHelper(List<Integer> choices, List<TreeNode> answers, boolean firstNode) {
    if (choices.size() == 1) {
      // have to make this choice
      if (choices.get(0) == null) {
        return null;
      }
      return new TreeNode(choices.get(0));
    } else {
      for (int i = 0; i < choices.size(); i++) {
        int choice = choices.get(i);
        List<Integer> leftChoices = divideNumbers(choices, choice, false);
        List<Integer> rightChoices = divideNumbers(choices, choice, true);
        TreeNode curr = new TreeNode(choice);
        TreeNode leftResult = generateHelper(leftChoices, answers, false);
        TreeNode rightResult = generateHelper(rightChoices, answers, false);
        curr.left = leftResult;
        curr.right = rightResult;
        if (firstNode) {
          answers.add(curr);
        }
      }
      return null;
    }
  }

  public static List<Integer> divideNumbers(List<Integer> choices, int currentNumber, boolean greaterThan) {
    List<Integer> newChoices = new ArrayList<Integer>();
    for (int i = 0; i < choices.size(); i++) {
      if (choices.get(i) != currentNumber) {
        if (greaterThan && choices.get(i) > currentNumber) {
          newChoices.add(choices.get(i));
        }

        if (!greaterThan && choices.get(i) < currentNumber) {
          newChoices.add(choices.get(i));
        }
      }
    }
    if (choices.size() == 0) {
      choices.add(null);
    }
    return newChoices;
  }

}
