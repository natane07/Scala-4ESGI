package model.youtube

import httpApi.HttpCallApi
import utils.Parse
import java.util.Date

import model.youtube

class Video() {

  var id:String = null

  var publishedAt:Date = null

  var channelId:String = null

  var title:String = null

  var description:String = null

  var tags:List[String] = List()

  var defaultAudioLanguage:String = null

  override def toString = s"Video($id, $publishedAt, $channelId, $title, $description, $tags, $defaultAudioLanguage)"

  def getRelatedVideos(): List[Video] ={
    var relatedVideos: List[Video] = List()
    val http = new HttpCallApi()
    val jsonResponse: String = http.youtubeVideoLink(this.id)
    val parseJson = new Parse()
    val listRelatedVideoJson = parseJson.json(jsonResponse)
    listRelatedVideoJson.foreach(relatedVideo => {
      val video: Video = Video.getVideo(relatedVideo.id)
      relatedVideos ::= video
    })
    relatedVideos
  }

}

object Video {

  def getVideo (videoId: String): Video = {
    // Call api
    val http = new HttpCallApi()
    val jsonResponse: String = http.youtubeVideos(videoId)
    // Parse du json
    val parseJson = new Parse()
    val listYoutubeJson = parseJson.json(jsonResponse)
    // Instance de video
    val video = new Video()
    video.id = listYoutubeJson.head.id
    video.publishedAt = listYoutubeJson.head.publishedAt
    video.channelId = listYoutubeJson.head.channelId
    video.title = listYoutubeJson.head.title
    video.description = listYoutubeJson.head.description
    video.tags = listYoutubeJson.head.tags
    video.defaultAudioLanguage = listYoutubeJson.head.defaultAudioLanguage
    video
  }

}