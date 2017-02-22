# Coding example for a job interview

## Overview:
* Basic task
  * Implement get and set (no need to send a working service / package!)
  * Assume a single threaded environment
  * Storing the short url - url mapping in memory is fine
  * Always generate the shortest possible URL which is available.
* Example:
  * ShortURL::set(“https://company.com/product/variant/123?prices=include”)
    * Returns: “a”
  * ShortURL::get(“a”)
    * Returns: “https://company.com/product/variant/123?prices=include”
    
## Requirements
* Java 8 JDK
* Maven >= 3.3.0

## Building
* mvn clean package