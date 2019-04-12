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
  
  def betterCountName():String = {
    var haveAnswer = false
    var timesUp = false
    
    val thread = new java.lang.Thread {
      override def run() {
        var ctr = 5
        while(!haveAnswer && ctr > 0) {
          println(ctr)
          ctr -= 1
          java.lang.Thread.sleep(1000)
        }
        if(!haveAnswer) {
          println("Times's up")
          timesUp = true
        }
      }
    }
    thread.start
    
    var name:String = null
    println("Enter your name: ")
    while(!timesUp && !Console.in.ready) {
      //java.lang.Thread.sleep(10)
    }
    if(!timesUp) {
      name = readLine
      haveAnswer = true
    }
    name
  }
  
  class Lock
  
  def simpleThreadCount():Unit = {
    val lock = new Lock
    
    var counter = 0
    val threads = Array.fill(10)(new java.lang.Thread {
      override def run() {
        for(i <- 1 to 1000000/10) {
          lock.synchronized {
            counter += 1 
          }
        }
      }
    })
    threads.foreach(_.start)
    threads.foreach(_.join)
    println(counter)
  }
  
  def main(args:Array[String]):Unit = {
    simpleThreadCount
    //val n = betterCountName
    //println("Hello, " + n)
  }
  
  
}