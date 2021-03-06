package application

object ApplicationConfiguration {

  val apiKey = ""
  val baseUrl = "https://youtube.googleapis.com/youtube/v3/"
  val urlSearch = baseUrl + "search"
  val urlVideos = baseUrl + "videos"
  val urlChannels = baseUrl + "channels"
  val urlPlaylist = baseUrl + "playlists"
  val urlPlaylistItems = baseUrl + "playlistItems"
  // Database
  val hostDatabase = "jdbc:mysql://??.??.??.??/"
  val urlDatabase = hostDatabase + "scala-4esgi"
  val userDatabase = ""
  val passwordDatabase = ""

}
