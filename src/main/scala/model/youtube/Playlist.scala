package model.youtube

import java.util.Date


class Playlist {

  val id:String = null

  val publishedAt:Date = null

  val channelId:String = null

  val title:String = null

  var videos:List[Video] = List()

}

// "items": [
//    "id": "PLbRL6lYUiVoyIfYycFkFulWsyxywubIMW",
//  "snippet": {
//    "publishedAt": "2021-04-09T08:29:15Z",
//    "channelId": "UCKKY2Jcg_P9fhfHD3ICyMxg",
//    "title": "MAITRE DES FLEURS",
// Tableau Video