/*
 * Copyright (c) 2020 魏遇卿 All Rights Reserved.
 * FileName: asdf.java
 * @author: 魏遇卿@date: 2020/6/11 下午4:50@version: 1.0
 * E-mail:358614401@qq.com
 * Code with UTF-8
 */

package autoScore;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class userIn extends JFrame implements ActionListener {
    //设置组件
    private JButton
            //创建窗体
            login /*= new JButton("login")*/;
    private JTextField
            //创建组件
            admin = new JTextField(),
            password = new JTextField();
    private JPanel contentPanel = new JPanel();

    public userIn() {
        super("Auto score to exam");
        /* this.setBounds(100,100,100,100);*/
        //获取主容器并设置为网格组布局
        // contentPanel = this.getContentPane();
        contentPanel.setLayout(null);
        this.setVisible(true);
        this.setSize(500, 350);//设置窗口大小
        this.setResizable(false);//设置窗口固定大小
        this.setLocationRelativeTo(null);//设置窗口居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作

        admin.setText("学号");
        password.setText("password");

        //添加组件
        contentPanel.setLayout(null);
        add(admin);
        add(password);
        //add(login);

        //组件位置
        admin.setBounds(95, 130, 300, 25);
        password.setBounds(95, 154, 300, 25);
        //login.setBounds(315, 225, 90, 20);
        //显示组件
        admin.setOpaque(false);
        password.setOpaque(false);
        // login.setOpaque(false);

        //设置监听（鼠标点击之后输入密码
        admin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = e.getButton();
                if (c == MouseEvent.BUTTON1 && admin.getText().equals("学号") && e.getClickCount() == 1) {
                    admin.setText(null);
                    /* password.setText("password");*/
                }
            }
        });
        admin.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {

            }
        });
        password.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = e.getButton();
                if (c == MouseEvent.BUTTON1 && password.getText().equals("password") && e.getClickCount() == 1) {
                    password.setText(null);
                    /* admin.setText("学号");*/
                }
            }
        });
        /*login.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseAdapter e) throws IOException {]
                int c=e.getButton();
                mainGUI a=new mainGUI();
            }
        });*/
        login = new JButton("login");
        login.addActionListener(this);
        this.add(login);
        login.setBounds(315, 225, 90, 20);
    }

    static String studentNumber = new String();
static String studentPassword="111";
static String studentNum=new String();
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("login")) {
            //login to do

            //password and in password to return
            if (password.getText().equals(studentPassword) == true) {
                String studentNumber = admin.getText();
                studentNum=studentNumber;
//            String studentName=
                System.out.println(studentNumber);
                try {
                    dispose();
                    mainGUI gui=new mainGUI();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }
        if (password.getText().equals(studentPassword) ==false) {
            System.out.println("your password false,try again");
        }
    }

    public static String getStudentNumber() {
        System.out.println(studentNum);
        return studentNum;

    }
}
