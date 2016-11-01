package com.damage.frames;

import com.damage.Response.Response;
import com.damage.grafos.Grafo;
import com.damage.grafos.armazenamento.DefinicaoFormal;
import com.damage.grafos.armazenamento.Definicoes;
import com.damage.grafos.armazenamento.ListaDeAdjacencia;
import com.damage.grafos.armazenamento.MatrizIncidencia;
import com.damage.modeloTabelaGrafos.ModeloTabelaGrafos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class FramePrincipal extends JFrame {

    /**Declaração das variaveis personalizadas*/
    //Tabela de grafos
    ModeloTabelaGrafos grafos;
    
    
    
    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        grafos = new ModeloTabelaGrafos();
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        labelMatrizIncidência = new javax.swing.JLabel();
        labelMatrizAdjacência = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoMatrizIncidencia = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoMatrizAdjacencia = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        textoListadeAdjacencia = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        botaoMenuCriarGrafo = new javax.swing.JButton();
        botaoMenuModificarGrafo = new javax.swing.JButton();
        botaoMenuExcluirGrafo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaGrafos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        labelSimples = new javax.swing.JLabel();
        labelCompleto = new javax.swing.JLabel();
        labelConexo = new javax.swing.JLabel();
        labelPlanar = new javax.swing.JLabel();
        labelInformacaoSimples = new javax.swing.JLabel();
        labelInformacaoCompleto = new javax.swing.JLabel();
        labelInformacaoConexo = new javax.swing.JLabel();
        labelInformacaoPlanar = new javax.swing.JLabel();
        labelNomeGrafo = new javax.swing.JLabel();
        textoNomeGrafo = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        textoDefinicaoFormal = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        labelDefinicaoFormal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuGrafosNovo = new javax.swing.JMenu();
        menuNovo = new javax.swing.JMenuItem();
        menuAbrirGrafos = new javax.swing.JMenuItem();
        menuIGrafosSalvar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuGrafoDesenhar = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Forker");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(50, 50));
        setName("framePrincipal"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

        labelMatrizIncidência.setText("Matriz Incidência");

        labelMatrizAdjacência.setText("Matriz Adjacência");

        textoMatrizIncidencia.setEditable(false);
        textoMatrizIncidencia.setColumns(20);
        textoMatrizIncidencia.setRows(5);
        jScrollPane2.setViewportView(textoMatrizIncidencia);

        textoMatrizAdjacencia.setColumns(20);
        textoMatrizAdjacencia.setRows(5);
        jScrollPane3.setViewportView(textoMatrizAdjacencia);

        textoListadeAdjacencia.setColumns(20);
        textoListadeAdjacencia.setRows(5);
        jScrollPane4.setViewportView(textoListadeAdjacencia);

        jLabel1.setText("Lista de Adjacencia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMatrizIncidência)
                            .addComponent(jLabel1)
                            .addComponent(labelMatrizAdjacência))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMatrizIncidência)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMatrizAdjacência)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        botaoMenuCriarGrafo.setText("Criar Grafo");
        botaoMenuCriarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMenuCriarGrafoActionPerformed(evt);
            }
        });

        botaoMenuModificarGrafo.setText("Modificar Grafo");
        botaoMenuModificarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMenuModificarGrafoActionPerformed(evt);
            }
        });

        botaoMenuExcluirGrafo.setText("Excluir Grafo");
        botaoMenuExcluirGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMenuExcluirGrafoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoMenuCriarGrafo)
                    .addComponent(botaoMenuModificarGrafo)
                    .addComponent(botaoMenuExcluirGrafo))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoMenuCriarGrafo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoMenuModificarGrafo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoMenuExcluirGrafo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Grafos"));

        TabelaGrafos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Nós", "Arestas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TabelaGrafos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TabelaGrafos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TabelaGrafos.setMinimumSize(new java.awt.Dimension(45, 0));
        this.TabelaGrafos.setModel(this.grafos);
        this.TabelaGrafos.getColumnModel().getColumn(0).setHeaderValue("Nome");
        this.TabelaGrafos.getColumnModel().getColumn(1).setHeaderValue("Nós");
        this.TabelaGrafos.getColumnModel().getColumn(2).setHeaderValue("Arestas");
        TabelaGrafos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaGrafosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaGrafos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Grafo"));

        labelSimples.setText("Simples:");

        labelCompleto.setText("Completo:");

        labelConexo.setText("Conexo:");

        labelPlanar.setText("Planar:");

        labelInformacaoSimples.setText("Não");

        labelInformacaoCompleto.setText("Não");

        labelInformacaoConexo.setText("Não");

        labelInformacaoPlanar.setText("Não");

        labelNomeGrafo.setText("Nome:");

        textoDefinicaoFormal.setColumns(20);
        textoDefinicaoFormal.setRows(5);
        jScrollPane5.setViewportView(textoDefinicaoFormal);

        labelDefinicaoFormal.setText("Definição Formal");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(labelNomeGrafo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoNomeGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(labelSimples)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelInformacaoSimples))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(labelConexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelInformacaoConexo))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(labelCompleto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelInformacaoCompleto))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(labelPlanar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelInformacaoPlanar))
                            .addComponent(labelDefinicaoFormal))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNomeGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoNomeGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSimples)
                    .addComponent(labelInformacaoSimples))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCompleto)
                    .addComponent(labelInformacaoCompleto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelConexo)
                    .addComponent(labelInformacaoConexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPlanar)
                    .addComponent(labelInformacaoPlanar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(labelDefinicaoFormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuGrafosNovo.setText("Arquivo");

        menuNovo.setText("Novo");
        menuNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoActionPerformed(evt);
            }
        });
        menuGrafosNovo.add(menuNovo);

        menuAbrirGrafos.setText("Abrir");
        menuAbrirGrafos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirGrafosActionPerformed(evt);
            }
        });
        menuGrafosNovo.add(menuAbrirGrafos);

        menuIGrafosSalvar.setText("Salvar");
        menuIGrafosSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIGrafosSalvarActionPerformed(evt);
            }
        });
        menuGrafosNovo.add(menuIGrafosSalvar);

        jMenuBar1.add(menuGrafosNovo);

        jMenu2.setText("Grafico");

        menuGrafoDesenhar.setText("Desenhar");

        menuGrafoDesenhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGrafoDesenharActionPerformed(evt);
            }
        });
        
        jMenu2.add(menuGrafoDesenhar);

        jMenuBar1.add(jMenu2);

        menuAjuda.setText("Ajuda");

        menuSobre.setText("Sobre");
        menuAjuda.add(menuSobre);

        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1063, 794));
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaGrafosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaGrafosMouseClicked
      Definicoes definicoes = new Definicoes();
      Grafo grafo = this.grafos.getGrafos().get(this.TabelaGrafos.getSelectedRow());
      this.textoMatrizIncidencia.setText(grafo.getMatrizIncidenciaString());

       this.textoMatrizAdjacencia.setText(grafo.getMatrizAdjacenciaString());

      this.textoListadeAdjacencia.setText(grafo.getListaAdjacencia());
      this.labelInformacaoCompleto.setText(grafo.getCompleto());
      this.labelInformacaoSimples.setText(grafo.getSimples());
      this.labelInformacaoConexo.setText(grafo.getConexo());
      this.labelInformacaoPlanar.setText(grafo.getPlanar());
      this.textoDefinicaoFormal.setText(grafo.getDefinicaoFormal());
      this.textoNomeGrafo.setText(grafo.getNome());
    }//GEN-LAST:event_TabelaGrafosMouseClicked

    private void botaoMenuCriarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMenuCriarGrafoActionPerformed
        FrameCriarGrafo.abrir(grafos);
    }//GEN-LAST:event_botaoMenuCriarGrafoActionPerformed

    private void botaoMenuExcluirGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMenuExcluirGrafoActionPerformed
        if(this.TabelaGrafos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(labelCompleto, "Selecione um grafo para realizar a Exclusão");
            return;
        }
        this.grafos.getGrafos().remove(this.TabelaGrafos.getSelectedRow());
        this.grafos.fireTableDataChanged();
        this.resetarInformacoes();
    }//GEN-LAST:event_botaoMenuExcluirGrafoActionPerformed

    private void menuAbrirGrafosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirGrafosActionPerformed
        /*Vetor de grafos e grafo temporario*/
        Vector<Grafo> vetorGrafos = new Vector<Grafo>();
        Grafo grafo;
        /*--*/
        int contLine = 0;
        JFileChooser arquivo = new JFileChooser();
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        arquivo.showOpenDialog(jPanel1);
        Response resposta;
        try {
            FileReader arq = new FileReader(arquivo.getSelectedFile().getPath());
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); 
            while (linha != null) {
              grafo = new Grafo();
              resposta = DefinicaoFormal.build(linha.substring(0 , linha.indexOf("|")), grafo);
              if(resposta.getCode() == 400){
                 JOptionPane.showMessageDialog(null, resposta.getMessage() + "\nLinha do erro: " + contLine, "Erro ao ler definição formal", 1);
                 return;
              }
              grafo.update();
              if(linha.substring(linha.indexOf("|") + 1).replace("|", "").length() < 4){
                 JOptionPane.showMessageDialog(null, "Problema com grafo na linha: " + contLine + "\nO nome do grafo deve ter no minimo 4 caracteres", "Erro ao ler definição formal", 1); 
              }
              grafo.setNome(linha.substring(linha.indexOf("|") + 1).replace("|", ""));
              vetorGrafos.add(grafo);
              linha = lerArq.readLine();
              contLine++;
            }
            resetarInformacoes();
            grafos.setGrafos(vetorGrafos);
            grafos.fireTableDataChanged();
            arq.close();
          } catch (IOException e) {
              System.err.printf("Erro na abertura do arquivo: %s.\n",
                e.getMessage());
          }
        
    }//GEN-LAST:event_menuAbrirGrafosActionPerformed

    private void menuIGrafosSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIGrafosSalvarActionPerformed
        JFileChooser arquivo = new JFileChooser();
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        arquivo.showSaveDialog(jPanel1);
        FileWriter arq = null;
        try {
            arq = new FileWriter(arquivo.getSelectedFile().getPath() + ".txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            for(Grafo grafo : grafos.getGrafos()){
                gravarArq.print(grafo.getDefinicaoFormal());
                gravarArq.print("|" + grafo.getNome());
                gravarArq.println("|");
            }
            arq.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(labelCompleto, "Erro ao salvar o arquivo", "Erro", 0);
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_menuIGrafosSalvarActionPerformed

    private void menuNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoActionPerformed
        int escolha = JOptionPane.showConfirmDialog(labelCompleto, "Deseja criar uma nova lista de grafos?", "Novos Grafos", 1);
        if(escolha == 0){
            grafos.setGrafos(new Vector<Grafo>());
            grafos.fireTableDataChanged();
        }
        this.resetarInformacoes();
    }//GEN-LAST:event_menuNovoActionPerformed

    private void botaoMenuModificarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMenuModificarGrafoActionPerformed
        if(this.TabelaGrafos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(labelCompleto, "Selecione um grafo para Editar");
            return;
        }
        FrameEditarGrafo.abrir(grafos.getGrafos().get(this.TabelaGrafos.getSelectedRow()), grafos);
    }//GEN-LAST:event_botaoMenuModificarGrafoActionPerformed


    private void menuGrafoDesenharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGrafoDesenharActionPerformed
    
        new DesenhaGrafos().setVisible(true);
        
    }//GEN-LAST:event_menuGrafoDesenharActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());    
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }
    
    public void resetarInformacoes(){
        this.textoMatrizAdjacencia.setText("");
        this.textoMatrizIncidencia.setText("");
        this.labelInformacaoCompleto.setText("Não");
        this.labelInformacaoConexo.setText("Não");
        this.labelInformacaoSimples.setText("Não");
        this.labelInformacaoPlanar.setText("Não");
        this.textoListadeAdjacencia.setText("");
        this.textoDefinicaoFormal.setText("");
        this.textoNomeGrafo.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaGrafos;
    private javax.swing.JButton botaoMenuCriarGrafo;
    private javax.swing.JButton botaoMenuExcluirGrafo;
    private javax.swing.JButton botaoMenuModificarGrafo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCompleto;
    private javax.swing.JLabel labelConexo;
    private javax.swing.JLabel labelDefinicaoFormal;
    private javax.swing.JLabel labelInformacaoCompleto;
    private javax.swing.JLabel labelInformacaoConexo;
    private javax.swing.JLabel labelInformacaoPlanar;
    private javax.swing.JLabel labelInformacaoSimples;
    private javax.swing.JLabel labelMatrizAdjacência;
    private javax.swing.JLabel labelMatrizIncidência;
    private javax.swing.JLabel labelNomeGrafo;
    private javax.swing.JLabel labelPlanar;
    private javax.swing.JLabel labelSimples;
    private javax.swing.JMenuItem menuAbrirGrafos;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenuItem menuGrafoDesenhar;
    private javax.swing.JMenu menuGrafosNovo;
    private javax.swing.JMenuItem menuIGrafosSalvar;
    private javax.swing.JMenuItem menuNovo;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JTextArea textoDefinicaoFormal;
    private javax.swing.JTextArea textoListadeAdjacencia;
    private javax.swing.JTextArea textoMatrizAdjacencia;
    private javax.swing.JTextArea textoMatrizIncidencia;
    private javax.swing.JLabel textoNomeGrafo;
    // End of variables declaration//GEN-END:variables
}
