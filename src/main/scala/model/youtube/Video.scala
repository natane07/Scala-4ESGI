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

  val defaultAudioLanguage:String = null

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

//  "items": [
//  {
//    "kind": "youtube#video",
//    "etag": "WC3tZGNNPsgLs-dHmUDQ8Q1YEGk",
//    "id": "cFxdonf2wz8",
//    "snippet": {
//      "publishedAt": "2021-02-24T16:00:10Z",
//      "channelId": "UCKKY2Jcg_P9fhfHD3ICyMxg",
//      "title": "JDG est allé trop loin ! GARTIC PHONE avec les potes",
//      "description": "Salut les fleurs ! \n\nAujourd'hui au programme... Un best of de la soirée Gartic Phone avec les potes (d'il y a deux semaines). C'était tellement drôle qu'on a été obligé d'en faire une vidéo sur cette chaine. \n\nDans ce best of, vous allez voir que JDG est allé trop loin !\n\nJ'espère que cette vidéo sur Gratic Phone vous a fait kiffer, n'hésitez pas à me le mentionner en commentaire (je lis tout). \n\nPrenez soin de vous !\n\n••► Retrouvez moi en live tous les jours sur ma chaine Twitch : https://www.twitch.tv/ponce\n\n••► S'abonner : https://www.youtube.com/poncefesse?sub_confirmation=1\n••► Ponce Replay : https://www.youtube.com/channel/UCELUxTfBayyzxMxcSE2uUhw\n••► Twitter : https://twitter.com/Poncefleur\n••► Instagram : https://www.instagram.com/poncefleur_/\n••► Discord : https://discord.gg/Vp5dSjq\n••► Boutique : https://boutiqueponce.fr/\n••► Tiktok : https://www.tiktok.com/@poncefleur_?lang=fr\n\nMusique d'intro : https://www.youtube.com/watch?v=dk6MHwAFBuE\nMusique d'outro : https://www.youtube.com/watch?v=fotBLRYnnfU\n\n#ponce #garticphone #JDG\n\nGestion de la chaîne Youtube : @Rooks_GG\nMontage : okamedia.fr\n\nLOVE & FLEURS",
//      "thumbnails": {
//      "default": {
//      "url": "https://i.ytimg.com/vi/cFxdonf2wz8/default.jpg",
//      "width": 120,
//      "height": 90
//    },
//      "medium": {
//      "url": "https://i.ytimg.com/vi/cFxdonf2wz8/mqdefault.jpg",
//      "width": 320,
//      "height": 180
//    },
//      "high": {
//      "url": "https://i.ytimg.com/vi/cFxdonf2wz8/hqdefault.jpg",
//      "width": 480,
//      "height": 360
//    },
//      "standard": {
//      "url": "https://i.ytimg.com/vi/cFxdonf2wz8/sddefault.jpg",
//      "width": 640,
//      "height": 480
//    },
//      "maxres": {
//      "url": "https://i.ytimg.com/vi/cFxdonf2wz8/maxresdefault.jpg",
//      "width": 1280,
//      "height": 720
//    }
//    },
//      "channelTitle": "Ponce",
//      "tags": [
//      "poncefesse",
//      "ponce",
//      "twitch",
//      "live",
//      "lestream",
//      "gartic phone",
//      "ponce gartic phone",
//      "best of ponce",
//      "ponce best of",
//      "poncezap",
//      "gartic phone best of",
//      "best of gartic phone",
//      "gartic phone fr",
//      "dessins gartic phone",
//      "ponce gartic phone replay",
//      "jdg gartic phone",
//      "joueur du grenier"
//      ],
//      "categoryId": "20",
//      "liveBroadcastContent": "none",
//      "localized": {
//      "title": "JDG est allé trop loin ! GARTIC PHONE avec les potes",
//      "description": "Salut les fleurs ! \n\nAujourd'hui au programme... Un best of de la soirée Gartic Phone avec les potes (d'il y a deux semaines). C'était tellement drôle qu'on a été obligé d'en faire une vidéo sur cette chaine. \n\nDans ce best of, vous allez voir que JDG est allé trop loin !\n\nJ'espère que cette vidéo sur Gratic Phone vous a fait kiffer, n'hésitez pas à me le mentionner en commentaire (je lis tout). \n\nPrenez soin de vous !\n\n••► Retrouvez moi en live tous les jours sur ma chaine Twitch : https://www.twitch.tv/ponce\n\n••► S'abonner : https://www.youtube.com/poncefesse?sub_confirmation=1\n••► Ponce Replay : https://www.youtube.com/channel/UCELUxTfBayyzxMxcSE2uUhw\n••► Twitter : https://twitter.com/Poncefleur\n••► Instagram : https://www.instagram.com/poncefleur_/\n••► Discord : https://discord.gg/Vp5dSjq\n••► Boutique : https://boutiqueponce.fr/\n••► Tiktok : https://www.tiktok.com/@poncefleur_?lang=fr\n\nMusique d'intro : https://www.youtube.com/watch?v=dk6MHwAFBuE\nMusique d'outro : https://www.youtube.com/watch?v=fotBLRYnnfU\n\n#ponce #garticphone #JDG\n\nGestion de la chaîne Youtube : @Rooks_GG\nMontage : okamedia.fr\n\nLOVE & FLEURS"
//    },
//      "defaultAudioLanguage": "fr"
//    }
//  }
//  ],