package listener
import java.awt.event._

import java.awt.event.{MouseEvent, MouseListener}
class ML extends MouseListener with MouseMotionListener{
  override def mouseDragged(e: MouseEvent): Unit = {

  }

  override def mouseMoved(e: MouseEvent): Unit = {
    Obj.x = e.getX
    Obj.y = e.getY
  }

  object Obj {
    var x1: Int = 0
    var y1: Int = 0
    var x2: Int = 10
    var y2: Int = 10
    var x : Int = 0
    var y : Int = 0
    var isFirstClick: Boolean = true
  }
  override def mouseClicked(e: MouseEvent): Unit = {
    val button = e.getButton
    print("Clicked at ")
    if(Obj.isFirstClick){
      Obj.x1 = e.getX
      Obj.y1 = e.getY
      Obj.isFirstClick = false
      println("1st Click" , e.getX , e.getY)
    }else{
      Obj.x2 = e.getX
      Obj.y2 = e.getY
      Obj.isFirstClick = true
      println("2nd Click" , e.getX , e.getY)
    }
  }

  override def mousePressed(e: MouseEvent): Unit = {

  }

  override def mouseReleased(e: MouseEvent): Unit = {

  }

  override def mouseEntered(e: MouseEvent): Unit = {

  }

  override def mouseExited(e: MouseEvent): Unit = {

  }
}

