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

  override def toString = s"Channel($id, $publishedAt, $title, $description, $country, $playlists, $videos)"
}

object Channel {
  def getChannel(channelId: String): Channel = {
    val http = new HttpCallApi()
    val jsonResponse: String = http.youtubeChannels(channelId)
    val parseJson = new Parse()
    val listChannelJson = parseJson.json(jsonResponse)
    val channel = new Channel()

    channel.id = listChannelJson.head.id
    channel.publishedAt = listChannelJson.head.publishedAt
    channel.title = listChannelJson.head.title
    channel.description = listChannelJson.head.description
    channel.country = listChannelJson.head.country
    channel.playlists = Playlist.getPlaylistChannel(channel.id)

    channel
  }
}