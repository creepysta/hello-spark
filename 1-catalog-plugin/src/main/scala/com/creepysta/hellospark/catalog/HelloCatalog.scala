package com.creepysta.hellospark.catalog

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.spark.sql.connector.catalog._
import org.apache.spark.sql.connector.expressions.Transform
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.util.CaseInsensitiveStringMap
import java.util.{Map => JMap}


class HelloCatalog extends CatalogPlugin with TableCatalog {
  implicit private var spark: SparkSession = _
  var _name: String = _
  var _options: CaseInsensitiveStringMap = _

  override def initialize(name: String, options: CaseInsensitiveStringMap): Unit = {
    import scala.jdk.CollectionConverters._
    println(s">>> initialize($name, ${options.asScala})")
    _name = name
    _options = options
  }

  override def name(): String = _name

  override def listTables(namespace: Array[String]): Array[Identifier] = {
    println(s">>> listTables(${namespace.toSeq})")
    Array.empty
  }

  override def loadTable(ident: Identifier): Table = {
    println(s">>> loadTable($ident)")
    ???
  }

  override def createTable(
                            ident: Identifier,
                            schema: StructType,
                            partitions: Array[Transform],
                            properties: JMap[String, String]): Table = {
    import scala.jdk.CollectionConverters._
    println(s">>> createTable($ident, $schema, $partitions, ${properties.asScala})")
    ???
  }

  override def alterTable(ident: Identifier, changes: TableChange*): Table = {
    println(s">>> alterTable($ident, $changes)")
    ???
  }

  override def dropTable(ident: Identifier): Boolean = {
    println(s">>> dropTable($ident)")
    true
  }

  override def renameTable(oldIdent: Identifier, newIdent: Identifier): Unit = {
    println(s">>> renameTable($oldIdent, $newIdent)")
  }

  override def toString = {
    import scala.jdk.CollectionConverters._

    val options = _options.entrySet().asScala
      .map(pair => pair.getKey + "=" + pair.getValue)
      .mkString(",")
    s"${this.getClass.getCanonicalName}(name=$name, options=$options)"
  }
}
