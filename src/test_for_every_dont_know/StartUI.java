package test_for_every_dont_know;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;

public class StartUI implements ActionListener {

    JButton jb1=new JButton("上传文件");
    JButton jb2=new JButton("显示图片");
    
    JButton sure=new JButton("sure");
    JButton exit=new JButton("exit");
    JButton next=new JButton("next");
    
    JButton sure1=new JButton("sure");
    JButton sure2=new JButton("sure");
    JButton sure3=new JButton("sure");
    JButton sure4=new JButton("sure");
    
    JButton gn1=new JButton("桥接词功能");
    JButton gn2=new JButton("生成文本功能");
    JButton gn3=new JButton("两点最短距离");
    JButton gn5=new JButton("随机游走功能");

    JTextField from=new JTextField();
    JTextField to =new JTextField();
    JTextArea bridge_word=new JTextArea();
    
    JTextArea User_input=new JTextArea();
    JTextArea word_output=new JTextArea();
    
    JTextArea ran_go=new JTextArea();
    JTextField start=new JTextField();
    
    JFrame myframe=new JFrame();
    JPanel mypanel=new JPanel();
    
    JTextField start2=new JTextField();
    JTextField end=new JTextField();
    JTextArea short1=new JTextArea();
    JTextArea short3=new JTextArea();
    
    JPanel pn1=new JPanel();
    linkList lnklst=new linkList();

    
    int height=768-80;
    int width=1366;
    int x;
    public StartUI()
    {
        
        myframe.setSize(1366,768);
        pn1.setVisible(false);
        myframe.setVisible(true);
        myframe.add(mypanel);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mypanel.setLayout(null);
        
        mypanel.add(jb1);
        jb1.addActionListener(this);
        jb1.setBounds(1366/2-100,height/8,200,50);
        
        jb2.addActionListener(this);
        mypanel.add(jb2);
        jb2.setBounds(1366/2-100,height*2/8,200,50);
        
        gn1.addActionListener(this);
        mypanel.add(gn1);
        gn1.setBounds(1366/2-100,height*3/8,200,50);
        
        gn2.addActionListener(this);
        mypanel.add(gn2);
        gn2.setBounds(1366/2-100,height*4/8,200,50);
        
        gn3.addActionListener(this);
        mypanel.add(gn3);
        gn3.setBounds(1366/2-100,height*5/8,200,50);
        
        gn5.addActionListener(this);
        mypanel.add(gn5);
        gn5.setBounds(1366/2-100,height*6/8,200,50);
        next.addActionListener(this);
        exit.addActionListener(this);
        sure.addActionListener(this);
        sure1.addActionListener(this);
        sure2.addActionListener(this);
        sure3.addActionListener(this);
        sure4.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==jb1)//上传文件创建链表
        {
            JFileChooser jfc=new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
            jfc.showDialog(new JLabel(), "选择");
            File file=jfc.getSelectedFile();
            if(file.isFile())
            {
                lnklst=StartTest.creatlnklst(CreatOptions.RetrnStringarrays(file.getAbsolutePath()));//功能要求1：创建链表
            }
        }
        else if(e.getSource()==jb2)
        {
            JFrame frm=new JFrame();
            JPanel pnl=new JPanel(new BorderLayout());
            frm.add(pnl);
            frm.setSize(1000,1000);
            JScrollPane sp = new JScrollPane(pnl);
            frm.getContentPane().add(sp);
            pnl.setBounds(0, 0, 500, 500);
            frm.setVisible(true);
            JLabel imag=new JLabel(new ImageIcon("E:\\ProgramLanguageOfAll\\myeclipse\\workplace\\SE-test-1\\out.jpg" ));
            imag.setBounds(0,0,pnl.getWidth(),pnl.getHeight());
            pnl.add(imag);
        }
        else if(e.getSource()==exit)
        {
            pn1.removeAll();
            pn1.setVisible(false);
            mypanel.setVisible(true);
        }
        else if(e.getSource()==gn1)
        {
            Label l1=new Label("查询桥接词功能");
            l1.setFont(new Font("Dialog",1,25));
            l1.setBounds(width/2-100,50,300,60);
            pn1.add(l1);
            pn1.setLayout(null);
            pn1.add(from);
            pn1.add(to);
            pn1.add(bridge_word);
            bridge_word.setLineWrap(true);
            pn1.add(sure);
            pn1.add(exit);
            from.setBounds(width/2-100,130,200,30);
            to.setBounds(width/2-100,180,200,30);
            bridge_word.setBounds(width/2-100,230,200,60);
            sure.setBounds(width/2-100,310,200,30);
            exit.setBounds(width/2-100,360,200,30);
            from.setText(null);
            to.setText(null);
            bridge_word.setText(null);
            mypanel.setVisible(false);
            pn1.setVisible(true);
            myframe.add(pn1);
        }
        else if(e.getSource()==sure)
        {
          String result=lnklst.searchBridgeWords(from.getText().toLowerCase(),to.getText().toLowerCase());
          bridge_word.setText(result);
        }
        else if(e.getSource()==gn2)
        {
            Label l2=new Label("生成文本功能");
            l2.setFont(new Font("Dialog",1,25));
            l2.setBounds(width/2-100,50,300,60);
            User_input.setBounds(width/2-100,130,200,100);
            word_output.setBounds(width/2-100,250,200,100);
            User_input.setLineWrap(true);
            word_output.setLineWrap(true);
            word_output.setEditable(false);
            pn1.add(l2);
            pn1.add(User_input);
            pn1.add(word_output);
            pn1.add(sure1);
            pn1.setLayout(null);
            pn1.add(exit);
            sure1.setBounds(width/2-100,370,200,30);
            exit.setBounds(width/2-100,420,200,30);
            User_input.setText(null);
            word_output.setText(null);
            mypanel.setVisible(false);
            pn1.setVisible(true);
            myframe.add(pn1);
        }
        else if(e.getSource()==sure1)
        {
          String result=lnklst.createNewTxtBasisOfBridgeWords(User_input.getText().toLowerCase());
            word_output.setText(result);
        }
        else if(e.getSource()==gn5)
        {
            Label l3=new Label("随机游走");
            l3.setFont(new Font("Dialog",1,25));
            l3.setBounds(width/2-100,50,300,60);
            start.setBounds(width/2-100,130,200,30);
            ran_go.setBounds(width/2-150,210,300,100);
            ran_go.setLineWrap(true);
            ran_go.setEditable(false);
            pn1.add(l3);
            pn1.add(ran_go);
            pn1.add(start);
            pn1.add(next);
            pn1.add(sure2);
            pn1.setLayout(null);
            pn1.add(exit);
            sure2.setBounds(width/2-100,330,200,30);
            exit.setBounds(width/2-100,380,200,30);
            next.setBounds(width/2-100,420,200,30);
            next.setVisible(false);
            start.setText(null);
            start.setVisible(false);
            ran_go.setText(null);
            mypanel.setVisible(false);
            pn1.setVisible(true);
            myframe.add(pn1);
        }
        else if(e.getSource()==sure2)
        {

            java.util.Random r=new java.util.Random();
            start.setText(lnklst.randomvisit());
            start.setVisible(false);
            ran_go.setText(lnklst.randomvisit());

        }
 
        else if(e.getSource()==gn3)
        {
            Label l3=new Label("点到点");
            l3.setFont(new Font("Dialog",1,25));
            l3.setBounds(width/2-100,50,300,60);
            start2.setBounds(width/2-100,130,200,30);
            end.setBounds(width/2-100,180,200,30);
            short1.setBounds(width/2-200,220,200,200);
            short1.setLineWrap(true);
            short1.setEditable(false);
            short3.setBounds(width/2+10,220,200,200);
            short3.setLineWrap(true);
            short3.setEditable(false);
            pn1.add(l3);
            pn1.add(start2);
            pn1.add(end);
            pn1.add(short1);
            pn1.add(sure4);
            pn1.setLayout(null);
            pn1.add(exit);
            pn1.add(short3);
            sure4.setBounds(width/2-100,440,200,30);
            exit.setBounds(width/2-100,500,200,30);
            start2.setText(null);
            short3.setText(null);
            end.setText(null);
            short1.setText(null);
            mypanel.setVisible(false);
            pn1.setVisible(true);
            myframe.add(pn1);
        }
        else if(e.getSource()==sure4)
        {
            short3.setText(null);
            short1.setText(null);
            Stack stack=new Stack();
            String result="there is no such word!";
            result=lnklst.shortestroad(start2.getText().toLowerCase(),end.getText().toLowerCase());;
            short1.setText(result);
        }
    }
}


