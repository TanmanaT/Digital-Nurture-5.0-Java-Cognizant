# Hands-On 1: HTTP Request and Response Details

## Objectives
* Understand HTTP request-response formats and headers
* Locate headers (`User-Agent`, `Content-Type`, `Authorization`) using browser developer tools and curl.

## Steps
1. Open the RFC standard for HTTP request/response: **https://tools.ietf.org/html/rfc7230** (Refer to sample in page 7).
2. Examine the request lines (Method, Resource, HTTP Version) and response lines (HTTP Version, Status Code 200, Content-Type).
3. Use Chrome browser, open DevTools (`F12`), visit `google.com`, check the **Network** tab, click a request and review:
   * General
   * Request Headers
   * Response Headers
