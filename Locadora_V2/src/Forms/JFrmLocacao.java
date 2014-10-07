package Forms;

import ControlersDao.ClienteDao;
import ControlersDao.LocacaoDao;
import ControlersDao.MediaDao;
import Model.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrmLocacao extends javax.swing.JFrame {
    private static final DateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    ClienteDao clienteDao;
    LocacaoBean locacao;
    float total = 0;
    Object titulo[] = {"ID", "Mídia", "Valor", "Tipo"};
    Object grade[][] = null;
    ArrayList<ClienteBean> clientes;
    DefaultTableModel model;
    MidiaBean midia;
    
    public JFrmLocacao() {
        initComponents();
        setLocationRelativeTo(null);
        model = new DefaultTableModel(grade, titulo);
        clienteDao = new ClienteDao();
        locacao = new LocacaoBean();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jcbxMidia = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtClienteId = new javax.swing.JTextField();
        jbtnSearchCliente = new javax.swing.JButton();
        jbtnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbLocacao = new javax.swing.JTable();
        jtxtValorTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jftDataLocacao = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jbtnExit = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Locação");
        setMinimumSize(new java.awt.Dimension(754, 508));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Locação"));

        jcbxMidia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Mídia:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cliente:");

        jtxtClienteId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtClienteId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtClienteIdMouseClicked(evt);
            }
        });

        jbtnSearchCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Icons/search-26.png"))); // NOI18N
        jbtnSearchCliente.setText("Search");
        jbtnSearchCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jtxtClienteId))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcbxMidia, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnSearchCliente)
                .addContainerGap(365, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSearchCliente))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbxMidia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Icons/Add.png"))); // NOI18N
        jbtnAdd.setText("Add");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnAdd))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnAdd))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Data locação:");

        jtbLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mídia", "Tipo", "Valor"
            }
        ));
        jScrollPane1.setViewportView(jtbLocacao);

        jtxtValorTotal.setEditable(false);
        jtxtValorTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtValorTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setText("TOTAL:");

        jftDataLocacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        try {
            jftDataLocacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftDataLocacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jftDataLocacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jbtnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Icons/exit-26.png"))); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.setPreferredSize(new java.awt.Dimension(87, 35));
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        jbtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Icons/save-26.png"))); // NOI18N
        jbtnSave.setText("Save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnSave))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSave))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jftDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jftDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String data = (new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
        jftDataLocacao.setText(data);
        jftDataLocacao.setEditable(false);
        
        
    }//GEN-LAST:event_formWindowOpened

    private int getIdFromComboBox(String value) {
        StringTokenizer st = new StringTokenizer(value, " - ");
        return Integer.valueOf(st.nextToken());
    }
    
    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        MediaDao midiaDao = new MediaDao();
        int media_id = getIdFromComboBox((String)jcbxMidia.getSelectedItem());
        midia = midiaDao.get(media_id);
        locacao.addMidia(midia);

        Object campos[] = {
            midia.getId(),
            midia.getTitulo(),
            midia.getValorLocacao(),
            midia.getGrupo()
        };

        model.addRow(campos);

        jtbLocacao.setModel(model);

        total += Double.valueOf(midia.getValorLocacao());
        jtxtValorTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        LocacaoDao dao = new LocacaoDao();
        try {
        locacao.setDataLocacao(SHORT_DATE_FORMAT.parse(jftDataLocacao.getText().toString()));

        dao.save(locacao);
        clear();
        } catch (ParseException ex) {}
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnSearchClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchClienteActionPerformed
        ClienteBean cliente = clienteDao.get(Integer.valueOf(jtxtClienteId.getText()));
        cliente.setId(Integer.valueOf(jtxtClienteId.getText()));
        locacao.setCliente(cliente);
        
        MediaDao midiaDao = new MediaDao();
        ArrayList<MidiaBean> midias = midiaDao.all();

        for (MidiaBean m : midias) {
            jcbxMidia.addItem(m.getId() + " - " + m.getTitulo());
        }
    }//GEN-LAST:event_jbtnSearchClienteActionPerformed

    private void jtxtClienteIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtClienteIdMouseClicked
        jtxtClienteId.setText(null);
    }//GEN-LAST:event_jtxtClienteIdMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(null, "Deseja sair",null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JButton jbtnSearchCliente;
    private javax.swing.JComboBox jcbxMidia;
    private javax.swing.JFormattedTextField jftDataLocacao;
    private javax.swing.JTable jtbLocacao;
    private javax.swing.JTextField jtxtClienteId;
    private javax.swing.JTextField jtxtValorTotal;
    // End of variables declaration//GEN-END:variables

    private void clear() {
        jtxtClienteId.setText(null);
        jcbxMidia.removeAllItems();
        jcbxMidia.setEnabled(false);
        jtxtValorTotal.setText(null);
        locacao = new LocacaoBean();
        model = new DefaultTableModel(grade, titulo);
        jtbLocacao.setModel(model);
        jtbLocacao.removeAll();
    }
}

