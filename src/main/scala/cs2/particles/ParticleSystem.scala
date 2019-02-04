package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class ParticleSystem(private var origin:Vec2) {
  private var parts = List[Particle]()
  
  def addParticle():Unit = {
    parts ::= new Particle(new Vec2(origin), 
                           new Vec2(math.random, math.random))
  }
  
  def display(g:GraphicsContext):Unit = {
    parts.foreach(_.display(g))
  }
  def timeStep():Unit = {
    for(x <- parts) x.timeStep()
  }
  def applyForce(acc:Vec2):Unit = {
    parts.foreach(_.applyForce(acc))
  }
  
}