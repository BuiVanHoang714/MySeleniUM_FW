# Selenium Test Automation Framework

A lightweight Selenium + TestNG UI automation framework built with Java 17 and Maven, following the Page Object Model (
POM) pattern.

## 1. Features

- Selenium WebDriver with multi-browser support (Chrome, Edge, Firefox)
- TestNG for test management and parallel execution
- Page Object Model (POM) design
- ExtentReports HTML report with screenshots on failure
- Custom assertion wrapper
- Utility layer for waits, elements, screenshots, JSON, files, and dates
- Data‑driven tests using JSON test data

## 2. Tech Stack

- Java 17
- Selenium WebDriver 4.x
- TestNG 7.x
- Maven 3.x
- ExtentReports
- WebDriverManager
- Gson, JavaFaker, Commons IO, Lombok

Dependencies are managed in `pom.xml`.

## 3. Project Structure (High Level)

- `src/main/java`
    - `assertions` – custom assertion classes
    - `bases` – `BasePage`, `BaseTest`
    - `drivers` – WebDriver and ThreadLocal driver manager
    - `listener` – TestNG listener for reporting & screenshots
    - `reports` – ExtentReports configuration and logger wrapper
    - `utilities` – helpers for waits, elements, screenshots, JSON, files, date/time
- `src/test/java`
    - `pages` – Page Object classes
    - `test` – Test classes (e.g. `LoginPageTest`)
    - `common`, `models` – shared test data and POJOs
- `src/test/resources`
    - `common/Products.json` – sample test data
    - `suite/regression-test.xml` – TestNG suite
- `ExtentReport/` – generated HTML reports (e.g. `report.html`)

## 4. Getting Started

1. Install JDK 17 and Maven 3+
2. Clone the repository:

    ```bash
    git clone <repository-url>
    cd My_SeleniUM_FrameWork
    ```

3. Download dependencies and build:

    ```bash
    mvn clean install
    ```

   WebDriver binaries are managed by WebDriverManager. Optional drivers can be placed under `drivers/`.

## 5. Running Tests

From the project root:

```bash
# Run all tests
mvn test

# Run TestNG suite
mvn test -DsuiteXmlFile=src/test/resources/suite/regression-test.xml

# Run a single test class
mvn test -Dtest=LoginPageTest
```

You can also run tests directly from your IDE using TestNG.

## 6. Reports

After a test run, open the Extent report:

```bash
# Windows
start ExtentReport/report.html
```

The folder also contains screenshots captured on failures.

## 7. Customization

- Add or modify Page Objects under `src/test/java/pages`
- Add new tests under `src/test/java/test`
- Update test data in `src/test/resources/common/Products.json`
- Adjust TestNG configuration in `src/test/resources/suite/regression-test.xml`

## 8. License & Author

- License: MIT
- Author: Hoang
