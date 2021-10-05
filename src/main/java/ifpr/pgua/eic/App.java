package ifpr.pgua.eic;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application{


    @Override
    public void start(Stage stage) throws Exception {
        
        //organizador de layout. O VBox coloca os elementos
        //em uma coluna.
        VBox root = new VBox();

        //espaço entre os elementos, no caso 5 pixels.
        root.setSpacing(5);
        //alinha o VBox no centro da tela
        root.setAlignment(Pos.CENTER);
        //coloca um espaço ente o VBox e a borda da tela
        root.setPadding(new Insets(8,8,8,8));   

        //cria um elemento que mostra um texto na tela
        Text texto = new Text("Digite uma frase:");
        //coloca o elemento dentro do organizador de layout
        root.getChildren().add(texto);

        //cria um componente para ler dados do teclado
        TextField tfFrase = new TextField();
        root.getChildren().add(tfFrase);

        //cria um componente para receber eventos de click
        //do mouse
        Button btAcao = new Button("Clique para calcular");
        root.getChildren().add(btAcao);

        Text txtResultado = new Text("Esperando frase...");
        root.getChildren().add(txtResultado);

        
        //criar um evento utilizando classe Anônima
        /*btAcao.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Clicou no botão....");
            }
          }
        );*/
        
        //utilizando função anônima
        btAcao.setOnAction((event)->{
            String fraseDigitada = tfFrase.getText();
            
            ArrayList<String> vogais = new ArrayList(Arrays.asList("a","e","i","o","u"));
            
            ArrayList<String> caracteresFrase = new ArrayList<>(Arrays.asList(fraseDigitada.split("")));

            caracteresFrase.retainAll(vogais);

            txtResultado.setText(fraseDigitada+"\n"+"Esta frase contém "+caracteresFrase.size()+" vogais!");
          }
        );

        
        //pega o tamanho do monitor primário
        //Rectangle2D size =  Screen.getPrimary().getBounds();
        
        //cria uma cena que receberá os atores para serem
        //mostrados na janela
        Scene cena = new Scene(root,600,400);
        
        //coloca a cena no palco (janela)
        stage.setScene(cena);
        
        //ajusta o título da janela 
        stage.setTitle("Minha Primeira GUI");
        
        //mostra a janela
        stage.show();
        
    }    

    public static void main(String[] args){
        launch(args);
    }


}