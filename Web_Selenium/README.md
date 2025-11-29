# 🚀 Selenium Test Automation Framework

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.34.0-green.svg)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.6.0-red.svg)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-Build%20Tool-blue.svg)](https://maven.apache.org/)

## 📋 Mục Lục

- [Tổng Quan](#-tổng-quan)
- [Kiến Trúc Framework](#-kiến-trúc-framework)
- [Công Nghệ Sử Dụng](#-công-nghệ-sử-dụng)
- [Yêu Cầu Hệ Thống](#-yêu-cầu-hệ-thống)
- [Cài Đặt](#-cài-đặt)
- [Cấu Trúc Dự Án](#-cấu-trúc-dự-án)
- [Hướng Dẫn Sử Dụng](#-hướng-dẫn-sử-dụng)
- [Chạy Test](#-chạy-test)
- [Báo Cáo](#-báo-cáo)
- [Best Practices](#-best-practices)
- [Tính Năng Nổi Bật](#-tính-năng-nổi-bật)
- [Đóng Góp](#-đóng-góp)

## 🎯 Tổng Quan

Framework tự động hóa kiểm thử web được xây dựng với **Selenium WebDriver**, **TestNG** và **Java 17**. Framework được
thiết kế theo mô hình **Page Object Model (POM)** với kiến trúc module hóa, dễ bảo trì và mở rộng.

### Đặc Điểm Chính

- ✅ Hỗ trợ đa trình duyệt (Chrome, Edge, Firefox)
- ✅ Page Object Model (POM) Design Pattern
- ✅ Extent Reports với screenshot tự động
- ✅ ThreadLocal để chạy song song
- ✅ Custom assertions và utilities
- ✅ Data-driven testing với JSON
- ✅ TestNG suite configuration
- ✅ Logging và error handling

## 🏗️ Kiến Trúc Framework

```
┌─────────────────────────────────────────────────┐
│           Test Layer (TestNG)                   │
│  - LoginPageTest                                │
│  - BaseTest (Setup/Teardown)                   │
└────────────────┬────────────────────────────────┘
                 │
┌────────────────┴────────────────────────────────┐
│           Page Layer (POM)                      │
│  - HomePage, ProductPage, CartPage             │
│  - BasePage (Common actions)                   │
└────────────────┬────────────────────────────────┘
                 │
┌────────────────┴────────────────────────────────┐
│        Utilities & Helpers                      │
│  - ElementUtil, WaitUtil, ScreenshotUtil       │
│  - JsonUtil, DateTimeUtil, FilesUtil           │
└────────────────┬────────────────────────────────┘
                 │
┌────────────────┴────────────────────────────────┐
│        Core Components                          │
│  - DriverManager (ThreadLocal)                 │
│  - AssertManager (Custom Assertions)           │
│  - ExtentReport (Reporting)                    │
│  - TestListener (Events)                       │
└─────────────────────────────────────────────────┘
```

## 💻 Công Nghệ Sử Dụng

| Công Nghệ          | Phiên Bản | Mục Đích                      |
|--------------------|-----------|-------------------------------|
| Java               | 17        | Ngôn ngữ lập trình            |
| Selenium WebDriver | 4.34.0    | Automation browser            |
| TestNG             | 7.6.0     | Testing framework             |
| Maven              | 3.x       | Build & dependency management |
| Extent Reports     | 4.1.7     | HTML reporting                |
| WebDriverManager   | 6.3.3     | Driver management             |
| Lombok             | 1.18.24   | Code generator                |
| GSON               | 2.9.0     | JSON parsing                  |
| JavaFaker          | 1.0.2     | Test data generation          |
| Commons IO         | 2.11.0    | File operations               |

## 📦 Yêu Cầu Hệ Thống

### Bắt Buộc

- **Java Development Kit (JDK)**: 17 hoặc cao hơn
- **Maven**: 3.6+
- **IDE**: IntelliJ IDEA / Eclipse / VS Code
- **Browser**: Chrome, Edge, hoặc Firefox (phiên bản mới nhất)

### Khuyến Nghị

- RAM: 8GB trở lên
- OS: Windows 10/11, macOS, Linux
- Internet connection (để download dependencies)

## 🔧 Cài Đặt

### 1. Clone Repository

```bash
git clone <repository-url>
cd Web_Selenium
```

### 2. Cài Đặt Dependencies

```bash
mvn clean install
```

### 3. Cấu Hình Driver

Framework sử dụng WebDriverManager để tự động quản lý browser drivers. Các driver cũng có thể được lưu trong thư mục
`drivers/`:

```
drivers/
  └── msedgedriver/
      └── win64/
          └── 142.0.3595.94/
              └── msedgedriver.exe
```

### 4. Cấu Hình Test Data

Chỉnh sửa file test data tại:

```
src/test/resources/common/Products.json
```

## 📁 Cấu Trúc Dự Án

```
Web_Selenium/
│
├── src/
│   ├── main/java/
│   │   ├── assertions/           # Custom assertion framework
│   │   │   ├── Assert.java       # Assertion implementation
│   │   │   └── AssertManager.java
│   │   │
│   │   ├── bases/                # Base classes
│   │   │   ├── BasePage.java     # Base page with common actions
│   │   │   └── BaseTest.java     # Base test with setup/teardown
│   │   │
│   │   ├── drivers/              # WebDriver management
│   │   │   ├── DriverManager.java # ThreadLocal driver
│   │   │   └── DriverOC.java     # Driver initialization
│   │   │
│   │   ├── listener/             # TestNG listeners
│   │   │   └── TestListener.java # Test event handling
│   │   │
│   │   ├── reports/              # Reporting framework
│   │   │   ├── ExtentLogger.java # Logger wrapper
│   │   │   ├── ExtentManager.java
│   │   │   └── ExtentReport.java # Report configuration
│   │   │
│   │   └── utilities/            # Utility classes
│   │       ├── DateTimeUtil.java
│   │       ├── ElementUtil.java  # Element interactions
│   │       ├── FilesUtil.java
│   │       ├── JsonUtil.java     # JSON handling
│   │       ├── ScreenshotUtil.java
│   │       └── WaitUtil.java     # Wait strategies
│   │
│   └── test/java/
│       ├── common/               # Test data
│       │   └── DataTest.java
│       │
│       ├── models/               # Data models
│       │   └── Product.java
│       │
│       ├── pages/                # Page Object classes
│       │   ├── BasePage.java
│       │   ├── HomePage.java
│       │   ├── ProductPage.java
│       │   ├── CartPage.java
│       │   └── RankingPage.java
│       │
│       └── test/                 # Test classes
│           ├── BaseTest.java
│           └── LoginPageTest.java
│
├── src/test/resources/
│   ├── common/
│   │   └── Products.json         # Test data JSON
│   └── suite/
│       └── regression-test.xml   # TestNG suite
│
├── ExtentReport/                 # Generated reports
│   ├── report.html
│   └── screenshots/
│
├── drivers/                      # Browser drivers
│   └── msedgedriver/
│
└── pom.xml                       # Maven configuration
```

## 📖 Hướng Dẫn Sử Dụng

### 1. Tạo Page Object Mới

```java
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPage extends BasePage {

    // Define locators
    @FindBy(css = "#element-id")
    private WebElement element;

    // Constructor
    public NewPage(WebDriver driver) {
        super(driver);
    }

    // Page actions
    public void performAction() {
        element.click();
    }
}
```

### 2. Tạo Test Class Mới

```java
package test;

import bases.BaseTest;
import org.testng.annotations.Test;
import pages.NewPage;

public class NewTest extends BaseTest {

    @Test
    public void testNewFeature() {
        // Initialize page
        NewPage page = new NewPage(getDriver());

        // Navigate to URL
        navigateToUrl("https://example.com");

        // Perform test actions
        page.performAction();

        // Assertions
        AssertManager.getAssertions().assertTrue(
                condition,
                "Verification message"
        );
    }
}
```

### 3. Sử Dụng Utilities

```java
// Element interactions
ElementUtil elementUtil = new ElementUtil(driver);
List<WebElement> elements = elementUtil.getElements(locator);
elementUtil.

selectByLoopText(elements, "text");

// Wait strategies
WaitUtil waitUtil = new WaitUtil(driver);
waitUtil.

waitForElementVisible(element);

// Screenshots
ScreenshotUtil.

captureScreenshot(driver, "screenshot-name");

// JSON data
JsonUtil jsonUtil = new JsonUtil();
List<Product> products = jsonUtil.readJsonFile("Products.json", Product.class);
```

## 🚀 Chạy Test

### Chạy Toàn Bộ Test Suite

```bash
mvn clean test
```

### Chạy Test Suite Với TestNG XML

```bash
mvn test -DsuiteXmlFile=src/test/resources/suite/regression-test.xml
```

### Chạy Test Với Browser Cụ Thể

```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=edge
mvn test -Dbrowser=firefox
```

### Chạy Test Class Cụ Thể

```bash
mvn test -Dtest=LoginPageTest
```

### Chạy Test Method Cụ Thể

```bash
mvn test -Dtest=LoginPageTest#Test_Case_Login
```

### Chạy Từ IDE

1. Right-click vào test class hoặc method
2. Chọn **Run** hoặc **Debug**
3. Hoặc chạy từ TestNG XML file

## 📊 Báo Cáo

### Extent Reports

Sau khi chạy test, báo cáo HTML được tạo tự động tại:

```
ExtentReport/report.html
```

**Tính năng báo cáo:**

- ✅ Test summary với pass/fail statistics
- ✅ Step-by-step execution logs
- ✅ Screenshots tự động khi test fail
- ✅ Execution time tracking
- ✅ System information
- ✅ Dark theme UI

### Mở Báo Cáo

```bash
# Windows
start ExtentReport/report.html

# Mac
open ExtentReport/report.html

# Linux
xdg-open ExtentReport/report.html
```

### TestNG Reports

TestNG cũng tạo báo cáo mặc định tại:

```
target/surefire-reports/
```

## 🎯 Best Practices

### 1. Page Object Model

- Mỗi page là một class riêng biệt
- Locators và actions được đóng gói trong page class
- Không viết locators trực tiếp trong test

### 2. Test Data Management

- Sử dụng JSON files cho test data
- Centralize test data trong `DataTest.java`
- Tránh hardcode data trong test

### 3. Waits

- Sử dụng explicit waits thay vì Thread.sleep()
- Implement custom wait utilities
- Set timeout phù hợp

### 4. Assertions

- Sử dụng custom AssertManager
- Thêm meaningful messages cho assertions
- Verify expected results rõ ràng

### 5. Logging

- Log mọi action quan trọng
- Sử dụng ExtentLogger cho reporting
- Include context information

### 6. Error Handling

- Implement try-catch blocks khi cần
- Clean up resources trong finally blocks
- Handle exceptions gracefully

## ✨ Tính Năng Nổi Bật

### 1. ThreadLocal Driver Management

```java
// Hỗ trợ parallel execution
DriverManager.setDriver(driver);

WebDriver driver = DriverManager.getDriver();
```

### 2. Custom Assertion Framework

```java
AssertManager.getAssertions().

assertEquals(actual, expected, message);
AssertManager.

getAssertions().

assertTrue(condition, message);
```

### 3. Extent Reporting Integration

```java
ExtentLogger.info("Test step description");
ExtentLogger.

pass("Verification passed");
ExtentLogger.

fail("Verification failed");
```

### 4. Dynamic Locators

```java
private By xDynamicMenuBars(String title) {
    return By.xpath(String.format("//a[text()='%s']", title));
}
```

### 5. Reusable Utilities

- **ElementUtil**: Common element operations
- **WaitUtil**: Wait strategies
- **ScreenshotUtil**: Capture screenshots
- **JsonUtil**: Read/write JSON data
- **FilesUtil**: File operations

## 🔍 Troubleshooting

### Issue: Driver Not Found

**Solution**:

- Kiểm tra WebDriverManager dependency
- Hoặc download driver manually vào `drivers/` folder

### Issue: Test Fails With Timeout

**Solution**:

- Tăng timeout trong WaitUtil
- Kiểm tra element locators
- Verify page load time

### Issue: Screenshot Not Captured

**Solution**:

- Kiểm tra ExtentReport folder permissions
- Verify ScreenshotUtil configuration

### Issue: Parallel Execution Issues

**Solution**:

- Ensure ThreadLocal driver management
- Check TestNG parallel configuration
- Verify thread-safe code

## 📝 Configuration Files

### TestNG XML (regression-test.xml)

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="TestSuite">
    <listeners>
        <listener class-name="listener.TestListener"/>
    </listeners>
    <test name="Regression">
        <parameter name="browser" value="edge"/>
        <classes>
            <class name="test.LoginPageTest"/>
        </classes>
    </test>
</suite>
```

### Maven POM Configuration

- Java 17
- Selenium 4.34.0
- TestNG 7.6.0
- All dependencies managed via Maven

## 🤝 Đóng Góp

Contributions are welcome! Để đóng góp:

1. Fork repository
2. Tạo feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open Pull Request

## 📜 License

This project is licensed under the MIT License.

## 👨‍💻 Tác Giả

**Hoang**

---

## 📞 Liên Hệ

Nếu có bất kỳ câu hỏi hoặc góp ý, vui lòng tạo issue hoặc liên hệ qua email.

---

## 🙏 Acknowledgments

- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Extent Reports](http://extentreports.com/)

---

**⭐ Nếu project hữu ích, đừng quên star repository!**


