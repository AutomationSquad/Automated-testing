#!/usr/bin/env bash
#java -jar -Dwebdriver.chrome.driver="chromedriver" selenium-server-standalone-3.12.0.jar -role node -hub http://localhost:4444/grid/register
java -Dwebdriver.chrome.driver="chromedriver"  -jar selenium-server-standalone-3.12.0.jar -role node -nodeConfig nodes.json

#1. Использование и настройка Selenium Grid
#2. Работа с фреймами и окнами, вкладками браузера
#3. Вызов скриптов JavaScript, получение результатов выполнения
#4. Ограничения фреймворка (что не можем тестировать и почему)
#5. Настройки драйвера (время ожиданий, управление cookies, окном)
#6. Работа с различными браузерами на разных платформах (Chrome, Firefox; Windows, Linux, Mac OS)
#7. Запуск тестов в гриде