package cs2.net

import java.net._
import java.io._
import java.lang.Thread

object ChatServerClient {
  
  def createInputThread(sock:Socket):Thread = {
    new Thread {
      override def run() {
        val bis = new BufferedInputStream(sock.getInputStream)
        
        var msg = ""
        while(!sock.isClosed && msg != "EXIT\n") {
          msg = ""
          while(!sock.isClosed && bis.available == 0) Thread.sleep(10)
          
          var lastChar = ' '
          while(!sock.isClosed && bis.available > 0 && lastChar != '\n') {
            lastChar = bis.read.toChar
            msg += lastChar
          }
          println("<< " + msg)
        }
        bis.close
      }
    }
  }
  
  def createOutputThread(sock:Socket):Thread = {
    new Thread {
      override def run() {
        val dos = new DataOutputStream(
                     new BufferedOutputStream(sock.getOutputStream))
        val sis = new BufferedInputStream(System.in)
        
        var msg = ""
        while(!sock.isClosed && msg != "EXIT\n") {
          msg = ""
          while(!sock.isClosed && sis.available == 0) Thread.sleep(10)
          
          var lastChar = ' '
          while(!sock.isClosed && sis.available > 0 && lastChar != '\n') {
            lastChar = sis.read.toChar
            msg += lastChar
          }
          
          println(">> " + msg)
          if(!sock.isClosed) {
            dos.writeBytes(msg)
            dos.flush
          }
        }
        dos.close
        sis.close
      }
    }
  }
  
  
  def main(args:Array[String]):Unit = {
    // args(0) = server | client
    // args(1) = port number
    // args(2) = hostname (only used if client)
    if(args(0) == "server") {
      val ss = new ServerSocket(args(1).toInt)
      val sock:Socket = ss.accept
      val in = createInputThread(sock)
      val out= createOutputThread(sock)
      in.start
      out.start
      in.join
      out.join
      sock.close
      ss.close
    } else if(args(0) == "client") {
      val sock = new Socket(args(2), args(1).toInt)
      val in = createInputThread(sock)
      val out= createOutputThread(sock)
      in.start
      out.start
      in.start
      out.start
      in.join
      out.join
      sock.close
    } else {
      println("Invalid args 0")
    }
    
  }
  
  
}