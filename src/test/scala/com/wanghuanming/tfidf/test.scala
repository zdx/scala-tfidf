package com.wanghuanming.tfidf

import scala.io._

object test {
  def main(args: Array[String]) = {
    val URLs = List("http://wanghuanming.com/2014/12/thread-and-process",
      "http://wanghuanming.com/2014/12/mesos-deploy",
      "http://www.cnblogs.com/jasonkoo/articles/2834727.html")
    TFIDF.constructCorpus("/opt/data/corpus/")
    for (url <- URLs) {
      println(url)

      val content = Source.fromURL(url).mkString
      val keywords = TFIDF.getKeywords(stripTags(content), 5)
      keywords.foreach(println)
    }
  }

  def stripTags(article: String) = {
    article.replaceAll("<script[\\s\\S]*</script>", "").replaceAll("<[^>]*?>", "").replaceAll("\\s", "")
  }
}
