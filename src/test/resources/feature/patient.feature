Feature: Patient
  In order to maintain the patient records
  As a admin
  I would like acces the OpenEMR portal

@Patient
  Scenario: Add Patient
    When I enter username as "admin"
    And I Enter password as "pass"
    And I select language as "English (Indian)"
    And I click on login button
    And I click on patient-client
    And I click on patient
    And I click on Add New Patient
    And I fill the form
      | firstname | lastname | dob       | gender |
      | John      | carter   | 199-02-02 | Male   |
    And I click on create new patient
    And I click on confrim 
