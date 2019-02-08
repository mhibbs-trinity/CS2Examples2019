package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

abstract class Particle(protected var pos:Vec2, protected var vel:Vec2) {
  
  def display(g:GraphicsContext):Unit
  
  def timeStep():Unit = {
    pos += vel
  }
  def applyForce(acc:Vec2):Unit = {
    vel += acc
  }
}