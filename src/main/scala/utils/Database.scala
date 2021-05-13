package utils
import java.util.Properties
import java.sql.{Connection, DriverManager, Statement, ResultSet}
import application.ApplicationConfiguration
object Database {

  /**
   * Insert data in SQL JDBC Database
   * @param request requete SQL
   * @return
   */
  def insertDatabase(request: String): Boolean = {
    Class.forName("com.mysql.jdbc.Driver")
    val dbc: Connection = DriverManager.getConnection(
        ApplicationConfiguration.urlDatabase,
        ApplicationConfiguration.userDatabase,
        ApplicationConfiguration.passwordDatabase
    )
    val st: Statement = dbc.createStatement()
    val rs = st.executeUpdate(request)
    dbc.close
    if (rs == 1)
      return true
    false
  }
}
