package application
import model.youtube._
import utils.Database
import utils.Utils
object Application {

  def main(args: Array[String]): Unit = {

    val request = "INSERT INTO video (id_video, published_at, channel_id, title, description, tags, default_audio_language) VALUES ('test2', '2020-10-02', 'test2','test2','test2','test2','test2')"
    val result = Database.insertDatabase(request)


    // Recuperer les Playlist d'une chaine youtube
    val playlist = Playlist.getPlaylistChannel("UCKKY2Jcg_P9fhfHD3ICyMxg")
    playlist.foreach(value => {
      println(value.title)
      value.videos.foreach(video => {
        println(video.title)
        println(Utils.dateToString(video.publishedAt))
        println(video.tags)
        println(video.defaultAudioLanguage)
      })
    })

//    val video = Video.getVideo("7mgex4sEUvc")
//    print(video)
  }

}
