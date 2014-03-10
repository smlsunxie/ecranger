databaseChangeLog = {

	changeSet(author: "Spooky (generated)", id: "1389670290769-1") {
		addColumn(tableName: "event") {
			column(name: "discount_money", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-2") {
		addColumn(tableName: "part") {
			column(name: "user_id", type: "BIGINT")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-3") {
		addColumn(tableName: "store") {
			column(name: "description", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-4") {
		addColumn(tableName: "store") {
			column(name: "email", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-5") {
		addColumn(tableName: "store") {
			column(name: "fax", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-6") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "description", tableName: "brand")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-7") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "homepage", tableName: "brand")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-8") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "creator", tableName: "event")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-9") {
		addNotNullConstraint(columnDataType: "BIGINT", columnName: "user_id", tableName: "event")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-10") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "creator", tableName: "event_detail")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-11") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "description", tableName: "event_detail")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-12") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "main_image", tableName: "event_detail")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-13") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "address", tableName: "store")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-14") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "telphone", tableName: "store")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-15") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "address", tableName: "user")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-16") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "description", tableName: "user")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-17") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "email", tableName: "user")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-18") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "mobile", tableName: "user")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-19") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "telphone", tableName: "user")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-20") {
		dropNotNullConstraint(columnDataType: "VARCHAR(255)", columnName: "title", tableName: "user")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-22") {
		dropIndex(indexName: "name", tableName: "event")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-23") {
		dropIndex(indexName: "name", tableName: "part")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-24") {
		dropIndex(indexName: "name", tableName: "post")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-25") {
		dropIndex(indexName: "name", tableName: "product")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-26") {
		dropIndex(indexName: "authority", tableName: "role")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-27") {
		dropIndex(indexName: "url", tableName: "security_map")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-28") {
		dropIndex(indexName: "name", tableName: "store")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-29") {
		dropIndex(indexName: "name", tableName: "tags")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-30") {
		dropIndex(indexName: "username", tableName: "user")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-31") {
		createIndex(indexName: "name_uniq_1386993452133", tableName: "brand", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-32") {
		createIndex(indexName: "name_uniq_1386993452144", tableName: "event", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-33") {
		createIndex(indexName: "name_uniq_1386993452152", tableName: "event_detail", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-34") {
		createIndex(indexName: "unique_name", tableName: "part", unique: "true") {
			column(name: "store_id")

			column(name: "user_id")

			column(name: "name")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-35") {
		createIndex(indexName: "name_uniq_1386993452158", tableName: "post", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-36") {
		createIndex(indexName: "unique_name", tableName: "product", unique: "true") {
			column(name: "user_id")

			column(name: "name")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-37") {
		createIndex(indexName: "authority_uniq_1386993452162", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-38") {
		createIndex(indexName: "url_uniq_1386993452163", tableName: "security_map", unique: "true") {
			column(name: "url")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-39") {
		createIndex(indexName: "name_uniq_1386993452164", tableName: "store", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-40") {
		createIndex(indexName: "unique_title", tableName: "store_cost_detail", unique: "true") {
			column(name: "date")

			column(name: "title")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-41") {
		createIndex(indexName: "name_uniq_1386993452172", tableName: "tags", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-42") {
		createIndex(indexName: "username_uniq_1386993452174", tableName: "user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-43") {
		dropColumn(columnName: "birthday", tableName: "user")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-44") {
		dropTable(tableName: "registration_code")
	}

	changeSet(author: "Spooky (generated)", id: "1389670290769-21") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "part", constraintName: "FK3463F394F1E5B6", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "user", referencedTableSchemaName: "ecranger", referencesUniqueColumn: "false")
	}
}
