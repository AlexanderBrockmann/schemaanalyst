package org.schemaanalyst.sqlrepresentation.expression;

import java.util.List;

import org.schemaanalyst.sqlrepresentation.Column;
import org.schemaanalyst.sqlrepresentation.Table;
import org.schemaanalyst.util.Duplicable;

public interface Expression extends Duplicable<Expression> {

    public Expression getSubexpression(ExpressionPath expressionPath);

    public Expression getSubexpression(int index);

    public void setSubexpression(int index, Expression subexpression);
    
    public void setSubexpressions(List<Expression> subexpressions);    
    
    public int getNumSubexpressions();

    public List<Expression> getSubexpressions();

    public void accept(ExpressionVisitor visitor);
    
    public List<Column> getColumnsInvolved();
    
    public Expression duplicate();
    
    public void remap(Table table);
}
