package com.knoldus.registration.db

import com.typesafe.config.ConfigFactory
import java.sql.Connection

object Database {

  private val config = ConfigFactory.load()
  private val url = config.getString("database.url")
  private val user = config.getString("database.user")
  private val password = config.getString("database.password")

  def getConnection: Connection = {
    Class.forName("com.mysql.cj.jdbc.Driver")
    java.sql.DriverManager.getConnection(url, user, password)
  }
}