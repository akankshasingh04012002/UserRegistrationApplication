package com.knoldus.registration.service

import com.knoldus.registration.models.User
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UserServiceTest extends AnyFlatSpec with Matchers {

  "UserService" should "register a user successfully" in {
    val user = User("Akanksha", "Singh", "akanksha@gmail.com", "1234567890")
    val userService = new UserService
    val result = userService.registerUser(user)
    result should be(true)
  }

  it should "reject registration with invalid email" in {
    val user = User("Shivani", "Singh", "emailll", "8881017525")
    val userService = new UserService
    val result = userService.registerUser(user)
    result should be(false)
  }

  it should "reject registration with invalid phone number" in {
    val user = User("Shiva", "Gautam", "shiva@gmail.com", "123")
    val userService = new UserService
    val result = userService.registerUser(user)
    result should be(false)
  }
}