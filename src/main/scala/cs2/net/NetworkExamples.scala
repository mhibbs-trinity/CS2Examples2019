package cs2.net

import java.net._
import java.io._

object NetworkExamples {
  
  def simpleServer():Unit = {
    val ss = new ServerSocket(50000)
    val sock = ss.accept()
    val dos = new DataOutputStream(
                new BufferedOutputStream(
                   sock.getOutputStream ))
    for(i <- 1 to 10) {
      println(">> Sending: " + i)
      dos.writeInt(i)
    }
    dos.close
    sock.close
    ss.close
  }
  
  def simpleClient():Unit = {
    val sock = new Socket("localhost", 50000)
    val dis = new DataInputStream(
                 new BufferedInputStream(
                    sock.getInputStream ))
    while(dis.available == 0) java.lang.Thread.sleep(10)
    while(dis.available > 0) {
      println("<< Recieved: " + dis.readInt)
    }
    dis.close
    sock.close
  }
  
  
  def getPageSource(url:String):String = {
    val page = new URL(url)
    val bis = new BufferedInputStream(page.openStream)
    var result = ""
    while(bis.available() > 0) {
      result += bis.read.toChar
    }
    result
  }
  
  def main(args:Array[String]):Unit = {
    (new java.lang.Thread {
      override def run() { simpleServer }
    }).start
    java.lang.Thread.sleep(1000)
    simpleClient
    //println(getPageSource("https://new.trinity.edu"))
  }
  
  
  
}