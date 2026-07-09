# Hands-On 1: RESTful Web Service Resource Naming Guidelines

## Objectives
* Follow standard REST conventions: plural resource names, consistent methods (GET/POST/PUT/DELETE).

## Naming Standards Reference Table

| Method Type | URL Path | Description | Annotation |
|---|---|---|---|
| GET | `/countries` | Get all countries | `@GetMapping` |
| GET | `/countries/{code}` | Get specific country | `@GetMapping("/{code}")` |
| POST | `/countries` | Create a country | `@PostMapping` |
| PUT | `/countries` | Update a country | `@PutMapping` |
| DELETE | `/countries/{code}` | Delete specific country | `@DeleteMapping("/{code}")` |
