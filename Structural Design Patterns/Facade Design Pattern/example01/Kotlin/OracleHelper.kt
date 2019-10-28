import java.sql.Connection;

class OracleHelper {
	companion object {
		fun getOracleDBConnection(): Connection? {
			return null
		}
	}

	fun generateOraclePDFReport(tableName: String, con: Connection) {}

	fun generateOracleHTMLReport(tableName: String, con: Connection) {}
}