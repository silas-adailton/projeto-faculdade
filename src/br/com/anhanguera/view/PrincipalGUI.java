/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Silas
 */
public class PrincipalGUI extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalGUI
     */
    public PrincipalGUI() {
        initComponents();
        //jLabel1.setText(String.valueOf(LocalDate.now()));
    }
    private static PrincipalGUI p;
    public static PrincipalGUI getInstancia() {
        if (p == null) {
            p = new PrincipalGUI();
        }
        return p;
    }

    public static JDesktopPane getPainel() {
        return getInstancia().painelPrincipal;
    }
    public void addTelaDesk(JInternalFrame tela) {
        for (JInternalFrame jInternalFrame : this.painelPrincipal.getAllFrames()) {
            // se uma janela semelhante estiver aberta  
            if (jInternalFrame.getClass().toString().equalsIgnoreCase(tela.getClass().toString())) {
                jInternalFrame.moveToFront(); // traz janela para frente para facilitar a escolha  

                Object[] opções = {"Utilizar Aberta", "Abrir Nova"};
                int qst = JOptionPane.showOptionDialog(null, "Abrir uma nova janela ou utilizar a que ja esta aberta?",
                        "Janela duplicada",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opções,
                        opções[0]);
                // se utilizar a aberta retorna e não abre outra,  
                // caso contrário sai do for e abre outra igual  
                if (qst == 0) {
                    return;
                } else if (qst == 1) {
                    break;
                }
            }
        }

        this.painelPrincipal.add(tela); //adiciona na tela  
        tela.setVisible(true); // seta visivel  
        this.cascade(); //coloca em cascata para deixar "pratico"  
    }

    private void cascade() {
        JDesktopPane desk = this.painelPrincipal; // JDesktopPane  
        Rectangle dBounds = desk.getBounds(); // Bordas do JDesktopPane  
        int separation = 25; // distancia entre as janelas  

        // Pega todos os frames e organiza, o ultimo fica mais em baido e mais pra cima  
        int i = desk.getAllFrames().length; // quantidade de frames  
        for (JInternalFrame f : desk.getAllFrames()) {
            f.setLocation(i * separation, i * separation);
            i--; //mutiplicador  
        }
    }
    
    public void setCentro(JInternalFrame j) {
        Dimension d = getContentPane().getSize();
        j.setLocation((d.width - j.getSize().width) / 2, (d.height - j.getSize().height) / 2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuPrincipal = new javax.swing.JMenu();
        jMenuItemCadastrar = new javax.swing.JMenuItem();
        jMenuItemPesquisarExcluir = new javax.swing.JMenuItem();
        jMenuItemAlterar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemCadastrarAluno = new javax.swing.JMenuItem();
        jMenuItemPesquisarExcluirAluno = new javax.swing.JMenuItem();
        jMenuItemExcluir = new javax.swing.JMenuItem();
        jMenuAtividade = new javax.swing.JMenu();
        jMenuItemCadastrarAtiv = new javax.swing.JMenuItem();
        jMenuItemPesquisarAtividade = new javax.swing.JMenuItem();
        jMenuItemAlterarAtividade = new javax.swing.JMenuItem();
        jMenuUsuario = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Power XY Gyn");

        painelPrincipal.setBackground(java.awt.Color.lightGray);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addContainerGap(574, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addContainerGap(530, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelPrincipal.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setInheritsPopupMenu(true);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(272, 35));

        jMenuPrincipal.setText("FUNCIONARIO");
        jMenuPrincipal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jMenuItemCadastrar.setText("Cadastrar");
        jMenuItemCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarActionPerformed(evt);
            }
        });
        jMenuPrincipal.add(jMenuItemCadastrar);

        jMenuItemPesquisarExcluir.setText("Pesquisar/Excluir");
        jMenuItemPesquisarExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisarExcluirActionPerformed(evt);
            }
        });
        jMenuPrincipal.add(jMenuItemPesquisarExcluir);

        jMenuItemAlterar.setText("Alterar");
        jMenuPrincipal.add(jMenuItemAlterar);

        jMenuBar1.add(jMenuPrincipal);

        jMenu2.setText("ALUNO");
        jMenu2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jMenuItemCadastrarAluno.setText("Cadastrar");
        jMenuItemCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarAlunoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCadastrarAluno);

        jMenuItemPesquisarExcluirAluno.setText("Pesquisar/Excluir");
        jMenuItemPesquisarExcluirAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisarExcluirAlunoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPesquisarExcluirAluno);

        jMenuItemExcluir.setText("Alterar");
        jMenu2.add(jMenuItemExcluir);

        jMenuBar1.add(jMenu2);

        jMenuAtividade.setText("ATIVIDADE");
        jMenuAtividade.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jMenuItemCadastrarAtiv.setText("Cadastrar");
        jMenuItemCadastrarAtiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarAtivActionPerformed(evt);
            }
        });
        jMenuAtividade.add(jMenuItemCadastrarAtiv);

        jMenuItemPesquisarAtividade.setText("Pesquisar/Excluir");
        jMenuItemPesquisarAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisarAtividadeActionPerformed(evt);
            }
        });
        jMenuAtividade.add(jMenuItemPesquisarAtividade);

        jMenuItemAlterarAtividade.setText("Alterar");
        jMenuAtividade.add(jMenuItemAlterarAtividade);

        jMenuBar1.add(jMenuAtividade);

        jMenuUsuario.setText("USUARIO");
        jMenuUsuario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jMenuItem1.setText("Cadastrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuItem1);

        jMenuBar1.add(jMenuUsuario);

        jMenu1.setText("SAIR");
        jMenu1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarActionPerformed
        CadFunc cFunc = new CadFunc();
        
       // PainelPrincipal.add(cFunc);
        //getContentPane().add(cFunc);
        addTelaDesk(cFunc);
        setCentro(cFunc);
        cFunc.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         UsuarioGUI usuario = new UsuarioGUI();
         addTelaDesk(usuario);
         setCentro(usuario);
         usuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemCadastrarAtivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarAtivActionPerformed
        CadAtividadesGUI ativGui = new CadAtividadesGUI();
        addTelaDesk(ativGui);
        setCentro(ativGui);
        ativGui.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarAtivActionPerformed

    private void jMenuItemPesquisarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisarAtividadeActionPerformed
        ConsultarAgenda conAgenda = new ConsultarAgenda();
        addTelaDesk(conAgenda);
        setCentro(conAgenda);
        conAgenda.setVisible(true);
    }//GEN-LAST:event_jMenuItemPesquisarAtividadeActionPerformed

    private void jMenuItemCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarAlunoActionPerformed
        CadAluno cadAluno = new CadAluno();
        addTelaDesk(cadAluno);
        setCentro(cadAluno);
        cadAluno.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarAlunoActionPerformed

    private void jMenuItemPesquisarExcluirAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisarExcluirAlunoActionPerformed
         PesAluno pesAluno = new PesAluno();
         addTelaDesk(pesAluno);
         setCentro(pesAluno);
         pesAluno.setVisible(true);
    }//GEN-LAST:event_jMenuItemPesquisarExcluirAlunoActionPerformed

    private void jMenuItemPesquisarExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisarExcluirActionPerformed
        PesFuncionarios pesFunc = new PesFuncionarios();
        addTelaDesk(pesFunc);
        setCentro(pesFunc);
        pesFunc.setVisible(true);
    }//GEN-LAST:event_jMenuItemPesquisarExcluirActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        System.exit(0);
        AgendaAlunos agenda = new AgendaAlunos();
        agenda.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenuAtividade;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemAlterar;
    private javax.swing.JMenuItem jMenuItemAlterarAtividade;
    private javax.swing.JMenuItem jMenuItemCadastrar;
    private javax.swing.JMenuItem jMenuItemCadastrarAluno;
    private javax.swing.JMenuItem jMenuItemCadastrarAtiv;
    private javax.swing.JMenuItem jMenuItemExcluir;
    private javax.swing.JMenuItem jMenuItemPesquisarAtividade;
    private javax.swing.JMenuItem jMenuItemPesquisarExcluir;
    private javax.swing.JMenuItem jMenuItemPesquisarExcluirAluno;
    private javax.swing.JMenu jMenuPrincipal;
    private javax.swing.JMenu jMenuUsuario;
    private javax.swing.JDesktopPane painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
