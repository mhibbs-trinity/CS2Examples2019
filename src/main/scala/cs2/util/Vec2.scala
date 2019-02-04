package cs2.util

class Vec2(var x:Double, var y:Double) {
  
  def this(other:Vec2) = this(other.x, other.y)
  
  def += (other:Vec2):Unit = {
    this.x += other.x
    this.y += other.y
  }
  
}