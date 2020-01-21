Feature: login tamplo feature


Scenario: nitin tajane want to login
Given user enters credentional
  | username | password |
  |nitin.tajane@tamplo.com|Nitin@1111|
When dashboard display or not
Then open logout page
Then user get logout

Scenario: nitin yandex want to login
Given user enters credentional
  | username | password |
  |nitin.tajane@yandex.com|12345|
When dashboard display or not
Then open logout page
Then user get logout




