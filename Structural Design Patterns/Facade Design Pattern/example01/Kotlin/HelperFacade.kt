import java.sql.Connection

class HelperFacade {
	companion object {
		enum class DBTypes {
			MYSQL, ORACLE
		}

		enum class ReportTypes {
			HTML, PDF
		}

		fun generateReport(dbTypes: DBTypes, reportTypes: ReportTypes, tableName: String) {
			var con: Connection? = null

			when(dbTypes) {
				DBTypes.MYSQL -> {
					con = MySqlHelper.getMySqlDBConnection()
					val mySqlHelper = MySqlHelper()
					when(reportTypes) {
						ReportTypes.HTML -> mySqlHelper.generateMySqlHTMLReport(tableName, con)
						ReportTypes.PDF -> mySqlHelper.generateMySqlPDFReport(tableName, con)
					}
				}
				DBTypes.ORACLE -> {
					con = OracleHelper.getMySqlDBConnection()
					val oracleHelper = OracleHelper()
					when(reportTypes) {
						ReportTypes.HTML -> oracleHelper.generateMySqlHTMLReport(tableName, con)
						ReportTypes.PDF -> oracleHelper.generateMySqlPDFReport(tableName, con)
					}
				}
			}
		}
	}
}