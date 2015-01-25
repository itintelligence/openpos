/**
 * Each instance holds a node label and image name, for JTree object.
 * @Author Ashraful Islam
 */
package gui.dashboard.models;

public class JTreeNode {

    // constructor
    public JTreeNode(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return this.name;
    }

    public String getIcon() {
        return ("/assets/" + this.icon);
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
    // Variables Declaration
    private String name;
    private String icon;
    
}
