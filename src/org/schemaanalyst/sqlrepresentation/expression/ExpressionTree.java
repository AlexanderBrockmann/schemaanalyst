package org.schemaanalyst.sqlrepresentation.expression;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.schemaanalyst.sqlrepresentation.Column;
import org.schemaanalyst.sqlrepresentation.Table;

public abstract class ExpressionTree implements Expression {

    @Override
    public Expression getSubexpression(ExpressionPath expressionPath) {
        List<Integer> indices = expressionPath.getIndices();
        if (indices.isEmpty()) {
            return null;
        }
        
        Expression expression = this;
        System.out.println("Expression is " + expression);
        Iterator<Integer> iterator = indices.iterator();
        while (iterator.hasNext()) {
        	expression = expression.getSubexpression(iterator.next());
        	System.out.println("Expression is " + expression);        	
        }
        return expression;
    }    

    @Override
    public abstract Expression getSubexpression(int index);
    
    @Override
    public abstract void setSubexpression(int index, Expression subexpression);
    
    @Override
    public void setSubexpressions(List<Expression> subexpressions) {
    	if (subexpressions.size() > getNumSubexpressions()) {
    		throw new NonExistentSubexpressionException(this, subexpressions.size());
    	}
    	for (int i=0; i < subexpressions.size(); i++) {
    		setSubexpression(i, subexpressions.get(i));
    	}
    }
    
    @Override
    public abstract int getNumSubexpressions();

    @Override
    public List<Expression> getSubexpressions() {
        List<Expression> subexpressions = new ArrayList<>();
        for (int i = 0; i < getNumSubexpressions(); i++) {
            subexpressions.add(getSubexpression(i));
        }
        return subexpressions;
    }
    
    @Override
    public List<Column> getColumnsInvolved() {
        Set<Column> columns = new HashSet<>();
        for (Expression expression : getSubexpressions()) {
            columns.addAll(expression.getColumnsInvolved());
        }
        return new ArrayList<>(columns);
    }

    @Override
    public void remap(Table table) {
        for (Expression expression : getSubexpressions()) {
            expression.remap(table);
        }
    }
}
