package cs2

class Angle(private var rad:Double) {
  normalizeAngle

  def this() = {
    this(0.0)
  }
  def this(other:Angle) = {
    this(other.rad)
  }
  
  private def normalizeAngle():Unit = {
    while(rad > 2*math.Pi) {
      rad -= 2*math.Pi
    }
    while(rad < 0) {
      rad += 2*math.Pi
    }
  }

  def radians() = rad
  def degrees() = rad / (2*math.Pi) * 360

  def radians_=(amt:Double):Unit = {
    rad = amt
    normalizeAngle
  }
  def degrees_=(amt:Double):Unit = {
    rad = amt / 360 * 2*math.Pi
    normalizeAngle
  }

  override def toString():String = {
    (rad / math.Pi).toString + "pi"
  }

  def + (other:Angle):Angle = {
    new Angle(this.rad + other.rad)
  }
  def + (amt:Double):Angle = {
    new Angle(this.rad + amt)
  }

  def * (amt:Double):Angle = {
    new Angle(this.rad * amt)
  }

  def unary_-():Angle = {
    new Angle(-this.rad)
  }
}



