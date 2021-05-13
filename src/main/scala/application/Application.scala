package application
import model.youtube._

object Application {

  def main(args: Array[String]): Unit = {
    // Recuperer les Playlist d'une chaine youtube
    val playlist = Playlist.getPlaylistChannel("UCKKY2Jcg_P9fhfHD3ICyMxg")
    playlist.foreach(value => {
      println(value.title)
      value.videos.foreach(video => {
        println(video.title)
        println(video.publishedAt)
        println(video.tags)
        println(video.defaultAudioLanguage)
      })
    })

//    val video = Video.getVideo("7mgex4sEUvc")
//    print(video)
  }

}
