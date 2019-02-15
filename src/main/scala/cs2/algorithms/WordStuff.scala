package cs2.algorithms

import scala.io.Source

object WordStuff {
  
  def wordsInFile(name:String):Unit = {
    val input = Source.fromFile(name)
    val lines = input.getLines()
    val wordSet = scala.collection.mutable.Set[String]()
    for(line <- lines) {
      var words = line.split("\\s+")
      words = words.map(_.filter(_.isLetter).toLowerCase)
      wordSet ++= words
    }
    for(word <- wordSet) {
      println(word)
    }
    println(wordSet.size)
  }
  
  def main(args:Array[String]):Unit = {
    wordsInFile("tempest.txt")
  }
  
  
}