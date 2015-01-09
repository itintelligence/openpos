
package classes.gui.mainmenu;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

/**
 * Implement TreeCellRendere to use Label for each JTree node. 
 * Using label allows usage of unique images for each Node.
 * 
 * @author Ashraful
 */

public class MenuTreeCellRenderer implements TreeCellRenderer{
    
    private JLabel menuNode;

    // constructor
    public MenuTreeCellRenderer(){
        
        menuNode = new JLabel();
    }
    
    
    @Override public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            
        Object obj = ((DefaultMutableTreeNode)value).getUserObject();

            if (obj instanceof DashMenuItem) {
                
                // new dashmenu item instance
                DashMenuItem dm = (DashMenuItem) obj;
                
                // set iconimage for the label
                menuNode.setIcon(new ImageIcon(getClass().getResource(dm.getItemIcon())));

                // set text for label
                menuNode.setText(dm.getItemName());
                
            } else {

                menuNode.setIcon(null);
                menuNode.setText("" + value);
                
            }
            
            // returns reference to menuNode
            return menuNode;
        }
}
