package model.youtube

import httpApi.HttpCallApi
import utils.Parse

import java.util.Date

class Video {

  var id:String = null

  var publishedAt:Date = null

  var channelId:String = null

  var title:String = null

  var description:String = null

  var tags:List[String] = List()

  var defaultAudioLanguage:String = null

  def getRelatedVideos(): List[Video] ={
    var relatedVideos: List[Video] = List()
    val http = new HttpCallApi()
    val jsonResponse: String = http.youtubeVideoLink(this.id)
    val parseJson = new Parse()
    val listRelatedVideoJson = parseJson.json(jsonResponse)
    listRelatedVideoJson.foreach(relatedVideo => {
      // Correct when video constructor done
      val video: Video = new Video()
      relatedVideos ::= video
    })
    relatedVideos
  }
}