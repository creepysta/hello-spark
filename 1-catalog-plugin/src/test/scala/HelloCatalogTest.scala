import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.scalatest.funsuite.AnyFunSuite

class HelloCatalogTest extends AnyFunSuite {
  test("HelloCatalog.listTables") {
    val conf = new SparkConf()
    conf.set("spark.master", "local[*]")
    conf.set("spark.sql.catalog.hellocatalog", "com.creepysta.hellospark.catalog.HelloCatalog")
    conf.set("spark.sql.catalog.hellocatalog.someconf", "hola amigo")
    val spark = SparkSession.builder().config(conf=conf).getOrCreate()
    spark.sql("show tables in hellocatalog").show()
    println("Hello World")
    assert(true)
  }
}
