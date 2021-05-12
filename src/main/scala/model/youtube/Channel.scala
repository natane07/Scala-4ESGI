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

  val http = new HttpCallApi()
  val jsonResponse: String = http.youtubeChannels(channelId)
  val parseJson = new Parse()
  val listChannelJson = parseJson.json(jsonResponse)

  this.id = listChannelJson.head.id
  this.publishedAt = listChannelJson.head.publishedAt
  this.title = listChannelJson.head.title
  this.description = listChannelJson.head.description
  this.country = listChannelJson.head.country
}