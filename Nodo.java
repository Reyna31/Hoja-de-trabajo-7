
public class Nodo<E> {
    Association<String,String> value;
    private Nodo<E> central;
    private Nodo<E> left;
    private Nodo<E> right;

    public Nodo(String Ing,String Esp){
        value = new Association(Ing,Esp);
        central = null;
        left = null;
        right = null;
    }

    public Nodo(String Ing, String Esp, Nodo<E> ni, Nodo<E> nd) {
        value = new Association(Ing,Esp); //valores del nodo asociaados
        if (ni != null) left = ni;
        if (nd != null) right = nd;
    }

    public Nodo(String Ing, String Esp, String IngLeft,String EspLeft,String IngRight,String EspRight) {
        value = new Association(Ing,Esp); //valores del nodo asociaados
        if (IngLeft!= null && EspLeft != null) {
            left = new Nodo<>(IngLeft,EspLeft);
        }
        if (IngRight!= null && EspRight != null) {
            right = new Nodo<>(IngRight,EspRight);
        }
    }

    public boolean hasChildren() {
        return (left != null && right != null);
    }

    public boolean isLeaf() {
        return (left == null && right == null);
    }

    public Association getAsociacion() {
        return value;
    }

    public String getEspanol() {
        return value.getValue();
    }

    public String getEnglish(){
        return value.getKey();
    }

    public Nodo getLeft(){
        return left;
    }

    public Nodo getRight(){
        return right;
    }

    public void setLeft(Nodo left){
        this.left = left;
    }

    public void setRight(Nodo right){
        this.right=right;
    }

    public void preOrder() {
        System.out.print(getEspanol() + " ");
        if (left != null)
            left.preOrder();
        if (right != null)
            right.preOrder();
    }

    public void inOrder() {
        if (this == null)
            return;
        if (left != null)
            if (left.isLeaf())
                System.out.print("("+left.getEnglish() + ", "+ left.getEspanol()+")\n");
            else
                left.inOrder();
        System.out.print("("+getEnglish() + ", "+getEspanol()+")\n");
        if (right != null)
            if (right.isLeaf())
                System.out.print("("+right.getEnglish() + ", "+ right.getEspanol()+")\n");
            else
                right.inOrder();
    }

    public void postOrder() {
        if (this == null)
            return;
        if (left != null)
            if (left.isLeaf())
                System.out.print(left.getEspanol() + " ");
            else
                left.postOrder();
        if (right != null)
            if (right.isLeaf())
                System.out.print(right.getEspanol() + " ");
            else
                right.postOrder();
        System.out.print(getEspanol() + " ");
    }

    public String search(String value){
        if (value.equals(this.value.getKey())){

            return this.value.theValue;
        }else if (value.compareTo(this.value.getKey()) < 0) {

            if (left == null){
                return "*" + value + "*";
            }else{
                return left.search(value);
            }
        }else if(value.compareTo(this.value.getKey()) > 0) {

            if (right == null){
                return "*" + value + "*";
            }else{
                return right.search(value);

            }
        }

        return "*" + value + "*";
    }

}
