package org.schemaanalyst.sqlrepresentation.expression;

import java.util.List;

import org.schemaanalyst.sqlrepresentation.Column;
import org.schemaanalyst.util.Duplicable;

public interface Expression extends Duplicable<Expression> {

    public Expression getSubexpression(List<Integer> indexes);

    public Expression getSubexpression(int index, int... furtherIndexes);

    public Expression getSubexpression(int index);
    
    public void setSubexpressions(List<Expression> subExpressions);

    public int getNumSubexpressions();

    public List<Expression> getSubexpressions();

    public void accept(ExpressionVisitor visitor);
    
    public List<Column> getColumnsInvolved();
    
    public Expression duplicate();
}
