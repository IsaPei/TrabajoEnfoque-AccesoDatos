package com.mycompany.enfoqueaccesodatos;

import data.ContratosData;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeneradorXML {

    public static void generarXML(List<ContratosData> contratos, String salida) throws TransformerConfigurationException, TransformerException {
        try {
            
            //Se crea el documento con su builder.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document documento = dBuilder.newDocument();

            //Se crea el elemento raíz contratos.
            Element elementoRaiz = documento.createElement("contratos");
            documento.appendChild(elementoRaiz);

            //Se recorre cada contrato y se crea elementos "contrato".
            for (ContratosData contrato : contratos) {
                Element contratoElemento = documento.createElement("contrato");
                elementoRaiz.appendChild(contratoElemento);

                //Se usa el método creado agregarElemento y se añaden los campos.
                agregarElemento(documento, contratoElemento, "nif", contrato.getNif());
                agregarElemento(documento, contratoElemento, "adjudicatario", contrato.getAdjudicatario());
                agregarElemento(documento, contratoElemento, "objeto_generico", contrato.getObjetoGenerico());
                agregarElemento(documento, contratoElemento, "objeto", contrato.getObjeto());
                
                //Se trabaja con la fecha para evitar errores.
                if (contrato.getFechaAdjudicacion() != null) {
                    agregarElemento(documento, contratoElemento, "fecha_adjudicacion", contrato.getFechaAdjudicacion().toString());
                } else {
                    agregarElemento(documento, contratoElemento, "fecha_adjudicacion", "");
                }
                
                agregarElemento(documento, contratoElemento, "importe", String.valueOf(contrato.getImporte()));
            }
            
            //Guardar el XML
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer tr = tf.newTransformer();
            
            //Para que lo guarde con formato
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            
            //Se crea DOM
            DOMSource ds = new DOMSource(documento);
            StreamResult st = new StreamResult(new File(salida));
            tr.transform(ds, st); //Escribe en el documento xml.
            
            System.out.println("XML generado desde GeneradorXML.");
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GeneradorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Método para agregar elementos de forma simplificada para no tener que añadir tantas líneas de código.
    private static void agregarElemento(Document documento, Element padre, String nombre, String valor) {
        //Se crea un elemento con "nombre".
        Element elemento = documento.createElement(nombre);
        //Se añade el "valor".
        elemento.appendChild(documento.createTextNode(valor));
        //Se añade "elemento" como hijo de "padre".
        padre.appendChild(elemento);
    }
}
