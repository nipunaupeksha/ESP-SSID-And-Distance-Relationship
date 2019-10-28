/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Nipuna
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PostTipSSCCE extends JPanel
{
    public PostTipSSCCE()
    {
        FocusAdapter fa = new FocusAdapter()
        {
            public void focusGained(FocusEvent e)
            {
                JComponent component = (JComponent)e.getSource();

                MouseEvent phantom = new MouseEvent(
                    component,
                    MouseEvent.MOUSE_MOVED,
                    System.currentTimeMillis(),
                    0,
                    10,
                    10,
                    0,
                    false);

                ToolTipManager.sharedInstance().mouseMoved(phantom);
            }
        };

        JButton button = new JButton("Button");
        button.setToolTipText("button tool tip");
        button.addFocusListener( fa );
        add( button );

        JTextField textField = new JTextField(10);
        textField.setToolTipText("text field tool tip");
        textField.addFocusListener( fa );
        add( textField );

        JCheckBox checkBox =  new JCheckBox("CheckBox");
        checkBox.setToolTipText("checkbox tool tip");
        checkBox.addFocusListener( fa );
        add( checkBox );
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("PostTipSSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new JScrollPane(new PostTipSSCCE()) );
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}