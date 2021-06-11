package application
import model.youtube._
import utils.Database
import utils.Utils
object Application {

  def main(args: Array[String]): Unit = {
    // Recuperer les informations d'une chaine, des playlist et des videos (limite de 5)
    val idChannel = Channel.searchChannel("Skyrroz")
    val channel = Channel.getChannel(idChannel)

    // Api pour recuperer les 10 premieres videos en tendance et les inserer en BDD
    Video.getVideoTendance()
  }

}
