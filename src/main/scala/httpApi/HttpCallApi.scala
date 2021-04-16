package httpApi
import scalaj.http._
import application.ApplicationConfiguration._

class HttpCallApi {

  def youtubeSearch(q:String, itemType:String): String = {
    val response: HttpResponse[String] = Http(urlSearch)
      .param("key",apiKey)
      .param("part","snippet")
      .param("maxResults","25")
      .param("q",q)
      .param("type",itemType)
      .asString
    println(response)
    println(response.body)
    response.body
  }

}
