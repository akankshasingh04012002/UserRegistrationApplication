package com.knoldus.registration

import com.knoldus.registration.models.User
import com.knoldus.registration.service.UserService
import io.opentelemetry.api.OpenTelemetry
import io.opentelemetry.api.trace.Tracer

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {

    val jaegerEndpoint = "http://localhost:4317"
    val openTelemetry: OpenTelemetry = ExampleConfiguration.initOpenTelemetry(jaegerEndpoint)
    val tracer: Tracer = openTelemetry.getTracer("user-registration-app")
    val span = tracer.spanBuilder("user-registration").startSpan()
    span.addEvent("Registration of user started")
    span.setAttribute("user.first_name", 1)
    span.setAttribute("user.last_name", 2)
    span.setAttribute("user.email", 3)
    span.setAttribute("user.phone_number", 4)
    Thread.sleep(100L)
    span.addEvent("Registration Completed")
    span.end()

    println("Welcome to User Registration")
    println("Enter your first name: ")
    val firstName = StdIn.readLine()
    println("Enter your last name: ")
    val lastName = StdIn.readLine()
    println("Please provide emailId: ")
    val email = StdIn.readLine()
    println("Enter your phone number: ")
    val phoneNumber = StdIn.readLine()

    //Create new User
    val user = User(firstName, lastName, email, phoneNumber)

    val emailValid = validateEmail(user.email)
    val phoneNumberValid = validatePhoneNUmber(user.phoneNumber)

    //Register the user
    val userService = new UserService
    val registeredUser = userService.registerUser(user)

    if (emailValid && phoneNumberValid && registeredUser) {
      println(s"Registration successful, User details $user")
    }
    else {
      println("Invalid email address or phone number , Registration failed")
      println("Please provide correct details....")

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
