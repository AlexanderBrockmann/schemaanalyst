package deprecated.mutation.mutators;

import java.util.List;

import org.schemaanalyst.sqlrepresentation.Schema;
import org.schemaanalyst.sqlrepresentation.Table;
import org.schemaanalyst.sqlrepresentation.constraint.CheckConstraint;

public class CheckConstraintMutator extends Mutator {

    @Override
    public void produceMutants(Table table, List<Schema> mutants) {
        for (CheckConstraint checkConstraint : table.getCheckConstraints()) {
            mutants.add(makeMutant(table, checkConstraint));
        }
    }

    protected Schema makeMutant(Table table, CheckConstraint checkConstraint) {
        Schema mutant = table.getSchema().duplicate();
        mutant.addComment("Mutant with check constraint \"" + checkConstraint + "\" removed from table \"" + table + "\"");
        mutant.addComment("(Check, 1)");
        mutant.addComment("table=" + table);

        Table mutantTable = mutant.getTable(table.getName());
        mutantTable.removeCheckConstraint(checkConstraint);

        return mutant;
    }
}