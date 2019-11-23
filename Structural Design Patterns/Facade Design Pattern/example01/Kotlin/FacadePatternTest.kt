import java.sql.Connection;

class FacadePatternTest {
	fun main(args: Array<String>) {
		val tableName = "Employee"

		val con: Connection = MySqlHelper.getMySqlDBConnection()
		val mySqlHelper: MySqlHelper = MySqlHelper()
		mySqlHelper.generateMySqlHTMLReport(tableName, con)

		val oracleConnection = OracleHelper.getOracleDBConnection()
		val oracleHelper = OracleHelper()
		oracleHelper.generateOraclePDFReport(tableName, oracleConnection)

		HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName)
		HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName)
	}
}