/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packato;

import java.awt.Color;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author oky
 */
public class MainFrame extends javax.swing.JFrame {
int variableContadora;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        cargarXml();  
        configTable();
       
     
       variableContadora=0;
    }

    private void cargarXml(){
        try {      
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                        Document doc = docBuilder.parse (new File("tabla_clientes.xml"));
                    
                         doc.getDocumentElement ().normalize ();
                         NodeList listaEmpresa= doc.getElementsByTagName("empresa");
                                doc.getDocumentElement().getNodeName();
                         
                         for ( int i = 0; i< listaEmpresa.getLength(); i++) {
                variableContadora++;
                Node firstEmpresaNode =listaEmpresa.item(i);
                if(firstEmpresaNode.getNodeType() == Node.ELEMENT_NODE){


                    Element firstEmpresaElement = (Element)firstEmpresaNode;
                    System.out.println("empresa numero:".concat(String.valueOf(i+1)));
                    
                    
                  NodeList firstNitList = firstEmpresaElement.getElementsByTagName("nit");
                    Element firstNitElement = (Element)firstNitList.item(0);

                    NodeList textNitList = firstNitElement.getChildNodes();
                    
                    System.out.println("Nit : " + 
                           ((Node)textNitList.item(0)).getNodeValue().trim());
                    String nit=((Node)textNitList.item(0)).getNodeValue().trim();
                   
                    //-----
                    
                      NodeList razonSocialList = firstEmpresaElement.getElementsByTagName("razonsocial");
                    Element razonSocialElement = (Element)razonSocialList .item(0);
                   
                    NodeList textRazonSocialList =razonSocialElement.getChildNodes();
                    
                    System.out.println("Razon social: " + 
                           ((Node)textRazonSocialList .item(0)).getNodeValue().trim());
                      String razonSocial= ((Node)textRazonSocialList .item(0)).getNodeValue().trim();
//                    tabla.setValueAt(razonSocial, i, i);
                        //-----
                    
                     NodeList pbxList = firstEmpresaElement.getElementsByTagName("pbx");
                    Element pbxElement = (Element)pbxList .item(0);

                    NodeList textpbxList =pbxElement.getChildNodes();
                    System.out.println("Pbx: " + 
                           ((Node)textpbxList .item(0)).getNodeValue().trim());
                    //-----
                     NodeList direccionList = firstEmpresaElement.getElementsByTagName("direccion");
                    Element direccionElement = (Element)direccionList .item(0);

                    NodeList textdireccionList =direccionElement.getChildNodes();
                    System.out.println("direccion: " + 
                           ((Node)textdireccionList  .item(0)).getNodeValue().trim());
                  //-----------
                    
                  
                    
                    try {
                        NodeList  emailList= firstEmpresaElement.getElementsByTagName("email");
                    Element emailElement = (Element)emailList.item(0);

                    NodeList textemailList =emailElement.getChildNodes();
                    System.out.println("email: " + 
                           ((Node)textemailList  .item(0)).getNodeValue().trim());
                             System.out.println("\n"+"--------------"+"\n");
                    } catch (Exception e) {
                        System.out.println("email:"+" no tiene email");
                        System.out.println("\n"+"--------------"+"\n");
                    }
                     
                    
                }
          
                         }
        }catch (SAXParseException err) {
        System.out.println ("** Parsing error" + ", line " 
             + err.getLineNumber () + ", uri " + err.getSystemId ());
        System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
        Exception x = e.getException ();
        ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
        t.printStackTrace ();
        }
}
    
    //******************************
    private void configTable(){
        Object columnNames[]={"Número empresa","nit","Razon Social","Pbx","Direccion","email"}; 
        int rowCount=variableContadora;
        DefaultTableModel modelo = new DefaultTableModel(columnNames,rowCount);
        tabla.setModel(modelo);
       tabla.setSelectionBackground(Color.GRAY.brighter());
    }
    //****************************
    
    private void montandoDatos(){
           
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        accionar.setText("Accionar bomba");
        accionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(accionar)
                .addGap(297, 382, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accionar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionarActionPerformed
cargarXml();        // TODO add your handling code here:
    }//GEN-LAST:event_accionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accionar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
