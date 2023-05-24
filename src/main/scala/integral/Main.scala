package integral

import javax.swing.JFrame

object Main {
  val WIDTH = 1000
  val HEIGHT = 1000
  def main(args: Array[String]): Unit = {

    val core = new Core()
    println("Hello world!")
    val jf = new JFrame("Graph")
    jf.setDefaultCloseOperation(3)
    jf.setSize(WIDTH , HEIGHT)
    jf.setVisible(true)
    jf.setLocation(0,0)
    jf.add(core)

  }
}