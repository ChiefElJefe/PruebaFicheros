import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*File archivo = new File("C:\\Users\\7N\\Desktop\\PruebaFicheros\\src\\prueba.txt");
        InputStream archivo2 = new FileInputStream("C:\\Users\\7N\\Desktop\\PruebaFicheros\\src\\prueba.txt");
        InputStreamReader entrada= new InputStreamReader(archivo2);
        OutputStream archivo3 = new FileOutputStream("C:\\Users\\7N\\Desktop\\PruebaFicheros\\src\\prueba.txt");
        OutputStreamWriter salida = new OutputStreamWriter(archivo3);
        int c = 0;
        String cart = "";
        if (archivo.exists()) {
            System.out.println("Nombre del fichero: " + archivo.getName());
            System.out.println("Se puede leer: " + archivo.canRead());
            System.out.println("Se puede escribir: " + archivo.canWrite());
            System.out.println("Se puede ejecutar: " + archivo.canExecute());
            System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
            System.out.println("Ruta: " + archivo.getPath());
            System.out.println("Numero de caracteres: " + archivo.length());
            System.out.println("Archivos y directorios: " + archivo.list());
        } else {
            System.out.println("No existe el fichero");
        }



        while (c!=-1){
            c = entrada.read();
            char letra = (char) c;
            cart = cart + String.valueOf(letra);

        }

        System.out.println(cart);
        entrada.close();

        salida.write(cart);
        salida.close();*/
        /*File archivo = new File("C:\\Users\\7N\\Desktop\\PruebaFicheros\\src\\PrimeraCarpeta");
        archivo.mkdir();
        File archivo2 = new File(archivo+"\\SegundaCarpeta");
        archivo2.mkdir();
        File archivo3 = new File(archivo2+"\\TerceraCarpeta");
        archivo3.mkdir();
        File fichero = new File(archivo3+"\\hola.txt");
        fichero.createNewFile();*/

        /*InputStream in = new FileInputStream("C:\\Users\\7N\\Desktop\\PruebaFicheros\\src\\origen");
        OutputStream out = new FileOutputStream(".\\src\\destino", true);
        byte[] buffer = new byte[256];
        while (true){
            int n = in.read(buffer);
            if (n <0)
                break;
            out.write(buffer,0,n);
        }
        in.close();
        out.close();*/
        /*
        FileReader in = new FileReader(".\\src\\odoo.conf");
        FileWriter out = new FileWriter(".\\src\\destino", true);

        String cadena = "";
        while (true){
            int n = in.read();
            if (!(n <0)) {
                cadena = ((char)n) + cadena;
            }
            if (n <0)
                break;
        }
        out.write(cadena);
        out.write("\nMiguel Ángel\n");
        out.write("Arribas Pérez\n");
        in.close();
        out.close();
        */
        /*
        FileReader en = new FileReader(".\\src\\destino");
        BufferedReader red = new BufferedReader(en);
        int n = 0;
        while (!(n <0)){
            n = red.read();
            String a = (char)n+ red.readLine();
            if (!(n <0)) {
                System.out.println(a);
            }

        }
        */
        /*Properties odoo = new Properties();
        String db_host ="";
        int db_port = 0;
        String db_user ="";
        String db_password ="";
        int xmlrpc_port = 0;
        String addons_path ="";
        try{
            odoo.load(new FileInputStream(".\\src\\odoo.conf"));
            db_host = odoo.getProperty("db_host");
            db_port = Integer.valueOf(odoo.getProperty("db_port"));
            db_user = odoo.getProperty("db_user");
            db_password = odoo.getProperty("db_password");
            xmlrpc_port = Integer.valueOf(odoo.getProperty("xmlrpc_port"));
            addons_path = odoo.getProperty("addons_path");
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        odoo.setProperty("db_host", db_host);
        odoo.setProperty("db_port", String.valueOf(db_port));
        odoo.setProperty("db_user", "Miguel Angel");
        odoo.setProperty("db_password", db_password);
        odoo.setProperty("xmlrpc_port", String.valueOf(xmlrpc_port));
        odoo.setProperty("addons_path", addons_path);

        try {
            odoo.store(new FileOutputStream(".\\src\\destino"),"Bien guapardo");
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }*/

        //xml Sacarlo por pantalla
/*
        String nombre = "";
        String autor = "";
        String precio = "";

        try {
            File archivo = new File("C:\\Users\\7N\\Desktop\\PruebaFicheros\\src\\libros.xml");
            DocumentBuilderFactory libro = DocumentBuilderFactory.newInstance();
            DocumentBuilder construir = libro.newDocumentBuilder();
            Document doc = construir.parse(archivo);
            Element raiz = doc.getDocumentElement();
            NodeList librosNodo = doc.getElementsByTagName("libro");
            for (int i = 0; i < librosNodo.getLength(); i++) {
                Node librosNodos = librosNodo.item(i);
                if (librosNodos.getNodeType() == Node.ELEMENT_NODE) {
                    Element partes = (Element) librosNodos;
                    Element id = null;
                    nombre = partes.getElementsByTagName("nombre").item(0).getTextContent();
                    autor = partes.getElementsByTagName("autor").item(0).getTextContent();
                    precio = partes.getElementsByTagName("precio").item(0).getTextContent();
                    id = doc.createElement("id");
                    partes.setTextContent(i+"");
                    partes.appendChild(id);
                    System.out.println("Nombre: " +nombre + "\nAutor: " + autor + "\nPrecio: " + precio + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //xml añadir id
        /*try {
            //File genera un objeto file de el archivo que toma de la dirección
            File archivo = new File("C:\\Users\\7N\\Desktop\\PruebaFicheros\\src\\libros.xml");
            //DocumentBuilder genera un objeto documento a partir del archivo
            DocumentBuilderFactory libro = DocumentBuilderFactory.newInstance();
            DocumentBuilder construir = libro.newDocumentBuilder();
            Document doc = construir.parse(archivo);
            //Aqui tomamos el elemento raiz del documento
            Element raiz = doc.getDocumentElement();
            //Aqui cogemos la parte del arbol xml que tenga el identificar que busques
            NodeList librosNodo = doc.getElementsByTagName("libro");
            for (int i = 0; i < librosNodo.getLength(); i++) {
                //Aqui vamos seleccionando los elementos internos del arbol seleccionado del xml
                Node librosNodos = librosNodo.item(i);
                if (librosNodos.getNodeType() == Node.ELEMENT_NODE) {
                    //Aqui cramos y añadimos al xml en memoria el identificador que queremos y su texto
                    Element partes = (Element) librosNodos;
                    Element id = doc.createElement("id");
                    id.setTextContent((i+1) + "");
                    partes.appendChild(id);
                }
            }
            //Aqui modificamos el archivo con el nuevo contenido
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(archivo);
            transformer.transform(source, result);


        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*ArrayList <Integer> enteros = new ArrayList<>();
        File archivo = new File("C:\\Users\\7N\\Desktop\\PruebaFicheros\\src\\impares.txt");
        OutputStream archivo2 = new FileOutputStream(archivo);
        OutputStreamWriter salida = new OutputStreamWriter(archivo2);
        String numeros = "";

        while (enteros.size() != 25){
            enteros.add(enteros.size());
        }

        System.out.println("El tamaño del array es de: " + enteros.size());

        for (int i = 0; i < enteros.size(); i++) {
            if (enteros.get(i) % 2 != 0){
                System.out.println(enteros.get(i));
                numeros += enteros.get(i) + " ";
            }
        }

        salida.write(numeros);
        salida.close();*/
/*//HashMap a xml
        //Hay que crear una lista  con hasmap, hash usa como identificador un atributo que le hayas asignado
        Map<String, Libro> libros = new HashMap<>();
        Scanner teclado = new Scanner(System.in);
        String nombre;
        String autor;
        while (libros.size() != ((int)(Math.random()*3)+4)) {
            System.out.println("Escribe titulo de Libro" + (libros.size() + 1) + ": ");
            nombre = teclado.nextLine();
            System.out.println("Escribe autor de Libro" + (libros.size() + 1) + ": ");
            autor = teclado.nextLine();
            Libro libro = new Libro(nombre,autor);
            //Aqui es donde se asigna el identificador
            libros.put(libro.getId()+"", libro);
        }
//Todo el bloque de try-catch tiene la creacion y escritura de un xml
        try{
            DocumentBuilderFactory documento = DocumentBuilderFactory.newInstance();
            DocumentBuilder docDocumento = documento.newDocumentBuilder();
            Document documentoXML = docDocumento.newDocument();
            Element root = documentoXML.createElement("Libros");
            documentoXML.appendChild(root);

            //Aqui creamos los elementos hoja del libro
            for (int i = 0; i < libros.size(); i++) {
                Element librazo = documentoXML.createElement("libro");
                root.appendChild(librazo);
                Element nombrazo = documentoXML.createElement("nombre");
                nombrazo.setTextContent(libros.get(i+"").getNombre());
                librazo.appendChild(nombrazo);
                Element autorazo = documentoXML.createElement("autor");
                autorazo.setTextContent(libros.get(i+"").getAutor());
                librazo.appendChild(autorazo);
                Element idazo = documentoXML.createElement("id");
                idazo.setTextContent(libros.get(i+"").getId()+"");
                librazo.appendChild(idazo);
            }

//Transformer se utiliza para escribir en el fichero que hemos creado el xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(documentoXML);
            StreamResult result = new StreamResult("C:\\Users\\7N\\Desktop\\PruebaFicheros\\src\\biblioteca.xml");
            transformer.transform(source, result);
        }catch (Exception e){
            e.printStackTrace();
        }*/

        /*List<Libro> listaLibros = new LinkedList<>();
        Libro librazo;
        try {
            //File genera un objeto file de el archivo que toma de la dirección
            File archivo = new File(".\\src\\biblioteca.xml");
            //DocumentBuilder genera un objeto documento a partir del archivo
            DocumentBuilderFactory libro = DocumentBuilderFactory.newInstance();
            DocumentBuilder construir = libro.newDocumentBuilder();
            Document doc = construir.parse(archivo);
            //Aqui tomamos el elemento raiz del documento
            Element raiz = doc.getDocumentElement();
            //Aqui cogemos la parte del arbol xml que tenga el identificar que busques
            NodeList librosNodo = doc.getElementsByTagName("libro");
            for (int i = 0; i < librosNodo.getLength(); i++) {
                //Aqui vamos seleccionando los elementos internos del arbol seleccionado del xml
                Node librosNodos = librosNodo.item(i);
                if (librosNodos.getNodeType() == Node.ELEMENT_NODE) {
                    Element parte = (Element) librosNodos;
                    //parte es el objeto en el que se va ir cada nodo que tomemos del xml, asi podemos cojer la parte interna del texto y añadirla al objeto libro y asi aderirla a la lista
                    librazo = new Libro(parte.getElementsByTagName("nombre").item(0).getTextContent(), parte.getElementsByTagName("autor").item(0).getTextContent());
                    listaLibros.add(librazo);
                }
            }//En este bucle sacamos por pantallota los atributos de los objetos incluidos de la lista
            for (Libro listaLibro : listaLibros) {
                System.out.println(listaLibro.getNombre() + " " + listaLibro.getAutor() + " " + listaLibro.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
/*
//HasMap, leer fichero colocarlo een un hash modificarlo y escribir otra vez
        Map<String, Libro> libros = new HashMap<>();
        Libro librazo;
        FileWriter fichero = new FileWriter(".\\src\\quirurgeon.txt");
        try {
            //File genera un objeto file de el archivo que toma de la dirección
            File archivo = new File(".\\src\\biblioteca.xml");
            //DocumentBuilder genera un objeto documento a partir del archivo
            DocumentBuilderFactory libro = DocumentBuilderFactory.newInstance();
            DocumentBuilder construir = libro.newDocumentBuilder();
            Document doc = construir.parse(archivo);
            //Aqui tomamos el elemento raiz del documento
            Element raiz = doc.getDocumentElement();
            //Aqui cogemos la parte del arbol xml que tenga el identificar que busques
            NodeList librosNodo = doc.getElementsByTagName("libro");
            for (int i = 0; i < librosNodo.getLength(); i++) {
                //Aqui vamos seleccionando los elementos internos del arbol seleccionado del xml
                Node librosNodos = librosNodo.item(i);
                if (librosNodos.getNodeType() == Node.ELEMENT_NODE) {
                    Element parte = (Element) librosNodos;
                    //parte es el objeto en el que se va ir cada nodo que tomemos del xml, asi podemos cojer la parte interna del texto y añadirla al objeto libro y asi aderirla a la lista
                    librazo = new Libro(parte.getElementsByTagName("nombre").item(0).getTextContent(), parte.getElementsByTagName("autor").item(0).getTextContent());
                    libros.put(librazo.getNombre()+"",librazo);
                }
            }//En este bucle sacamos por pantallota los atributos de los objetos incluidos de la lista
            for (String nombre: libros.keySet()) {
                System.out.println(libros.get(nombre).getNombre() + " " + libros.get(nombre).getAutor() + " " + libros.get(nombre).getId());
            }
            // Cambiamos el valor por otro
            for (String nombre: libros.keySet()) {
                if (libros.get(nombre).getNombre().equals("3")) {
                    libros.get(nombre).setNombre("Repetido");
                }
                if (libros.get(nombre).getAutor().equals("3")) {
                    libros.get(nombre).setAutor("Repetido");
                }
                if (libros.get(nombre).getId().equals("3")) {
                    libros.get(nombre).setId("Repetido");
                }
            }
            //Formamos una cadena y lo escribimos en un fichero de texto .txt
            String cat = "";
            for (String nombre: libros.keySet()) {
                System.out.println(libros.get(nombre).getNombre() + " " + libros.get(nombre).getAutor() + " " + libros.get(nombre).getId());
                cat += libros.get(nombre).getNombre() + " " + libros.get(nombre).getAutor() + " " + libros.get(nombre).getId() + "\n";
            }

            fichero.write(cat);
            fichero.close();

        } catch (Exception e) {
            e.printStackTrace();
        }*/
/*
        Connection conexion;
        PreparedStatement sentencia;
        ResultSet resultado;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/vehiculos_motorizados",
                    "root", "root");
            sentencia = conexion.prepareStatement("SELECT * FROM sede");
            resultado = sentencia.executeQuery();
            System.out.println("Sede;Pais");
            while(resultado.next()){
                System.out.print(resultado.getString(1)+";");
                System.out.println(resultado.getString(2));
            }
            System.out.println("----------------------------------------");
            sentencia = conexion.prepareStatement("INSERT INTO sede (Sede, Nacionalidad) Values (?, ?)");
            sentencia.setString(1, "Ankara");
            sentencia.setString(2, "Turquia");
            sentencia.executeUpdate();

            sentencia = conexion.prepareStatement("SELECT * FROM sede");
            resultado = sentencia.executeQuery();
            System.out.println("Sede;Pais");
            while(resultado.next()){
                System.out.print(resultado.getString(1)+";");
                System.out.println(resultado.getString(2));
            }
            sentencia.close();
            resultado.close();
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }*/

        /*UsoBasedeDatos a = new UsoBasedeDatos();
        String[] menu = new String[]{
                "1.Insertar",
                "2.Modificar",
                "3.Borrar",
                "4.Listar Consulta",
                "5.Salir"
        };
        Scanner teclado = new Scanner(System.in);
        int indice = 0;

        while (indice != 5){
            for (int i = 0; i < menu.length; i++) {
                System.out.println(menu[i]);
            }
            try {
                indice = teclado.nextInt();
            }catch (Exception e){
                e.printStackTrace();
            }
            teclado.nextLine();
            switch(indice){
                case 1:
                    System.out.println("Introduce Sede: ");
                    String sede = teclado.nextLine();
                    System.out.println("Introduce Nacionalidad: ");
                    String nacionalidad = teclado.nextLine();
                    a.insertarTabla(sede, nacionalidad);
                    break;
                case 2:
                    System.out.println("Introduce Sede: ");
                    sede = teclado.nextLine();
                    System.out.println("Introduce Nacionalidad: ");
                    nacionalidad = teclado.nextLine();
                    System.out.println("Introduce la Sede a cambiar: ");
                    String sede2 = teclado.nextLine();
                    a.actualizarTupla(sede2, sede,nacionalidad);
                    break;
                case 3:
                    System.out.println("Introduce la Sede a borrar: ");
                    sede2 = teclado.nextLine();
                    a.borrarDatos(sede2);
                    break;
                case 4:
                    System.out.println("Introduce una consulta: ");
                    sede2 = teclado.nextLine();
                    a.listaDatos(sede2);
                    break;
                case 5:
                    a.cerrarConexion();
                    System.out.println("SALIENDO...");
                    break;
                default:
                    System.out.println("Numero introducido invalido....");
            }
        }
        */

        /*UsoDeBaseDeDatos2 datos = new UsoDeBaseDeDatos2();
        datos.insertar();*/
        //Examen
       /* UsoDeBaseDeDatos3Ex datos = new UsoDeBaseDeDatos3Ex();
        datos.insertar();*/
        Ivan datos = new Ivan();
        datos.borrar();
    }
}