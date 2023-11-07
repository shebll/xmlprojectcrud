import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AddRecordToXML {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("How many users do you want to add? ");
            int numUsers = scanner.nextInt();
            User[] users = new User[numUsers];
            for (int i = 0; i < numUsers; i++) {
                System.out.println("Enter information for user " + (i + 1) + ":");
                System.out.print("ID: ");
                int ID = scanner.nextInt();
                System.out.print("FirstName: ");
                String FirstName = scanner.next();
                System.out.print("LastName: ");
                String LastName = scanner.next();
                System.out.print("Gender: ");
                String Gender = scanner.next();
                System.out.print("Level: ");
                int Level = scanner.nextInt();
                System.out.print("GPA: ");
                Double GPA = scanner.nextDouble();
                System.out.print("Address: ");
                String Address = scanner.next();
                users[i] = new User(FirstName,LastName,ID,GPA,Level,Gender,Address);

                Element root = doc.getDocumentElement();
                Element newRecord = doc.createElement("Student");
                newRecord.setAttribute("id", Integer.toString(users[i].getId()));
                Element FirstNameIn = doc.createElement("FirstName");
                FirstNameIn.appendChild(doc.createTextNode(users[i].getFirstName()));
                newRecord.appendChild(FirstNameIn);
                Element LastNameIn = doc.createElement("LastName");
                LastNameIn.appendChild(doc.createTextNode(users[i].getLastName()));
                newRecord.appendChild(LastNameIn);
                Element GenderIn = doc.createElement("Gender");
                GenderIn.appendChild(doc.createTextNode(users[i].getGender()));
                newRecord.appendChild(GenderIn);
                Element AddressIn = doc.createElement("Address");
                AddressIn.appendChild(doc.createTextNode(users[i].getAddress()));
                newRecord.appendChild(AddressIn);
                Element LevelIn = doc.createElement("Level");
                LevelIn.appendChild(doc.createTextNode(Integer.toString(users[i].getLevel())));
                newRecord.appendChild(LevelIn);
                Element GPAIn = doc.createElement("GPA"); 
                GPAIn.appendChild(doc.createTextNode(Double.toString(users[i].getGPA())));
                newRecord.appendChild(GPAIn);
                root.appendChild(newRecord);
            }
        }
            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(xmlFile);
            transformer.transform(source, result);
            System.out.println("Record added to the XML file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class User {
    private String FirstName;
    private String LastName;
    private String Address;
    private String Gender;
    private int Id;
    private Double GPA;
    private int Level;


    public User(String FirstName , String LastName, int Id,Double GPA, int Level, String Gender , String Address) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Id = Id;
        this.GPA = GPA;
        this.Level = Level;
        this.Address = Address;
        this.Address = Gender;
        
    }

    public String getFirstName() {
        return FirstName;
    }
    public String getLastName() {
        return LastName;
    }
    public String getGender() {
        return Gender;
    }
    public String getAddress() {
        return Address;
    }
    public int getId() {
        return Id;
    }
    public double getGPA() {
        return GPA;
    }   
    public int getLevel() {
        return Level;
    }
}