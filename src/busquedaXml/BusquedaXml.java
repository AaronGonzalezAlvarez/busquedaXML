package busquedaXml;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BusquedaXml {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		ArrayList<Producto> productosList = new ArrayList<Producto>();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("C:\\Users\\DAW_M\\Documents\\xml\\Productos.xml"));
			document.getDocumentElement().normalize();
			
			System.out.println("El elemento raiz: " + document.getDocumentElement().getNodeName());
			NodeList productos = document.getElementsByTagName("Producto");
			System.out.println("Nodos a recorrer: " + productos.getLength());
			
			for (int i = 0; i < productos.getLength(); i++) {
	            Node productNode = productos.item(i);

	            if (productNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element productElement = (Element) productNode;
	                String id = productElement.getAttribute("id");
	                String aLaVenta = productElement.getAttribute("aLaVenta");
	                
	                int stock = Integer.parseInt(productElement.getElementsByTagName("Stock").item(0).getTextContent().trim());
	                if( stock < 5) {
	                	productElement.setAttribute("aLaVenta","false");
	                }
	                
                    String venta = productElement.getAttribute("aLaVenta");
                    String nombre = productElement.getElementsByTagName("Nombre").item(0).getTextContent().trim();
                    String precio = productElement.getElementsByTagName("Precio").item(0).getTextContent().trim();
                    String stockxml = productElement.getElementsByTagName("Stock").item(0).getTextContent().trim();
                    int xStock = Integer.parseInt(stockxml);
                    int xid = Integer.parseInt(id);
                    double xprecio = Double.parseDouble(precio);
                    boolean xventa = Boolean.parseBoolean(venta);
                    Producto newProduct = new Producto(xid, xventa, nombre, xprecio, xStock);
                    productosList.add(newProduct);
	                
	            }
	        }
			
			//mejor crearse un nuevo xml
			
			//Document documentNew = builder.parse(new File("C:\\Users\\DAW_M\\Documents\\xml\\Productos.xml"));
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream("C:\\Users\\DAW_M\\Documents\\xml\\ProductosActualizados.xml"));
            transformer.transform(source, result);
			
			
			/*try {
			      DocumentBuilder docBuilder = factory.newDocumentBuilder();
			      //Elemento raíz
			      Document doc = docBuilder.newDocument();
			      Element rootElement = doc.createElement("ListaProductos");
			      doc.appendChild(rootElement);
			      
			      for(Producto x: productosList) {
			    	  
			      }
			      //Primer elemento
			      Element elemento1 = doc.createElement("elemento1");
			      rootElement.appendChild(elemento1);
			      //Se agrega un atributo al nodo elemento y su valor
			      Attr attr = doc.createAttribute("id");
			      attr.setValue("valor del atributo");
			      elemento1.setAttributeNode(attr);
			      Element elemento2 = doc.createElement("elemento2");
			      elemento2.setTextContent("Contenido del elemento 2");
			      rootElement.appendChild(elemento2);
			      //Se escribe el contenido del XML en un archivo
			      TransformerFactory transformerFactory = TransformerFactory.newInstance();
			      Transformer transformer = transformerFactory.newTransformer();
			      DOMSource source = new DOMSource(doc);
			      StreamResult result = new StreamResult(new File("/ruta/prueba.xml"));
			      transformer.transform(source, result);
			    } catch (ParserConfigurationException pce) {
			      pce.printStackTrace();
			    } catch (TransformerException tfe) {
			      tfe.printStackTrace();
			    }
			*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}