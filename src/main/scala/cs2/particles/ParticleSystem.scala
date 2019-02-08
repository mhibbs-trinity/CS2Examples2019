package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class ParticleSystem(protected var origin:Vec2) {
  protected var parts = List[Particle]()
  
  def addParticle():Unit = {
    if(math.random < 0.5) {
      parts ::= new SquareParticle(new Vec2(origin), 
                           new Vec2(math.random*2 - 1, math.random*2 - 1))
    } else {
      parts ::= new RoundParticle(new Vec2(origin), 
                           new Vec2(math.random*2 - 1, math.random*2 - 1))
    }
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