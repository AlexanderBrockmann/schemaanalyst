package org.schemaanalyst.coverage.criterion.types;

import org.schemaanalyst.coverage.CoverageException;
import org.schemaanalyst.coverage.criterion.Criterion;
import org.schemaanalyst.coverage.criterion.MultiCriterion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Instantiates a {@link Criterion} for use in data generation.
 *
 * @author Phil
 */
public class CriterionFactory {

    /**
     * Instantiate a {@link Criterion} instance given the name.
     * 
     * @param criterionName The name
     * @return The criterion
     */
    @SuppressWarnings("unchecked")
    public static Criterion instantiate(String criterionName) {
        Class<CriterionFactory> c = CriterionFactory.class;
        Method methods[] = c.getMethods();

        for (Method m : methods) {
            if (m.getName().equals(criterionName)) {
                try {
                    return (Criterion) m.invoke(null);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        throw new CoverageException("Unknown criterion \"" + criterionName + "\"");
    }

    /**
     * Returns a list of all data generation {@link Criterion}.
     * 
     * @return All criterion
     */
    public static List<Criterion> allCriteria() {
        List<Criterion> criteria = new ArrayList<>();
        Class<CriterionFactory> c = CriterionFactory.class;
        Method methods[] = c.getMethods();

        for (Method m : methods) {
            if (m.getName().endsWith("Coverage")) {
                try {
                    criteria.add((Criterion) m.invoke(null));
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return criteria;
    }

    public static Criterion amplifiedConstraintCACCoverage() {
        return new AmplifiedConstraintCACCoverage();
    }

    public static Criterion amplifiedConstraintCACWithNullAndUniqueColumnCoverage() {
        return new MultiCriterion(
                new AmplifiedConstraintCACCoverage(),
                new NullColumnCoverage(),
                new UniqueColumnCoverage()
        );
    }

    public static Criterion constraintCACCoverage() {
        return new ConstraintCACCoverage();
    }

    public static Criterion constraintCACWithNullAndUniqueColumnCoverage() {
        return new MultiCriterion(
                new ConstraintCACCoverage(),
                new NullColumnCoverage(),
                new UniqueColumnCoverage()
        );
    }

    public static Criterion nullCoverage() {
        return new NullColumnCoverage();
    }

    public static Criterion uniqueCoverage() {
        return new UniqueColumnCoverage();
    }
}