
package com.knoldus.registration.service

import com.knoldus.registration.UsersTable
import com.knoldus.registration.models.User

class UserService {
  def registerUser(user: User): Boolean = {
    UsersTable.createUserTable()
    val emailValid = UsersTable.validateEmail(user.email)
    val phoneNumberValid = UsersTable.validatePhoneNUmber(user.phoneNumber)

    if (emailValid && phoneNumberValid) {
      UsersTable.insertUser(user)
      true
    } else {
      println("Invalid email address or phone number")
      false
    }
  }
}