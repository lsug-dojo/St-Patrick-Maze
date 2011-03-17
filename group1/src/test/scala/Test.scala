package lsug

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite

class TestSuite extends FunSuite with ShouldMatchers {
  test("room has two doors") { 
    val room = new Room()
    room.doors.length should be(2)
  }
  test("door leads to room"){
   val door = new Door(2, Up)
    door.enter.isInstanceOf[Room] should be(true)
  }
  test("we know what level we are on"){
     val room = new Room()
     room.level should be(2)
  }
  test("up from level 2 is level 3") {
     val room = new Room(level = 2)
     room.doors.head.enter.level should be(3)
  }

  test("down from level 2 is level 1") {
    new Room().doors.tail.last.enter.level should be(1)
  }

  test("down from level 1 is level 1") { new Room(level = 1).doors.last.enter.level should be(1)
				   }

  test("Leprechaun starts on some level") {
    new Leprechaun().room.level should be > (0)
  }

  test("Guiness is in a Room")(
    new Guiness().room.level should be > (0)
  )
}

