package httpApi
import utils._

object ApiExample {
  def main(args: Array[String]): Unit = {
    val http = new HttpCallApi()
    // SEARCH
    val jsonResponse:String = http.youtubeSearch("joueur du grenier", "channel")
    // PlaylistItems
//    val jsonResponse:String = http.youtubePlaylistItems("PLbRL6lYUiVozE5p4P-uemi0n6YNPQuYxl")
    // Playlist
//    val jsonResponse:String = http.youtubePlaylist("UCKKY2Jcg_P9fhfHD3ICyMxg")
    // Video liés a une video id youtube
//    val jsonResponse:String = http.youtubeVideoLink("raIAyq5ih98")
    // Video Youtube
//    val jsonResponse:String = http.youtubeVideos("7mgex4sEUvc")

    val parseJson = new Parse()
    val listYoutubeJson = parseJson.json(jsonResponse)
    listYoutubeJson.foreach(youtubeJson => {
      println(youtubeJson.id)
      println(youtubeJson.publishedAt)
      println(youtubeJson.channelId)
      println(youtubeJson.title)
      println(youtubeJson.description)
      println(youtubeJson.tags)
      println(youtubeJson.defaultAudioLanguage)
      println(youtubeJson.country)
      println(youtubeJson.videoId)
      println("-------")
    })
  }

}