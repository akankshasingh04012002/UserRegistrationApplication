package com.knoldus.registration

import com.knoldus.registration.db.Database
import com.knoldus.registration.models.User

object UsersTable {
  def createUserTable(): Unit = {
    val connection = Database.getConnection
    try {
      val statement = connection.createStatement()
      val query =
        """
          |CREATE TABLE IF NOT EXISTS users (
          |  id SERIAL PRIMARY KEY,
          |  first_name VARCHAR(50) NOT NULL,
          |  last_name VARCHAR(50) NOT NULL,
          |  email VARCHAR(100) NOT NULL,
          |  phone_number VARCHAR(15) NOT NULL
          |);
          |""".stripMargin

      statement.execute(query)
    } finally {
      connection.close()
    }
  }

  def insertUser(user: User): Boolean = {
    val connection = Database.getConnection
    val query = "INSERT INTO users (first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?)"

    try {
      val statement = connection.prepareStatement(query)
      statement.setString(1, user.firstName)
      statement.setString(2, user.lastName)
      statement.setString(3, user.email)
      statement.setString(4, user.phoneNumber)

      val emailValid = validateEmail(user.email)
      val phoneNumberValid = validatePhoneNUmber(user.phoneNumber)
      if (emailValid && phoneNumberValid) {
        statement.executeUpdate() > 0
      } else {
        false
      }
    } finally {
      connection.close()
    }
  }

  def validateEmail(email: String): Boolean = {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    email.matches(emailRegex)
  }

  def validatePhoneNUmber(phoneNumber: String): Boolean = {
    val phoneRegex = "^\\d{10}$"
    phoneNumber.matches(phoneRegex)
  }

}
