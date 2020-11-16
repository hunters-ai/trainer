package com.example.exercise

import org.apache.spark.sql.DataFrame

case class Logic(snapshotDf: DataFrame, updateDf: DataFrame) {

  def newSnapshot(): DataFrame = {
    snapshotDf
  }

}
