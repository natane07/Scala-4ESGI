package model.youtube

import java.util.Date

import httpApi.HttpCallApi
import utils.Parse


class Playlist {

  var id: String = null

  var publishedAt: Date = null

  var channelId: String = null

  var title: String = null

  var videos: List[Video] = List()

  override def toString = s"Playlist($id, $publishedAt, $channelId, $title, $videos)"

}

object Playlist {
  /**
   * Récuperer les playlist d'une chaine youtube
   * @param channelId String, Identifiant de la chaine youtube
   * @return List de Playlist
   */
  def getPlaylistChannel (channelId: String) : List[Playlist] = {
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
      playlist.title = youtubeJson.title
      // TODO : ajouter les videos de la playlist
      listPlaylist = listPlaylist ++ List(playlist)
    })
    listPlaylist
  }

}