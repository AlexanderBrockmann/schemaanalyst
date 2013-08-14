package deprecated.mutation;

/**
 * This class represents the two-tuple (SQL Statement, Return Code)
 */
public class SQLSelectRecord extends SQLExecutionRecord {

    @Override
    public String toString() {
        return "SQLInsertRecord{" + "statement=" + statement + ", returnCode=" + returnCode + '}';
    }
    
}