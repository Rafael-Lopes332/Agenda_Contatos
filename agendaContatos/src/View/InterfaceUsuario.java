package View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class InterfaceUsuario {

    public InterfaceUsuario(){
        configurarInterface();
    }

    private void configurarInterface(){
        JFrame janela = new JFrame("Agenda de Contatos");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        janela.setSize(700, 500);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setLayout(null);

        JLabel lbNome = new JLabel("Nome");
        lbNome.setBounds(40, 15, 100, 30);
        janela.add(lbNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(40,50,270,25);
        janela.add(txtNome);

        JLabel lbTelefone = new JLabel("Telefone");
        lbTelefone.setBounds(430, 15, 100, 30);
        janela.add(lbTelefone);

        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(430, 50, 210, 25);
        janela.add(txtTelefone);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setBounds(40, 80, 100, 30);
        janela.add(lbEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(40,110,270,25);
        janela.add(txtEmail);

        JTextArea area = new JTextArea();
        
        area.setBounds(40, 170, 600, 200);
        area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        area.setEditable(false);

        area.append("Rafael \n");
        area.append("Teste \n");
        janela.add(area);

        JButton btAdicionar = new JButton("Adicionar");
        btAdicionar.setBounds(40, 400, 100, 30);
        janela.add(btAdicionar);

        btAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Botão clicado!");
            }
        });

        JButton btBuscar = new JButton("Buscar");
        btBuscar.setBounds(190, 400, 100, 30);
        janela.add(btBuscar);

        JButton btEditar = new JButton("Editar");
        btEditar.setBounds(390, 400, 100, 30);
        janela.add(btEditar);

        JButton btExcluir = new JButton("Excluir");
        btExcluir.setBounds(540, 400, 100, 30);
        janela.add(btExcluir);
        
        janela.setVisible(true);
    }

}
