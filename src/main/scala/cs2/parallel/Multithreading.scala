package cs2.parallel

import io.StdIn._

object Multithreading {
  
  def countDownGetName():String = {
    
    val thread = new java.lang.Thread {
      override def run():Unit = {
        for(i <- 0 until 5) {
          println(i)
          java.lang.Thread.sleep(1000)
        }
        println("Time's up!")
        sys.exit
      }
    }
    thread.start
    
    println("Enter your name: ")
    var name = readLine
    thread.stop
    name
  }
  
  def main(args:Array[String]):Unit = {
    val n = countDownGetName
    println("Hello, " + n)
  }
  
  
}