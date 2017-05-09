import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.RowFactory
import org.apache.spark.sql.types.DataTypes

object Test {
  def main(args:Array[String]) : Unit = {
    val conf = new SparkConf().setAll(
      Map("spark.master" -> "local[*]",
          "spark.app.name" -> "Test"))

    val ss = SparkSession.builder().config(conf).getOrCreate()
    val sc = ss.sparkContext

    val data = Array(1,2,3,4,5)
    val distData = sc.parallelize(data)
    val testDF = ss.createDataFrame(
                   sc.textFile("/Users/larluo/test.txt")
                     .map(_.split(","))
                     .map(attributes => RowFactory.create(attributes(0), Integer.valueOf(attributes (1).trim) )),
                    DataTypes.createStructType(Array (
                      DataTypes.createStructField("name", DataTypes.StringType, false),
                      DataTypes.createStructField ("age", DataTypes.IntegerType, false))))
    testDF.createOrReplaceTempView("test")
    ss.sql ("SELECT * FROM test").show ()
  }
}


