

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int decision = 0;

        Nodo<String> nod = null;
        arbolbinario<String> tree = new arbolbinario<String>(nod);

        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

            System.out.println("Ingrese el nombre o dirreccion de su documento .txt: ");
            String file = in.nextLine();

            BufferedReader br = new BufferedReader( new FileReader(file));

            try {
                StringBuilder sb = new StringBuilder();
                String line = "";

                String espanol = "";
                String ingles = "";

                while((line = br.readLine())!= null){
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = line + "";

                    for(int i=1;i< line.length();i++){
                        String iter = line.substring((i-1),i);
                        if (iter.equals(",")){
                            espanol = line.substring(i, line.length()).toUpperCase();
                            ingles = line.substring(0,i-1).toUpperCase();
                        }
                    }

                    Nodo<String> node = new Nodo<String>(ingles,espanol);
                    tree.addNodo(node);
                }
                System.out.println("Porfavor elija una opcion: \n1.Traducir archivo de texto \n2.Mostrar el recorrido del arbol \n3.Salir ");
                decision = in.nextInt();
                while (decision !=3){
                    if(decision == 1){
                        String traduccion = "";
                        String oracion = "";
                        System.out.println("Ingrese el nombre del archivo a traducir");
                        String texto = in2.nextLine();
                        File archivo = new File(texto);

                        FileReader fr = new FileReader(archivo);
                        BufferedReader br1 = new BufferedReader(fr);
                        String linea = "";
                        Scanner sc = new Scanner(fr);
                        String palabra = "";

                        while (sc.hasNextLine()){
                            linea += sc.nextLine();
                            palabra = line.replaceAll("\n", " ");
                        }
                        fr.close();
                        br1.close();

                        String palabras[] = palabra.split(" ");
                        for(int i = 0; i < palabras.length; i++){
                            palabra = palabras[i];
                            palabra = palabra.toUpperCase();
                            String prueba = tree.buscar(palabra);
                            traduccion = traduccion + prueba;
                        }
                        System.out.println(traduccion);
                    }else if(decision == 2){
                        tree.recorrer(arbolbinario.recorrido.Inorded);
                    }else {
                        System.out.println("No se ingreso una opcion valida");
                    }
                    System.out.println("Porfavor elija una opcion: \n1.Traducir archivo de texto \n2.Mostrar el recorrido del arbol \n3.Salir ");
                    decision = in.nextInt();
                }
            }
            finally {
                br.close();
            }
    }
}
