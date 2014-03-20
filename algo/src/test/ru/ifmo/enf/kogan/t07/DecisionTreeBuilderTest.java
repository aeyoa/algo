package ru.ifmo.enf.kogan.t07;

import junit.framework.Assert;
import org.junit.Test;
import ru.ifmo.enf.kogan.t05.DecisionTree;
import ru.ifmo.enf.kogan.t05.Entity;
import ru.ifmo.enf.kogan.t05.NodeFactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by arsenykogan on 15/03/14.
 */
public class DecisionTreeBuilderTest extends Assert {

    public enum Category {
        PREMIUM, BASIC, NONE;
    }

    @Test
    public void sandbox() {
        final List<DecisionTreeBuilder.DataItem<Category>> items = new ArrayList<DecisionTreeBuilder.DataItem<Category>>() {
            {
                add(new DataItem<Category>(getEntityByAttributes("country", "usa", "faq", ">20"), Category.PREMIUM));
                add(new DataItem<Category>(getEntityByAttributes("country", "usa", "faq", ",<20"), Category.BASIC));
                add(new DataItem<Category>(getEntityByAttributes("country", "germany", "faq", ">10"), Category.BASIC));
                add(new DataItem<Category>(getEntityByAttributes("country", "france", "faq", "<10"), Category.NONE));
            }
        };

        final List<DecisionTree.Factor> factors = new ArrayList<DecisionTree.Factor>() {
            {
                add(new NodeFactor("from usa", "country", "usa"));
                add(new NodeFactor("faq > 20", "faq", ">20"));
                add(new NodeFactor("faq > 10", "faq", ">10"));
            }
        };

        final DecisionTreeBuilder<Category> treeBuilder = new DecisionTreeBuilderImpl<Category>();
        final DecisionTree<Category> decisionTree = treeBuilder.buildTree(items, factors);
        final Category category = decisionTree.getCategory(getEntityByAttributes("country", "germany", "faq", ">10"));
        assertEquals(Category.BASIC, category);

    }

    /*
    * Converts human notation (e.g. "color", "red", "size", "small") in HashMap.
    * Splits list of attributes into pairs and adds them to HashMap.
    * Then returns new entity with desired attributes. */
    private DecisionTree.Entity getEntityByAttributes(final String... attributesList) {

        final HashMap<String, String> attributes = new HashMap<String, String>();
        for (int i = 0; i < attributesList.length / 2; i++) {
            attributes.put(attributesList[i * 2], attributesList[i * 2 + 1]);
        }
        // Creating entity with these attributes
        final DecisionTree.Entity entity = new Entity<Category>(attributes);
        return entity;
    }
}
