package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    gotoAddContactPage();
    AddContactData contact = new AddContactData();
    contact.first_name = "first name 1";
    contact.last_name = "last name 1";
    contact.address1 = "address 1";
    contact.home1 = "home 1";
    contact.mobile = "mobile 1";
    contact.work = "work 1";
    contact.email1 = "email 1";
    contact.email2 = "email 2";
    contact.bday = "10";
    contact.bmonth = "July";
    contact.byear = "1988";
    contact.group = "Rob";
    contact.address2 = "address 2";
    contact.home2 = "home 2";
	fillAddContactForm(contact);
    submitContactCreation();
    returnToMainPage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    gotoAddContactPage();
    fillAddContactForm(new AddContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "", ""));
    submitContactCreation();
    returnToMainPage();
  }

}
