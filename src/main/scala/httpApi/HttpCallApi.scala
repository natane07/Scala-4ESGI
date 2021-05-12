package httpApi
import scalaj.http._
import application.ApplicationConfiguration._

class HttpCallApi {

  /**
   * Call api pour rechercher un chaine sur youtube avec un filtre sur le type (itemType)
   * @param q le mot à recherche
   * @param itemType le filtre : channel
   * @return
   */
  def youtubeSearch(q:String, itemType:String = "channel"): String = {
    val response: HttpResponse[String] = Http(urlSearch)
      .param("key",apiKey)
      .param("part","snippet")
      .param("maxResults","25")
      .param("q",q)
      .param("type",itemType)
      .asString
    println(response.body)
    response.body
  }

  /**
   * Call api pour recuperer les videos liées à une autre vidéo
   * @param relatedToVideoId l'id d'une video yotube
   * @return Json String
   */
  def youtubeVideoLink(relatedToVideoId:String): String = {
    val response: HttpResponse[String] = Http(urlSearch)
      .param("key",apiKey)
      .param("part","snippet")
      .param("relatedToVideoId", relatedToVideoId)
      .param("type", "video")
      .asString
    println(response.body)
    response.body
  }

  /**
   * Call api pour recuperer les information d'une chaine
   * @param channelId l'id de la chaine youtube
   * @return
   */
  def youtubeChannels(channelId:String): String = {
    val response: HttpResponse[String] = Http(urlChannels)
      .param("key",apiKey)
      .param("part","snippet")
      .param("id",channelId)
      .asString
    println(response.body)
    response.body
  }

  /**
   * Call api pour recuperer les playlists d'une chaine youtube
   * @param channelId L'id de la chaine youtube
   * @return Json String
   */
  def youtubePlaylist(channelId:String): String = {
    val response: HttpResponse[String] = Http(urlPlaylist)
      .param("key",apiKey)
      .param("part","snippet")
      .param("channelId",channelId)
      .asString
    println(response.body)
    response.body
  }

  /**
   * Call api pour recuperer les videos d'une playslist
   * @param playlistId l'id de la playlist
   * @return Json String
   */
  def youtubePlaylistItems(playlistId:String): String = {
    val response: HttpResponse[String] = Http(urlPlaylistItems)
      .param("key",apiKey)
      .param("part","snippet")
      .param("playlistId",playlistId)
      .asString
    println(response.body)
    response.body
  }

  /**
   * Call api pour recuperer les informations d'une videos grace à son id
   * @param videoId id de la video
   * @return Json String
   */
  def youtubeVideos(videoId:String): String = {
    val response: HttpResponse[String] = Http(urlVideos)
      .param("key",apiKey)
      .param("part","snippet")
      .param("id",videoId)
      .asString
    println(response.body)
    response.body
  }

  /**
   * Call api pour recuperer les informations des videos en tendance
   * @return Json String
   */
  def youtubeTendance(): String = {
    val response: HttpResponse[String] = Http(urlVideos)
      .param("key",apiKey)
      .param("part","snippet")
      .param("chart","mostPopular")
      .param("regionCode", "Fr")
      .param("maxResults", "10")
      .asString
    println(response.body)
    response.body
  }

}
