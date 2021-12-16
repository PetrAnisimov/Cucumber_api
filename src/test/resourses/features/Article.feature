Feature: Получить статью
  Пользователь должен получать список статей

  Scenario Template: Sent request for getting articles
    Given Get Articles "<URL>" Request
    Then Response code is: "<status>"
    Examples:
    | URL          | status |
    |article.json  |200     |