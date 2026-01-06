package com.mycompany.enfoqueaccesodatos;

import data.ContratosData;
import db.ContratosDAO;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EnfoqueAccesoDatos {

    public static void main(String[] args) throws SQLException, TransformerException {
        String rutaXML = "src\\main\\java\\com\\mycompany\\enfoqueaccesodatos\\contratos.xml";
        //Para el archivo que genero con los nuevos datos.
        String rutaXMLNuevo = "src\\main\\java\\com\\mycompany\\enfoqueaccesodatos\\contratos_nuevo.xml";

        try {
            System.out.println("Conexión a la base de datos exitosa");
            //Se crea el documento XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document documento = dBuilder.parse(new File(rutaXML));

            //Obtenemos el documento y quitamos nodos vacios
            documento.getDocumentElement().normalize();

            //Obtener todos los elementos del documento
            NodeList listaContratos = documento.getElementsByTagName("contrato");

            //Lista para almacenar los datos
            List<ContratosData> contratos = new ArrayList<>();

            //Recojo en variables los datos del xml.
            for (int i = 0; i < listaContratos.getLength(); i++) {
                Element elemento = (Element) listaContratos.item(i);

                String nif = obtenerTxtHijo(elemento, "nif");
                String adjudicatario = obtenerTxtHijo(elemento, "adjudicatario");
                String objetoGenerico = obtenerTxtHijo(elemento, "objetoGenerico");
                String objeto = obtenerTxtHijo(elemento, "objeto");
                String fechaAdjudicacion = obtenerTxtHijo(elemento, "fechaAdjudicacion");
                String importe = obtenerTxtHijo(elemento, "importe");
                String tipoContrato = obtenerTxtHijo(elemento, "tipoContrato");

                //Convierto la fecha.
                LocalDateTime fecha = null;
                if (!fechaAdjudicacion.isEmpty()) {
                    //Formato fecha y hora
                    if (fechaAdjudicacion.contains("T")) {
                        fecha = LocalDateTime.parse(fechaAdjudicacion);
                        //System.out.println("Fecha con hora: " + fecha);
                    } else {
                        fecha = LocalDateTime.parse(fechaAdjudicacion + "T00:00:00");
                        //System.out.println("Fecha sin hora: " + fecha);
                    }
                } else {
                    fecha = LocalDateTime.of(1900, 1, 1, 0, 0);
                    //System.out.println("Fecha vacía, por defecto 1900-01-01");
                }

                //Convierto el precio
                Double precio = 0.0;
                if (!importe.isEmpty()) {
                    String importeCambiado = importe.replace(",", ".")
                            .replace("€", "")
                            .trim();
                    precio = Double.valueOf(importeCambiado);
                }

                ContratosData contrato = new ContratosData(nif, adjudicatario, objetoGenerico, objeto, fecha, precio, tipoContrato);
                contratos.add(contrato);

            }
            System.out.println("Lectura de datos completada en el archivo XML.");

            ContratosDAO dao = new ContratosDAO();
            dao.vaciarDatos(); //Método de ContratosDAO para vacíar los datos.
            System.out.println("Limpieza de datos exitoso.");

            for (ContratosData contrato : contratos) {
                dao.introducirDatos(contrato); //Método de ContratosDAO
            }
            System.out.println("Inserción de nuevos datos completada.");

            //Recorre los datos con un List y usa el método listar del DAO.
            List<ContratosData> contratosBd = dao.listarContratos(null, null, null, null, null, null, null);

            //Genera los datos en un xml.
            GeneradorXML.generarXML(contratosBd, rutaXMLNuevo);
            System.out.println("Generado nuevo documento XML");

        } catch (IOException | NumberFormatException | ParserConfigurationException | SAXException e) {
            System.err.print("Error: " + e.getMessage());
        }
    }

    //Método para obtener los textos del hijo.
    private static String obtenerTxtHijo(Element padre, String nombreElemento) {
        //Busca los hijos.
        NodeList nodos = padre.getElementsByTagName(nombreElemento);
        //Si encuentra alguno.
        if (nodos.getLength() > 0) {
            //Recojo el primer hijo encontrado y obtengo el texto.
            return nodos.item(0).getTextContent().trim();
        }
        //Si no lo encuentra, lo devuelve vacío.
        return "";
    }
}
