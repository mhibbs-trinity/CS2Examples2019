package cs2.io

import java.io.FileInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.BufferedOutputStream
import java.io.DataOutputStream
import java.io.DataInputStream
import java.io.BufferedInputStream
import java.io.OutputStream
import java.io.InputStream

object GeneralIO {
  
  def copyStream(in:InputStream, out:OutputStream):Unit = {
    while(in.available() > 0) {
      out.write(in.read)
    }
  }
  
  def main(args:Array[String]):Unit = {
    for(str <- args) println(str)
    
    val fis = new FileInputStream(new File("tempest.txt"))
    val fos = new FileOutputStream(new File("tempestCopy.txt"))
    copyStream(fis, fos)
    fis.close
    fos.close
    
    /*
    val dos = new DataOutputStream( new BufferedOutputStream(
                 new FileOutputStream( new File("textFile") )))
    for(i <- 65 to 90) {
      dos.writeInt(i)
    }
    dos.writeDouble(math.Pi)
    dos.writeBoolean(false)
    dos.close
    
    val dis = new DataInputStream( new BufferedInputStream(
                 new FileInputStream( new File("textFile") )))
    for(x <- 1 to 26) {
      println(dis.readInt)
    }
    println(dis.readDouble)
    println(dis.readBoolean)
    dis.close
    */
  }
  
  
}