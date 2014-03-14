package org.schemaanalyst.data.generation.directedrandom;

import org.schemaanalyst.data.Cell;
import org.schemaanalyst.data.generation.CellValueGenerator;
import org.schemaanalyst.logic.predicate.checker.ExpressionClauseChecker;

/**
 * Created by phil on 27/02/2014.
 */
public class ExpressionClauseFixer extends Fixer {

    private ExpressionClauseChecker expressionClauseChecker;
    private CellValueGenerator cellValueGenerator;

    public ExpressionClauseFixer(ExpressionClauseChecker expressionClauseChecker, CellValueGenerator cellValueGenerator) {
        this.expressionClauseChecker = expressionClauseChecker;
        this.cellValueGenerator = cellValueGenerator;
    }

    @Override
    public void attemptFix() {
        for (Cell cell : expressionClauseChecker.getNonComplyingCells()) {
            cellValueGenerator.generateCellValue(cell);
        }
    }
}
