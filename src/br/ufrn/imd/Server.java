package br.ufrn.imd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Font;

public class Server extends JFrame {

	private JPanel contentPane;
	private JTextField txfIp;
	private JTextField txfPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Responsavel por criar o frame e manter todas as funcoes de interface.
	 */
	public Server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txfIp = new JTextField();
		txfIp.setEditable(false);
		txfIp.setColumns(10);
		
		JLabel lblIp = new JLabel("IP");
		
		txfPort = new JTextField();
		txfPort.setEditable(false);
		txfPort.setColumns(10);
		
		JLabel lblPort = new JLabel("Port");
		
		/*
		 * TextArea para mostrar o log da aplicacao
		 */
		JTextArea txtrLog = new JTextArea();
		txtrLog.setRows(12);
		txtrLog.setEditable(false);
		txtrLog.setFont(new Font("Courier New", Font.PLAIN, 13));
		txtrLog.setForeground(Color.GREEN);
		txtrLog.setBackground(Color.BLACK);
		
		/*
		 * Label que ira mostrar o status do servidor
		 */
		JLabel lblStatus = new JLabel("OFF");
		lblStatus.setForeground(Color.RED);
		
		/*
		 * Botao responsavel por iniciar o servidor 
		 */
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				printLog("SERVER STARTED : ", txtrLog, true);
				lblStatus.setText("ON");
				lblStatus.setForeground(Color.GREEN);
			}
		});
		
		/*
		 * Botao responsavel por parar o servidor 
		 */
		JButton btnStop = new JButton("Stop");
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				printLog("SERVER STOPED : ", txtrLog, false);
				lblStatus.setText("OFF");
				lblStatus.setForeground(Color.RED);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtrLog, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(txfIp, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblIp)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPort)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txfPort, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblStatus)
									.addGap(10)
									.addComponent(btnStart)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					.addGap(174))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIp)
						.addComponent(lblPort))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txfIp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txfPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStatus)
						.addComponent(btnStart)
						.addComponent(btnStop))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtrLog, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/*
	 * Responsavel por imprimir uma mensagem de log
	 * @param msg 		Mensagem a ser impressa
	 * @param txtrlog 	O objeto em que a mensagem deve ser impressa
	 * @param reset 	Flag para informar se o conteúdo da área de log deve ser resetado
	 */
	public void printLog(String msg, JTextArea txtrLog, boolean reset) {
		if (reset) {
			Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			txtrLog.setText(msg + sdf.format(cal.getTime()));
		} else {
			Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			txtrLog.setText(txtrLog.getText() + "\n" + msg + sdf.format(cal.getTime()));
		}	
	}

}
