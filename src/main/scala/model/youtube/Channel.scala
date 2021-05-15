package model.youtube

import httpApi.HttpCallApi
import utils._

import java.util.Date

class Channel() {

  var id: String = null

  var publishedAt: Date = null

  var title: String = null

  var description: String = null

  var country: String = null

  var playlists: List[Playlist] = List()

  var videos: List[Video] = List()

  var idDb: Int = 0

  override def toString = s"Channel($id, $publishedAt, $title, $description, $country, $playlists, $videos, $idDb)"
}

object Channel {

  /**
   * Recuperer les informations d'une chaine youtube
   * @param channelId identifiant de la chaine youtube
   * @return Une instance de la classe Channel
   */
  def getChannel(channelId: String): Channel = {
    val http = new HttpCallApi()
    val jsonResponse: String = http.youtubeChannels(channelId)
    val parseJson = new Parse()
    val listChannelJson = parseJson.json(jsonResponse)
    val channel = new Channel()

    channel.id = listChannelJson.head.id
    channel.publishedAt = listChannelJson.head.publishedAt
    channel.title = listChannelJson.head.title.replace("\"", "")
    channel.description = listChannelJson.head.description.replace("\"", "")
    channel.country = listChannelJson.head.country
    val idDbChannel = Channel.insertDataDb(channel)
    channel.playlists = Playlist.getPlaylistChannel(channel.id, idDbChannel)

    channel
  }

  /**
   * Insertion des information d'une chaine en BDD et renvoie l'id de la ligne inseret
   * @param channel Instance de la classe channel
   * @return id de la ligne inseret
   */
  def insertDataDb(channel: Channel): Int = {
    val query = s"INSERT INTO channel (id_channel, published_at, title, description, country) " +
      s"""VALUES ("${channel.id}", "${Utils.dateToString(channel.publishedAt)}", "${channel.title}", "${channel.description}", "${channel.country}")"""
    val idDb = Database.insertDatabase(query)
    channel.idDb = idDb
    idDb
  }
}