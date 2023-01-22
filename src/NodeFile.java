import java.util.ArrayList;
import java.util.List;

public class NodeFile {
    List<NodeFile> children;
    String name;
    int size;
    String type;
    NodeFile parent;

    public NodeFile(String name) {
        this.name = name;
        this.size = -1;
        this.children = new ArrayList<NodeFile>();
        this.type = "dir";
    }

    public NodeFile(String name, int size, String type, NodeFile parent) {
        this.name = name;
        this.size = size;
        this.children = new ArrayList<NodeFile>();
        this.type = type;
        this.parent = parent;
    }

    public void addChild(NodeFile child) {
        children.add(child);
    }

    public boolean isChild(String name) {
        for(NodeFile child: this.children) {
            if(child.name.equals(name)){
                return true;
            }
        }
        return false;
    }

    public void calculateDirSize() {
        int dirSize = 0;
        for (NodeFile child: this.children) {
            if(child.type.equals("dir")) {
                child.calculateDirSize();
            }
            dirSize += child.size;
        }
        this.size = dirSize;
    }

    public int sumDirOverSize() {
        int dirSize = 0;

        for (NodeFile child: this.children) {
            if(child.type.equals("dir")) {
                if(child.size <= 100000) {
                    dirSize += child.size;
                }
                dirSize += child.sumDirOverSize();
            }
        }

        return dirSize;
    }


    public int findSmallestDir(int toDelete) {
        int dirSize = -1;
        int childSize = -1;

        if(this.size >= toDelete) {
            dirSize = this.size;
        }

        for (NodeFile child: this.children) {
            if(child.type.equals("dir")) {
                childSize = child.findSmallestDir(toDelete);
                if(childSize != -1 && childSize < dirSize){
                    dirSize = childSize;
                }
            }
        }

        return dirSize;
    }

}
