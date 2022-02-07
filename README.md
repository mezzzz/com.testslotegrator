Запуск возможнен через maven - plugin - выбрать "Test" или добавить конфигурацию мавена, указать всю папку и применить команду "clean test". 
Короткий отчет отобразится в консоли intellij.

ui тесты - src/test/java/uitests/steps
api тесты - src/test/java/com/testslotegrator/testsuites

Посокольку метод Delete отсутствовал, для повторного запуска API тестов необходимо в классе 
src/test/java/com/testslotegrator/testsuites/UserTest.java изменить константы USERNAME и EMAIL.
