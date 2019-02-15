package cs2.algorithms

object ParametricSorting {
  
  def bubbleSort[A <% Ordered[A]](a:Array[A]):Unit = {
    for(j <- 0 until a.length) {
      for(i <- 0 until a.length-1) {
        if(a(i) > a(i+1)) {
          val tmp = a(i+1)
          a(i+1) = a(i)
          a(i) = tmp
        }
      }
    }
  }
  
  def bubbleSort[A](a:Array[A], gt:(A,A)=>Boolean):Unit = {
    for(j <- 0 until a.length) {
      for(i <- 0 until a.length-1) {
        if(gt(a(i),a(i+1))) {
          val tmp = a(i+1)
          a(i+1) = a(i)
          a(i) = tmp
        }
      }
    }
  }
  
  class Student(var first:String, var last:String, val id:Int, var gpa:Double) 
             extends Ordered[Student] {
    def compare(other:Student):Int = {
      this.gpa.compare(other.gpa)
    }
    override def toString():String = {
      "(" + last + ", " + first + " : " + gpa + ")"
    }
  }
  
  def main(args:Array[String]):Unit = {
    val x = new Student("Sally","Ride",1,4.0)
    val y = new Student("Jonny","Depp",365,2.5)
    val z = new Student("Jennifer","Lawrence",4523,3.5)
    val arr = Array(x,y,z)
    //val arr = Array.fill(10)((math.random * 50))
    println(arr.mkString(","))
    bubbleSort(arr)
    println(arr.mkString(","))
    bubbleSort(arr, (s1:Student, s2:Student) => s1.first > s2.first)
    println(arr.mkString(","))
  }
}




