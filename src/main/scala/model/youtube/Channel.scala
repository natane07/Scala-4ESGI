package model.youtube

import httpApi.HttpCallApi
import utils._

import java.util.Date

class Channel(channelId: String) {

  var id: String = null

  var publishedAt: Date = null

  var title: String = null

  var description: String = null

  var country: String = null

  var playlists: List[Playlist] = List()

  var videos: List[Video] = List()


  def Channel(channelId: String): Unit = {
    val http = new HttpCallApi()
    val jsonResponse: String = http.youtubeChannels(channelId)
    val parseJson = new Parse()
    val listYoutubeJson = parseJson.json(jsonResponse)

    this.id = listYoutubeJson.head.id
    this.publishedAt = listYoutubeJson.head.publishedAt
    this.title = listYoutubeJson.head.title
    this.description = listYoutubeJson.head.description
    this.country = listYoutubeJson.head.country
  }

}