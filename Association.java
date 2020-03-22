
import java.util.Map;

public class Association<K extends Comparable<K>,V extends Comparable<V>> implements Map.Entry<K,V> {

    protected K theKey;
    protected V theValue;

    public Association(K key, V value){
        theKey = key;
        theValue = value;
    }

    public Association(K key){
        this(key,null);
    }

    public boolean equals(Object other){
        Association otherAsso =(Association)other;
        return  getKey().equals(otherAsso.getKey());
    }

    public int hashCode (){
        return getKey().hashCode();
    }

    public V getValue(){
        return theValue;
    }

    public K getKey(){
        return theKey;
    }

    public V setValue(V value){
        V valueante = theValue;
        theValue = value;
        return valueante;
    }

    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
}
