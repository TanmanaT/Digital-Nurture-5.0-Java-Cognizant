# Factory Method Pattern Example

## Scenario
You are developing a document management system that needs to create different types of documents (e.g., Word, PDF, Excel).

## Core Concepts
- **Factory Method Pattern**: Defines an interface/abstract class for creating an object, but lets subclasses decide which class to instantiate.
- **Loose Coupling**: Clients code to the abstract `DocumentFactory` and `Document` types rather than concrete classes, enabling easy extension to new document formats.

## Class Map
- `Document`: Base interface for document types.
- `WordDocument`, `PdfDocument`, `ExcelDocument`: Concrete document classes.
- `DocumentFactory`: Abstract creator class declaring the factory method `createDocument()`.
- `WordDocumentFactory`, `PdfDocumentFactory`, `ExcelDocumentFactory`: Concrete factory subclasses.
- `FactoryMethodTest`: Driver class to demonstrate document creation.

## Compilation and Execution
```powershell
javac -d bin src/*.java
java -cp bin FactoryMethodTest
```
