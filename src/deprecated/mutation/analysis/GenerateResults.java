/*
 */
package deprecated.mutation.analysis;

import java.io.File;
import java.util.List;

import org.schemaanalyst.dbms.DBMS;
import org.schemaanalyst.dbms.DBMSFactory;
import org.schemaanalyst.dbms.DatabaseInteractor;
import org.schemaanalyst.sqlrepresentation.Schema;
import org.schemaanalyst.sqlwriter.SQLWriter;
import org.schemaanalyst.util.runner.Parameter;
import org.schemaanalyst.util.runner.RequiredParameters;
import org.schemaanalyst.util.runner.Runner;
import org.schemaanalyst.util.xml.XMLSerialiser;

import deprecated.mutation.SQLExecutionRecord;
import deprecated.mutation.SQLExecutionReport;
import deprecated.mutation.SQLInsertRecord;

/**
 *
 * @author Chris J. Wright
 */
@RequiredParameters("casestudy")
public abstract class GenerateResults extends Runner {

    /**
     * The name of the schema to use.
     */
    @Parameter
    protected String casestudy;
    /**
     * The folder to store the generated results.
     */
    @Parameter
    protected String outputfolder;

    protected Schema schema;
    protected DBMS dbms;
    protected SQLWriter sqlWriter;
    
    @Override
    public void task() {
        // Setup
        if (outputfolder == null) {
            outputfolder = locationsConfiguration.getResultsDir() + File.separator + "generatedresults" + File.separator;
        }

        // Instantiate the DBMS and related objects
        try {
            dbms = DBMSFactory.instantiate(databaseConfiguration.getDbms());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            throw new RuntimeException(ex);
        }
        sqlWriter = dbms.getSQLWriter();
        DatabaseInteractor databaseInteractor = dbms.getDatabaseInteractor(casestudy, databaseConfiguration, locationsConfiguration);

        // Get the required schema class
        try {
            schema = (Schema) Class.forName(casestudy).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            throw new RuntimeException(ex);
        }

        // Create the report
        SQLExecutionReport sqlReport = new SQLExecutionReport();

        // Drop existing tables
        List<String> dropStmts = sqlWriter.writeDropTableStatements(schema, true);
        for (String stmt : dropStmts) {
            databaseInteractor.executeUpdate(stmt);
        }

        // Create the schema in the database and store result
        List<String> createStmts = sqlWriter.writeCreateTableStatements(schema);
        for (String stmt : createStmts) {
            int returnCount = databaseInteractor.executeUpdate(stmt);
            sqlReport.addCreateTableStatement(new SQLExecutionRecord(stmt, returnCount));
        }

        // Generate the test data
        List<String> insertStmts = getInserts();

        // Insert the test data
        for (String stmt : insertStmts) {
            SQLInsertRecord record = new SQLInsertRecord(stmt, databaseInteractor.executeUpdate(stmt), false);
            sqlReport.addInsertStatement(record);
        }

        // Drop tables
        for (String stmt : dropStmts) {
            databaseInteractor.executeUpdate(stmt);
        }

        // Store results
        XMLSerialiser.save(sqlReport, outputfolder + casestudy + ".xml");
    }

    public abstract List<String> getInserts();
}
