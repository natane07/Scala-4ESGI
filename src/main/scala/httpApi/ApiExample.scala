package httpApi

object ApiExample {
  def main(args: Array[String]): Unit = {
    val http = new HttpCallApi()
    http.youtubeSearch("Ponce")
  }

}