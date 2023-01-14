# Basic Catalog Plugin with Table Catalog

```scala
val conf = new SparkConf()
conf.set("spark.master", "local[*]")
conf.set("spark.sql.catalog.hellocatalog", "com.creepysta.hellospark.catalog.HelloCatalog")
conf.set("spark.sql.catalog.hellocatalog.someconf", "hola amigo")
val spark = SparkSession.builder().config(conf=conf).getOrCreate()
spark.sql("show tables in hellocatalog").show()
```

```console
>>> initialize(hellocatalog, Map(someconf -> hola amigo))
>>> listTables(ArraySeq())
23/01/14 11:33:50 INFO CodeGenerator: Code generated in 211.802403 ms
+---------+---------+-----------+
|namespace|tableName|isTemporary|
+---------+---------+-----------+
+---------+---------+-----------+
```

Ref -
- https://books.japila.pl/spark-sql-internals/demo/developing-catalogplugin/#cannot-find-catalog-plugin-class
- https://github.com/jaceklaskowski/spark-examples
