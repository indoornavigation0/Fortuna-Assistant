import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.*;


public class inst extends Application {
    @FXML
    TextArea txtfie;
    Scene sce1;
    //List textlist1 = (List) new ArrayList();
    ArrayList<String> textlist1 = new ArrayList<String>();
    Map<String, String> ssce2 = new HashMap<>();
    List<TextArea> all_spec = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Fortuna Assistant");
        Label label = new Label("Enter Ontology:");
        TextArea textField1 = new TextArea();
        Button bt = new Button("Submit");
        HBox hb1 = new HBox(bt);
        hb1.setAlignment(Pos.BASELINE_CENTER);
        VBox vb = new VBox(label, textField1, hb1);
        sce1 = new Scene(vb, 500, 200);
        primaryStage.setScene(sce1);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setMaximized(true);
        primaryStage.show();
        bt.setOnAction(new EventHandler<ActionEvent>() {
            List<String> textlist2 = new ArrayList<String>();
            @Override
            public void handle(ActionEvent event) {
                textlist1.add(textField1.getText().trim());
                List tlist = Arrays.asList(textlist1.get(0).split("\n"));
                Button bt1 = new Button("Submit"); //= new Button("Submit");
                VBox vbo = new VBox();
                if (!"".equals(textlist1.get(0))) {
                    Stage stage1 = new Stage();
                    stage1.setTitle("Fortuna Assistant");
                    List<TextArea> all = new ArrayList<>();
                    for(int i=0;i<=tlist.size()-1;i++) {
                        String instsent = "Enter the most important instances for " + tlist.get(i);
                        Label labe = new Label(instsent);
                        // TextField txtfie = new TextField();
                        TextArea txtfie = new TextArea();
                        //txtfie.setOnAction(customEvent);
                        all.add(txtfie);
                        vbo.getChildren().addAll(labe, txtfie);
                    }
                    Button btname = new Button("Submit");
                    HBox hb2 = new HBox(btname);
                    hb2.setAlignment(Pos.BASELINE_CENTER);
                    vbo.getChildren().add(hb2);
                    //btname.setOnAction(new EventHandler<ActionEvent>() {
                        //@Override
                        //public void handle(ActionEvent event) {
//                            for (int i = 0; i <= tlist.size() - 1; i++) {
//                                String ab = all.get(i).getText();
//                                ssce2.put(tlist.get(i), ab);
//                            }
                        //}
                    //});
                    vb.getChildren().addAll(vbo);
                    vbo.setSpacing(10);
                    ScrollPane scp = new ScrollPane(vb);
                    scp.setFitToHeight(true);
                    scp.setFitToWidth(true);
                    sce1 = new Scene(scp, 500, 200);
                    primaryStage.setScene(sce1);
                    Screen screen = Screen.getPrimary();
                    Rectangle2D bounds = screen.getVisualBounds();
                    primaryStage.setWidth(bounds.getWidth());
                    primaryStage.setHeight(bounds.getHeight());
                    primaryStage.setMaximized(true);
                    primaryStage.show();
                    btname.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            for (int i = 0; i <= tlist.size() - 1; i++) {
                                String ab = all.get(i).getText().trim();
                                ssce2.put((String) tlist.get(i), ab);
                            }
                            VBox vbx = new VBox();
                            Label reqlabel = new Label("Enter Requirement");
                            TextField tf = new TextField();
                            Button btreq = new Button("Sub-Req");
                            Button btspec = new Button("Spec");
                            Button btdom = new Button("Domain");
                            HBox hbx = new HBox(btreq, btspec, btdom);
                            hbx.setAlignment(Pos.BASELINE_CENTER);
                            vbx.getChildren().addAll(reqlabel, tf, hbx);
                            vb.getChildren().addAll(vbx);
                            ScrollPane scp = new ScrollPane(vb);
                            scp.setFitToHeight(true);
                            scp.setFitToWidth(true);
                            sce1 = new Scene(scp, 500, 200);
                            primaryStage.setScene(sce1);
                            Screen screen = Screen.getPrimary();
                            Rectangle2D bounds = screen.getVisualBounds();
                            primaryStage.setWidth(bounds.getWidth());
                            primaryStage.setHeight(bounds.getHeight());
                            primaryStage.setMaximized(true);
                            primaryStage.show();
                            System.out.println(ssce2);
                            btreq.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    String requ = tf.getText();
                                    sentencebreak sb = new sentencebreak();
                                    HashMap a = sb.dataPre(requ);
                                    List req = (List) a.get("This is a requirement");
                                    Stage stage = new Stage();
                                    stage.setTitle("Fortuna Assistant");
                                    VBox vr = new VBox();
                                    int requsize = req.size();
                                    TextField[] txtl = new TextField[requsize];
                                    HBox hbo = new HBox();
                                    for(int i=0;i<requsize;i++){
                                        int j=i+1;
                                        String Reqnum = "Requirement_"+j;
                                        TextField tf = new TextField((String) req.get(i));
                                        tf.setMaxWidth(1500);
                                        Label lab = new Label(Reqnum);
                                        //Button dwrbt = new Button("Do you want to refine");
                                        //hbo.getChildren().add(dwrbt);
                                        vr.getChildren().addAll(lab, tf);
                                    }
                                    Button dwrbt = new Button("Submit");
                                    hbo.getChildren().addAll(dwrbt);
                                    hbo.setAlignment(Pos.BASELINE_CENTER);
                                    vr.getChildren().addAll(hbo);
                                    vb.getChildren().addAll(vr);
                                    ScrollPane scp = new ScrollPane(vb);
                                    scp.setFitToHeight(true);
                                    scp.setFitToWidth(true);
                                    sce1 = new Scene(scp, 500, 200);
                                    primaryStage.setScene(sce1);
                                    Screen screen = Screen.getPrimary();
                                    Rectangle2D bounds = screen.getVisualBounds();
                                    primaryStage.setWidth(bounds.getWidth());
                                    primaryStage.setHeight(bounds.getHeight());
                                    primaryStage.setMaximized(true);
                                    primaryStage.show();
                                }
                            });
                            btspec.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    String requ = tf.getText();
                                    specification sp = new specification();
                                    HashMap<String, String> ddd = sp.specfunc(ssce2, requ, tlist);
                                    List<String> mapk = new ArrayList<String>(ddd.keySet());
                                    VBox vspecb = new VBox();
                                    for(int i=0;i<=ddd.size()-1;i++){
                                        String labl = mapk.get(i);
                                        Label lab = new Label(labl);
                                        String valuek = ddd.get(mapk.get(i));
                                        TextArea ta = new TextArea(valuek);
                                        all_spec.add(ta);
                                        Button gqb = new Button("Generate Question");
                                        HBox hqb = new HBox();
                                        hqb.getChildren().addAll(gqb);
                                        hqb.setAlignment(Pos.BASELINE_CENTER);
                                        vspecb.getChildren().addAll(lab, ta, hqb);
                                    }
                                    vb.getChildren().addAll(vspecb);
                                    ScrollPane scp = new ScrollPane(vb);
                                    scp.setFitToHeight(true);
                                    scp.setFitToWidth(true);
                                    sce1 = new Scene(scp, 500, 200);
                                    primaryStage.setScene(sce1);
                                    Screen screen = Screen.getPrimary();
                                    Rectangle2D bounds = screen.getVisualBounds();
                                    primaryStage.setWidth(bounds.getWidth());
                                    primaryStage.setHeight(bounds.getHeight());
                                    primaryStage.setMaximized(true);
                                    primaryStage.show();
                                }
                            });
                        }
                    });
                        }
                }
            });
    }
}