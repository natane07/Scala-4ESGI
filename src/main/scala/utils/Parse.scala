package utils

import java.util
import java.util.Date
import java.util.LinkedHashMap

import scala.util.{Failure, Success}

class Parse {

  /**
   * Parse le json por n'importe quelle call API de Youtube
   * @param jsonString
   * @return
   */
  def json(jsonString: String): List[YoutubeJson] = {
    val data = ujson.read(jsonString)
    var listYoutubeJson: List[YoutubeJson] = List()
    val itemsArr = data("items").arr
    for (item <- itemsArr) {
      val youtubeJson: YoutubeJson = new YoutubeJson()
      val itemsHmap = ujson.read(item)
      // snippet
      var snippet: ujson.Value = null
      try {
        snippet = itemsHmap("snippet") //snippet
      } catch {
        case e: Exception => None
      }
      // id
      try {
        youtubeJson.id = itemsHmap("id").str
      } catch {
        case e: Exception => None
      }
      // publishedAt
      try {
        val format = new java.text.SimpleDateFormat("yyyy-MM-dd'T'H:m:s'Z'")
        val publishedAt = format.parse(snippet("publishedAt").str)
        youtubeJson.publishedAt = publishedAt
      } catch {
        case e: Exception => None
      }
      // channelId
      try {
        youtubeJson.channelId = snippet("channelId").str
      } catch {
        case e: Exception => None
      }
      // title
      try {
        youtubeJson.title = snippet("title").str
      } catch {
        case e: Exception => None
      }
      // description
      try {
        youtubeJson.description = snippet("description").str
      } catch {
        case e: Exception => None
      }
      // tags
      try {
        val tags = snippet("tags").arr
        var tagsList:List[String] = List()
        tags.foreach(tag => {
          tagsList = tagsList :+ tag.str
        })
        youtubeJson.tags = tagsList
      } catch {
        case e: Exception => None
      }
      // defaultAudioLanguage
      try {
        youtubeJson.defaultAudioLanguage = snippet("defaultAudioLanguage").str
      } catch {
        case e: Exception => None
      }
      // country
      try {
        youtubeJson.country = snippet("country").str
      } catch {
        case e: Exception => None
      }
      // videoId
      try {
        youtubeJson.videoId = snippet("resourceId")("videoId").str
      } catch {
        case e: Exception => None
      }
      listYoutubeJson = listYoutubeJson ++ List(youtubeJson)
    }
    listYoutubeJson
  }

}

class YoutubeJson {
  var id:String = null

  var publishedAt:Date = null

  var channelId:String = null

  var title:String = null

  var description:String = null

  var tags:List[String] = List()

  var defaultAudioLanguage:String = null

  var country:String = null

  var videoId:String = null

  override def toString = s"YoutubeJson($id, $publishedAt, $channelId, $title, $description, $tags, $defaultAudioLanguage, $country, $videoId)"
}
