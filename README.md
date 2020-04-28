# cvs-auto-vtm

A. For running tests locally
* Create a serenity.conf(do not add it to git versioning) file in src/test/resources containing the following
````
webdriver {
  driver = chrome
}
headless.mode = false

#
# Chrome options can be defined using the chrome.switches property
#
chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
                   --disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
                   --incognito;--disable-infobars,--disable-gpu"""
#
# Define drivers for different platforms. Serenity will automatically pick the correct driver for the current platform
#
drivers {
  windows {
    webdriver.chrome.driver = "src/test/resources/webdriver/windows/chromedriver.exe"
    webdriver.gecko.driver = "src/test/resources/webdriver/windows/geckodriver.exe"
    webdriver.ie.driver = "src/test/resources/webdriver/windows/IEDriverServer.exe"
    webdriver.edge.driver = "src/test/resources/webdriver/windows/msedgedriver.exe"
  }
  mac {
    webdriver.chrome.driver = "src/test/resources/webdriver/mac/chromedriver"
    webdriver.gecko.driver = "src/test/resources/webdriver/mac/geckodriver"
    webdriver.edge.driver = "src/test/resources/webdriver/mac/msedgedriver"
  }
  linux {
    webdriver.chrome.driver = "src/test/resources/webdriver/linux/chromedriver"
    webdriver.gecko.driver = "src/test/resources/webdriver/linux/geckodriver"
  }
}

#
# This section defines environment-specific configuration for different environments.
# You can define normal Serenity properties, such as webdriver.base.url, or custom ones
# You can find more details about this feature at https://johnfergusonsmart.com/environment-specific-configuration-in-serenity-bdd/
# The webdriver.base.url needs to be changed depending on what branch we want to run our tests

environments {
  default {
    webdriver.base.url = "http://localhost:4200"
  }
}
````

* In the ````src/test/resources/```` we should create a folder called ````webdriver````(DO NO ADD IT TO GIT VERSIONING) with subfolders for various operating systems:
  1. linux
  2. mac
  3. windows

* In each folder we should manually download the proper drivers for the OS and the browsers on which we want to run the tests locally

* Comment the following lines in ````serenity.properties```` (BUT DO NOT COMMIT THESE CHANGES)
````
webdriver.driver=provided
webdriver.provided.type=mydriver
webdriver.provided.mydriver=util.DriverSourceImpl
thucydides.driver.capabilities = mydriver
````

B. For running tests from local machine on browserstack
* Make sure the four lines listed above are not commented out in serenity.properties
* Create a file in ````src/main/resources/conf```` called ````enviroment.properties```` containing the following lines:
````
#localBrowserstack
type=localBrowserstack
browserstack.username=<username>
browserstack.password=<password>
browserstack.hostname=hub-cloud.browserstack.com
browserstack.os=Windows
browserstack.os.version=10
#accepted values for browser: Chrome, Firefox, Edge
browserstack.browser=Chrome
# check for browserstack supported versions per browser depending on OS(Windows) and OS version(10) on 
# https://www.browserstack.com/automate/capabilities
browserstack.browser.version=<browser.version>
browserstack.local=false
browserstack.selenium.version=3.141.0
local.name=<name> #everyone should put their own name so the test run on browserstack is easier to identify
app.username=<username> #username used for the microsoft login
app.password=<password> #password used for the microsoft login
microsoftonline.url=<url> # url for retrieving auth token needed for performing BE requests
base.path.url=<api_url> # base url for performing BE requests in order to create test data
````
