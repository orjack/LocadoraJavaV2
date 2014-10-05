package Forms;

import ControlersDao.AutorDao;
import ControlersDao.DiretorDao;
import ControlersDao.FornecedorDao;
import ControlersDao.MediaDao;
import Model.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrmMidia extends javax.swing.JFrame {
    MidiaBean media;
    MediaDao dao;
    DefaultTableModel model;
    int selected_index;
    
    private static final DateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy");
    
    //LISTANDO OS DIRETORES
    ArrayList<DiretorBean> diretores;
    //LISTANDO OS AUTORES
    ArrayList<AutorBean> autores;
    //LISTANDO OS FORNECEDORES
    ArrayList<FornecedorBean> fornecedores;
    //LISTANDO AS MIDIAS
    ArrayList<MidiaBean> list;
    public JFrmMidia() {
        initComponents();
        setLocationRelativeTo(null);
        
        media = new MidiaBean();
        dao = new MediaDao();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTPanel = new javax.swing.JTabbedPane();
        jpListagemMidias = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbMidia = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbtnEdit = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jbtnNew = new javax.swing.JButton();
        jpCadastroMidias = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcbxFornecedor = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jcbxGrupo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbxGenero = new javax.swing.JComboBox();
        jcbxCensura = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jtxtTitulo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbxAutor = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jcbxDiretor = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jcbxCategoria = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jftDataLancamento = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtSinopse = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jftValor_compra = new javax.swing.JFormattedTextField();
        jftValor_locacao = new javax.swing.JFormattedTextField();
        jbtnSave = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jsQuantidade = new javax.swing.JSpinner();
        jcbSituacao = new javax.swing.JCheckBox();
        jbtnExit = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(754, 674));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtbMidia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Título", "Valor compra", "Valor locação", "Quantidade"
            }
        ));
        jtbMidia.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jtbMidia);

        jbtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Icons/edit-26.png"))); // NOI18N
        jbtnEdit.setText("Edit");
        jbtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditActionPerformed(evt);
            }
        });

        jbtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Icons/delete-26.png"))); // NOI18N
        jbtnDelete.setText("Delete");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        jbtnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Icons/Add.png"))); // NOI18N
        jbtnNew.setText("New");
        jbtnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnDelete)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jbtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpListagemMidiasLayout = new javax.swing.GroupLayout(jpListagemMidias);
        jpListagemMidias.setLayout(jpListagemMidiasLayout);
        jpListagemMidiasLayout.setHorizontalGroup(
            jpListagemMidiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
            .addGroup(jpListagemMidiasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpListagemMidiasLayout.setVerticalGroup(
            jpListagemMidiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListagemMidiasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTPanel.addTab("Listagem de Mídias", jpListagemMidias);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código:");

        jtxtId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setText("Fornecedor:");

        jLabel3.setText("Grupo:");

        jcbxGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DVD", "VHS", "Blu-ray" }));
        jcbxGrupo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcbxGrupo.setName(""); // NOI18N

        jLabel4.setText("Censura:");

        jLabel5.setText("Genero:");

        jcbxGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Animação", "Ação", "Comédia", "" }));

        jcbxCensura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Livre", "Adulto", "Senior" }));

        jLabel6.setText("Titulo:");

        jLabel7.setText("Autor:");

        jLabel8.setText("Diretor:");

        jLabel9.setText("Categoria:");

        jcbxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Catalogo", "Lançamento" }));

        jLabel10.setText("Lançamento:");

        try {
            jftDataLancamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jcbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jcbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jcbxCensura, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jcbxAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel8)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcbxDiretor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jftDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jcbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbxCensura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcbxAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jcbxDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jcbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jftDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcbxGrupo.getAccessibleContext().setAccessibleName("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sinopse"));

        jtxtSinopse.setColumns(20);
        jtxtSinopse.setRows(5);
        jScrollPane2.setViewportView(jtxtSinopse);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel11.setText("Valor de compra:");

        jLabel12.setText("Valor de locação:");

        jftValor_compra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jftValor_locacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jbtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Icons/save-26.png"))); // NOI18N
        jbtnSave.setText("Save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        jLabel13.setText("Qtd:");

        jsQuantidade.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jcbSituacao.setText("Ativo");

        javax.swing.GroupLayout jpCadastroMidiasLayout = new javax.swing.GroupLayout(jpCadastroMidias);
        jpCadastroMidias.setLayout(jpCadastroMidiasLayout);
        jpCadastroMidiasLayout.setHorizontalGroup(
            jpCadastroMidiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroMidiasLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpCadastroMidiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpCadastroMidiasLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpCadastroMidiasLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpCadastroMidiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpCadastroMidiasLayout.createSequentialGroup()
                                .addGroup(jpCadastroMidiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpCadastroMidiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jftValor_compra)
                                    .addComponent(jftValor_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jcbSituacao))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jsQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnSave)))
                .addContainerGap())
        );
        jpCadastroMidiasLayout.setVerticalGroup(
            jpCadastroMidiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroMidiasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpCadastroMidiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastroMidiasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpCadastroMidiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jftValor_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jsQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpCadastroMidiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jftValor_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbSituacao)
                        .addGap(269, 269, 269))
                    .addGroup(jpCadastroMidiasLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jbtnSave)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTPanel.addTab("Cadastro de Mídia", jpCadastroMidias);

        jbtnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Icons/exit-26.png"))); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Cadastro de Mídia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTPanel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbtnExit))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jLabel14)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jTPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        media.setFornecedor(fornecedores.get(jcbxFornecedor.getSelectedIndex()));
        media.setGrupo(jcbxGrupo.getSelectedIndex()+1);
        media.setGenero(jcbxGenero.getSelectedIndex()+1);
        media.setCensura(jcbxCensura.getSelectedIndex()+1);
        media.setTitulo(jtxtTitulo.getText());
        media.setAutor(autores.get(jcbxAutor.getSelectedIndex()));
        media.setDiretor(diretores.get(jcbxDiretor.getSelectedIndex()));
        media.setCategoria(jcbxCategoria.getSelectedIndex()+1);
        media.setDataLancamento(jftDataLancamento.getText());
        media.setSinopse(jtxtSinopse.getText());
        media.setValorCusto(Double.valueOf(jftValor_compra.getText()));
        media.setValorLocacao(Double.valueOf(jftValor_locacao.getText()));
        media.setQuantidade(Integer.valueOf(jsQuantidade.getValue().toString()));
        media.setSituacao(jcbSituacao.isSelected() == true ? 1: 2);
        dao.save(media);
        clear();
        loadTable();
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
         int id = (Integer)model.getValueAt(jtbMidia.getSelectedRow(), 0);
         selected_index = jtbMidia.getSelectedRow();
        
        if (selected_index != -1) {
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o autor?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                list.remove(selected_index);

                try {
                    media = new MidiaBean();
                    media.setId(id);
                    dao.delete(media);
                    loadTable();
                    clear();
                    
                    JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir este registro!");
                }
            }
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed
        
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        clear();
        jtxtId.setEditable(false);
        jTPanel.setEnabledAt(1, false);
        jTPanel.setSelectedComponent(jpListagemMidias);
        
        fornecedores = FornecedorDao.all();
        for (FornecedorBean fornecedor : fornecedores) {
            jcbxFornecedor.addItem(fornecedor.getId() + " - " + fornecedor.getRazaoSocial());
        }
        
        DiretorDao diretorDao = new DiretorDao();
        diretores = diretorDao.all();
        for (DiretorBean diretor : diretores) {
            jcbxDiretor.addItem(diretor.getId() + " - " + diretor.getNome());
        }
        AutorDao autorDao = new AutorDao();
        autores = autorDao.all();
        for (AutorBean autor: autores) {
            jcbxAutor.addItem(autor.getId() + " - "+ autor.getNome());
        }
        loadTable();
    }//GEN-LAST:event_formWindowOpened

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(null, "Deseja sair",null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void jbtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditActionPerformed
        int selected_index = jtbMidia.getSelectedRow();
        jcbSituacao.setVisible(true);
        jcbSituacao.setEnabled(true);
        if (selected_index != -1) {
            media = list.get(selected_index);
            jtxtId.setText(String.valueOf(media.getId()));
            jcbxFornecedor.setSelectedItem(media.getFornecedor());
            jcbxGrupo.setSelectedItem(media.getGrupo());
            jcbxGenero.setSelectedItem(media.getGenero());
            jcbxCensura.setSelectedItem(media.getCensura());
            jtxtTitulo.setText(media.getTitulo());
            jcbxAutor.setSelectedItem(media.getAutor());
            jcbxDiretor.setSelectedItem(media.getDiretor());
            jcbxCategoria.setSelectedItem(media.getCategoria());
            jftDataLancamento.setText(String.valueOf(media.getDataLancamento()));
            jtxtSinopse.setText(media.getSinopse());
            jftValor_compra.setText(String.valueOf(media.getValorCusto()));
            jftValor_locacao.setText(String.valueOf(media.getValorLocacao()));
            jsQuantidade.setValue(media.getQuantidade());
            jcbSituacao.setSelected(media.getSituacao() == 1);
            jTPanel.setEnabledAt(1, true);
            jTPanel.setSelectedComponent(jpCadastroMidias);
            jbtnSave.setEnabled(true);

        }else
         JOptionPane.showMessageDialog(null, "Selecione um cliente"); 
    }//GEN-LAST:event_jbtnEditActionPerformed

    private void jbtnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewActionPerformed
        jtxtId.setEditable(false);
        jTPanel.setEnabledAt(1, true);
        jTPanel.setSelectedComponent(jpCadastroMidias);
        jcbSituacao.setEnabled(false);
        jbtnSave.setEnabled(true);      
    }//GEN-LAST:event_jbtnNewActionPerformed

    private void clear(){
        jcbSituacao.setVisible(false);
        jtxtId.setEditable(false);
        jtxtId.setText(null);
        jtxtTitulo.setText(null);
        jftDataLancamento.setText(null);
        jftValor_compra.setText(null);
        jftValor_locacao.setText(null);
        jtxtSinopse.setText(null);
        jsQuantidade.setValue(0);
        media = new MidiaBean();
        jTPanel.setEnabledAt(0, true);
        jTPanel.setEnabledAt(1, false);
        jTPanel.setSelectedComponent(jpListagemMidias);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTPanel;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnEdit;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnNew;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JCheckBox jcbSituacao;
    private javax.swing.JComboBox jcbxAutor;
    private javax.swing.JComboBox jcbxCategoria;
    private javax.swing.JComboBox jcbxCensura;
    private javax.swing.JComboBox jcbxDiretor;
    private javax.swing.JComboBox jcbxFornecedor;
    private javax.swing.JComboBox jcbxGenero;
    private javax.swing.JComboBox jcbxGrupo;
    private javax.swing.JFormattedTextField jftDataLancamento;
    private javax.swing.JFormattedTextField jftValor_compra;
    private javax.swing.JFormattedTextField jftValor_locacao;
    private javax.swing.JPanel jpCadastroMidias;
    private javax.swing.JPanel jpListagemMidias;
    private javax.swing.JSpinner jsQuantidade;
    private javax.swing.JTable jtbMidia;
    private javax.swing.JTextField jtxtId;
    private javax.swing.JTextArea jtxtSinopse;
    private javax.swing.JTextField jtxtTitulo;
    // End of variables declaration//GEN-END:variables


    public void loadTable(){
        Object titulo[] = {"Código", "Título", "Valor Compra", "Valor Locação", "Quantidade"};
        Object grade[][] = null;
        model = new DefaultTableModel(grade, titulo);
        jtbMidia.setModel(model);
        this.list = dao.all();
        for(MidiaBean _midia: list){
            Object campo[] = {
                _midia.getId(), 
                _midia.getTitulo(),
                _midia.getValorCusto(), 
                _midia.getValorLocacao(), 
                _midia.getQuantidade()};
            model.addRow(campo);
        }
    }
}
