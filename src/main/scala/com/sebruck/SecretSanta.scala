package com.sebruck

import scala.util.Random

class SecretSanta(attendees: List[String],
                  blacklist: Map[String, List[String]]) {

  def draw(): Map[String, String] = {
    @scala.annotation.tailrec
    def recurse(pool: List[String],
                drawers: List[String],
                sidePool: List[String],
                result: Map[String, String]): Map[String, String] = {
      drawers match {
        case Nil                    => result
        case _ :: _ if pool.isEmpty =>
          // indissoluble  state due to blacklists, restart whole drawing process
          recurse(attendees, attendees, List.empty, Map.empty)
        case drawer :: restDrawers =>
          val drawn :: restPool = Random.shuffle(pool)
          val isValid = drawer != drawn && !blacklist
            .getOrElse(drawer, List.empty)
            .contains(drawn)

          if (isValid)
            recurse(
              restPool ++ sidePool,
              restDrawers,
              List.empty,
              result ++ Map(drawer -> drawn)
            )
          else recurse(restPool, drawers, sidePool :+ drawn, result)
      }
    }

    recurse(attendees, attendees, List.empty, Map.empty)
  }
}

object SecretSanta {
  def apply(attendees: List[String],
            blacklist: Map[String, List[String]]): SecretSanta =
    new SecretSanta(attendees, blacklist)
}
