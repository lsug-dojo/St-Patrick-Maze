package lsug

class Door(val level: Int, val direction: Direction = Up){

  def enter = {
    def nextLevel(level: Int) : Int = {
      level match {
	case 0 => 1
	case _ => level
      }
    }
    direction match {
    case Up => new Room(level = nextLevel(level + 1))
    case Down => new Room(level = nextLevel(level - 1))
    }
  }

}
class Room(val level: Int = 2) {
  def doors = List(new Door(level, Up), new Door(level, Down))
}

abstract class Direction 
case object Up extends Direction
case object Down extends Direction

object Maze {
  val MaxLevels = 1000000
  def randomLevel = 1 + scala.util.Random.nextInt(Maze.MaxLevels)
}

class Leprechaun {
  val room = new Room(Maze.randomLevel)
}

class Guiness {
  val room = new Room(Maze.randomLevel)
}
