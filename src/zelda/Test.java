/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.FileOutputStream;

import javax.swing.JPanel;
import javax.swing.JTable;

public class Test extends javax.swing.JFrame {
    private JTable table;
    /**
     * Creates new form Test
     */
    public Test() {
        initComponents();
        getContentPane().setLayout(new BorderLayout());
    }
    
  private void createTable() {
    Object[][] data = {{ "a", "b", "e", 4, false },  { "A", "B", "C", 5, false }};
    String[] columnNames = { "A", "B", "C", "D", "E" };

    table = new JTable(data, columnNames);

    JPanel tPanel = new JPanel(new BorderLayout());
    tPanel.add(table.getTableHeader(), BorderLayout.NORTH);
    tPanel.add(table, BorderLayout.CENTER);

    getContentPane().add(tPanel, BorderLayout.CENTER);
  }
    
  private void print() {
    Document document = new Document(PageSize.A4.rotate());
    try {
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("jTable.pdf"));

      document.open();
      document.add(new Paragraph(new Chunk("Report title")));
      PdfContentByte cb = writer.getDirectContent();

      cb.saveState();
      Graphics2D g2 = cb.createGraphicsShapes(500, 500);

      Shape oldClip = g2.getClip();
      g2.clipRect(0, 0, 500, 500);

      table.print(g2);
      g2.setClip(oldClip);

      g2.dispose();
      cb.restoreState();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    document.close();
  }
  
  public static void main(String[] args) {
    Test frame = new Test();
    frame.pack();
    frame.setVisible(true);
    frame.print();
  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
