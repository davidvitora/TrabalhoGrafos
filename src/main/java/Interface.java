
import com.damage.grafos.Grafo;
import java.util.Scanner;
import java.util.Vector;

public class Interface {
    
    Vector<Grafo> grafos = new Vector<Grafo>();
    
    public Interface(){
        
    }
    
    public int escolhaPrincipal(){
        Scanner leitor = new Scanner(System.in);
        Menu.imprimirMenuPrincipal();
        return leitor.nextInt();
    }
    
    public void escolhaModificarGrafo(){
        Scanner leitor = new Scanner(System.in);
        Menu.imprimirModificarGrafo();
        switch(leitor.nextInt()){
            case 1 : break;
            case 2 : break;
            case 3 : break;
            case 4 : break;
        }
    }
    
    public void escolhaTesteGrafo(){
        Scanner leitor = new Scanner(System.in);
        Menu.imprimirMenuTesteGrafo();
        switch(leitor.nextInt()){
            case 1 : break;
            case 2 : break;
            case 3 : break;
            case 4 : break;
        }
    }
    
    public void teste(){
        Frame.abrir(grafos);
    }
    
}
