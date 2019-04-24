package cs2.io

import java.io.FileInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.BufferedOutputStream
import java.io.DataOutputStream

object GeneralIO {
  
  def main(args:Array[String]):Unit = {
    
    val fis = new FileInputStream(new File("tempest.txt"))
    val fos = new FileOutputStream(new File("tempestCopy.txt"))
    while(fis.available() > 0) {
      fos.write(fis.read)
    }
    fis.close
    fos.close
    
    val dos = new DataOutputStream( new BufferedOutputStream(
                 new FileOutputStream( new File("textFile") )))
    for(i <- 65 to 90) {
      dos.writeInt(i)
    }
    dos.close
    
  }
  
  
}