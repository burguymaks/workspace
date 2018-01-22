package com.example.tests;

import org.testng.annotations.Test;

public class GruopCreationTests extends TestBase { 
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    goToGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	fillGroupForm(group);
    submitGropCreation();
    returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    goToGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGropCreation();
    returnToGroupsPage();
  }
}
