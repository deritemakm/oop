package easekolar.listeners;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import easekolar.application.Easekolar;

public class SidebarListener implements ActionListener {

    private Easekolar sklMainFrame;
    private Color clrLightPink = new Color(255, 182, 193);

    public SidebarListener(Easekolar sklMainFrame) {
        this.sklMainFrame = sklMainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton) e.getSource();
        String strButtonText = btnClicked.getText();

        if (strButtonText.equals("Home")) {
            sklMainFrame.getSubjectPanel().removeAll();
            sklMainFrame.loadHome();
            sklMainFrame.setHeaderText("Home");  // Set header text to "Home"
            sklMainFrame.revalidate();
            sklMainFrame.repaint();
        } else {
            JPanel pnlSelectedPanel = makeSubjectPanel(strButtonText);
            switchToPanel(pnlSelectedPanel);
            sklMainFrame.setHeaderText(strButtonText);  // Set header text to the button clicked
        }
    }

    // TODO: PUT CONTENT.
    public JPanel makeSubjectPanel(String contentText) {
        JPanel pnlSwitchedPanel = new JPanel();
        pnlSwitchedPanel.add(new JLabel(contentText));
        pnlSwitchedPanel.setBackground(clrLightPink);
        return pnlSwitchedPanel;
    }

    public void switchToPanel(JPanel pnlSwitchedPanel) {
        sklMainFrame.getSubjectPanel().removeAll();
        sklMainFrame.getSubjectPanel().add(pnlSwitchedPanel, BorderLayout.CENTER);
        sklMainFrame.revalidate();
        sklMainFrame.repaint();
    }
}
