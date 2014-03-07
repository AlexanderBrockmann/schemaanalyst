package org.schemaanalyst.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	org.schemaanalyst.test.coverage.criterion.predicate.TestConstraintPredicateGenerator.class,
	org.schemaanalyst.test.coverage.criterion.predicate.TestPredicate.class,
	org.schemaanalyst.test.coverage.criterion.requirements.TestCheckConstraintRequirementsGenerator.class,
	org.schemaanalyst.test.coverage.criterion.requirements.TestMultiColumnConstraintCACRequirementsGenerator.class,
	org.schemaanalyst.test.coverage.criterion.requirements.TestMultiColumnConstraintRequirementsGenerator.class,
	org.schemaanalyst.test.coverage.criterion.requirements.TestNotNullConstraintRequirementsGenerator.class,
	org.schemaanalyst.test.coverage.testgeneration.datageneration.checker.TestMatchClauseChecker.class,
	org.schemaanalyst.test.coverage.testgeneration.datageneration.checker.TestRelationalChecker.class,
	org.schemaanalyst.test.coverage.testgeneration.datageneration.fixer.TestExpressionClauseFixer.class,
	org.schemaanalyst.test.coverage.testgeneration.datageneration.fixer.TestMatchClauseFixer.class,
	org.schemaanalyst.test.coverage.testgeneration.datageneration.fixer.TestNullClauseFixer.class,
	org.schemaanalyst.test.coverage.testgeneration.datageneration.fixer.TestPredicateFixer.class,
	org.schemaanalyst.test.coverage.testgeneration.datageneration.objectivefunction.TestMatchClauseObjectiveFunction.class,
	org.schemaanalyst.test.coverage.testgeneration.datageneration.valuegeneration.TestCellValueGenerator.class,
	org.schemaanalyst.test.coverage.testgeneration.datageneration.valuegeneration.TestExpressionConstantMiner.class,
	org.schemaanalyst.test.data.TestStringValue.class,
	org.schemaanalyst.test.data.TestValueEquality.class,
	org.schemaanalyst.test.datageneration.search.TestAlternatingValueSearch.class,
	org.schemaanalyst.test.datageneration.search.TestSearchEvaluation.class,
	org.schemaanalyst.test.datageneration.search.directedrandom.data.TestExpressionColumnHandler.class,
	org.schemaanalyst.test.datageneration.search.directedrandom.data.TestNullColumnHandler.class,
	org.schemaanalyst.test.datageneration.search.directedrandom.data.TestReferenceColumnHandler.class,
	org.schemaanalyst.test.datageneration.search.directedrandom.data.TestUniqueColumnHandler.class,
	org.schemaanalyst.test.datageneration.search.objective.TestDistanceObjectiveValue.class,
	org.schemaanalyst.test.datageneration.search.objective.TestObjectiveValue.class,
	org.schemaanalyst.test.datageneration.search.objective.data.TestExpressionColumnObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.data.TestNullColumnObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.data.TestReferenceColumnObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.data.TestUniqueColumnObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.row.TestAndExpressionRowObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.row.TestBetweenExpressionRowObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.row.TestInExpressionRowObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.row.TestNullExpressionRowObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.row.TestOrExpressionRowObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.row.TestRelationalExpressionRowObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.value.TestEqualsMultiValueObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.value.TestNullValueObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.value.TestRelationalBooleanValueObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.value.TestRelationalCompoundValueObjectiveFunction.class,
	org.schemaanalyst.test.datageneration.search.objective.value.TestRelationalNumericValueObjectiveFunction.class,
	org.schemaanalyst.test.faultlocalization.TestCalculator.class,
	org.schemaanalyst.test.faultlocalization.TestProcessMatrix.class,
	org.schemaanalyst.test.logic.TestRelationalOperator.class,
	org.schemaanalyst.test.mutation.equivalence.TestChangedConstraintFinder.class,
        org.schemaanalyst.test.mutation.equivalence.TestChangedTableFinder.class,
	org.schemaanalyst.test.mutation.equivalence.TestCheckEquivalenceChecker.class,
	org.schemaanalyst.test.mutation.equivalence.TestColumnEquivalenceChecker.class,
	org.schemaanalyst.test.mutation.equivalence.TestEquivalenceChecker.class,
	org.schemaanalyst.test.mutation.equivalence.TestForeignKeyEquivalenceChecker.class,
	org.schemaanalyst.test.mutation.equivalence.TestMutantEquivalentToMutantChecker.class,
	org.schemaanalyst.test.mutation.equivalence.TestNotNullEquivalenceChecker.class,
	org.schemaanalyst.test.mutation.equivalence.TestPrimaryKeyEquivalenceChecker.class,
	org.schemaanalyst.test.mutation.equivalence.TestSchemaEquivalenceChecker.class,
	org.schemaanalyst.test.mutation.equivalence.TestSchemaEquivalenceWithNotNullCheckChecker.class,
	org.schemaanalyst.test.mutation.equivalence.TestTableEquivalenceChecker.class,
	org.schemaanalyst.test.mutation.equivalence.TestUniqueEquivalenceChecker.class,
	org.schemaanalyst.test.mutation.mutator.TestListElementRemover.class,
	org.schemaanalyst.test.mutation.mutator.TestRelationalOperatorExchanger.class,
	org.schemaanalyst.test.mutation.operator.TestCCInExpressionRHSListExpressionElementR.class,
	org.schemaanalyst.test.mutation.operator.TestCCNullifier.class,
	org.schemaanalyst.test.mutation.operator.TestCCRelationalExpressionOperatorE.class,
	org.schemaanalyst.test.mutation.operator.TestFKCColumnPairA.class,
	org.schemaanalyst.test.mutation.operator.TestFKCColumnPairE.class,
	org.schemaanalyst.test.mutation.operator.TestFKCColumnPairR.class,
	org.schemaanalyst.test.mutation.operator.TestNNCAR.class,
	org.schemaanalyst.test.mutation.operator.TestPKCColumnARE.class,
	org.schemaanalyst.test.mutation.operator.TestUCColumnARE.class,
	org.schemaanalyst.test.mutation.reduction.TestNSelectiveRemover.class,
	org.schemaanalyst.test.mutation.reduction.TestPercentageSamplingRemover.class,
	org.schemaanalyst.test.mutation.reduction.TestSamplingRemover.class,
	org.schemaanalyst.test.mutation.redundancy.TestRedundancyRemovers.class,
	org.schemaanalyst.test.mutation.supplier.TestAbstractSupplier.class,
	org.schemaanalyst.test.mutation.supplier.TestIteratingSupplier.class,
	org.schemaanalyst.test.mutation.supplier.TestLinkedSupplier.class,
	org.schemaanalyst.test.mutation.supplier.TestSolitaryComponentSupplier.class,
	org.schemaanalyst.test.sqlrepresentation.TestColumn.class,
	org.schemaanalyst.test.sqlrepresentation.TestSchema.class,
	org.schemaanalyst.test.sqlrepresentation.TestTable.class,
	org.schemaanalyst.test.sqlrepresentation.TestTableDependencyOrderer.class,
	org.schemaanalyst.test.sqlrepresentation.constraint.TestConstraints.class,
	org.schemaanalyst.test.sqlrepresentation.datatype.TestDataTypes.class,
	org.schemaanalyst.test.sqlrepresentation.expression.TestExpression.class,
	org.schemaanalyst.test.sqlrepresentation.expression.TestExpressionFilterWalker.class,
	org.schemaanalyst.test.sqlrepresentation.expression.TestExpressionPath.class,
	org.schemaanalyst.test.sqlrepresentation.expression.TestExpressionTreeWithExpressionPath.class,
	org.schemaanalyst.test.sqlrepresentation.expression.TestExpressions.class,
	org.schemaanalyst.test.util.collection.TestIdentifiableEntity.class,
	org.schemaanalyst.test.util.collection.TestIdentifiableEntitySet.class,
	org.schemaanalyst.test.util.collection.TestIdentifier.class,
	org.schemaanalyst.test.util.runner.TestRunner.class,
	org.schemaanalyst.test.util.sql.TestSQLRepairer.class
})

public class AllTests {}

