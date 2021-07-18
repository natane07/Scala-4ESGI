package httpApi
import utils._

object ApiExample {
  def main(args: Array[String]): Unit = {
    val http = new HttpCallApi()
    // SEARCH
//    val jsonResponse:String = http.youtubeSearch("squezzie", "channel")
    // PlaylistItems
//    val jsonResponse:String = http.youtubePlaylistItems("PLbRL6lYUiVoyN-OZo7bvt4UOzx8uxkyXn")
    // Playlist
    val jsonResponse:String = http.youtubePlaylist("UCKKY2Jcg_P9fhfHD3ICyMxg")
    // Video liés a une video id youtube
//    val jsonResponse:String = http.youtubeVideoLink("raIAyq5ih98")
    // Video Youtube
//    val jsonResponse:String = http.youtubeVideos("7mgex4sEUvc")
      // videoChannel
//   val jsonResponse:String = http.youtubeChannels("UCWeg2Pkate69NFdBeuRFTAw")
    // youtube tendance
//    val jsonResponse:String = http.youtubeTendance()

    val parseJson = new Parse()
    val listYoutubeJson = parseJson.json(jsonResponse)
    println(listYoutubeJson.length)
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