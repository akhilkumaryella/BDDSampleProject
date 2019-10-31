$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/featurefiles/Search.feature");
formatter.feature({
  "name": "Google Search",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search cricket",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "name": "open google URL",
  "keyword": "Given "
});
formatter.match({
  "location": "Search.open_google_URL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter \"criket\"",
  "keyword": "And "
});
formatter.match({
  "location": "Search.enter(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click GoogleSearch",
  "keyword": "When "
});
formatter.match({
  "location": "Search.click_GoogleSearch()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "cricket results coming",
  "keyword": "Then "
});
formatter.match({
  "location": "Search.cricket_results_coming()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});