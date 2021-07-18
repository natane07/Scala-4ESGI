package model.youtube

import java.util.Date

import httpApi.HttpCallApi
import utils.{Database, Parse, Utils}


class Playlist {

  var id: String = null

  var publishedAt: Date = null

  var channelId: String = null

  var title: String = null

  var videos: List[Video] = List()

  var idDb: Int = 0

  override def toString = s"Playlist($id, $publishedAt, $channelId, $title, $videos, $idDb)"

}

object Playlist {
  /**
   * Récuperer les playlist d'une chaine youtube
   * @param channelId String, Identifiant de la chaine youtube
   * @return List de Playlist
   */
  def getPlaylistChannel (channelId: String, idDbChannel: Int) : List[Playlist] = {
    // Call api
    val http = new HttpCallApi()
    val jsonResponse: String = http.youtubePlaylist(channelId)
    // Parse du json
    val parseJson = new Parse()
    val listYoutubeJson = parseJson.json(jsonResponse)
    // List des playlist
    var listPlaylist: List[Playlist] = List()

    println(listYoutubeJson.length)
    listYoutubeJson.foreach(youtubeJson => {
      val playlist: Playlist = new Playlist()
      playlist.id = youtubeJson.id
      playlist.publishedAt = youtubeJson.publishedAt
      playlist.channelId = youtubeJson.channelId
      playlist.title = youtubeJson.title.replace("\"", "")
      val idDbPlaylist = Playlist.insertDataDb(playlist, idDbChannel)
      playlist.videos = Playlist.getVideoPlaylist(youtubeJson.id, idDbPlaylist)
      listPlaylist = listPlaylist ++ List(playlist)
    })
    listPlaylist
  }

  /**
   * Recuperer les video d'une playlist
   * @param playlistId id de la playlist youtube
   * @return liste des Videos youtube de la playlist
   */
  def getVideoPlaylist(playlistId: String, idDbPlaylist: Int) : List[Video] = {
    // Call api
    val http = new HttpCallApi()
    val jsonResponse:String = http.youtubePlaylistItems(playlistId)
    // Parse du json
    val parseJson = new Parse()
    val listYoutubeJson = parseJson.json(jsonResponse)
    // List des playlist
    var listVideoPlaylist: List[Video] = List()

    listYoutubeJson.foreach(youtubeJson => {
      val video: Video = Video.getVideo(youtubeJson.videoId, idDbPlaylist)
      listVideoPlaylist = listVideoPlaylist ++ List(video)
    })
    listVideoPlaylist
  }

  /**
   * Insertion des données en BDD et renvoie l'id de la ligne inseret
   * @param playlist Instance de la classe playlist
   * @param idDbChannel id de la chaine en BDD
   * @return id de la ligne inseret
   */
  def insertDataDb(playlist: Playlist, idDbChannel: Int): Int = {
    val query = s"INSERT INTO playlist (id_playlist, published_at, channel_id, title, id_channel) " +
      s"""VALUES ("${playlist.id}", "${Utils.dateToString(playlist.publishedAt)}", "${playlist.channelId}", "${playlist.title}", ${idDbChannel})"""
    val idDb = Database.insertDatabase(query)
    playlist.idDb = idDb
    idDb
  }

}