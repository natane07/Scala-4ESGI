package utils
import java.util.Properties
import java.sql.{Connection, DriverManager, Statement}
import application.ApplicationConfiguration
object Database {

  /**
   * Insert data in SQL JDBC Database
   * @param request requete SQL
   * @return id de la ligne creer en bdd
   */
  def insertDatabase(request: String): Int = {
    Class.forName("com.mysql.jdbc.Driver")
    val dbc: Connection = DriverManager.getConnection(
        ApplicationConfiguration.urlDatabase,
        ApplicationConfiguration.userDatabase,
        ApplicationConfiguration.passwordDatabase
    )
    val st: Statement = dbc.createStatement()
    st.executeUpdate(request, Statement.RETURN_GENERATED_KEYS)

    // retourne l'id
    var idDb = 0
    try {
      val rep = st.getGeneratedKeys()
      if(rep.next()) {
        idDb = rep.getInt(1)
      }
    } catch {
      case e: Exception => {
        dbc.close
        return idDb
      }
    }
    dbc.close
    idDb
  }
}
