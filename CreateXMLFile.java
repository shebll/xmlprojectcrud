import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class CreateXMLFile {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("University");
            document.appendChild(root);

            Element record = document.createElement("Student");
            record.setAttribute("ID", "");
            Element FirstName = document.createElement("FirstName");
            Element LastName = document.createElement("LastName");
            Element Gender = document.createElement("Gender");
            Element Level = document.createElement("Level");
            Element GPA = document.createElement("GPA");
            Element Address = document.createElement("Address");
            record.appendChild(FirstName);
            record.appendChild(LastName);
            record.appendChild(Gender);
            record.appendChild(Level);
            record.appendChild(GPA);
            record.appendChild(Address);


            
            root.appendChild(record);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            File xmlFile = new File("data.xml");
            StreamResult result = new StreamResult(xmlFile);

            transformer.transform(source, result);

            System.out.println("XML file generated successfully at " + xmlFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}