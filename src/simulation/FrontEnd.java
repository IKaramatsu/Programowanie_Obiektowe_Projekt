package simulation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import astrophage.Astrophage;
import cell.Cell;

public class FrontEnd extends Application {

    Canvas Background = new Canvas(1920, 1080);
    Canvas Board = new Canvas(800, 800);
    Canvas AstrophageLayer = new Canvas(800, 800);
    GraphicsContext gcBackground = Background.getGraphicsContext2D();
    GraphicsContext gcBoard = Board.getGraphicsContext2D();
    GraphicsContext gcAstro = AstrophageLayer.getGraphicsContext2D();
    Image GUI = new Image(getClass().getResourceAsStream("/resources/astrophage ABM simulation.png"));
    Pane root = new Pane();
    Simulation simulation;

    @Override
    public void start(Stage stage) {
        UserInput input = new UserInput();
        input.getInput();
        simulation = new Simulation(input);

        gcBackground.drawImage(GUI, 0, 0, 1920, 1080);

        Board.setLayoutX(179);
        Board.setLayoutY(135);
        AstrophageLayer.setLayoutX(179);
        AstrophageLayer.setLayoutY(135);
        AstrophageLayer.setBlendMode(BlendMode.SCREEN);

        root.getChildren().addAll(Board, AstrophageLayer, Background);

        gcBackground.setFill(Color.rgb(100, 45, 45));
        gcBackground.setFont(Font.font("Courier New", FontWeight.BOLD, 24));
        gcBackground.fillText(String.valueOf(input.agentAmount), 1105, 183);
        gcBackground.fillText(String.valueOf(input.boardSize), 1500, 183);
        gcBackground.fillText(String.valueOf(input.movementCost), 1105, 335);
        gcBackground.fillText(String.valueOf(input.simulationSpan), 1500, 335);
        gcBackground.fillText(String.valueOf(input.lifeLength), 1105, 488);
        gcBackground.fillText(String.valueOf(input.coreAmount), 1500, 488);

        drawBoard();

        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.setTitle("Astrophage Simulation");
        stage.setResizable(false);

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 500_000_000) {//zmiencie na wolniej jak chcecie ogarnac lepiej co sie wizualnie dzieje
                    simulation.update();
                    drawBoard();
                    lastUpdate = now;
                }
            }
        };
        timer.start();
        stage.show();
    }

    public void drawBoard() {
        
        Cell[][] grid = simulation.getGrid();
        int size = simulation.getSize();
        double cellSize = 800.0 / size;

        // plansza
        gcBoard.setFill(Color.BLACK);
        gcBoard.fillRect(0, 0, 800, 800);

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Cell cell = grid[y][x];
                float brightness = cell.getBrightness();

                if (cell.getCore()) {
                    gcBoard.setFill(Color.rgb(235, 212, 162));
                } else if (brightness > 0) {
                    int r = (int)(245 * (brightness / 10.0) + 10);
                    int g = (int)(90 * (brightness / 10.0) + 10);
                    gcBoard.setFill(Color.rgb(r, g, 0));
                } else {
                    gcBoard.setFill(Color.rgb(10, 10, 10));
                }
                gcBoard.fillRect(x * cellSize, y * cellSize, cellSize - 1, cellSize - 1);
            }
        }

        // blending mody zeby wygladalo hot
        //astrofagi
        gcAstro.clearRect(0, 0, 800, 800);
        for (Astrophage a : simulation.getAstrophage()) {
            double offset = cellSize * 0.15;
            gcAstro.setFill(Color.rgb(255, 124, 124));
            gcAstro.fillOval(
                a.getX() * cellSize + offset + RandomVariables.moveOffset(),// dodany randomowy offset zeby lepiej bylo widac ile astrofagow jest na polu
                a.getY() * cellSize + offset + RandomVariables.moveOffset(),
                cellSize - 2 * offset,
                cellSize - 2 * offset
            );
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}