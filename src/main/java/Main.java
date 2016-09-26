
public class Main {
    
    public static void main(String[] args) {
        Interface InterFace = new Interface();
        
        boolean running = true;
        while(running == true){
            switch(InterFace.escolhaPrincipal()){
                case 1 : InterFace.escolhaModificarGrafo();
                case 2 : InterFace.escolhaTesteGrafo();
            }
        }
    }
    
}


