package model.youtube

import java.util.Date

class Video {

  var id:String = null

  var publishedAt:Date = null

  var channelId:String = null

  var title:String = null

  var description:String = null

  var tags:List[String] = List()

  var defaultAudioLanguage:String = null

}