package simulation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import astrophage.Astrophage;
import astrophage.Moving;
import cell.Cell;

public class SimulationFrontend extends Application {

    static final int CELL_SIZE = 12;
    static final int SIZE = 50;

    private Simulation sim;

    public void start(Stage stage) {
        Simulation sim = new Simulation(SIZE, 10);
        
        Canvas canvas = new Canvas(SIZE * CELL_SIZE, SIZE * CELL_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            public void handle(long now) {
                // krok co 200ms
                if (now - lastUpdate >= 200_000_000) {
                    for (Astrophage a : sim.getAstrophage()) {
                        Moving.move(a, sim.getGrid());
                    }
                    draw(gc);
                    lastUpdate = now;
                }
            }
        };
        timer.start();

        Scene scene = new Scene(new StackPane(canvas));
        stage.setScene(scene);
        stage.setTitle("Astrophage Simulation");
        stage.show();
    }

    private void draw(GraphicsContext gc) {
        Cell[][] grid = sim.getGrid();
        
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                float brightness = grid[x][y].getBrightness();
                gc.setFill(Color.color(brightness / 10.0, brightness / 10.0, 0));
                gc.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                gc.setStroke(Color.DARKGRAY);
                gc.strokeRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        for (Astrophage a : sim.getAstrophage()) {
            gc.setFill(Color.RED);
            gc.fillOval(a.getX() * CELL_SIZE, a.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}