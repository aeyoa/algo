package ru.ifmo.enf.kogan.t05;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by arsenykogan on 01/03/14.
 */
public class DecisionTreeTest extends Assert {

    @Test
    public void sandbox() {

        // Defining attributes of our entity
        final HashMap<String, String> attributes = new HashMap<String, String>();
        attributes.put("size", "big");
        attributes.put("color", "yellow");

        // Creating entity with these attributes
        final DecisionTree.Entity entity = new Entity<Fruits>(attributes);


        // Defining tree with some nodes
        // 1. Creating leaf-nodes
        final TreeNode<Fruits> bananaNode = new TreeNode<Fruits>(Fruits.BANANA);
        final TreeNode<Fruits> grapesNode = new TreeNode<Fruits>(Fruits.GRAPES);
        final TreeNode<Fruits> appleNode = new TreeNode<Fruits>(Fruits.APPLE);

        // 2. Creating some factor-nodes
        final TreeNode<Fruits> sizeIsBIG = new TreeNode<Fruits>(new NodeFactor("Size is BIG", "size", "big"), grapesNode, appleNode);

        // 3. Creating root node
        final TreeNode<Fruits> colorIsRED = new TreeNode<Fruits>(new NodeFactor("Color is RED", "color", "red"), bananaNode, sizeIsBIG);

        final DecisionTree<Fruits> tree = new DecisionTreeImpl<Fruits>(colorIsRED);

        System.out.println(tree.getCategory(entity));
    }

    public enum Fruits {
        APPLE, GRAPES, BANANA;
    }


}
