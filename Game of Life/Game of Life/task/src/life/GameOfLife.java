package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {

    public Universe World;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        JLabel generation = new JLabel();
        generation.setName("GenerationLabel");
        generation.setText("Generation #0");
        generation.setBounds(20, 10, 100, 30);
        add(generation);

        JLabel alive = new JLabel();
        alive.setName("AliveLabel");
        alive.setText("Alive: 0");
        alive.setBounds(20, 30, 100, 30);
        add(alive);

        setLayout(null);
        setVisible(true);
    }

    public void setWorld(Universe world) {
        this.World = world;
    }

    public void UIComponents() {

        JLabel generation = new JLabel();
        generation.setName("GenerationLabel");
        generation.setText("Generation #" + this.World.Generation);
        generation.setBounds(20, 10, 100, 30);
        add(generation);

        JLabel alive = new JLabel();
        alive.setName("AliveLabel");
        alive.setText("Alive: " + this.World.countAliveCells());
        alive.setBounds(20, 30, 100, 30);
        add(alive);

        int[][] map = this.World.state;
        JPanel world = new JPanel();
        world.setBounds(0, 60, 300, 250);
        world.setLayout(new GridLayout(map.length, map.length));
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                JPanel spot = new JPanel();
                spot.setBackground(map[i][j] == 0 ? Color.BLACK : Color.WHITE);
                world.add(spot);
            }
        }
        add(world);
    }

    public void refresh() throws InterruptedException {
        this.World.evolve(this.World.Generation);
        getContentPane().removeAll();
        UIComponents();
        revalidate();
        repaint();
    }
}