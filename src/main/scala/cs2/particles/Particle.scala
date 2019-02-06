package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class Particle(protected var pos:Vec2, protected var vel:Vec2) {
  
  def display(g:GraphicsContext):Unit = {
    g.strokeOval(pos.x, pos.y, 10,10)
  }
  def timeStep():Unit = {
    pos += vel
  }
  def applyForce(acc:Vec2):Unit = {
    vel += acc
  }
}