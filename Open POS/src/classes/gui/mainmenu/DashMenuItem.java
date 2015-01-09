/**
 * Each instance holds a node label and image name, for JTree object.
 * @Author Ashraful Islam
 */
package classes.gui.mainmenu;

public class DashMenuItem {
    private String itemName;
    private String itemIcon;
    
    // constructor
    public DashMenuItem(String itemName, String itemIcon) {
        this.itemName = itemName;
        this.itemIcon = itemIcon;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemIcon() {
        return ("/assets/"+itemIcon);
    }

    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
    }
}
