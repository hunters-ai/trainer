package com.example.exercise

import org.apache.log4j.{Level, LogManager, Logger}
import org.apache.spark.sql.SparkSession
import org.scalatest.{FunSuite, _}

class MyTest extends FunSuite with BeforeAndAfterEach {
  private val log: Logger = LogManager.getLogger(this.getClass)
  private var sparkSession : SparkSession = _
  Logger.getLogger("org").setLevel(Level.WARN)

  override def beforeEach() {
    sparkSession = SparkSession.builder().appName("my tests")
      .master("local")
      .config("", "")
      .getOrCreate()
  }

  test("test1") {
    val snapshotDf = sparkSession
      .read
      .json("input/snapshot.json")

    val updateDf = sparkSession
      .read
      .json("input/update.json")

    Logic(snapshotDf, updateDf)
      .newSnapshot()
      .write
      .json("output/snapshot.json")
  }


  override def afterEach() {
    sparkSession.stop()
  }
}
