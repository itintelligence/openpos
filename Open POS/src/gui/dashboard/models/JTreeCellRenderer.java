package gui.dashboard.models;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * Implement DefaultTreeCellRendere to use Label as JTree node. 
 * Using label allows usage of unique images for each Node.
 *
 * @author Ashraful
 */
public class JTreeCellRenderer extends DefaultTreeCellRenderer {

    // constructor
    public JTreeCellRenderer() {
        node = new JLabel();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean selected, boolean expanded, boolean leaf,
            int row, boolean hasFocus) {

        Object obj = ((DefaultMutableTreeNode) value).getUserObject();

        if (obj instanceof JTreeNode) {

            JTreeNode jtn = (JTreeNode) obj;

            icon = new ImageIcon(getClass().getResource(jtn.getIcon()));
            node.setIcon(icon);
            node.setText(jtn.getName());
            node.setFont(new java.awt.Font("Tahoma", 1, 12));

        } else {

            node.setIcon(null);
            node.setText("" + value);

        }

        return node;
    }
    
    // Variables Declaration
    private JLabel node;
    private ImageIcon icon;
}
