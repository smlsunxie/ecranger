databaseChangeLog = {

	changeSet(author: "Spooky (generated)", id: "1389926481457-1") {
		addColumn(tableName: "user") {
			column(name: "tour_step", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}
	changeSet(author: "Spooky (generated)", id: "1389926481457-2") {
        grailsChange {
            change {
                sql.execute("update user set tour_step='STEP1_START'")
            }
            rollback {
            }
        }
	}	
}
