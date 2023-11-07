import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AccessRecordsInXML {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList recordList = doc.getElementsByTagName("record");

            for (int i = 0; i < recordList.getLength(); i++) {
                Element record = (Element) recordList.item(i);
                String id = record.getElementsByTagName("id").item(0).getTextContent();
                String name = record.getElementsByTagName("name").item(0).getTextContent();
                String email = record.getElementsByTagName("email").item(0).getTextContent();

                System.out.println("Record ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
