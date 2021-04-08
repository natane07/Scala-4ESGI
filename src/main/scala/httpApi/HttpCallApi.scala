package httpApi
import scalaj.http._

class HttpCallApi {

  val apiKey = ""

  def youtubeSearch(q: String): String = {
    val response: HttpResponse[String] = Http("https://youtube.googleapis.com/youtube/v3/search")
      .param("key",apiKey)
      .param("part","snippet")
      .param("maxResults","25")
      .param("q",q)
      .asString
    println(response)
    println(response.body)
    response.body
  }

}
