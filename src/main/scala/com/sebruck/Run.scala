package com.sebruck

object Run extends App {
  val attendees =
    List(
      "Sebastian",
      "Christina",
      "Melanie",
      "Simone",
      "Patrick",
      "Martin",
      "Marcus"
    )

  val blacklist = Map(
    "Sebastian" -> List("Christina"),
    "Christina" -> List("Sebastian"),
    "Simone" -> List("Patrick"),
    "Patrick" -> List("Simone"),
    "Martin" -> List("Marcus"),
    "Marcus" -> List("Martin")
  )

  val secretSanta = SecretSanta(attendees, blacklist)
  val result = secretSanta.draw()

  Writer.writeResults(result)

  println(s"${result.size} files written to ./results . Merry Christmas!")
}
