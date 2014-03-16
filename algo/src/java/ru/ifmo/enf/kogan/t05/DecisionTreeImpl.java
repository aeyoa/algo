package ru.ifmo.enf.kogan.t05;

/**
 * Created by arsenykogan on 01/03/14.
 */
public class DecisionTreeImpl<E extends Enum<E>> implements DecisionTree {

    private final TreeNode<E> rootNode;

    public DecisionTreeImpl(final TreeNode<E> rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public Enum getCategory(final Entity entity) {
        return rootNode.getCategory(entity);
    }

    @Override
    public String toString() {
        return rootNode.toString();
    }
}
