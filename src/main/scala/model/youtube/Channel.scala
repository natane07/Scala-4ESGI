package model.youtube

import java.util.Date

class Channel {

  val id:String = null

  val publishedAt:Date = null

  val title:String = null

  val description:String = null

  val country:String = null

  var playlists:List[Playlist] = List()

  var videos:List[Video] = List()


}
//
//{
//  "items": [
//{
//  "kind": "youtube#channel",
//  "etag": "4J3dN3d1Kyaz5_ZMPyLE_CT95J0",
//  "id": "UCKKY2Jcg_P9fhfHD3ICyMxg",
//  "snippet": {
//  "title": "Ponce",
//  "description": "••► Retrouvez moi en live tous les jours sur ma chaine Twitch : https://www.twitch.tv/ponce\nEt aussi sur LeStream\n\n••► S'abonner : https://www.youtube.com/poncefesse?sub_confirmation=1\n••► Twitter : twitter.com/Poncefleur\n••► Instagram : instagram.com/Poncefleur_\n\nGestion de la chaîne Youtube : @Rooks_GG\n\nLOVE & FLEURS",
//  "customUrl": "poncefleur",
//  "publishedAt": "2015-04-15T12:26:39Z",
//  "thumbnails": {
//  "default": {
//  "url": "https://yt3.ggpht.com/ytc/AAUvwnjvAnD8PjZJES1JTiYpn8KbWvC1Me_1MvMXwzSs=s88-c-k-c0x00ffffff-no-rj",
//  "width": 88,
//  "height": 88
//},
//  "medium": {
//  "url": "https://yt3.ggpht.com/ytc/AAUvwnjvAnD8PjZJES1JTiYpn8KbWvC1Me_1MvMXwzSs=s240-c-k-c0x00ffffff-no-rj",
//  "width": 240,
//  "height": 240
//},
//  "high": {
//  "url": "https://yt3.ggpht.com/ytc/AAUvwnjvAnD8PjZJES1JTiYpn8KbWvC1Me_1MvMXwzSs=s800-c-k-c0x00ffffff-no-rj",
//  "width": 800,
//  "height": 800
//}
//},
//  "localized": {
//  "title": "Ponce",
//  "description": "••► Retrouvez moi en live tous les jours sur ma chaine Twitch : https://www.twitch.tv/ponce\nEt aussi sur LeStream\n\n••► S'abonner : https://www.youtube.com/poncefesse?sub_confirmation=1\n••► Twitter : twitter.com/Poncefleur\n••► Instagram : instagram.com/Poncefleur_\n\nGestion de la chaîne Youtube : @Rooks_GG\n\nLOVE & FLEURS"
//},
//  "country": "FR"
//}
//}
//  ]
//}

