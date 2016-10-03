
public class Main {
    
    public static void main(String[] args) {
        Interface InterFace = new Interface();
        
        boolean running = true;
        while(running == true){
            switch(InterFace.escolhaPrincipal()){
                case 0 : running = false; break;
                case 1 : InterFace.escolhaModificarGrafo(); break;
                case 2 : InterFace.escolhaTesteGrafo(); break;
                case 3 : InterFace.teste(); break;
                default: System.out.println("Escolha Invalida");
            }
        }
    }
    
}


