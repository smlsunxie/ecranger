databaseChangeLog = {

	changeSet(author: "Spooky (generated)", id: "1389710163379-1") {
		addNotNullConstraint(columnDataType: "varchar(255)", columnName: "title", tableName: "user")
	}

	changeSet(author: "Spooky (generated)", id: "1389710163379-2") {
		dropIndex(indexName: "name_uniq_1386993452161", tableName: "product")
	}

	changeSet(author: "Spooky (generated)", id: "1389710163379-3") {
		createIndex(indexName: "unique_name", tableName: "product", unique: "true") {
			column(name: "user_id")

			column(name: "name")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389710163379-4") {
        grailsChange {
            change {
                sql.execute("UPDATE user SET email = null where email = ''")
            }
            rollback {
            }
        }
		createIndex(indexName: "email_uniq_1389710163140", tableName: "user", unique: "true") {
			column(name: "email")
		}
	}
}
