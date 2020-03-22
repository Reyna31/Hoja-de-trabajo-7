

public class arbolbinario<E extends Comparable<E>> {
    private Nodo<E> raiz;

    public enum recorrido{Preorder,Inorded,Postorder}

    public arbolbinario(Nodo<E> r){
        raiz = r;
    }

    public Nodo<E> getRaiz(){
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz){
        this.raiz = raiz;
    }

    public void addNodo(Nodo node,Nodo raiz){
        if (raiz == null){
            this.setRaiz(node);
        }else{
            if(node.getAsociacion().getKey().compareTo(raiz.getAsociacion().getKey()) < 0){
                if (raiz.getLeft() == null){
                    raiz.setLeft(node);
                }else{
                    addNodo(node, raiz.getLeft());
                }
            }else{
                if (raiz.getRight() == null){
                    raiz.setRight(node);
                }else{
                    addNodo(node, raiz.getRight());
                }
            }
        }

    }

    public void addNodo(Nodo node){
        this.addNodo(node,this.raiz);
    }

    public void recorrer(recorrido tipo){
        switch (tipo){
            case Preorder:
                System.out.println("recorrido preorder");
                raiz.preOrder();
                break;
            case Inorded:
                System.out.println("recorrido inorder");
                raiz.inOrder();
                break;
            case Postorder:
                System.out.println("recorrido postorder");
                raiz.postOrder();
                break;
        }
        System.out.println();
    }

    public String buscar(String palabra){
        if (raiz == null){
            return "*" + palabra + "*";
        }else{
            return raiz.search(palabra);
        }
    }

}
