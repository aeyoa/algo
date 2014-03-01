package ru.ifmo.enf.kogan.t05;

/**
 * Created by arsenykogan on 01/03/14.
 */
public class TreeNode<E extends Enum<E>> {

    private final DecisionTree.Factor factor;
    private final TreeNode<E> noNode;
    private final TreeNode<E> yesNode;
    private final E result;

    // Constructor for node with factor
    public TreeNode(final DecisionTree.Factor factor, final TreeNode noNode, final TreeNode yesNode) {
        this.factor = factor;
        this.noNode = noNode;
        this.yesNode = yesNode;
        this.result = null;
    }

    // Constructor for leaf node
    public TreeNode(final E result) {
        this.factor = null;
        this.noNode = null;
        this.yesNode = null;
        this.result = result;
    }

    public Enum getCategory(final DecisionTree.Entity entity) {
        if (result != null) {
            return result;
        }
        if (factor.is(entity)) {
            return yesNode.getCategory(entity);
        }
        return noNode.getCategory(entity);
    }

    public TreeNode getNoNode() {
        return noNode;
    }

    public TreeNode getYesNode() {
        return yesNode;
    }
}
