import java.sql.Connection

class MySqlHelper {
	companion object {
		fun getMySqlDBConnection(): Connection? {
			return null
		}
	}

	fun generateMySqlPDFReport(tableName: String, con: Connection) {}

	fun generateMySqlHTMLReport(tableName: String, con: Connection) {}
}