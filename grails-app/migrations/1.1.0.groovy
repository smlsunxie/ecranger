databaseChangeLog = {

	changeSet(author: "Spooky (generated)", id: "1389514556181-1") {
		dropForeignKeyConstraint(baseTableName: "part", constraintName: "FK3463F310475694")
	}

	changeSet(author: "Spooky (generated)", id: "1389514556181-2") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "part", constraintName: "FK3463F394F1E5B6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}
}
