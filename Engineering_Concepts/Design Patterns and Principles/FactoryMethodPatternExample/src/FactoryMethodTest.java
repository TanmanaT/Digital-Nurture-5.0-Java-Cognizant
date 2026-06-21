public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document doc1 = wordFactory.createDocument();
        doc1.open();
        doc1.close();

        System.out.println("------------------------------------");

        Document doc2 = pdfFactory.createDocument();
        doc2.open();
        doc2.close();

        System.out.println("------------------------------------");

        Document doc3 = excelFactory.createDocument();
        doc3.open();
        doc3.close();
    }
}
