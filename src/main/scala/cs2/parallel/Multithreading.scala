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
  
  val lock1 = new Lock
  val lock2 = new Lock
  
  import java.lang.Thread
  
  def funcA = {
    lock1.synchronized {
      println("A1")
      Thread.sleep(1)
      lock2.synchronized {
        println("A2")
      }
    }
  }
  def funcB = {
    lock2.synchronized {
      println("B2")
      Thread.sleep(1)
      lock1.synchronized {
        println("B1")
      }
    }
  }
  
  def tryToDeadlock():Unit = {
    val athreads = Array.fill(10)( new Thread {
      override def run() { funcA }
    })
    val bthreads = Array.fill(10)( new Thread {
      override def run() { funcB }
    })
    athreads.foreach(_.start)
    Thread.sleep(10)
    bthreads.foreach(_.start)
  }
  
  def simpleWaitNotify:Unit = {
    var turn = -1
    val threads = Array.tabulate(8)(idx => new Thread {
      override def run() {
        println("Start thread " + idx)
        for(ctr <- 1 to 10) lock1.synchronized {
          while(turn != idx) { lock1.wait }
          Thread.sleep((math.random() * 100).toInt)
          println("Thread " + idx + " iteration " + ctr)
          turn = (turn + 1) % 8
          lock1.notifyAll
        }
      }
    })
    threads.foreach(_.start)
    Thread.sleep(500)
    turn = 0
    lock1.synchronized { lock1.notifyAll }
  }
  
  //Factorials
  def factRecur(n:BigInt):BigInt = {
    if(n <= 1) 1
    else n * factRecur(n-1)
  }
  def factFor(n:BigInt):BigInt = {
    var product:BigInt = 1
    val one:BigInt = 1
    for(x <- one to n) {
      product *= x
    }
    product
  }
  def factCollect(n:BigInt):BigInt = {
    val one:BigInt = 1
    (one to n).reduce(_*_) //.product
  }
  
  import java.util.concurrent._
  def factExec(n:BigInt):BigInt = {
    val service = Executors.newCachedThreadPool
    val future1 = service.submit(new Callable[BigInt] {
      def call:BigInt = {
        (BigInt(1) until n/2).product  
      }
    })
    val future2 = service.submit(new Callable[BigInt] {
      def call:BigInt = {
        (n/2 to n).product  
      }
    })
    val res = future1.get * future2.get
    service.shutdown
    res
  }
  
  def main(args:Array[String]):Unit = {
    println(factExec(50000))
    //simpleWaitNotify
    //tryToDeadlock
    //simpleThreadCount
    //val n = betterCountName
    //println("Hello, " + n)
  }
  
  
}