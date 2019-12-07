package com.sebruck

import java.io.{BufferedWriter, File, FileWriter}

object Writer {

  private val writeResult = (drawer: String, drawn: String) => {
    val file = new File(s"results/$drawer.txt")
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(drawn)
    bw.close()
  }

  def writeResults(result: Map[String, String]): Unit = {
    val directory = new File("results")
    if (!directory.exists()) directory.mkdir()

    result.toList.foreach(writeResult.tupled)
  }
}
