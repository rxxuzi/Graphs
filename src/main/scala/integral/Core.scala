package integral

import listener.ML

import java.awt.event.MouseListener
import java.awt.{Color, Font, Graphics}
import javax.swing.JPanel

class Core extends JPanel{
  private val ML = new ML()
  private val isGrid = true
  private val isDraw = true
  private val d = 50
  private var t = 0l
  var sx = -100 ; var sy = -100
  this.setBackground(Color.black)
  this.addMouseListener(ML)
  this.addMouseMotionListener(ML)
  override def paintComponent(g: Graphics): Unit = {
    super.paintComponent(g)
    draw(g)
    drawGrid(g)
  }
  //  this.addMouseListener(MouseListener)

  private val formula = "sin (x) * 5 + x/2"

  private def f(x: Double): Double = {
    math.sin(x + t*0.05) * 5 + x/2
//    math.pow(x, 2)
  }

  private def drawGrid(g : Graphics): Unit = {
    val width = getWidth
    val height = getHeight
    g.setColor(Color.LIGHT_GRAY)
    if(isGrid){
      for (i <- width / 2 until width by d) {
        if (isGrid) {
          g.drawLine(i, 0, i, height)
          g.drawLine(width - i, 0, width - i, height)
        } else {
          g.drawLine(i, height / 2 - 4, i, height / 2 + 4)
          g.drawLine(width - i, height / 2 - 4, width - i, height / 2 + 4)
        }
      }
      for (i <- height / 2 until height by d) {
        if (isGrid) {
          g.drawLine(0, i, width, i)
          g.drawLine(0, height - i, width, height - i)
        } else {
          g.drawLine(width / 2 - 4, i, width / 2 + 4, i)
          g.drawLine(width / 2 - 4, height - i, width / 2 + 4, height - i)
        }
      }
    }
//    g.setColor(Color.RED)
//    g.drawLine(0,getHeight/2 , getWidth , getHeight/2)
//    g.drawLine(getWidth/2,0 , getWidth/2 , getHeight)
  }

  private def draw(g: Graphics): Unit = {
    g.setColor(Color.white)
    g.setFont(new Font("Arial", Font.ITALIC, 30))
    g.drawString(formula , 30 ,30)
    drawGraph(g)
    scope(g)
    sleep()
    sx += 1
    sy += 1
  }

  private def drawBall(g : Graphics): Unit = {

  }

  private def drawGraph(g: Graphics): Unit = {
    val w = getWidth
    val h = getHeight
    val fontSize = 20
    g.setColor(Color.RED)
    g.setFont(new Font("Arial", Font.ITALIC, fontSize))
    var i = w/2d
    val dx = w/d
    var counter = 0
    var x = 0d
    val e = 0.05
    val r = 9
    while (x < w/2) {
      if((f(x) *d + h/2).toInt != (f(x + e) *d + h/2).toInt){
//        g.fillOval((x*d + w/2).toInt, (-f(x) *d + h/2).toInt, r, r)
//        g.drawLine((x*d + w/2).toInt, (-f(x) *d + h/2).toInt , ((x + e)*d + w/2).toInt, (-f(x + e) *d + h/2).toInt)
        counter += 1
      }
      g.fillOval((x*d + w/2).toInt, (-f(x) *d + h/2).toInt, r, r)
      x += e
    }
    g.setColor(Color.blue)
    x = 0d
    while (x > - w / 2) {
      if ((h/2 - f(x) * d).toInt != (h/2 - f(x + e) * d).toInt) {
//        g.fillOval((w/2 + x * d).toInt, (h/2 - f(x) * d).toInt, r, r)
//        g.drawLine((w/2 - x * d).toInt, (h/2 - f(x) * d).toInt , (w/2 - x * d).toInt, (h/2 - f(x) * d).toInt)
        counter += 1
      }
      g.fillOval((w/2 + x * d).toInt, (h/2 - f(x) * d).toInt, r, r)
      x -= e
    }

//    println("ball" + counter)

//    println(x,f(x) + " is at ")
//    println(x*d + w/2,f(x)*d + h/2)
  }

  private def scope(g: Graphics) : Unit = {
    g.setColor(Color.cyan)
    g.fillRect(ML.Obj.x1, ML.Obj.y1, ML.Obj.x2 - ML.Obj.x1, ML.Obj.y2 - ML.Obj.y1)
  }

  private def sleep():Unit={
    Thread.sleep(1)
    this.repaint()
    t += 1
  }
}

object isGrid
