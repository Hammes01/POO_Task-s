import javax.swing.*;
import java.awt.*;


public class AppUI extends JFrame {


    private JPanel listaPanel;

    private ObterTarefasServico servico;

    private JCheckBox checkPanel;

    JLabel caixaEntrada;

    JButton botao;

    private  GroupLayout JanelaLayout;

    public AppUI(){
        setTitle("Tarefas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,500);
        setResizable(false);
        servico = new ObterTarefasServico();
        configurarJanela();
        setVisible(true);


    }



    private void configurarJanela() {

        listaPanel = new JPanel();
        listaPanel.setLayout(new BoxLayout(listaPanel,BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(listaPanel);

      // Texto
        caixaEntrada = new JLabel("Caixa de entrada");
        caixaEntrada.setPreferredSize(new Dimension(30,30));
        caixaEntrada.setMinimumSize(new Dimension(30,30));
        caixaEntrada.setLocation(5, 9);
        listaPanel.add(caixaEntrada);

        // BOTÃO
        botao = new JButton("Nova Tarefa");
        //botao.addActionListener(te);
        botao.setActionCommand("NOVA TAREFA");
        botao.setPreferredSize(new Dimension(30,30));
        botao.setMinimumSize(new Dimension(30,30));
        listaPanel.add(botao);

        listaPanel.add(Box.createVerticalStrut(20));
        checkPanel = new JCheckBox();
        popularLista();
        add(scrollPane);

        listaPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,1));

        GroupLayout JanelaLayout = new GroupLayout(listaPanel);
        JanelaLayout.setAutoCreateGaps(true);
        JanelaLayout.setAutoCreateContainerGaps(true);
        listaPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Tarefas"),
                                BorderFactory.createEmptyBorder(10,10,10,10)),
                listaPanel.getBorder()));




    }



    private void popularLista(){
        for(String s : servico.obterTodos()){
            listaPanel.add(criarItemDaLista(s));

        }
    }



    private JPanel criarItemDaLista(String item){
        JPanel panel = new JPanel();
        JCheckBox box = new JCheckBox();
        JLabel label = new JLabel(item);
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(box);
        panel.add(label);
        return panel;
    }

}
