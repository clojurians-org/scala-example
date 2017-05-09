import org.apache.spark.{SparkConf, SparkContext}

object Test {
  def main(args:Array[String]) : Unit = {
    val conf = new SparkConf().setAll(
      Map("spark.master" -> "local[*]",
          "spark.app.name" -> "Test"))
    val sc = new SparkContext(conf)
    val data = Array(1,2,3,4,5)
    val distData = sc.parallelize(data)

    distData.map { x => x + 1}.collect
    sc.stop()
  }  
}


