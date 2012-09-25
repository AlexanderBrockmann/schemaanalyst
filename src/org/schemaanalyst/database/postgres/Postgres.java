package org.schemaanalyst.database.postgres;

import org.schemaanalyst.database.Database;
import org.schemaanalyst.databaseinteraction.DatabaseInteractor;

public class Postgres extends Database {
    private PostgresDatabaseInteractor databaseInteraction = new PostgresDatabaseInteractor();

    public Postgres() {
	sqlWriter = new PostgresSQLWriter();
    }

    public DatabaseInteractor getDatabaseInteraction() {
	return databaseInteraction;
    }
}
