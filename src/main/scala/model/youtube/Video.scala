package model.youtube

import httpApi.HttpCallApi
import utils.{Database, Parse, Utils}
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

  var idDb: Int = 0

  override def toString = s"Video($id, $publishedAt, $channelId, $title, $description, $tags, $defaultAudioLanguage, $idDb)"

  /**
   * Récuperer les videos recommander à coté d'une video youtube
   * @return Liste des video recommander
   */
  def getRelatedVideos(): List[Video] ={
    var relatedVideos: List[Video] = List()
    val http = new HttpCallApi()
    val jsonResponse: String = http.youtubeVideoLink(this.id)
    val parseJson = new Parse()
    val listRelatedVideoJson = parseJson.json(jsonResponse)
    listRelatedVideoJson.foreach(relatedVideo => {
      val video: Video = Video.getVideo(relatedVideo.id, 0)
      relatedVideos ::= video
    })
    relatedVideos
  }

}

object Video {

  /**
   * Récuperer les informations d'une video youtube API et insére dans la BDD
   * @param videoId identifiant youtube de la video
   * @param idDbPlaylist: identifiant de la BDD de la playlist
   * @return une instance de la video
   */
  def getVideo (videoId: String, idDbPlaylist: Int): Video = {
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
    video.title = listYoutubeJson.head.title.replace("\"", "")
    video.description = listYoutubeJson.head.description.replace("\"", "")
    video.tags = listYoutubeJson.head.tags
    video.defaultAudioLanguage = listYoutubeJson.head.defaultAudioLanguage
    Video.insertDataDb(video, idDbPlaylist)
    video
  }

  /**
   * Insertion des données en BDD et renvoie l'id de la ligne inseret
   * @param video Instance de la classe playlist
   * @param idDbPlaylist id de la playlist en BDD
   * @return id de la ligne inseret
   */
  def insertDataDb(video: Video, idDbPlaylist: Int): Int = {
    val query = s"INSERT INTO video (id_video, published_at, channel_id, title, description, tags, default_audio_language, id_playlist) " +
      s""" VALUES ("${video.id}", "${Utils.dateToString(video.publishedAt)}", "${video.channelId}", "${video.title}", """ +
      s""" "${video.description}", "${video.tags.map(x => x.replace("\"", ""))}", "${video.defaultAudioLanguage}", ${idDbPlaylist} )"""
    val idDb = Database.insertDatabase(query)
    video.idDb = idDb
    idDb
  }

}