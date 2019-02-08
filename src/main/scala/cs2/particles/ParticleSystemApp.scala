package cs2.particles

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import cs2.util.Vec2
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent
import scalafx.Includes._

object ParticleSystemApp {
  
  val app = new JFXApp {
    stage = new JFXApp.PrimaryStage {
      title = "Particles!"
      scene = new Scene(600,400) {
        val canvas = new Canvas(600,400)
        val g = canvas.graphicsContext2D
        content = canvas
        
        var systems = List[ParticleSystem]()
        
        canvas.onMouseClicked = (e:MouseEvent) => {
          systems ::= new RainbowParticleSystem(new Vec2(e.x, e.y))
        }
        
        val bg = new RainbowBackground(600, 400)
        
        val timer = AnimationTimer(t => {
          bg.display(g)
          for(sys <- systems) {
            sys.display(g)
            sys.timeStep()
            sys.addParticle()
            sys.applyForce(new Vec2(0,0.1))
          }
        })
        timer.start
      }
    }
  }
  
  def main(args:Array[String]):Unit = {
    app.main(args)
  }
  
  
}